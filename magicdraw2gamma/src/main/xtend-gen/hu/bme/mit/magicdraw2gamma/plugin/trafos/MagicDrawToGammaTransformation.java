package hu.bme.mit.magicdraw2gamma.plugin.trafos;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.FinalState;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.StateNode;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.Transition;
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.OwnedTransitions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class MagicDrawToGammaTransformation {
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
  
  private final StatechartModelFactory f = StatechartModelFactory.eINSTANCE;
  
  /**
   * VIATRA Query Pattern Group
   */
  @Extension
  private final StatechartDefinitions statechartDefinitions = StatechartDefinitions.instance();
  
  private final Map<Element, StatechartDefinition> gammaStateDefs = Maps.<Element, StatechartDefinition>newHashMap();
  
  private final Map<Element, Region> gammaRegions = Maps.<Element, Region>newHashMap();
  
  private final Map<Element, StateNode> gammaStateNode = Maps.<Element, StateNode>newHashMap();
  
  private final List<Element> processedRegions = Lists.<Element>newArrayList();
  
  private final List<Element> unProcessedRegions = Lists.<Element>newArrayList();
  
  /**
   * Rules
   */
  private final BatchTransformationRule<StatechartDefinitions.Match, StatechartDefinitions.Matcher> statechartDefinitionCreationRule = this._batchTransformationRuleFactory.<StatechartDefinitions.Match, StatechartDefinitions.Matcher>createRule().precondition(this.statechartDefinitions).action(((Consumer<StatechartDefinitions.Match>) (StatechartDefinitions.Match match) -> {
    final StatechartDefinition statechartDef = this.f.createStatechartDefinition();
    this.gammaStateDefs.put(match.getStatechartDefinition(), statechartDef);
  })).build();
  
  private final BatchTransformationRule<MainRegions.Match, MainRegions.Matcher> mainRegionsCreationRule = this._batchTransformationRuleFactory.<MainRegions.Match, MainRegions.Matcher>createRule().precondition(MainRegions.instance()).action(((Consumer<MainRegions.Match>) (MainRegions.Match match) -> {
    final Region region = this.f.createRegion();
    region.setName(match.getRegion().getName());
    this.gammaRegions.put(match.getRegion(), region);
    EList<Region> _regions = this.gammaStateDefs.get(match.getStatechartDefinition()).getRegions();
    _regions.add(region);
    com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region _region = match.getRegion();
    this.processedRegions.add(_region);
  })).build();
  
  private final BatchTransformationRule<StatesInRegions.Match, StatesInRegions.Matcher> statesInRegionsCreationRule = this._batchTransformationRuleFactory.<StatesInRegions.Match, StatesInRegions.Matcher>createRule().precondition(StatesInRegions.instance()).action(((Consumer<StatesInRegions.Match>) (StatesInRegions.Match match) -> {
    final Vertex vertex = match.getVertex();
    StateNode statenode = null;
    if ((vertex instanceof State)) {
      statenode = this.f.createState();
    }
    if ((vertex instanceof Pseudostate)) {
      statenode = this.f.createInitialState();
    }
    if ((vertex instanceof FinalState)) {
      statenode = this.f.createState();
      statenode.setName("FinalState");
    }
    boolean _contains = this.processedRegions.contains(match.getRegion());
    if (_contains) {
      EList<StateNode> _stateNodes = this.gammaRegions.get(match.getRegion()).getStateNodes();
      _stateNodes.add(statenode);
    } else {
      boolean _contains_1 = this.unProcessedRegions.contains(match.getRegion());
      boolean _not = (!_contains_1);
      if (_not) {
        final Region region = this.f.createRegion();
        region.setName(match.getRegion().getName());
        this.unProcessedRegions.add(match.getRegion());
        this.gammaRegions.put(match.getRegion(), region);
      }
      EList<StateNode> _stateNodes_1 = this.gammaRegions.get(match.getRegion()).getStateNodes();
      _stateNodes_1.add(statenode);
    }
    statenode.setName(vertex.getName());
    this.gammaStateNode.put(match.getVertex(), statenode);
  })).build();
  
  private final BatchTransformationRule<OwnedTransitions.Match, OwnedTransitions.Matcher> transitionsCreationRule = this._batchTransformationRuleFactory.<OwnedTransitions.Match, OwnedTransitions.Matcher>createRule().precondition(OwnedTransitions.instance()).action(((Consumer<OwnedTransitions.Match>) (OwnedTransitions.Match match) -> {
    final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class mdStatechartDef = match.getStmt();
    final StatechartDefinition gammaStatechartDef = this.gammaStateDefs.get(mdStatechartDef);
    final Transition tra = this.f.createTransition();
    final Vertex source = match.getTransition().getSource();
    final Vertex target = match.getTransition().getTarget();
    tra.setSourceState(this.gammaStateNode.get(source));
    tra.setTargetState(this.gammaStateNode.get(target));
    EList<Transition> _transitions = gammaStatechartDef.getTransitions();
    _transitions.add(tra);
  })).build();
  
  public MagicDrawToGammaTransformation(final ViatraQueryEngine engine) {
    this.engine = engine;
    this.createTransformation();
  }
  
  private void processRemainingRegions() {
    final RegionsInStates.Matcher matcher = RegionsInStates.instance().getMatcher(this.engine);
    final Consumer<Element> _function = (Element r) -> {
      final RegionsInStates.Match match = matcher.newEmptyMatch();
      match.set("region", r);
      final Consumer<RegionsInStates.Match> _function_1 = (RegionsInStates.Match m) -> {
        final StateNode stateNode = this.gammaStateNode.get(m.getState());
        EList<Region> _regions = ((hu.bme.mit.gamma.statechart.model.State) stateNode).getRegions();
        Region _get = this.gammaRegions.get(r);
        _regions.add(_get);
      };
      matcher.getAllMatches(match).forEach(_function_1);
    };
    this.unProcessedRegions.stream().forEach(_function);
  }
  
  public void execute() {
    this.statements.<StatechartDefinitions.Match>fireAllCurrent(this.statechartDefinitionCreationRule);
    this.statements.<MainRegions.Match>fireAllCurrent(this.mainRegionsCreationRule);
    this.statements.<StatesInRegions.Match>fireAllCurrent(this.statesInRegionsCreationRule);
    this.processRemainingRegions();
    this.statements.<OwnedTransitions.Match>fireAllCurrent(this.transitionsCreationRule);
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
  
  public Map<Element, StatechartDefinition> getStatechartDefs() {
    return this.gammaStateDefs;
  }
  
  public void dispose() {
    this.transformation = null;
    return;
  }
}
