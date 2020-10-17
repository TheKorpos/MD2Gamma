package hu.bme.mit.md2g.serialization;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior;

import hu.bme.mit.gamma.property.model.PropertyPackage;
import hu.bme.mit.gamma.querygenerator.serializer.UppaalPropertySerializer;
import hu.bme.mit.md2g.propertylanguage.CustomPropertyLanguageStandaloneSetup;
import hu.bme.mit.md2g.util.profile.Gamma.GammaWorkspace;

public class PropertySerializer {

	private OpaqueBehavior expression;


	public PropertySerializer(OpaqueBehavior expression) {
		this.expression = expression;
	}
	
	
	public String serialize() throws IOException {
		Element container = expression.getOwner();
		Package workspace = (Package) container.getOwner();
		
		String workspaceUri = GammaWorkspace.getWorkspaceUri(workspace);
		
		Class uppaalModel = (Class) GammaWorkspace.getUppaalModel(workspace);
		Class gammaInterfaceModel = (Class) GammaWorkspace.getGammaInterfaceModel(workspace);
		Class gammaModel = (Class) GammaWorkspace.getGammaStatechartModel(workspace);
		Class trace = (Class) GammaWorkspace.getGammToUppaalTrace(workspace);
		
		Injector injector = new CustomPropertyLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		loadModel(resourceSet, workspaceUri, uppaalModel);
		loadModel(resourceSet, workspaceUri, gammaInterfaceModel);
		loadModel(resourceSet, workspaceUri, gammaModel);
		loadModel(resourceSet, workspaceUri, trace);
		
		String expr = /* getImports() + getComponent() + */ expression.getBody().get(0);
		
		Resource res = resourceSet.createResource(URI.createFileURI("__temp.gpd"));
		
		res.load(new StringInputStream(expr), Collections.singletonMap(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE));
		
		PropertyPackage prop = (PropertyPackage) res.getContents().get(0);
		
		String uppaalProperty = UppaalPropertySerializer.INSTANCE.serializeCommentableStateFormulas(prop.getFormulas());
		
		resourceSet.getResources().forEach(Resource::unload);
		
		return uppaalProperty;
	}
	
	private Resource loadModel(ResourceSet resourceSet, String workspaceUri, Class model) throws IOException {
		String gammaModel = ModelHelper.getComment(model);
		
		Resource resource = resourceSet.createResource(URI.createFileURI(workspaceUri + File.separator + model.getName()));

		resource.load(new StringInputStream(gammaModel), Collections.emptyMap());
		
		return resource;
	}
}
