package hu.bme.mit.md2g.transformation;

import java.util.Map;
import java.util.Optional;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.SendSignalAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.InitialNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.ActivityNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdintermediateactivities.FinalNode;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import hu.bme.mit.gamma.action.model.Action;
import hu.bme.mit.gamma.statechart.model.RaiseEventAction;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.interface_.Event;

public class ActivityTransformer {
	
	public static Optional<Action> tryTransform(Activity activity, Map<Signal, Event> signalTraces, Map<Port, hu.bme.mit.gamma.statechart.model.Port> portTraces) {
		Optional<ActivityNode> init = activity.getNode().stream().filter(InitialNode.class::isInstance).findFirst();
		Optional<ActivityNode> end = activity.getNode().stream().filter(FinalNode.class::isInstance).findFirst();
		Optional<SendSignalAction> sendSignalAction = activity.getNode().stream().filter(SendSignalAction.class::isInstance).map(SendSignalAction.class::cast).findFirst();
		
		if (!init.isPresent()) return Optional.empty();
		if (!end.isPresent()) return Optional.empty();
		if (activity.getNode().size() != 3) return Optional.empty();
		
		return sendSignalAction.map(act -> {
			Signal signal = act.getSignal();
			Event event = signalTraces.get(signal);
			Port onPort = act.getOnPort();
			hu.bme.mit.gamma.statechart.model.Port gPort = portTraces.get(onPort);
			
			 RaiseEventAction raise = StatechartModelFactory.eINSTANCE.createRaiseEventAction();
			 raise.setEvent(event);
			 raise.setPort(gPort);
			 
			 return raise;
		});	
	}
}
