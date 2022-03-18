package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.transformation.CompositeTransformation;
import hu.bme.mit.md2g.transformation.TraceModelCreator;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.Gamma.GammaWorkspace;

public class TransformWorkspaceTargetToGammaAction  extends NMAction {
	
	final Package workspace;

	public TransformWorkspaceTargetToGammaAction(String id, String name, Package workspace) {
		super(id, name, 0, null);
		this.workspace = workspace;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		final Project project = Project.getProject(workspace);
		Optional<Element> target = Optional.ofNullable(Gamma.GammaWorkspace.getTarget(workspace));
		Optional<String> workspaceUri = Optional.ofNullable(Gamma.GammaWorkspace.getWorkspaceUri(workspace));
		
		if (!workspaceUri.isPresent()) {
			//TODO: notify user
			return;
		}
		
		target.filter(Class.class::isInstance).map(Class.class::cast).ifPresent(t -> {
			
				CompositeTransformation compositeTransformation = new CompositeTransformation();
				List<hu.bme.mit.gamma.statechart.interface_.Package> gPackages = compositeTransformation.transform(t, false);
								
				Map<URI, EObject> uriMap = new HashMap<>();
				
				gPackages.forEach(gp -> {
					uriMap.put(URI.createFileURI(gp.getName() + ".gsm"), gp);
				});
				
				try {
					Map<EObject, NamedElement> traces = compositeTransformation.extractTraces();
					TraceModelCreator traceModelCreator = new TraceModelCreator(traces);
					
					ResourceSet resourceSet = new ResourceSetImpl();
					
					
					Element gammaStatechartModel = GammaWorkspace.getGammaStatechartModel(workspace);
					Element gammaInterfaceModel = GammaWorkspace.getGammaInterfaceModel(workspace);
					
					try {
						if (gammaStatechartModel != null) {
							ModelElementsManager.getInstance().removeElement(gammaStatechartModel);
						}
						
						if (gammaInterfaceModel != null) {
							ModelElementsManager.getInstance().removeElement(gammaInterfaceModel);
						}
					} catch(ReadOnlyElementException e){
						Application.getInstance().getGUILog().log("Could not remove old gamma models. Please lock the workspace.");
					}
	
					
					for (Entry<URI, EObject> entry: uriMap.entrySet()) {
						EObject eObject = entry.getValue();
						
						Resource resource = resourceSet.createResource(entry.getKey());
						resource.getContents().add(eObject);
					}
					
					SessionManager.getInstance().createSession(project, "Transforming Gamma model");
					
					for (Resource resource: resourceSet.getResources()) {
						
						ByteArrayOutputStream stream = new ByteArrayOutputStream();
						resource.save(stream, Collections.EMPTY_MAP);
						
						
						Stereotype gammaWSFile = Gamma.getInstance(workspace).getGammaModel();
						Class gammaFile = project.getElementsFactory().createClassInstance();
						StereotypesHelper.addStereotype(gammaFile, gammaWSFile);
						
						if (resource.getContents().contains(compositeTransformation.getInterfacesPackage())) {
							Gamma.GammaWorkspace.setGammaInterfaceModel(workspace, gammaFile);
						} else if (resource.getContents().contains(compositeTransformation.getTopMostComponentPackage())) {
							Gamma.GammaWorkspace.setGammaStatechartModel(workspace, gammaFile);
						}
						
						gammaFile.setName(resource.getURI().toFileString());
						gammaFile.setOwner(workspace);
						
						ModelHelper.setComment(gammaFile, new String(stream.toByteArray()));
						
						EObject eObject = resource.getContents().get(0);
						
						if (eObject instanceof hu.bme.mit.gamma.statechart.interface_.Package) {
							hu.bme.mit.gamma.statechart.interface_.Package pa = (hu.bme.mit.gamma.statechart.interface_.Package) eObject;
							traceModelCreator.createWithoutSession(gammaFile, pa.eAllContents());
						}
						
					
						stream.close();
					}
					
					SessionManager.getInstance().closeSession(project);
					
				} catch (IOException e) {
					SessionManager.getInstance().cancelSession(project);
					e.printStackTrace();
				}
		});
	}
}
