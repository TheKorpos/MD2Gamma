package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.util.AbstractMap.SimpleEntry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;

import hu.bme.mit.gamma.statechart.model.EventTrigger;
import hu.bme.mit.gamma.statechart.model.InitialState;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.State;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.Transition;
import hu.bme.mit.gamma.statechart.model.Trigger;
import hu.bme.mit.gamma.uppaal.serializer.UppaalModelSerializer;
import hu.bme.mit.gamma.uppaal.transformation.batch.StatechartToUppaalTransformer;
import hu.bme.mit.gamma.uppaal.transformation.traceability.G2UTrace;
import uppaal.NTA;

public class TestVerificationAction extends MDAction {

	public TestVerificationAction(String id, String name) {
		super(id, name, null, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		StatechartModelFactory f = StatechartModelFactory.eINSTANCE;
		hu.bme.mit.gamma.statechart.model.Package p = f.createPackage();
		StatechartDefinition def = f.createStatechartDefinition();
		p.getComponents().add(def);
		p.setName("main");
		
		
		Region region = f.createRegion();
		region.setName("MainRegion");
		
		def.getRegions().add(region);
		
		InitialState is = f.createInitialState();
		region.getStateNodes().add(is);
		
		State state = f.createState();
		state.setName("First State");
		
		region.getStateNodes().add(state);
		
		Transition trans = f.createTransition();
		
		trans.setSourceState(is);
		trans.setTargetState(state);
		
		def.getTransitions().add(trans);
		
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("gammastatechart"));
		r.getContents().add(p);
		
		StatechartToUppaalTransformer transformer = new StatechartToUppaalTransformer(p);
		SimpleEntry<NTA, G2UTrace> entry = transformer.execute();
		
		final String mdHome = Application.environment().getInstallRoot();
		
		UppaalModelSerializer.saveToXML(entry.getKey(), mdHome + "\\gammaOut\\something");
	}

}
