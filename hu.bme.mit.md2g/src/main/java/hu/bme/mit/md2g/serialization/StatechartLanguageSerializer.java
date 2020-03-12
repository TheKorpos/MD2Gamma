package hu.bme.mit.md2g.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;


import com.google.inject.Inject;
import com.google.inject.Injector;
import com.nomagic.magicdraw.core.Application;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.model.Package;

public class StatechartLanguageSerializer {

	static {
		StatechartLanguageStandaloneSetup.doSetup();
	}
	
	private XtextResourceSet resourceSet;

	@Inject
	public StatechartLanguageSerializer(XtextResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}
	
	private void resolveResources(EObject object, Set<Resource> resolvedResources) {
		for (EObject crossObject : object.eCrossReferences()) {
			Resource resource = crossObject.eResource();
			if (resource != null && !resolvedResources.contains(resource)) {
				
				resourceSet.getResource(resource.getURI(), true);
				
				resolvedResources.add(resource);
				
			}
			resolveResources(crossObject, resolvedResources);
		}
		for (EObject containedObject : object.eContents()) {
			resolveResources(containedObject, resolvedResources);
		}
	}

	public void save(EObject object, String fileName) throws IOException {
		URI traceUri = URI.createFileURI(fileName);
		// Theoretically, all referenced resources must be in the resource set
		resolveResources(object, new HashSet<Resource>());
		// Tried using getResource instead of createResource. Unfortunately, it did not solve the import problem
		// (automatic update of import reference to the new serialized model and thus, the new contained object elements).
		Resource traceResource = resourceSet.createResource(traceUri);
		traceResource.getContents().add(object);
		traceResource.save(Collections.EMPTY_MAP);
	}
	
	public void save(Map<URI, EObject> rootElements) throws IOException {
		rootElements.forEach((key, value) -> {
			Resource resource = this.resourceSet.createResource(key);
			resource.getContents().add(value);
		});
		
		for (Resource res: this.resourceSet.getResources()) {
			try {
				res.save(Collections.EMPTY_MAP);
				JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), res.getURI().toFileString() +  " exported.");
			} catch (Exception e) {
				e.printStackTrace();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (Application.getInstance().getMainFrame(), "Could not export into gcl. Reason: \n"
						+ e.getMessage() + "\nDo you want to export as gsl?", "Export error",  dialogButton
				);
				if(dialogResult == JOptionPane.YES_OPTION){
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource saveResource = resourceSet.createResource(URI.createFileURI(res.getURI().toFileString().replace(".gcd", ".gsm")));
					EObject eObject = res.getContents().get(0);
					res.getContents().remove(eObject);
					saveResource.getContents().add(eObject);
					saveResource.save(Collections.EMPTY_MAP);
					
					JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "Models successfully exported to: " + saveResource.getURI().toFileString());
				}
			}
		}
	}
	
	public static void normalSave(EObject rootElem, String parentFolder, String fileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource saveResource = resourceSet.createResource(URI.createFileURI(URI.decode(parentFolder + File.separator + fileName)));
		saveResource.getContents().add(rootElem);
		saveResource.save(Collections.EMPTY_MAP);
	}
	
	public static void serialize(EObject rootElem, String parentFolder, String fileName) throws IOException {
		Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		StatechartLanguageSerializer serializer = injector.getInstance(StatechartLanguageSerializer.class);
		serializer.save(rootElem, URI.decode(parentFolder + File.separator + fileName));
   }
	
	public static void saveModel(EObject rootElem, String parentFolder, String fileName) throws IOException {
		if (rootElem instanceof Package) {
			try {
				// Trying to serialize the model
				serialize(rootElem, parentFolder, fileName);
				JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "Models successfully exported to: " + parentFolder);
			} catch (Exception e) {
				e.printStackTrace();
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (Application.getInstance().getMainFrame(), "Could not export into gcl. Reason: \n"
						+ e.getMessage() + "\nDo you want to export as gsl?", "Export error",  dialogButton
				);
				if(dialogResult == JOptionPane.YES_OPTION){
					new File(parentFolder + File.separator + fileName).delete();
					// Saving like an EMF model
					String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".gsm";
					normalSave(rootElem, parentFolder, newFileName);
					
					JOptionPane.showMessageDialog(Application.getInstance().getMainFrame(), "Models successfully exported to: " + parentFolder);
				}
			}

		}
		else {
			// It is not a statechart model, regular saving
			normalSave(rootElem, parentFolder, fileName);
		}
	}
	
	public static URI createURI(String parentFolder, String fileName) {
		return URI.createFileURI(parentFolder + File.separator + fileName);
	}
	
	public static void serialize(Map<URI, EObject> rootObjects) throws IOException {
		saveModel(rootObjects);
	}
	
	private static void saveModel(Map<URI, EObject> rootObjects) throws IOException {
		Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		StatechartLanguageSerializer serializer = injector.getInstance(StatechartLanguageSerializer.class);
		serializer.save(rootObjects);
	}
}