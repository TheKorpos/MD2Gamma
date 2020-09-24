package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.google.common.collect.BiMap;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;

import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder.Trace;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer.Scheduler;
import hu.bme.mit.gamma.uppaal.composition.transformation.SimpleInstanceHandler;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.md2g.serialization.StatechartLanguageSerializer;
import hu.bme.mit.md2g.transformation.CompositeTransformation;
import hu.bme.mit.md2g.transformation.TraceModelCreator;
import hu.bme.mit.md2g.util.ModelHelper;
import hu.bme.mit.md2g.util.NameSanitizer;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.SysML;
import org.eclipse.emf.common.util.URI;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.impl.ElementsFactory;

import uppaal.NTA;

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
				List<hu.bme.mit.gamma.statechart.model.Package> gPackages = compositeTransformation.transform(t, false);
								
				Map<URI, EObject> uriMap = new HashMap<>();
				
				hu.bme.mit.gamma.statechart.model.Package topmostPack = compositeTransformation.getTopMostComponentPackage();
				hu.bme.mit.gamma.statechart.model.Package interfacesPack = compositeTransformation.getInterfacesPackage();
				
				uriMap.put(StatechartLanguageSerializer.createURI(workspaceUri.get(), topmostPack.getName() + ".gcd"), topmostPack);
				uriMap.put(StatechartLanguageSerializer.createURI(workspaceUri.get(), interfacesPack.getName() + ".gcd"), interfacesPack);

				try {
					StatechartLanguageSerializer.serialize(uriMap);
					Map<EObject, NamedElement> traces = compositeTransformation.extractTraces();
					
					TraceModelCreator traceModelCreator = new TraceModelCreator(traces);
					
					SessionManager.getInstance().executeInsideSession(project, "Creating Gamma Model Pointers", () -> {
						uriMap.forEach((uri, eobj) -> {
							Stereotype gammaWSFile = Gamma.getInstance(workspace).getGammaWorkspaceFile();
							Class gammaFile = project.getElementsFactory().createClassInstance();
							StereotypesHelper.addStereotype(gammaFile, gammaWSFile);
							gammaFile.setName(uri.toFileString());
							gammaFile.setOwner(workspace);
							
							if (eobj instanceof hu.bme.mit.gamma.statechart.model.Package) {
								hu.bme.mit.gamma.statechart.model.Package pa = (hu.bme.mit.gamma.statechart.model.Package) eobj;
								traceModelCreator.createWithoutSession(gammaFile, pa.eAllContents());
							}
						});
					});	
				} catch (IOException e) {
					e.printStackTrace();
				}
		});
	}
}
