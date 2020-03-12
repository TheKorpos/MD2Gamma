package hu.bme.mit.md2g.transformation;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.sysml.util.SysMLProfile;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Constraint;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.SignalEvent;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.TimeEvent;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;

import hu.bme.mit.gamma.action.model.Action;
import hu.bme.mit.gamma.expression.model.Declaration;
import hu.bme.mit.gamma.expression.model.Expression;
import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.IntegerLiteralExpression;
import hu.bme.mit.gamma.expression.model.TypeDefinition;
import hu.bme.mit.gamma.expression.model.VariableDeclaration;
import hu.bme.mit.gamma.statechart.model.DeepHistoryState;
import hu.bme.mit.gamma.statechart.model.EventTrigger;
import hu.bme.mit.gamma.statechart.model.ForkState;
import hu.bme.mit.gamma.statechart.model.InitialState;
import hu.bme.mit.gamma.statechart.model.InterfaceRealization;
import hu.bme.mit.gamma.statechart.model.JoinState;
import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.Port;
import hu.bme.mit.gamma.statechart.model.PortEventReference;
import hu.bme.mit.gamma.statechart.model.RealizationMode;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction;
import hu.bme.mit.gamma.statechart.model.ShallowHistoryState;
import hu.bme.mit.gamma.statechart.model.State;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.TimeSpecification;
import hu.bme.mit.gamma.statechart.model.TimeUnit;
import hu.bme.mit.gamma.statechart.model.TimeoutDeclaration;
import hu.bme.mit.gamma.statechart.model.TimeoutEventReference;
import hu.bme.mit.gamma.statechart.model.Transition;
import hu.bme.mit.gamma.statechart.model.composite.Component;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;
import hu.bme.mit.md2g.transformation.parse.GammaExpression;
import hu.bme.mit.md2g.transformation.queries.DeepHistoryInStateMachine;
import hu.bme.mit.md2g.transformation.queries.ForksInStateMachine;
import hu.bme.mit.md2g.transformation.queries.InitialStatesInStatemachine;
import hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.RegionsInStatemachine;
import hu.bme.mit.md2g.transformation.queries.ShallowHistoryInStatemachine;
import hu.bme.mit.md2g.transformation.queries.StatesInStatemachine;
import hu.bme.mit.md2g.transformation.queries.TranisitonsInStateMachine;
import hu.bme.mit.md2g.util.NameSanitizer;

public class StatechartTransformation {

	private final StatechartModelFactory statechartFactory = StatechartModelFactory.eINSTANCE;
	private final Project project = Application.getInstance().getProject();
	private final Map<Vertex, StateNode> vertexTraces = new HashMap<>();
	private final Map<com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region, Region> regionTraces = new HashMap<>();
	private final Map<com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition, Transition> transitionTraces = new HashMap<>();
	private final Map<com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port, Port> portTraces = new HashMap<>();
	private static int nextElementSuffixId = 0;
	private final NameSanitizer nameSanitizer = new NameSanitizer();
	
	private Map<String, Declaration> variables = new HashMap<>();
	
	private final Map<com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition, Constraint>
		discoveredGuards = new HashMap<>();
	
	private final Class stateMachineClass;
	private StatechartDefinition gStatechart;
	
	public StatechartTransformation(Class stateMachine) {
		this.stateMachineClass = stateMachine;
	}
	
	public Map<com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port, Port> getPortTraces() {
		return portTraces;
	}
	
	public StatechartDefinition transform(Package statechartPackage, Map<Signal, Event> signalTraces, Map<Classifier, Interface> interfaceTraces) {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		ViatraQueryEngine engine = adapter.getEngine();
		
		StateMachine stateMachine = (StateMachine) stateMachineClass.getClassifierBehavior();
	
		gStatechart = statechartFactory.createStatechartDefinition();
		gStatechart.setName(nameSanitizer.getSenitizedName(stateMachine) + "_Statechart");
		
		stateMachineClass.getMember().stream()
			.filter(Property.class::isInstance)
			.map(Property.class::cast)
			.forEach(prop -> {
				Type type = prop.getType();
				if (type == SysMLProfile.getInstance(project).getInteger()) {
					createVariable(prop, ExpressionModelFactory.eINSTANCE.createIntegerTypeDefinition());
				} else if (type == SysMLProfile.getInstance(project).getBoolean()) {
					createVariable(prop, ExpressionModelFactory.eINSTANCE.createBooleanTypeDefinition());
				}
			});
		
		transformPort(stateMachineClass, gStatechart, interfaceTraces, portTraces);
		
		RegionsInStatemachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(this::transformRegions);;
		InitialStatesInStatemachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(this::transformInitialState);
		StatesInStatemachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(it -> transformState(it, signalTraces));
		ShallowHistoryInStatemachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(this::transformShallowHistory);
		DeepHistoryInStateMachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(this::transformDeepHistory);
		ForksInStateMachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(this::transformForkState);
		TranisitonsInStateMachine.Matcher.on(engine).getAllMatches(stateMachine, null)
				.forEach(match -> transformTransition(match, signalTraces));
		
	
		
		vertexTraces.forEach((vertex, stateNode) -> {
			regionTraces.get(vertex.getContainer()).getStateNodes().add(stateNode);
		});
		
		regionTraces.forEach((mdRegion, gRegion) -> {
			BaseElement mdElement = mdRegion.getObjectParent();
			
			if (mdElement == stateMachine) {
				gStatechart.getRegions().add(gRegion);
			} else if (mdElement instanceof Vertex) {
				State gState = (State) vertexTraces.get((Vertex) mdElement);
				gState.getRegions().add(gRegion);
			}
			
		});
		
		gStatechart.getTransitions().addAll(transitionTraces.values());
		
		statechartPackage.getComponents().add(gStatechart);
	
		return gStatechart;
	}

