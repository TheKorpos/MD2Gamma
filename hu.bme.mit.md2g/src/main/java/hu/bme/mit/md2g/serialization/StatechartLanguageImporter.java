package hu.bme.mit.md2g.serialization;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Injector;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;

public class StatechartLanguageImporter {
	
	static {
		StatechartLanguageStandaloneSetup.doSetup();
	}
	
	private XtextResourceSet resourceSet;

	@Inject
	public StatechartLanguageImporter(XtextResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}
	
	public static StatechartLanguageImporter createImporter() {
		Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		return injector.getInstance(StatechartLanguageImporter.class);
	}
	
	public Map<URI, Resource> importResources(Set<URI> uris) {
		
		Map<URI, Resource> resourceMap = new HashMap<URI, Resource>();
		
		uris.forEach(uri -> {
			Resource res = resourceSet.createResource(uri);
			
			try {
				res.load(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		
	
		resourceSet.getResources().forEach(res -> {
			resourceMap.put(res.getURI(), res);
		});
		
		
		return resourceMap;
	}
	
	
}
