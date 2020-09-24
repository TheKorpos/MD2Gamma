package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer.Scheduler;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder.Trace;
import hu.bme.mit.gamma.uppaal.composition.transformation.SimpleInstanceHandler;
import hu.bme.mit.gamma.uppaal.serializer.UppaalModelSerializer;
import hu.bme.mit.gamma.uppaal.transformation.ModelValidator;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.md2g.serialization.StatechartLanguageImporter;
import hu.bme.mit.md2g.util.profile.Gamma;
import hu.bme.mit.md2g.util.profile.SysML;
import uppaal.NTA;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

public class TransformWorkspaceModelsToUppaalAction extends NMAction{
	
private Package workspace;

public TransformWorkspaceModelsToUppaalAction(Package workspace) {
	super("WORKSPACE_GAMMA_UPPAAL", "Transform Gamma models to UPPAAL", null, null);
	this.workspace = workspace;
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		List<Class> gModels = workspace.getOwnedElement().stream().filter(Gamma::isGammaWorkspaceFile)
																  .map(Class.class::cast)
																  .filter(c -> c.getName().endsWith("gcd") || c.getName().endsWith("gsm"))
																  .collect(Collectors.toList());
		
		Set<URI> uris = new HashSet<>();
	
		
		Element target = Gamma.GammaWorkspace.getTarget(workspace);
		Optional<InstanceSpecification> trace = workspace.getOwnedElement().stream().filter(SysML::isTrace)
																	 .map(Abstraction.class::cast)
																	 .filter(dep -> dep.getSupplier().contains(target))
																	 .map(dep -> dep.getClient().iterator().next())
																	 .filter(InstanceSpecification.class::isInstance)
																	 .map(InstanceSpecification.class::cast)
																	 .findFirst();
		if (trace.isPresent()) {
			
			URI topLevelURI = null;
			
			for (Class spec: gModels) {
				String uriString = Gamma.GammaWorkspaceFile.getWorkspaceRelativeUri(spec);
				URI uri = URI.createFileURI(uriString);
				uris.add(uri);
				
				if (spec == trace.get()) {
					topLevelURI = uri;
				}
			}
			

			Map<URI, Resource> importedResources = StatechartLanguageImporter.createImporter().importResources(uris);
			
			Resource resource = importedResources.get(topLevelURI);
			hu.bme.mit.gamma.statechart.model.Package gPackage = (hu.bme.mit.gamma.statechart.model.Package) resource.getContents().get(0);
			Component component = gPackage.getComponents().get(0);
			
			try {
				run(gPackage, component, topLevelURI.toFileString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//COPIED FROM GAMMA CODEBASE
	//SOURCE: hu.bme.mit.gamma.uppaal.composition.transformation.commandhandler
	public void run(hu.bme.mit.gamma.statechart.model.Package gammaPackage, Component component, String fileURISubstring) throws IOException {
		String parentFolder = fileURISubstring.substring(0, fileURISubstring.lastIndexOf(File.separator));
		String fileName = fileURISubstring.substring(fileURISubstring.lastIndexOf(File.separator) + 1);
		String fileNameWithoutExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
		// Unfolding the given system
		Trace trace = new ModelUnfolder().unfold(gammaPackage);
		Component topComponent = trace.getTopComponent();
		
		// Saving the Package of the unfolded model
		String flattenedModelFileName = "." + fileNameWithoutExtenstion + ".gsm";
		normalSave(trace.getPackage(), parentFolder, flattenedModelFileName);
		
		Project project = Project.getProject(workspace);
		SessionManager.getInstance().executeInsideSession(project, "Adding instance specification", () -> {
			InstanceSpecification instanceSpec = project.getElementsFactory().createInstanceSpecificationInstance();
			StereotypesHelper.addStereotype(instanceSpec, Gamma.getInstance(project).getGammaWorkspaceFile());
			instanceSpec.setName(parentFolder + File.separator + flattenedModelFileName);
			instanceSpec.setOwner(workspace);
		});
		// Reading the model from disk as this is the only way it works
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet
				.getResource(URI.createFileURI(parentFolder + File.separator + flattenedModelFileName), true);
		// Needed because reading from disk means it is another model now
		Component newTopComponent = getEquivalentComposite(resource, topComponent);
		// Checking the model whether it contains forbidden elements
		ModelValidator validator = new ModelValidator(resourceSet, newTopComponent);
		validator.checkModel();
		SimpleInstanceHandler simpleInstanceHandler = new SimpleInstanceHandler();
		
		CompositeToUppaalTransformer transformer = new CompositeToUppaalTransformer(resourceSet,
				newTopComponent, Scheduler.RANDOM, simpleInstanceHandler.getSimpleInstances(newTopComponent), Collections.emptyList()); // newTopComponent
		SimpleEntry<NTA, G2UTrace> resultModels = transformer.execute();
		NTA nta = resultModels.getKey();
		// Saving the generated models
		normalSave(nta, parentFolder, "." + fileNameWithoutExtenstion + ".uppaal");
		normalSave(resultModels.getValue(), parentFolder, "." + fileNameWithoutExtenstion + ".g2u");
		// Serializing the NTA model to XML
		UppaalModelSerializer.saveToXML(nta, parentFolder, fileNameWithoutExtenstion + ".xml");
		
		SessionManager.getInstance().executeInsideSession(project, "Adding instance specification", () -> {
			InstanceSpecification uppaalModel = project.getElementsFactory().createInstanceSpecificationInstance();
			InstanceSpecification g2uTrace = project.getElementsFactory().createInstanceSpecificationInstance();
			InstanceSpecification upaalXMl = project.getElementsFactory().createInstanceSpecificationInstance();
			StereotypesHelper.addStereotype(uppaalModel, Gamma.getInstance(project).getGammaWorkspaceFile());
			StereotypesHelper.addStereotype(g2uTrace, Gamma.getInstance(project).getGammaWorkspaceFile());
			StereotypesHelper.addStereotype(upaalXMl, Gamma.getInstance(project).getGammaWorkspaceFile());
			uppaalModel.setName(parentFolder + File.separator + "." + fileNameWithoutExtenstion + ".uppaal");
			g2uTrace.setName(parentFolder + File.separator +"." + fileNameWithoutExtenstion + ".g2u");
			upaalXMl.setName(parentFolder + File.separator + fileNameWithoutExtenstion + ".xml");
			
			uppaalModel.setOwner(workspace);
			g2uTrace.setOwner(workspace);
			upaalXMl.setOwner(workspace);
		});
		
		// Deleting old q file
		new File(parentFolder + File.separator + fileNameWithoutExtenstion + ".q").delete();
		UppaalModelSerializer.createStateReachabilityQueries(transformer.getTemplateLocationsMap(), "isStable", parentFolder,
				fileNameWithoutExtenstion + ".q");
		transformer.dispose();
	}
	
	/**
	 * Returns whether the given objects are equal taking into consideration Ecore copies too.
	 */
	private boolean helperEquals(EObject lhs, EObject rhs) {
		EqualityHelper helper = new EqualityHelper();
		return helper.equals(lhs, rhs);
	}

	/**
	 * Returns the CompositeDefinition from the resource that equals to the given composite.
	 */
	private Component getEquivalentComposite(Resource resource, Component component) {
		hu.bme.mit.gamma.statechart.model.Package gammaPackage = (hu.bme.mit.gamma.statechart.model.Package) resource.getContents().get(0);
		Component foundComponent = (Component) gammaPackage.getComponents().get(0);
		if (helperEquals(component, foundComponent)) {
			return foundComponent;
		}
		throw new IllegalArgumentException("No equivalent component!");
	}

	private void normalSave(EObject rootElem, String parentFolder, String fileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource saveResource = resourceSet
				.createResource(URI.createFileURI(URI.decode(parentFolder + File.separator + fileName)));
		saveResource.getContents().add(rootElem);
		saveResource.save(Collections.EMPTY_MAP);
	}

}
