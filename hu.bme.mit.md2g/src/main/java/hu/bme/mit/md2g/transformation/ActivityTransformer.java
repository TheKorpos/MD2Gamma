package hu.bme.mit.md2g.transformation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.beust.jcommander.internal.Lists;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.SendSignalAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.ActivityEdge;
import com.nomagic.uml2.ext.magicdraw.activities.mdbasicactivities.InitialNode;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.ActivityNode;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import hu.bme.mit.gamma.action.model.Action;
import hu.bme.mit.gamma.statechart.interface_.Event;
import hu.bme.mit.gamma.statechart.statechart.RaiseEventAction;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;

public class ActivityTransformer {
	
	public static List<Action> tryTransform(Activity activity, Map<Signal, Event> signalTraces, Map<Port, hu.bme.mit.gamma.statechart.interface_.Port> portTraces) {
		Optional<ActivityNode> init = activity.getNode().stream().filter(InitialNode.class::isInstance).findFirst();
		if (!init.isPresent()) return Lists.newArrayList();
		
		List<SendSignalAction> sendActions = new LinkedList<>();
		
		if (init.isPresent()) {
			
			ActivityNode source = init.get();
			
			Optional<SendSignalAction> hopOne = hopOne(source);
			
			while (hopOne.isPresent()) {
				SendSignalAction sendSignalAction = hopOne.get();
				
				if (!sendActions.contains(sendSignalAction)) {
					sendActions.add(sendSignalAction);
					hopOne = hopOne(sendSignalAction);
				} else {
					hopOne = Optional.empty();
				}
			}
			
		}
		
		return sendActions.stream().map(act -> {
			Signal signal = act.getSignal();
			Event event = signalTraces.get(signal);
			Port onPort = act.getOnPort();
			hu.bme.mit.gamma.statechart.interface_.Port gPort = portTraces.get(onPort);
			
			 RaiseEventAction raise = StatechartModelFactory.eINSTANCE.createRaiseEventAction();
			 raise.setEvent(event);
			 raise.setPort(gPort);
			 
			 return raise;
		}).collect(Collectors.toList());	
	}

	private static Optional<SendSignalAction> hopOne(ActivityNode source) {
		return source.getOutgoing().stream().map(ActivityEdge::getTarget).filter(SendSignalAction.class::isInstance).map(SendSignalAction.class::cast).findFirst();
	}
}
