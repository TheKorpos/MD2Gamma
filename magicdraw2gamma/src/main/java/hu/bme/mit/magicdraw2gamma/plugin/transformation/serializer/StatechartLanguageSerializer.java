package hu.bme.mit.magicdraw2gamma.plugin.transformation.serializer;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;


import com.google.inject.Inject;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;

public class StatechartLanguageSerializer {

	private XtextResourceSet resourceSet;
	
	static {
		StatechartLanguageStandaloneSetup.doSetup(); // Should be removed but does not work without this
	}

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
}