package hu.bme.mit.md2g.verification;

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

import hu.bme.mit.gamma.trace.language.TraceLanguageStandaloneSetup;

class TraceLanguageSerializer {
	
	XtextResourceSet resourceSet;
	
	static {
		TraceLanguageStandaloneSetup.doSetup();
	}

	@Inject
	public TraceLanguageSerializer(XtextResourceSet resourceSet) {
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

	void save(EObject object, String fileName) throws IOException {
		URI traceUri = URI.createFileURI(fileName);
		resolveResources(object, new HashSet<Resource>());
		Resource traceResource = resourceSet.createResource(traceUri);
		traceResource.getContents().add(object);
		traceResource.save(Collections.EMPTY_MAP);
	}
}