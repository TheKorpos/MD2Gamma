package hu.bme.mit.magicdraw2gamma.plugin.trafos;

import com.google.common.base.Objects;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.State;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.PseudoStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionTrace;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateTrace;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartTrace;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TranisitonsInStateMachine;
import hu.bme.mit.magicdraw2gamma.plugin.queries.VertexTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.AbstractTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  protected ViatraQueryEngine engine;
  
  private ViatraQueryEngine targetModelEngine;
  
  protected Resource resource;
  
  private final StatechartModelFactory f = StatechartModelFactory.eINSTANCE;
  
  private MD2GTrace traceRoot;
  
  public MagicdrawToGammaTransformer(final ViatraQueryEngine sourceModelEngine, final ViatraQueryEngine targetModelEngine, final MD2GTrace traceRoot) {
    this.engine = sourceModelEngine;
    this.targetModelEngine = targetModelEngine;
    this.traceRoot = traceRoot;
    this.createTransformation();
  }
  
  public void execute() {
    this.statements.<MainRegions.Match>fireAllCurrent(this.mainRegionRule);
    this.statements.<StatesInRegions.Match>fireAllCurrent(this.statesInRegionsRule);
    this.statements.<RegionsInStates.Match>fireAllCurrent(this.regionsInStatesRule);
    this.statements.<PseudoStates.Match>fireAllCurrent(this.pseudoStateRule);
    this.statements.<TranisitonsInStateMachine.Match>fireAllCurrent(this.transitionRule);
  }
  
  private final BatchTransformationRule<MainRegions.Match, MainRegions.Matcher> mainRegionRule = this._batchTransformationRuleFactory.<MainRegions.Match, MainRegions.Matcher>createRule().precondition(MainRegions.instance()).action(((Consumer<MainRegions.Match>) (MainRegions.Match match) -> {
    final Optional<StatechartTrace.Match> trace = this.trace(match.getStateMachine());
    boolean _isPresent = trace.isPresent();
    if (_isPresent) {
      StatechartDefinition _target = trace.get().getTarget();
      final StatechartDefinition statechartdef = ((StatechartDefinition) _target);
      final Region mainRegion = this.f.createRegion();
      mainRegion.setName(match.getRegion().getName());
      EList<Region> _regions = statechartdef.getRegions();
      _regions.add(mainRegion);
      this.makeAndAddTrace(this.traceRoot, match.getRegion(), mainRegion);
    }
  })).build();
  
  private final BatchTransformationRule<StatesInRegions.Match, StatesInRegions.Matcher> statesInRegionsRule = this._batchTransformationRuleFactory.<StatesInRegions.Match, StatesInRegions.Matcher>createRule().precondition(StatesInRegions.instance()).action(((Consumer<StatesInRegions.Match>) (StatesInRegions.Match match) -> {
    final Optional<RegionTrace.Match> regionTrace = this.trace(match.getContainingRegion());
    final State gammaState = this.f.createState();
    gammaState.setName(match.getState().getName());
    this.makeAndAddTrace(this.traceRoot, match.getState(), gammaState);
    boolean _isPresent = regionTrace.isPresent();
    if (_isPresent) {
      EObject _target = regionTrace.get().getTarget();
      final Region gammaRegion = ((Region) _target);
      EList<StateNode> _stateNodes = gammaRegion.getStateNodes();
      _stateNodes.add(gammaState);
    } else {
      final Region gammaRegion_1 = this.f.createRegion();
      EList<StateNode> _stateNodes_1 = gammaRegion_1.getStateNodes();
      _stateNodes_1.add(gammaState);
      this.makeAndAddTrace(this.traceRoot, match.getContainingRegion(), gammaRegion_1);
    }
  })).build();
  
  private final BatchTransformationRule<RegionsInStates.Match, RegionsInStates.Matcher> regionsInStatesRule = this._batchTransformationRuleFactory.<RegionsInStates.Match, RegionsInStates.Matcher>createRule().precondition(RegionsInStates.instance()).action(((Consumer<RegionsInStates.Match>) (RegionsInStates.Match match) -> {
    final Optional<StateTrace.Match> t = this.trace(match.getContainingState());
    final Optional<RegionTrace.Match> s = this.trace(match.getRegion());
    EObject _target = t.get().getTarget();
    final State gammaState = ((State) _target);
    boolean _isPresent = s.isPresent();
    boolean _not = (!_isPresent);
    if (_not) {
      final Region gammaRegion = this.f.createRegion();
      gammaRegion.setName(match.getRegion().getName());
      EList<Region> _regions = gammaState.getRegions();
      _regions.add(gammaRegion);
      this.makeAndAddTrace(this.traceRoot, match.getRegion(), gammaRegion);
    } else {
      EObject _target_1 = s.get().getTarget();
      final Region gammaRegion_1 = ((Region) _target_1);
      EList<Region> _regions_1 = gammaState.getRegions();
      _regions_1.add(gammaRegion_1);
    }
  })).build();
  
  private final BatchTransformationRule<PseudoStates.Match, PseudoStates.Matcher> pseudoStateRule = this._batchTransformationRuleFactory.<PseudoStates.Match, PseudoStates.Matcher>createRule().precondition(PseudoStates.instance()).action(
    ((Consumer<PseudoStates.Match>) (PseudoStates.Match match) -> {
      EObject _target = this.trace(match.getContainingRegion()).get().getTarget();
      final Region gammaRegion = ((Region) _target);
      StateNode pseudoState = null;
      PseudostateKind _kind = match.getKind();
      boolean _matched = false;
      if (Objects.equal(_kind, PseudostateKindEnum.INITIAL)) {
        _matched=true;
        pseudoState = this.f.createInitialState();
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.SHALLOWHISTORY)) {
          _matched=true;
          pseudoState = this.f.createShallowHistoryState();
        }
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.CHOICE)) {
          _matched=true;
          pseudoState = this.f.createChoiceState();
        }
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.FORK)) {
          _matched=true;
          pseudoState = this.f.createForkState();
        }
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.JOIN)) {
          _matched=true;
          pseudoState = this.f.createJoinState();
        }
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.DEEPHISTORY)) {
          _matched=true;
          pseudoState = this.f.createDeepHistoryState();
        }
      }
      if (!_matched) {
        if (Objects.equal(_kind, PseudostateKindEnum.JUNCTION)) {
          _matched=true;
          pseudoState = this.f.createMergeState();
        }
      }
      EList<StateNode> _stateNodes = gammaRegion.getStateNodes();
      _stateNodes.add(pseudoState);
      this.makeAndAddTrace(this.traceRoot, match.getPseudoState(), pseudoState);
    })).build();
  
  private final BatchTransformationRule<TranisitonsInStateMachine.Match, TranisitonsInStateMachine.Matcher> transitionRule = this._batchTransformationRuleFactory.<TranisitonsInStateMachine.Match, TranisitonsInStateMachine.Matcher>createRule().precondition(TranisitonsInStateMachine.instance()).action(((Consumer<TranisitonsInStateMachine.Match>) (TranisitonsInStateMachine.Match match) -> {
    final Transition transion = match.getTransition();
    final hu.bme.mit.gamma.statechart.model.Transition gammaTransition = this.f.createTransition();
    EList<hu.bme.mit.gamma.statechart.model.Transition> _transitions = this.trace(match.getStateMachine()).get().getTarget().getTransitions();
    _transitions.add(gammaTransition);
    EObject _target = this.trace(transion.getSource()).get().getTarget();
    final StateNode gammaStateNodeS = ((StateNode) _target);
    EObject _target_1 = this.trace(transion.getTarget()).get().getTarget();
    final StateNode gammaStateNodeT = ((StateNode) _target_1);
    gammaTransition.setSourceState(gammaStateNodeS);
    gammaTransition.setTargetState(gammaStateNodeT);
  })).build();
  
  private Optional<StatechartTrace.Match> trace(final StateMachine stmt) {
    Optional<StatechartTrace.Match> _xblockexpression = null;
    {
      final StatechartTrace.Matcher matcher = StatechartTrace.instance().getMatcher(this.targetModelEngine);
      final Collection<StatechartTrace.Match> matches = matcher.getAllMatches(stmt, null, null);
      _xblockexpression = Optional.<StatechartTrace.Match>ofNullable(IterableExtensions.<StatechartTrace.Match>head(matches));
    }
    return _xblockexpression;
  }
  
  private Optional<RegionTrace.Match> trace(final com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region region) {
    Optional<RegionTrace.Match> _xblockexpression = null;
    {
      final RegionTrace.Matcher matcher = RegionTrace.instance().getMatcher(this.targetModelEngine);
      final Collection<RegionTrace.Match> matches = matcher.getAllMatches(region, null, null);
      _xblockexpression = Optional.<RegionTrace.Match>ofNullable(IterableExtensions.<RegionTrace.Match>head(matches));
    }
    return _xblockexpression;
  }
  
  private Optional<StateTrace.Match> trace(final com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State state) {
    Optional<StateTrace.Match> _xblockexpression = null;
    {
      final StateTrace.Matcher matcher = StateTrace.instance().getMatcher(this.targetModelEngine);
      final Collection<StateTrace.Match> matches = matcher.getAllMatches(state, null, null);
      _xblockexpression = Optional.<StateTrace.Match>ofNullable(IterableExtensions.<StateTrace.Match>head(matches));
    }
    return _xblockexpression;
  }
  
  private boolean makeAndAddTrace(final MD2GTrace root, final EObject source, final EObject target) {
    boolean _xblockexpression = false;
    {
      final Trace ret = TraceFactory.eINSTANCE.createTrace();
      EList<EObject> _source = ret.getSource();
      _source.add(source);
      EList<EObject> _target = ret.getTarget();
      _target.add(target);
      EList<AbstractTrace> _traces = root.getTraces();
      _xblockexpression = _traces.add(ret);
    }
    return _xblockexpression;
  }
  
  private Optional<VertexTrace.Match> trace(final Vertex vertex) {
    Optional<VertexTrace.Match> _xblockexpression = null;
    {
      final VertexTrace.Matcher matcher = VertexTrace.instance().getMatcher(this.targetModelEngine);
      final Collection<VertexTrace.Match> matches = matcher.getAllMatches(vertex, null, null);
      _xblockexpression = Optional.<VertexTrace.Match>ofNullable(IterableExtensions.<VertexTrace.Match>head(matches));
    }
    return _xblockexpression;
  }
  
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
