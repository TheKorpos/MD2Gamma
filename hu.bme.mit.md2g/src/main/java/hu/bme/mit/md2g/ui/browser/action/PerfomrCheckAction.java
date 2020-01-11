package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.actions.NMAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder;
import hu.bme.mit.gamma.uppaal.composition.transformation.ModelUnfolder.Trace;
import hu.bme.mit.gamma.uppaal.composition.transformation.CompositeToUppaalTransformer.Scheduler;
import hu.bme.mit.gamma.uppaal.composition.transformation.SimpleInstanceHandler;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import hu.bme.mit.md2g.transformation.CompositeTransformation;
import uppaal.NTA;

public class PerfomrCheckAction  extends NMAction {
	
	final Class target;

	public PerfomrCheckAction(String id, String name, Class target) {
		super(id, name, 0, null);
		this.target = target;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
//		CompositeTransformation compositTransformation = new CompositeTransformation();
//		Package gammaModel = compositTransformation.transform(target);
//		
//		ResourceSet rs = new ResourceSetImpl();
//		
//		Trace trace = new ModelUnfolder().unfold(gammaModel);
//		Component topComponent = trace.getTopComponent();
//		
//		Resource res = rs.createResource(URI.createURI("__synthetic/helloworld.gcd"));
//		res.getContents().add(trace.getPackage());
//		
//		SimpleInstanceHandler simpleInstanceHandler = new SimpleInstanceHandler();
//		
//		CompositeToUppaalTransformer transformer = new CompositeToUppaalTransformer(rs,
//				topComponent, Scheduler.RANDOM, simpleInstanceHandler.getSimpleInstances(topComponent), Collections.emptyList());
//		
//		SimpleEntry<NTA, G2UTrace> resultModels = transformer.execute();
//		
		
	}

}