	private void createVariable(Property prop, TypeDefinition gType) {
		VariableDeclaration variable = ExpressionModelFactory.eINSTANCE.createVariableDeclaration();
		 variable.setName(nameSanitizer.getSenitizedName(prop));
		variable.setType(gType);
		gStatechart.getVariableDeclarations().add(variable);
		variables.put(prop.getName(), variable);
	}
	
	public static void transformPort(Class mdClass, Component component, Map<Classifier, Interface> interfaceTraces, Map<com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port, Port> portTraces) {
		
		StatechartModelFactory statechartFactory = StatechartModelFactory.eINSTANCE;
		NameSanitizer nameSanitizer = new NameSanitizer();
		
		mdClass.getOwnedPort().forEach(port -> {
			Port gPort = statechartFactory.createPort();
			gPort.setName(nameSanitizer.getSenitizedName(port));
			component.getPorts().add(gPort);
			
			
			Interface gInterface = interfaceTraces.get((Classifier)port.getType());
			
			InterfaceRealization realization = statechartFactory.createInterfaceRealization();
			realization.setInterface(gInterface);
			gPort.setInterfaceRealization(realization);
			
			if (port.isConjugated()) {
				realization.setRealizationMode(RealizationMode.REQUIRED);
			} else {
				realization.setRealizationMode(RealizationMode.PROVIDED);
			}
			
			portTraces.put(port, gPort);
		});
	}

	private void transformRegions(RegionsInStatemachine.Match match) {
		Region gRegion = statechartFactory.createRegion();
		gRegion.setName(nameSanitizer.getSenitizedName(match.getSubregion()));
		regionTraces.put(match.getSubregion(), gRegion);
	}

	private void transformInitialState(InitialStatesInStatemachine.Match match) {
		InitialState gInitState = statechartFactory.createInitialState();
		gInitState.setName(nameSanitizer.getSenitizedName(match.getInitialState()));
		vertexTraces.put(match.getInitialState(), gInitState);
	}
	
	private void transformState(StatesInStatemachine.Match match, Map<Signal, Event> signalTraces) {
		State gState = statechartFactory.createState();
		gState.setName(nameSanitizer.getSenitizedName(match.getState()));
		
		transformAction(match.getState().getEntry(), gState.getEntryActions(), signalTraces);
		transformAction(match.getState().getExit(), gState.getExitActions(), signalTraces);
		
		vertexTraces.put(match.getState(), gState);
	}
	
	private void transformAction(Behavior entry, List<Action> actions, Map<Signal, Event> signalTraces) {
		if (entry == null || !(entry instanceof Activity)) return;
		List<Action> tryTransform = ActivityTransformer.tryTransform((Activity) entry,  signalTraces, portTraces);
		tryTransform.forEach(actions::add);
	}

	private void transformShallowHistory(ShallowHistoryInStatemachine.Match match) {
		ShallowHistoryState gShallow = statechartFactory.createShallowHistoryState();
		gShallow.setName(nameSanitizer.getSenitizedName(match.getHistory()));
		vertexTraces.put(match.getHistory(), gShallow);
	}
	
	private void transformDeepHistory(DeepHistoryInStateMachine.Match match) {
		DeepHistoryState gDeep = statechartFactory.createDeepHistoryState();
		gDeep.setName(nameSanitizer.getSenitizedName(match.getHistory()));
		vertexTraces.put(match.getHistory(), gDeep);
	}
	
