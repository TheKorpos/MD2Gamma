package hu.bme.mit.md2g.transformation;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.beust.jcommander.internal.Maps;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;

import hu.bme.mit.md2g.transformation.queries.FragmentTrace;

public class TraceModelManager {
	
	private final Class container;
	private final ResourceSetImpl rs;
	private final Resource resource;
	private final ViatraQueryEngine engine;
	
	public TraceModelManager(ViatraQueryEngine engine, Class container) {
		this.container = container;
		this.rs = new ResourceSetImpl();
		this.engine = engine;
		this.resource = rs.createResource(URI.createFileURI(container.getName()));
	}
	
	public void loadResource() throws IOException {
		this.resource.load(Maps.newHashMap());
	}
	
	public Set<NamedElement> g2md(EObject eObj) {
		String uriFragment = resource.getURIFragment(eObj);
		return FragmentTrace.Matcher.on(engine).getAllValuesOfelemnet(uriFragment);
	}
	
	public Set<EObject> md2g(NamedElement element){
		Set<String> uriFragments = FragmentTrace.Matcher.on(engine).getAllValuesOfuriFragment(element);
		return uriFragments.stream().map(resource::getEObject).collect(Collectors.toSet());
	}
	
}
