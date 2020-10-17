package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.xtext.util.StringInputStream;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.impl.ElementsFactory;

import hu.bme.mit.gamma.statechart.interface_.Component;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.md2g.transformation.TraceModelManager;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.Gamma.GammaWorkspace;
import uppaal.NTA;

public class TransformWorkspaceModelsToUppaalAction extends NMAction{
	
private Package workspace;

	public TransformWorkspaceModelsToUppaalAction(Package workspace) {
		super("WORKSPACE_GAMMA_UPPAAL", "Transform Gamma models to UPPAAL", null, null);
		this.workspace = workspace;
	}
	
	@Override
	public boolean isEnabled() {
		return GammaWorkspace.getGammaInterfaceModel(workspace) != null && GammaWorkspace.getGammaStatechartModel(workspace) != null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Project project = Project.getProject(workspace);
		AdvancedViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		
		String workspaceUri = GammaWorkspace.getWorkspaceUri(workspace);
		
		Class target = (Class) GammaWorkspace.getTarget(workspace);
		Class gammaInterfaceModel = (Class) GammaWorkspace.getGammaInterfaceModel(workspace);
		Class gammaStatechartModel = (Class) GammaWorkspace.getGammaStatechartModel(workspace);
		
		try {
			
			loadModel(resourceSet, workspaceUri, gammaInterfaceModel);
			Resource statechartResource = loadModel(resourceSet, workspaceUri, gammaStatechartModel);
			
			
			Element topmost = GammaWorkspace.getTarget(workspace);
			
			TraceModelManager traceModelManager = new TraceModelManager(engine, gammaStatechartModel, statechartResource);
			
			Optional<Component> topc = traceModelManager.md2g((NamedElement) topmost)
						.stream().filter(Component.class::isInstance).map(Component.class::cast).findFirst();
			
			Component component = topc.orElseThrow(() -> new IllegalStateException("Missing top component from gamma model."));
			
			CompositeToUppaalTransformer transformer = new CompositeToUppaalTransformer(component);
			
			SimpleEntry<NTA, G2UTrace> execute = transformer.execute();
			
			Resource g2u = resourceSet.createResource(URI.createFileURI("trace.g2u"));
			g2u.getContents().add(execute.getValue());
			
			Resource uppaal = resourceSet.createResource(URI.createFileURI(target.getName() + ".uppaal"));
			uppaal.getContents().add(execute.getKey());
			
			SessionManager.getInstance().createSession(project, "Saving models");
			
			Class g2uModel = save(project, workspace, g2u);
			Class uppaalModel = save(project, workspace, uppaal);
			
			GammaWorkspace.setUppaalModel(workspace, uppaalModel);
			GammaWorkspace.setGammaToUppaalTrace(workspace, g2uModel);
			
			SessionManager.getInstance().closeSession(project);
			
		} catch (IOException e) {
			SessionManager.getInstance().cancelSession(project);
			e.printStackTrace();
		}
	}

	private Resource loadModel(ResourceSet resourceSet, String workspaceUri, Class model) throws IOException {
		String gammaModel = ModelHelper.getComment(model);
		
		Resource resource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + model.getName()));

		resource.load(new StringInputStream(gammaModel), Collections.emptyMap());
		
		return resource;
	}
	
	
	private Class save(Project project, Package workspace, Resource resource) throws IOException {
		ElementsFactory elementsFactory = project.getElementsFactory();
		Class model = elementsFactory.createClassInstance();
		model.setName(resource.getURI().toFileString());
		StereotypesHelper.addStereotype(model, Gamma.getInstance(project).getGammaModel());
		
		model.setOwner(workspace);
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		resource.save(stream, Collections.EMPTY_MAP);
		ModelHelper.setComment(model, stream.toString());
		
		return model;
	}
}
