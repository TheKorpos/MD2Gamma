package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch;

import com.google.common.base.Objects;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.TimeEvent;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import hu.bme.mit.gamma.action.model.ActionModelPackage;
import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage;
import hu.bme.mit.gamma.constraint.model.NamedElement;
import hu.bme.mit.gamma.constraint.model.OpaqueExpression;
import hu.bme.mit.gamma.constraint.model.ParameterDeclaration;
import hu.bme.mit.gamma.constraint.model.VariableDeclaration;
import hu.bme.mit.gamma.statechart.model.OpaqueTrigger;
import hu.bme.mit.gamma.statechart.model.PortEventReference;
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.model.TimeSpecification;
import hu.bme.mit.gamma.statechart.model.TimeoutDeclaration;
import hu.bme.mit.gamma.statechart.model.TimeoutEventReference;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration;
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection;
import hu.bme.mit.gamma.statechart.model.interface_.Interface;
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage;
import hu.bme.mit.magicdraw2gamma.plugin.parsing.GammaExpressionParser;
import hu.bme.mit.magicdraw2gamma.plugin.queries.ActionsOnTransitions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.AnyEventTriggers;
import hu.bme.mit.magicdraw2gamma.plugin.queries.EntryActions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.EventTriggers;
import hu.bme.mit.magicdraw2gamma.plugin.queries.ExitActions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.GuardsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.OpaqueTriggers;
import hu.bme.mit.magicdraw2gamma.plugin.queries.OwnedOperations;
import hu.bme.mit.magicdraw2gamma.plugin.queries.ParametersInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.PropertiesInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.PseudoStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SignalsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInStatemachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TimeEventsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TranisitonsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer;
import hu.bme.mit.magicdraw2gamma.plugin.transformation.NameFormatter;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClass;
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
  
  @Extension
  private ActionModelPackage actionModelPackage = ActionModelPackage.eINSTANCE;
  
  @Extension
  private NameFormatter nameFormatter = new NameFormatter();
  
  private final ArrayList<String> masseges = new ArrayList<String>();
  
  private MD2GTrace traceRoot;
  
  private ViatraQueryEngine engine;
  
  private final GammaExpressionParser timeP = new GammaExpressionParser();
  
  public MagicdrawToGammaTransformer(final ViatraQueryEngine engine, final Tracer tracer) {
    this.engine = engine;
    this.traceRoot = this.traceRoot;
    this.tracer = tracer;
    this.createTransformation();
  }
  
  public void execute() {
    this.statements.<ParametersInStateMachine.Match>fireAllCurrent(this.parameterRule);
    this.statements.<PropertiesInStateMachine.Match>fireAllCurrent(this.propertyRule);
    this.statements.<OwnedOperations.Match>fireAllCurrent(this.operationsRule);
    this.statements.<SignalsInStateMachine.Match>fireAllCurrent(this.collectEventsRule);
    this.statements.<MainRegions.Match>fireAllCurrent(this.mainRegionRule);
    this.statements.<StatesInStatemachine.Match>fireAllCurrent(this.statePrepareRule);
    this.statements.<RegionsInStates.Match>fireAllCurrent(this.regionsInStatesRule);
    this.statements.<StatesInRegions.Match>fireAllCurrent(this.statesInRegionsRule);
    this.statements.<PseudoStates.Match>fireAllCurrent(this.pseudoStateRule);
    this.statements.<TranisitonsInStateMachine.Match>fireAllCurrent(this.transitionRule);
    this.statements.<EventTriggers.Match>fireAllCurrent(this.callOperationTrigger);
    this.statements.<AnyEventTriggers.Match>fireAllCurrent(this.anyTriggerRule);
    this.statements.<TimeEventsInStateMachine.Match>fireAllCurrent(this.timeEventRule);
    this.statements.<OpaqueTriggers.Match>fireAllCurrent(this.opaqueTriggerRule);
    this.statements.<GuardsInStateMachine.Match>fireAllCurrent(this.guardRule);
    this.statements.<ActionsOnTransitions.Match>fireAllCurrent(this.actionRule);
    this.statements.<EntryActions.Match>fireAllCurrent(this.entryActionRule);
    this.statements.<ExitActions.Match>fireAllCurrent(this.exitActionRule);
  }
  
  public ArrayList<String> getMessage() {
    return this.masseges;
  }
  
  private EClass getTypeByName(final String mdTypeName) {
    if (mdTypeName != null) {
      switch (mdTypeName) {
        case "Integer":
          return this.constraintModelPackage.getIntegerTypeDefinition();
        case "Boolean":
          return this.constraintModelPackage.getBooleanTypeDefinition();
        default:
          return this.constraintModelPackage.getIntegerTypeDefinition();
      }
    } else {
      return this.constraintModelPackage.getIntegerTypeDefinition();
    }
  }
  
  private final BatchTransformationRule<ParametersInStateMachine.Match, ParametersInStateMachine.Matcher> parameterRule = this._batchTransformationRuleFactory.<ParametersInStateMachine.Match, ParametersInStateMachine.Matcher>createRule(this.searchQueries.getParametersInStateMachine()).action(((Consumer<ParametersInStateMachine.Match>) (ParametersInStateMachine.Match match) -> {
    try {
      final StateMachine mdStateMachine = match.getStateMachine();
      final Parameter property = match.getParameter();
      final Type mdPropertyType = property.getType();
      EClass propertyType = null;
      if ((mdPropertyType == null)) {
      } else {
        propertyType = this.getTypeByName(mdPropertyType.getName());
      }
      EObject _createChild = this.manipulation.createChild(IterableExtensions.<StatechartDefinition>head(this.tracer.pairs(mdStateMachine)), this.constraintModelPackage.getParametricElement_ParameterDeclarations(), this.constraintModelPackage.getParameterDeclaration());
      final Procedure1<ParameterDeclaration> _function = (ParameterDeclaration it) -> {
        it.setName(this.nameFormatter.fomratName(property.getName()));
      };
      final ParameterDeclaration gParameterDecl = ObjectExtensions.<ParameterDeclaration>operator_doubleArrow(((ParameterDeclaration) _createChild), _function);
      this.manipulation.createChild(gParameterDecl, this.constraintModelPackage.getDeclaration_Type(), propertyType);
      this.tracer.createTrace(property, gParameterDecl);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<PropertiesInStateMachine.Match, PropertiesInStateMachine.Matcher> propertyRule = this._batchTransformationRuleFactory.<PropertiesInStateMachine.Match, PropertiesInStateMachine.Matcher>createRule(this.searchQueries.getPropertiesInStateMachine()).action(((Consumer<PropertiesInStateMachine.Match>) (PropertiesInStateMachine.Match match) -> {
    try {
      final Property property = match.getProp();
      EClass propertyType = this.getTypeByName(property.getType().getName());
      EObject _createChild = this.manipulation.createChild(IterableExtensions.<NamedElement>head(this.tracer.genericPair(match.getStateMachine())), this.statechartPackage.getStatechartDefinition_VariableDeclarations(), this.constraintModelPackage.getVariableDeclaration());
      final Procedure1<VariableDeclaration> _function = (VariableDeclaration it) -> {
        it.setName(this.nameFormatter.fomratName(property.getName()));
      };
      final VariableDeclaration gDclaration = ObjectExtensions.<VariableDeclaration>operator_doubleArrow(((VariableDeclaration) _createChild), _function);
      this.manipulation.createChild(gDclaration, this.constraintModelPackage.getDeclaration_Type(), propertyType);
      this.tracer.createTrace(property, gDclaration);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
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
        String _fomratName = this.nameFormatter.fomratName(match.getOperation().getName());
        String _plus = ("Operation_Call_" + _fomratName);
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
      final Signal mdSignal = match.getSignal();
      Interface _gInterface = match.getGInterface();
      final Interface gInterface = ((Interface) _gInterface);
      EObject _createChild = this.manipulation.createChild(gInterface, this.interfacePackage.getInterface_Events(), this.interfacePackage.getEventDeclaration());
      final Procedure1<EventDeclaration> _function = (EventDeclaration it) -> {
        it.setDirection(EventDirection.IN);
      };
      final EventDeclaration gEventDeclaration = ObjectExtensions.<EventDeclaration>operator_doubleArrow(((EventDeclaration) _createChild), _function);
      EObject _createChild_1 = this.manipulation.createChild(gEventDeclaration, this.interfacePackage.getEventDeclaration_Event(), this.interfacePackage.getEvent());
      final Procedure1<Event> _function_1 = (Event it) -> {
        it.setName(this.nameFormatter.fomratName(mdSignal.getName()));
      };
      final Event gEvent = ObjectExtensions.<Event>operator_doubleArrow(((Event) _createChild_1), _function_1);
      this.tracer.createInterfaceTrace(mdSignal, gEvent);
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
          String _name_1 = gStatechartDefinition.getName();
          _xifexpression = ("main_region_of_" + _name_1);
        } else {
          _xifexpression = this.nameFormatter.fomratName(this.statechartPackage.getRegion().getName());
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
      hu.bme.mit.gamma.statechart.model.Region _head = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(gStatechart.getRegions());
      final hu.bme.mit.gamma.statechart.model.Region mainRegion = ((hu.bme.mit.gamma.statechart.model.Region) _head);
      final int stateCount = mainRegion.getStateNodes().size();
      EObject _createChild = this.manipulation.createChild(mainRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getState());
      final Procedure1<hu.bme.mit.gamma.statechart.model.State> _function = (hu.bme.mit.gamma.statechart.model.State it) -> {
        if (((mdState.getName() == null) || Objects.equal(mdState.getName(), ""))) {
          it.setName(("state_" + Integer.valueOf(stateCount)));
        } else {
          String _fomratName = this.nameFormatter.fomratName(mdState.getName());
          String _plus = (_fomratName + "_");
          String _plus_1 = (_plus + Integer.valueOf(stateCount));
          it.setName(_plus_1);
        }
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
      StateNode _head = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      final hu.bme.mit.gamma.statechart.model.State gState = ((hu.bme.mit.gamma.statechart.model.State) _head);
      EObject _createChild = this.manipulation.createChild(gState, this.statechartPackage.getCompositeElement_Regions(), this.statechartPackage.getRegion());
      final hu.bme.mit.gamma.statechart.model.Region gRegion = ((hu.bme.mit.gamma.statechart.model.Region) _createChild);
      if (((gRegion.getName() == null) || Objects.equal(gRegion.getName(), ""))) {
        final int regionCount = gState.getRegions().size();
        String _name = gState.getName();
        String _plus = ((("region_" + Integer.valueOf(regionCount)) + "_in_") + _name);
        gRegion.setName(_plus);
      } else {
        gRegion.setName(this.nameFormatter.fomratName(mdRegion.getName()));
      }
      this.tracer.createTrace(mdRegion, gRegion);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<StatesInRegions.Match, StatesInRegions.Matcher> statesInRegionsRule = this._batchTransformationRuleFactory.<StatesInRegions.Match, StatesInRegions.Matcher>createRule(this.searchQueries.getStatesInRegions()).action(((Consumer<StatesInRegions.Match>) (StatesInRegions.Match match) -> {
    try {
      final Region mdRegion = match.getContainingRegion();
      final State mdState = match.getState();
      hu.bme.mit.gamma.statechart.model.Region _head = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(this.tracer.pairs(mdRegion));
      final hu.bme.mit.gamma.statechart.model.Region gRegion = ((hu.bme.mit.gamma.statechart.model.Region) _head);
      StateNode _head_1 = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      final hu.bme.mit.gamma.statechart.model.State gState = ((hu.bme.mit.gamma.statechart.model.State) _head_1);
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
        hu.bme.mit.gamma.statechart.model.Region _head = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Region>head(this.tracer.pairs(mdRegion));
        final hu.bme.mit.gamma.statechart.model.Region gRegion = ((hu.bme.mit.gamma.statechart.model.Region) _head);
        StateNode pseudoState = null;
        String cName = "";
        boolean _matched = false;
        if (Objects.equal(mdStateKind, PseudostateKindEnum.INITIAL)) {
          _matched=true;
          cName = "init";
          EObject _createChild = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getInitialState());
          pseudoState = ((StateNode) _createChild);
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.SHALLOWHISTORY)) {
            _matched=true;
            cName = "s_history";
            EObject _createChild_1 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getShallowHistoryState());
            pseudoState = ((StateNode) _createChild_1);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.CHOICE)) {
            _matched=true;
            cName = "choice";
            EObject _createChild_2 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getChoiceState());
            pseudoState = ((StateNode) _createChild_2);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.FORK)) {
            _matched=true;
            cName = "fork";
            EObject _createChild_3 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getForkState());
            pseudoState = ((StateNode) _createChild_3);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.JOIN)) {
            _matched=true;
            cName = "join";
            EObject _createChild_4 = this.manipulation.createChild(gRegion, this.statechartPackage.getRegion_StateNodes(), this.statechartPackage.getJoinState());
            pseudoState = ((StateNode) _createChild_4);
          }
        }
        if (!_matched) {
          if (Objects.equal(mdStateKind, PseudostateKindEnum.DEEPHISTORY)) {
            _matched=true;
            cName = "d_history";
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
            String _humanName = mdVertex.getHumanName();
            String _plus = (_humanName + " is not supported, skipping");
            this.masseges.add(_plus);
            return;
          }
        }
        if (((mdVertex.getName() == null) || Objects.equal(mdVertex.getName(), ""))) {
          final int statecount = gRegion.getStateNodes().size();
          String _name = gRegion.getName();
          String _plus = ((((cName + "_") + Integer.valueOf(statecount)) + "_in_") + _name);
          pseudoState.setName(_plus);
        } else {
          pseudoState.setName(this.nameFormatter.fomratName(mdVertex.getName()));
        }
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
          ValueSpecification _expr = mdEvent.getWhen().getExpr();
          final LiteralString expr = ((LiteralString) _expr);
          try {
            EObject _parseTimeSpecification = this.timeP.parseTimeSpecification(gStatechart, this.nameFormatter.fomratName(expr.getValue()));
            final TimeSpecification gTimeSpecification = ((TimeSpecification) _parseTimeSpecification);
            if (((gTimeSpecification == null) || (gTimeSpecification.getValue() == null))) {
              String _value = expr.getValue();
              String _plus = ("Could not parse: " + _value);
              throw new Exception(_plus);
            }
            EObject _createChild = this.manipulation.createChild(gStatechart, this.statechartPackage.getStatechartDefinition_TimeoutDeclarations(), this.statechartPackage.getTimeoutDeclaration());
            final TimeoutDeclaration gTimeoutDeclaration = ((TimeoutDeclaration) _createChild);
            int _size = gStatechart.getTimeoutDeclarations().size();
            String _plus_1 = ("timeout_" + Integer.valueOf(_size));
            gTimeoutDeclaration.setName(_plus_1);
            EObject _createChild_1 = this.manipulation.createChild(gStateNode, this.statechartPackage.getState_EntryActions(), this.statechartPackage.getSetTimeoutAction());
            final SetTimeoutAction gSetTimeoutAction = ((SetTimeoutAction) _createChild_1);
            gSetTimeoutAction.setTimeoutDeclaration(gTimeoutDeclaration);
            gSetTimeoutAction.setTime(gTimeSpecification);
            final EObject gTrigger = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getEventTrigger());
            EObject _createChild_2 = this.manipulation.createChild(gTrigger, this.statechartPackage.getEventTrigger_EventReference(), this.statechartPackage.getTimeoutEventReference());
            final TimeoutEventReference gTmeoutEventReference = ((TimeoutEventReference) _createChild_2);
            gTmeoutEventReference.setTimeout(gTimeoutDeclaration);
            this.tracer.createOnetToManyTrace(IterableExtensions.<Trigger>head(match.getTransition().getTrigger()), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gTimeoutDeclaration, gSetTimeoutAction, gTrigger)));
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              String _humanName = match.getEvent().getHumanName();
              String _plus_2 = ("invalid element: " + _humanName);
              String _plus_3 = (_plus_2 + ", falling back to opaque trigger\n");
              String _plus_4 = (_plus_3 + " reason: ");
              String _message = e.getMessage();
              String _plus_5 = (_plus_4 + _message);
              this.masseges.add(_plus_5);
              EObject _createChild_3 = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getOpaqueTrigger());
              final Procedure1<OpaqueTrigger> _function = (OpaqueTrigger it) -> {
                String _fomratName = this.nameFormatter.fomratName(expr.getValue());
                String _plus_6 = ("after(" + _fomratName);
                String _plus_7 = (_plus_6 + ")");
                it.setTrigger(_plus_7);
              };
              final OpaqueTrigger gTrigger_1 = ObjectExtensions.<OpaqueTrigger>operator_doubleArrow(((OpaqueTrigger) _createChild_3), _function);
              this.tracer.createTrace(IterableExtensions.<Trigger>head(mdTransition.getTrigger()), gTrigger_1);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
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
      this.tracer.createTrace(IterableExtensions.<Trigger>head(mdTransition.getTrigger()), gEventTrigger);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<AnyEventTriggers.Match, AnyEventTriggers.Matcher> anyTriggerRule = this._batchTransformationRuleFactory.<AnyEventTriggers.Match, AnyEventTriggers.Matcher>createRule(this.searchQueries.getAnyEventTriggers()).action(((Consumer<AnyEventTriggers.Match>) (AnyEventTriggers.Match match) -> {
    try {
      final Transition mdTransition = match.getTransition();
      final hu.bme.mit.gamma.statechart.model.Transition gTransition = match.getGTransition();
      final EObject gAnyTrigger = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getAnyTrigger());
      this.tracer.createTrace(IterableExtensions.<Trigger>head(mdTransition.getTrigger()), gAnyTrigger);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<OpaqueTriggers.Match, OpaqueTriggers.Matcher> opaqueTriggerRule = this._batchTransformationRuleFactory.<OpaqueTriggers.Match, OpaqueTriggers.Matcher>createRule(this.searchQueries.getOpaqueTriggers()).action(((Consumer<OpaqueTriggers.Match>) (OpaqueTriggers.Match match) -> {
    try {
      final Transition mdTransition = match.getTransition();
      final hu.bme.mit.gamma.statechart.model.Transition gTransition = match.getGTransition();
      if (((match.getTrigger().getName() != null) && (!Objects.equal(match.getTrigger().getName(), "")))) {
        EObject _createChild = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Trigger(), this.statechartPackage.getOpaqueTrigger());
        final Procedure1<OpaqueTrigger> _function = (OpaqueTrigger it) -> {
          String _xifexpression = null;
          com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Event _event = match.getTrigger().getEvent();
          boolean _tripleNotEquals = (_event != null);
          if (_tripleNotEquals) {
            _xifexpression = this.nameFormatter.fomratName(match.getTrigger().getEvent().getName());
          } else {
            _xifexpression = this.nameFormatter.fomratName(match.getTrigger().getName());
          }
          it.setTrigger(_xifexpression);
        };
        final OpaqueTrigger gOpaqueTrigger = ObjectExtensions.<OpaqueTrigger>operator_doubleArrow(((OpaqueTrigger) _createChild), _function);
        this.tracer.createTrace(IterableExtensions.<Trigger>head(mdTransition.getTrigger()), gOpaqueTrigger);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<GuardsInStateMachine.Match, GuardsInStateMachine.Matcher> guardRule = this._batchTransformationRuleFactory.<GuardsInStateMachine.Match, GuardsInStateMachine.Matcher>createRule(this.searchQueries.getGuardsInStateMachine()).action(((Consumer<GuardsInStateMachine.Match>) (GuardsInStateMachine.Match match) -> {
    try {
      final hu.bme.mit.gamma.statechart.model.Transition gTranistion = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Transition>head(this.tracer.pairs(match.getTransition()));
      final String guardString = match.getBody();
      EObject _createChild = this.manipulation.createChild(gTranistion, this.statechartPackage.getTransition_Guard(), this.constraintModelPackage.getOpaqueExpression());
      final Procedure1<OpaqueExpression> _function = (OpaqueExpression it) -> {
        it.setExpression(this.nameFormatter.fomratName(guardString));
      };
      final OpaqueExpression guardExpr = ObjectExtensions.<OpaqueExpression>operator_doubleArrow(((OpaqueExpression) _createChild), _function);
      Transition _transition = match.getTransition();
      com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression _opaqueExpression = match.getOpaqueExpression();
      this.tracer.createManyToManyTrace(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(_transition, _opaqueExpression)), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gTranistion, guardExpr)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<ActionsOnTransitions.Match, ActionsOnTransitions.Matcher> actionRule = this._batchTransformationRuleFactory.<ActionsOnTransitions.Match, ActionsOnTransitions.Matcher>createRule(this.searchQueries.getActionsOnTransitions()).action(((Consumer<ActionsOnTransitions.Match>) (ActionsOnTransitions.Match match) -> {
    try {
      final Transition mdTransition = match.getTransition();
      final String body = match.getBody();
      final hu.bme.mit.gamma.statechart.model.Transition gTransition = IterableExtensions.<hu.bme.mit.gamma.statechart.model.Transition>head(this.tracer.pairs(mdTransition));
      final EObject gAction = this.manipulation.createChild(gTransition, this.statechartPackage.getTransition_Effects(), this.actionModelPackage.getExpressionStatement());
      EObject _createChild = this.manipulation.createChild(gAction, this.actionModelPackage.getExpressionStatement_Expression(), this.constraintModelPackage.getOpaqueExpression());
      final Procedure1<OpaqueExpression> _function = (OpaqueExpression it) -> {
        it.setExpression(body);
      };
      ObjectExtensions.<OpaqueExpression>operator_doubleArrow(
        ((OpaqueExpression) _createChild), _function);
      Behavior _effect = match.getEffect();
      this.tracer.createManyToManyTrace(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(mdTransition, _effect)), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gAction)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<EntryActions.Match, EntryActions.Matcher> entryActionRule = this._batchTransformationRuleFactory.<EntryActions.Match, EntryActions.Matcher>createRule(this.searchQueries.getEntryActions()).action(((Consumer<EntryActions.Match>) (EntryActions.Match match) -> {
    try {
      final State mdState = match.getState();
      final String body = match.getBody();
      final StateNode gState = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      final EObject gAction = this.manipulation.createChild(gState, this.statechartPackage.getState_EntryActions(), this.actionModelPackage.getExpressionStatement());
      EObject _createChild = this.manipulation.createChild(gAction, this.actionModelPackage.getExpressionStatement_Expression(), this.constraintModelPackage.getOpaqueExpression());
      final Procedure1<OpaqueExpression> _function = (OpaqueExpression it) -> {
        it.setExpression(body);
      };
      ObjectExtensions.<OpaqueExpression>operator_doubleArrow(
        ((OpaqueExpression) _createChild), _function);
      Behavior _effect = match.getEffect();
      this.tracer.createManyToManyTrace(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(mdState, _effect)), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gAction)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  })).build();
  
  private final BatchTransformationRule<ExitActions.Match, ExitActions.Matcher> exitActionRule = this._batchTransformationRuleFactory.<ExitActions.Match, ExitActions.Matcher>createRule(this.searchQueries.getExitActions()).action(((Consumer<ExitActions.Match>) (ExitActions.Match match) -> {
    try {
      final State mdState = match.getState();
      final String body = match.getBody();
      final StateNode gState = IterableExtensions.<StateNode>head(this.tracer.pairs(mdState));
      final EObject gAction = this.manipulation.createChild(gState, this.statechartPackage.getState_ExitActions(), this.actionModelPackage.getExpressionStatement());
      EObject _createChild = this.manipulation.createChild(gAction, this.actionModelPackage.getExpressionStatement_Expression(), this.constraintModelPackage.getOpaqueExpression());
      final Procedure1<OpaqueExpression> _function = (OpaqueExpression it) -> {
        it.setExpression(body);
      };
      ObjectExtensions.<OpaqueExpression>operator_doubleArrow(
        ((OpaqueExpression) _createChild), _function);
      Behavior _effect = match.getEffect();
      this.tracer.createManyToManyTrace(Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(mdState, _effect)), Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(gAction)));
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
