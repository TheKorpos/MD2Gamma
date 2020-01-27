package hu.bme.mit.md2g.transformation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.beust.jcommander.internal.Lists;
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
	
	public static List<Action> tryTransform(Activity activity, Map<Signal, Event> signalTraces, Map<Port, hu.bme.mit.gamma.statechart.model.Port> portTraces) {
		Optional<ActivityNode> init = activity.getNode().stream().filter(InitialNode.class::isInstance).findFirst();
		Optional<ActivityNode> end = activity.getNode().stream().filter(FinalNode.class::isInstance).findFirst();
		List<SendSignalAction> sendSignalAction = activity.getNode().stream().filter(SendSignalAction.class::isInstance).map(SendSignalAction.class::cast).collect(Collectors.toList());
		
		if (!init.isPresent()) return Lists.newArrayList();
		if (!end.isPresent()) return Lists.newArrayList();
		if (sendSignalAction.size() + 2 != activity.getNode().size()) return Lists.newArrayList();
		
		return sendSignalAction.stream().map(act -> {
			Signal signal = act.getSignal();
			Event event = signalTraces.get(signal);
			Port onPort = act.getOnPort();
			hu.bme.mit.gamma.statechart.model.Port gPort = portTraces.get(onPort);
			
			 RaiseEventAction raise = StatechartModelFactory.eINSTANCE.createRaiseEventAction();
			 raise.setEvent(event);
			 raise.setPort(gPort);
			 
			 return raise;
		}).collect(Collectors.toList());	
	}
}