	private void transformTransition(TranisitonsInStateMachine.Match match, Map<Signal, Event> signalTraces) {
		Vertex source = match.getTransition().getSource();
		Vertex target = match.getTransition().getTarget();
		
		Transition gTransition = statechartFactory.createTransition();
		
		gTransition.setSourceState(vertexTraces.get(source));
		gTransition.setTargetState(vertexTraces.get(target));
		
		Optional<Trigger> trigger = match.getTransition().getTrigger().stream().findFirst();
		trigger.ifPresent(tr -> {
			if (tr.getEvent() instanceof TimeEvent) {
				TimeEvent te = (TimeEvent) tr.getEvent();
				if (te.isRelative()) {
					transformTimeEvent(gTransition, te);
				}
			} else if (tr.getEvent() instanceof SignalEvent) {
				transformSignalEvent(gTransition, tr, signalTraces);
			}
		});
		
		Constraint guard = match.getTransition().getGuard();
		
		if (guard != null) {
			if (guard.getSpecification() instanceof OpaqueExpression) {
				transformGuards(gTransition, (OpaqueExpression) guard.getSpecification()); 
			}
		}
		
		Behavior behavior = match.getTransition().getEffect();
		if (behavior != null) {
			if (behavior instanceof Activity) {
				Activity activity = (Activity) behavior;
				List<Action> tryTransform = ActivityTransformer.tryTransform(activity, signalTraces, portTraces);
				tryTransform.forEach(gTransition.getEffects()::add);
			}
		}
		
		transitionTraces.put(match.getTransition(), gTransition);
	}
	
	private void transformSignalEvent(Transition gTransition, Trigger trigger, Map<Signal, Event> signalTraces) {
		final SignalEvent signalEvent = (SignalEvent) trigger.getEvent();
		Signal signal = signalEvent.getSignal();
		Event gEvent = signalTraces.get(signal);
		
		trigger.getPort().stream().findFirst().ifPresent(mdPort -> {			
			Port port = portTraces.get(mdPort);
			
			EventTrigger eventTrigger = statechartFactory.createEventTrigger();
			
			PortEventReference ref = statechartFactory.createPortEventReference();
			ref.setEvent(gEvent);
			ref.setPort(port);
			
			eventTrigger.setEventReference(ref);
			
			gTransition.setTrigger(eventTrigger);
		});
	}

	private void transformGuards(Transition transition, OpaqueExpression expression) {
		if (!expression.getBody().isEmpty()) {
			String body = expression.getBody().get(0);
			Expression gExpression = GammaExpression.of(body, variables);
			Transition gTransition = transition;
			gTransition.setGuard(gExpression);
		}
	}
	
	private void transformForkState(ForksInStateMachine.Match match) {
		ForkState forkState = statechartFactory.createForkState();
		forkState.setName(nameSanitizer.getSenitizedName(match.getForkState()));
		vertexTraces.put(match.getForkState(), forkState);
	}
	
	public void transformJoinSate(JoinsInStateMachine.Match match) {
		JoinState createJoinState = statechartFactory.createJoinState();
		createJoinState.setName(nameSanitizer.getSenitizedName(match.getJoinState()));
		vertexTraces.put(match.getJoinState(), createJoinState);
	}
	
	public Map<com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition, Constraint> getDiscoveredGuards() {
		return discoveredGuards;
	}
	
	
	private void transformTimeEvent(Transition transition, TimeEvent event) {
		TimeoutDeclaration gTimeout = statechartFactory.createTimeoutDeclaration();
		gTimeout.setName("timeout_"+nextElementSuffixId++);
		
		gStatechart.getTimeoutDeclarations().add(gTimeout);
		
		TimeoutEventReference timoutEventReference = statechartFactory.createTimeoutEventReference();
		timoutEventReference.setTimeout(gTimeout);
		
		EventTrigger eventTrigger = statechartFactory.createEventTrigger();
		eventTrigger.setEventReference(timoutEventReference);
		
		State sourceState = (State) transition.getSourceState();
		
		SetTimeoutAction action = statechartFactory.createSetTimeoutAction();
		TimeSpecification spec = statechartFactory.createTimeSpecification();
		
		LiteralString ls = (LiteralString) event.getWhen().getExpr();
		String value = ls.getValue().trim();
		
		if (value.endsWith("s")) {
			spec.setUnit(TimeUnit.SECOND);
		} else {
			spec.setUnit(TimeUnit.MILLISECOND);
		}
		
	
		IntegerLiteralExpression literalInt = ExpressionModelFactory.eINSTANCE.createIntegerLiteralExpression();
		literalInt.setValue(new BigInteger(value.split("[a-zA-z]")[0]));
		
		spec.setValue(literalInt);
		
		action.setTime(spec);
		action.setTimeoutDeclaration(gTimeout);
		
		sourceState.getEntryActions().add(action);
		
		transition.setTrigger(eventTrigger);
	}
	
}
