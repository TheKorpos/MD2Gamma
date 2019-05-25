package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch;

import com.google.common.base.Objects;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.TimeEvent;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage;
import hu.bme.mit.gamma.statechart.model.PortEventReference;
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.model.TimeSpecification;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration;
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage;
import hu.bme.mit.magicdraw2gamma.plugin.parsing.ActionParser;
import hu.bme.mit.magicdraw2gamma.plugin.queries.EventTriggers;
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.OwnedOperations;
import hu.bme.mit.magicdraw2gamma.plugin.queries.PseudoStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SignalsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInStatemachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TimeEventsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TranisitonsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class MagicdrawToGammaTransformer {
  /**
   * Transformation-related extensions
   */
  @Extension
  private BatchTransformation transformation;
  
  @Extension
  private BatchTransformationStatements statements;
  
  /**
   * Transformation rule-related extensions
   */
  @Extension
  private BatchTransformationRuleFactory _batchTransformationRuleFactory = new BatchTransformationRuleFactory();
  
  @Extension
  private IModelManipulations manipulation;
  
  /**
   * Other extensions
   */
  @Extension
  private Tracer tracer;
  
  @Extension
  private SearchQueries searchQueries = SearchQueries.instance();
  
  @Extension
  private StatechartModelPackage statechartPackage = StatechartModelPackage.eINSTANCE;
  
  @Extension
  private InterfacePackage interfacePackage = InterfacePackage.eINSTANCE;
  
  @Extension
  private ConstraintModelPackage constraintModelPackage = ConstraintModelPackage.eINSTANCE;
  
  private MD2GTrace traceRoot;
  
  private ViatraQueryEngine engine;
  
  private final ActionParser timeP = new ActionParser();
  
  public MagicdrawToGammaTransformer(final ViatraQueryEngine engine, final Tracer tracer) {
    this.engine = engine;
    this.traceRoot = this.traceRoot;
    this.tracer = tracer;
    this.createTransformation();
  }
  
  public void execute() {
    this.statements.<OwnedOperations.Match>fireAllCurrent(this.operationsRule);
    this.statements.<SignalsInStateMachine.Match>fireAllCurrent(this.collectEventsRule);
    this.statements.<MainRegions.Match>fireAllCurrent(this.mainRegionRule);
    this.statements.<StatesInStatemachine.Match>fireAllCurrent(this.statePrepareRule);
    this.statements.<RegionsInStates.Match>fireAllCurrent(this.regionsInStatesRule);
    this.statements.<StatesInRegions.Match>fireAllCurrent(this.statesInRegionsRule);
    this.statements.<PseudoStates.Match>fireAllCurrent(this.pseudoStateRule);
    this.statements.<TranisitonsInStateMachine.Match>fireAllCurrent(this.transitionRule);
    this.statements.<EventTriggers.Match>fireAllCurrent(this.callOperationTrigger);
    this.statements.<TimeEventsInStateMachine.Match>fireAllCurrent(this.timeEventRule);
  }
  
  private final BatchTransformationRule<OwnedOperations.Match, OwnedOperations.Matcher> operationsRule = this._batchTransformationRuleFactory.<OwnedOperations.Match, OwnedOperations.Matcher>createRule(this.searchQueries.getOwnedOperations()).action(((Consumer<OwnedOperations.Match>) (OwnedOperations.Match match) -> {
    try {
      final Interface gInterface = match.getGInterface();
      EObject _createChild = this.manipulation.createChild(gInterface, this.interfacePackage.getInterface_Events(), this.interfacePackage.getEventDeclaration());
      final Procedure1<EventDeclaration> _function = (EventDeclaration it) -> {
        it.setDirection(EventDirection.IN);
      };
      final EventDeclaration gEventDeclaration = ObjectExtensions.<EventDeclaration>operator_doubleArrow(((EventDeclaration) _createChild), _function);
      EObject _createChild_1 = this.manipulation.createChild(gEventDeclaration, this.interfacePackage.getEventDeclaration_Event(), this.interfacePackage.getEvent());
      final Procedure1<Event> _function_1 = (Event it) -> {
        String _name = match.getOperation().getName();
        String _plus = ("Operation_Call_" + _name);
        it.setName(_plus);
      };
      final Event gEvent = ObjectExtensions.<Event>operator_doubleArrow(((Event) _createChild_1), _function_1);
      this.tracer.createInterfaceTrace(match.getOperation(), gEvent);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<SignalsInStateMachine.Match, SignalsInStateMachine.Matcher> collectEventsRule = this._batchTransformationRuleFactory.<SignalsInStateMachine.Match, SignalsInStateMachine.Matcher>createRule(this.searchQueries.getSignalsInStateMachine()).action(((Consumer<SignalsInStateMachine.Match>) (SignalsInStateMachine.Match match) -> {
    try {
      final Trigger mdTrigger = match.getTrigger();
      final Collection<Port> mdSourcePorts = mdTrigger.getPort();
      int _size = mdSourcePorts.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
      } else {
        final Signal mdSignal = match.getSignal();
        final Interface gInterface = match.getGInterface();
        EObject _createChild = this.manipulation.createChild(gInterface, this.interfacePackage.getInterface_Events(), this.interfacePackage.getEventDeclaration());
        final Procedure1<EventDeclaration> _function = (EventDeclaration it) -> {
          it.setDirection(EventDirection.IN);
        };
        final EventDeclaration gEventDeclaration = ObjectExtensions.<EventDeclaration>operator_doubleArrow(((EventDeclaration) _createChild), _function);
        EObject _createChild_1 = this.manipulation.createChild(gEventDeclaration, this.interfacePackage.getEventDeclaration_Event(), this.interfacePackage.getEvent());
        final Procedure1<Event> _function_1 = (Event it) -> {
          String _name = mdSignal.getName();
          String _plus = ("Signal_" + _name);
          it.setName(_plus);
        };
        final Event gEvent = ObjectExtensions.<Event>operator_doubleArrow(((Event) _createChild_1), _function_1);
        this.tracer.createInterfaceTrace(mdSignal, gEvent);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<MainRegions.Match, MainRegions.Matcher> mainRegionRule = this._batchTransformationRuleFactory.<MainRegions.Match, MainRegions.Matcher>createRule(this.searchQueries.getMainRegions()).action(((Consumer<MainRegions.Match>) (MainRegions.Match match) -> {
    try {
      final StateMachine mdStateMachine = match.getStateMachine();
      final Region mdRegion = match.getRegion();
      final StatechartDefinition gStatechartDefinition = IterableExtensions.<StatechartDefinition>head(this.tracer.pairs(mdStateMachine));
      EObject _createChild = this.manipulation.createChild(gStatechartDefinition, this.statechartPackage.getCompositeElement_Regions(), this.statechartPackage.getRegion());
      final Procedure1<hu.bme.mit.gamma.statechart.model.Region> _function = (hu.bme.mit.gamma.statechart.model.Region it) -> {
        String _xifexpression = null;
        String _name = mdRegion.getName();
        boolean _equals = Objects.equal(_name, "");
        if (_equals) {
          BaseElement _objectParent = mdRegion.getObjectParent();
          String _name_1 = ((NamedElement) _objectParent).getName();
          _xifexpression = ("R_" + _name_1);
        } else {
          _xifexpression = this.statechartPackage.getRegion().getName();
        }
        it.setName(_xifexpression);
      };
      final hu.bme.mit.gamma.statechart.model.Region gRegion = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.Region>operator_doubleArrow(((hu.bme.mit.gamma.statechart.model.Region) _createChild), _function);
      this.tracer.createTrace(mdRegion, gRegion);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<StatesInStatemachine.Match, StatesInStatemachine.Matcher> statePrepareRule = this._batchTransformationRuleFactory.<StatesInStatemachine.Match, StatesInStatemachine.Matcher>createRule(this.searchQueries.getStatesInStatemachine()).action(((Consumer<StatesInStatemachine.Match>) (StatesInStatemachine.Match match) -> {
    try {
      final StateMachine mdStateMachine = match.getStateMachine();
      final State mdState = match.getState();
      final StatechartDefinition gStatechart = IterableExtensions.<StatechartDefinition>head(this.tracer.pairs(mdStateMachine));
      EObject _createChild = this.manipulation.createChild(IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(gStatechart.getRegions()), this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getState());
      final Procedure1<hu.bme.mit.gamma.statechart.model.State> _function = (hu.bme.mit.gamma.statechart.model.State it) -> {
        it.setName(mdState.getName());
      };
      final hu.bme.mit.gamma.statechart.model.State gState = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.State>operator_doubleArrow(((hu.bme.mit.gamma.statechart.model.State) _createChild), _function);
      this.tracer.createTrace(mdState, gState);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<RegionsInStates.Match, RegionsInStates.Matcher> regionsInStatesRule = this._batchTransformationRuleFactory.<RegionsInStates.Match, RegionsInStates.Matcher>createRule(this.searchQueries.getRegionsInStates()).action(((Consumer<RegionsInStates.Match>) (RegionsInStates.Match match) -> {
    try {
      final State mdState = match.getContainingState();
      final Region mdRegion = match.getRegion();
      final StateNode gState = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      final EObject gRegion = this.manipulation.createChild(gState, this.statechartPackage.getCompositeElement_Regions(), this.statechartPackage.getRegion());
      ((hu.bme.mit.gamma.statechart.model.Region) gRegion).setName(mdRegion.getName());
      this.tracer.createTrace(mdRegion, gRegion);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<StatesInRegions.Match, StatesInRegions.Matcher> statesInRegionsRule = this._batchTransformationRuleFactory.<StatesInRegions.Match, StatesInRegions.Matcher>createRule(this.searchQueries.getStatesInRegions()).action(((Consumer<StatesInRegions.Match>) (StatesInRegions.Match match) -> {
    try {
      final Region mdRegion = match.getContainingRegion();
      final State mdState = match.getState();
      final hu.bme.mit.gamma.statechart.model.Region gRegion = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(this.tracer.pairs(mdRegion));
      final StateNode gState = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      this.manipulation.moveTo(gState, gRegion, this.statechartPackage.getRegion_StateNodes());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<PseudoStates.Match, PseudoStates.Matcher> pseudoStateRule = this._batchTransformationRuleFactory.<PseudoStates.Match, PseudoStates.Matcher>createRule(this.searchQueries.getPseudoStates()).action(
    ((Consumer<PseudoStates.Match>) (PseudoStates.Match match) -> {
      try {
        final Region mdRegion = match.getContainingRegion();
        final Pseudostate mdVertex = match.getPseudoState();
        final PseudostateKind mdStateKind = match.getKind();
        final hu.bme.mit.gamma.statechart.model.Region gRegion = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(this.tracer.pairs(mdRegion));
        StateNode pseudoState = null;
        boolean _matched = false;
        if (Objects.equal(mdStateKind, PseudostateKindEnum.INITIAL)) {
          _matched=true;
          EObject _createChild = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getInitialState());
          pseudoState = ((StateNode) _createChild);
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.SHALLOWHISTORY)) {
            _matched=true;
            EObject _createChild_1 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getShallowHistoryState());
            pseudoState = ((StateNode) _createChild_1);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.CHOICE)) {
            _matched=true;
            EObject _createChild_2 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getChoiceState());
            pseudoState = ((StateNode) _createChild_2);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.FORK)) {
            _matched=true;
            EObject _createChild_3 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getForkState());
            pseudoState = ((StateNode) _createChild_3);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.JOIN)) {
            _matched=true;
            EObject _createChild_4 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getJoinState());
            pseudoState = ((StateNode) _createChild_4);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.DEEPHISTORY)) {
            _matched=true;
            EObject _createChild_5 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getDeepHistoryState());
            pseudoState = ((StateNode) _createChild_5);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.JUNCTION)) {
            _matched=true;
            EObject _createChild_6 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getMergeState());
            pseudoState = ((StateNode) _createChild_6);
          }
        }
        if (!_matched) {
          {
            System.out.println(("not been converted " + mdVertex));
            return;
          }
        }
        pseudoState.setName(mdVertex.getName());
        this.tracer.createTrace(mdVertex, pseudoState);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    })).build();
  
  private final BatchTransformationRule<TranisitonsInStateMachine.Match, TranisitonsInStateMachine.Matcher> transitionRule = this._batchTransformationRuleFactory.<TranisitonsInStateMachine.Match, TranisitonsInStateMachine.Matcher>createRule(this.searchQueries.getTranisitonsInStateMachine()).action(((Consumer<TranisitonsInStateMachine.Match>) (TranisitonsInStateMachine.Match match) -> {
    try {
      final Transition mdTransition = match.getTransition();
      final StateMachine mdStateMachine = match.getStateMachine();
      final Vertex mdSource = mdTransition.getSource();
      final Vertex mdTarget = mdTransition.getTarget();
      final StateNode gSource = IterableExtensions.<StateNode>head(this.tracer.pairs(mdSource));
      final StateNode gTarget = IterableExtensions.<StateNode>head(this.tracer.pairs(mdTarget));
      final StatechartDefinition gStatechart = IterableExtensions.<StatechartDefinition>head(this.tracer.pairs(mdStateMachine));
      EObject _createChild = this.manipulation.createChild(gStatechart, this.statechartPackage.getStatechartDefinition_Transitions(), this.statechartPackage.getTransition());
      final Procedure1<hu.bme.mit.gamma.statechart.model.Transition> _function = (hu.bme.mit.gamma.statechart.model.Transition it) -> {
        it.setSourceState(gSource);
        it.setTargetState(gTarget);
      };
      final hu.bme.mit.gamma.statechart.model.Transition gTransition = ObjectExtensions.<hu.bme.mit.gamma.statechart.model.Transition>operator_doubleArrow(((hu.bme.mit.gamma.statechart.model.Transition) _createChild), _function);
      this.tracer.createTrace(mdTransition, gTransition);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<TimeEventsInStateMachine.Match, TimeEventsInStateMachine.Matcher> timeEventRule = this._batchTransformationRuleFactory.<TimeEventsInStateMachine.Match, TimeEventsInStateMachine.Matcher>createRule(this.searchQueries.getTimeEventsInStateMachine()).action(((Consumer<TimeEventsInStateMachine.Match>) (TimeEventsInStateMachine.Match match) -> {
    try {
      boolean _isRelative = match.getEvent().isRelative();
      if (_isRelative) {
        final Transition mdTransition = match.getTransition();
        final Vertex mdState = mdTransition.getSource();
        if ((mdState instanceof State)) {
          final hu.bme.mit.gamma.statechart.model.Transition gTransition = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Transition>head(this.tracer.pairs(mdTransition));
          final StateNode gStateNode = gTransition.getSourceState();
          final TimeEvent mdEvent = match.getEvent();
          final StateMachine mdStateMachine = match.getStateMachine();
          final StatechartDefinition gStatechart = IterableExtensions.<StatechartDefinition>head(this.tracer.pairs(mdStateMachine));
          final EObject gTimeoutDeclaration = this.manipulation.createChild(gStatechart, this.statechartPackage.getStatechartDefinition_TimeoutDeclarations(), this.statechartPackage.getTimeoutDeclaration());
          EObject _createChild = this.manipulation.createChild(gStateNode, this.statechartPackage.getState_EntryActions(), this.statechartPackage.getSetTimeoutAction());
          final SetTimeoutAction gSetTimeoutAction = ((SetTimeoutAction) _createChild);
          this.manipulation.add(gSetTimeoutAction, this.statechartPackage.getTimeoutAction_TimeoutDeclaration(), gTimeoutDeclaration);
          ValueSpecification _expr = mdEvent.getWhen().getExpr();
          final LiteralString expr = ((LiteralString) _expr);
          EObject _parseTimeSpecification = this.timeP.parseTimeSpecification(expr.getValue());
          final TimeSpecification gTimeSpecification = ((TimeSpecification) _parseTimeSpecification);
          gSetTimeoutAction.setTime(gTimeSpecification);
          final EObject gTrigger = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getEventTrigger());
          final EObject gTmeoutEventReference = this.manipulation.createChild(gTrigger, this.statechartPackage.getEventTrigger_EventReference(), this.statechartPackage.getTimeoutEventReference());
          this.manipulation.addTo(gTmeoutEventReference, this.statechartPackage.getTimeoutEventReference_Timeout(), gTimeoutDeclaration);
          this.tracer.createOnetToManyTrace(IterableExtensions.<Trigger>head(match.getTransition().getTrigger()), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gTimeoutDeclaration, gSetTimeoutAction, gTrigger)));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<EventTriggers.Match, EventTriggers.Matcher> callOperationTrigger = this._batchTransformationRuleFactory.<EventTriggers.Match, EventTriggers.Matcher>createRule(this.searchQueries.getEventTriggers()).action(((Consumer<EventTriggers.Match>) (EventTriggers.Match match) -> {
    try {
      final Transition mdTransition = match.getTransition();
      final hu.bme.mit.gamma.statechart.model.Transition gTransition = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Transition>head(this.tracer.pairs(mdTransition));
      final EObject gEventTrigger = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getEventTrigger());
      EObject _createChild = this.manipulation.createChild(gEventTrigger, this.statechartPackage.getEventTrigger_EventReference(), this.statechartPackage.getPortEventReference());
      final Procedure1<PortEventReference> _function = (PortEventReference it) -> {
        it.setPort(match.getGPort());
        it.setEvent(match.getGEvent());
      };
      ObjectExtensions.<PortEventReference>operator_doubleArrow(
        ((PortEventReference) _createChild), _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private BatchTransformationStatements createTransformation() {
    BatchTransformationStatements _xblockexpression = null;
    {
      SimpleModelManipulations _simpleModelManipulations = new SimpleModelManipulations(this.engine);
      this.manipulation = _simpleModelManipulations;
      this.transformation = BatchTransformation.forEngine(this.engine).build();
      _xblockexpression = this.statements = this.transformation.getTransformationStatements();
    }
    return _xblockexpression;
  }
  
  public void dispose() {
    this.transformation = null;
    return;
  }
}
