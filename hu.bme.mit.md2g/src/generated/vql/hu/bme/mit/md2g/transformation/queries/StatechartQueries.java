/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import hu.bme.mit.md2g.transformation.queries.Actions;
import hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions;
import hu.bme.mit.md2g.transformation.queries.ChoiceStates;
import hu.bme.mit.md2g.transformation.queries.DeepHistoryInStateMachine;
import hu.bme.mit.md2g.transformation.queries.EntryActions;
import hu.bme.mit.md2g.transformation.queries.ExitActions;
import hu.bme.mit.md2g.transformation.queries.FinalStates;
import hu.bme.mit.md2g.transformation.queries.ForksInStateMachine;
import hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.InitialStatesInStatemachine;
import hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.Juncitons;
import hu.bme.mit.md2g.transformation.queries.MainRegions;
import hu.bme.mit.md2g.transformation.queries.OwnedTransitions;
import hu.bme.mit.md2g.transformation.queries.ParametersInStateMachine;
import hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine;
import hu.bme.mit.md2g.transformation.queries.RegionsInRegion;
import hu.bme.mit.md2g.transformation.queries.RegionsInStatechart;
import hu.bme.mit.md2g.transformation.queries.RegionsInStatemachine;
import hu.bme.mit.md2g.transformation.queries.RegionsInStates;
import hu.bme.mit.md2g.transformation.queries.RelativeTimeEventsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.ShallowHistoryInStatemachine;
import hu.bme.mit.md2g.transformation.queries.Signals;
import hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.StateMachines;
import hu.bme.mit.md2g.transformation.queries.StatesInMainRegion;
import hu.bme.mit.md2g.transformation.queries.StatesInRegions;
import hu.bme.mit.md2g.transformation.queries.StatesInStatemachine;
import hu.bme.mit.md2g.transformation.queries.TranisitonsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.Transitions;
import hu.bme.mit.md2g.transformation.queries.Triggers;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in StatechartQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file StatechartQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.md2g.transformation.queries, the group contains the definition of the following patterns: <ul>
 * <li>StateMachines</li>
 * <li>ParametersInStateMachine</li>
 * <li>RegionsInRegion</li>
 * <li>RegionsInStatemachine</li>
 * <li>InitialStatesInStatemachine</li>
 * <li>ShallowHistoryInStatemachine</li>
 * <li>DeepHistoryInStateMachine</li>
 * <li>ForksInStateMachine</li>
 * <li>JoinsInStateMachine</li>
 * <li>StatesInStatemachine</li>
 * <li>TranisitonsInStateMachine</li>
 * <li>SignalsInStateMachine</li>
 * <li>MainRegions</li>
 * <li>StatesInMainRegion</li>
 * <li>StatesInRegions</li>
 * <li>ChoiceStates</li>
 * <li>Juncitons</li>
 * <li>FinalStates</li>
 * <li>RegionsInStates</li>
 * <li>Transitions</li>
 * <li>RegionsInStatechart</li>
 * <li>OwnedTransitions</li>
 * <li>Triggers</li>
 * <li>Signals</li>
 * <li>GuardsInStateMachine</li>
 * <li>RelativeTimeEventsInStateMachine</li>
 * <li>PropertiesInStateMachine</li>
 * <li>Actions</li>
 * <li>ActionsOnTransitions</li>
 * <li>EntryActions</li>
 * <li>ExitActions</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class StatechartQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static StatechartQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new StatechartQueries();
    }
    return INSTANCE;
  }
  
  private static StatechartQueries INSTANCE;
  
  private StatechartQueries() {
    querySpecifications.add(StateMachines.instance());
    querySpecifications.add(ParametersInStateMachine.instance());
    querySpecifications.add(RegionsInRegion.instance());
    querySpecifications.add(RegionsInStatemachine.instance());
    querySpecifications.add(InitialStatesInStatemachine.instance());
    querySpecifications.add(ShallowHistoryInStatemachine.instance());
    querySpecifications.add(DeepHistoryInStateMachine.instance());
    querySpecifications.add(ForksInStateMachine.instance());
    querySpecifications.add(JoinsInStateMachine.instance());
    querySpecifications.add(StatesInStatemachine.instance());
    querySpecifications.add(TranisitonsInStateMachine.instance());
    querySpecifications.add(SignalsInStateMachine.instance());
    querySpecifications.add(MainRegions.instance());
    querySpecifications.add(StatesInMainRegion.instance());
    querySpecifications.add(StatesInRegions.instance());
    querySpecifications.add(ChoiceStates.instance());
    querySpecifications.add(Juncitons.instance());
    querySpecifications.add(FinalStates.instance());
    querySpecifications.add(RegionsInStates.instance());
    querySpecifications.add(Transitions.instance());
    querySpecifications.add(RegionsInStatechart.instance());
    querySpecifications.add(OwnedTransitions.instance());
    querySpecifications.add(Triggers.instance());
    querySpecifications.add(Signals.instance());
    querySpecifications.add(GuardsInStateMachine.instance());
    querySpecifications.add(RelativeTimeEventsInStateMachine.instance());
    querySpecifications.add(PropertiesInStateMachine.instance());
    querySpecifications.add(Actions.instance());
    querySpecifications.add(ActionsOnTransitions.instance());
    querySpecifications.add(EntryActions.instance());
    querySpecifications.add(ExitActions.instance());
  }
  
  public StateMachines getStateMachines() {
    return StateMachines.instance();
  }
  
  public StateMachines.Matcher getStateMachines(final ViatraQueryEngine engine) {
    return StateMachines.Matcher.on(engine);
  }
  
  public ParametersInStateMachine getParametersInStateMachine() {
    return ParametersInStateMachine.instance();
  }
  
  public ParametersInStateMachine.Matcher getParametersInStateMachine(final ViatraQueryEngine engine) {
    return ParametersInStateMachine.Matcher.on(engine);
  }
  
  public RegionsInRegion getRegionsInRegion() {
    return RegionsInRegion.instance();
  }
  
  public RegionsInRegion.Matcher getRegionsInRegion(final ViatraQueryEngine engine) {
    return RegionsInRegion.Matcher.on(engine);
  }
  
  public RegionsInStatemachine getRegionsInStatemachine() {
    return RegionsInStatemachine.instance();
  }
  
  public RegionsInStatemachine.Matcher getRegionsInStatemachine(final ViatraQueryEngine engine) {
    return RegionsInStatemachine.Matcher.on(engine);
  }
  
  public InitialStatesInStatemachine getInitialStatesInStatemachine() {
    return InitialStatesInStatemachine.instance();
  }
  
  public InitialStatesInStatemachine.Matcher getInitialStatesInStatemachine(final ViatraQueryEngine engine) {
    return InitialStatesInStatemachine.Matcher.on(engine);
  }
  
  public ShallowHistoryInStatemachine getShallowHistoryInStatemachine() {
    return ShallowHistoryInStatemachine.instance();
  }
  
  public ShallowHistoryInStatemachine.Matcher getShallowHistoryInStatemachine(final ViatraQueryEngine engine) {
    return ShallowHistoryInStatemachine.Matcher.on(engine);
  }
  
  public DeepHistoryInStateMachine getDeepHistoryInStateMachine() {
    return DeepHistoryInStateMachine.instance();
  }
  
  public DeepHistoryInStateMachine.Matcher getDeepHistoryInStateMachine(final ViatraQueryEngine engine) {
    return DeepHistoryInStateMachine.Matcher.on(engine);
  }
  
  public ForksInStateMachine getForksInStateMachine() {
    return ForksInStateMachine.instance();
  }
  
  public ForksInStateMachine.Matcher getForksInStateMachine(final ViatraQueryEngine engine) {
    return ForksInStateMachine.Matcher.on(engine);
  }
  
  public JoinsInStateMachine getJoinsInStateMachine() {
    return JoinsInStateMachine.instance();
  }
  
  public JoinsInStateMachine.Matcher getJoinsInStateMachine(final ViatraQueryEngine engine) {
    return JoinsInStateMachine.Matcher.on(engine);
  }
  
  public StatesInStatemachine getStatesInStatemachine() {
    return StatesInStatemachine.instance();
  }
  
  public StatesInStatemachine.Matcher getStatesInStatemachine(final ViatraQueryEngine engine) {
    return StatesInStatemachine.Matcher.on(engine);
  }
  
  public TranisitonsInStateMachine getTranisitonsInStateMachine() {
    return TranisitonsInStateMachine.instance();
  }
  
  public TranisitonsInStateMachine.Matcher getTranisitonsInStateMachine(final ViatraQueryEngine engine) {
    return TranisitonsInStateMachine.Matcher.on(engine);
  }
  
  public SignalsInStateMachine getSignalsInStateMachine() {
    return SignalsInStateMachine.instance();
  }
  
  public SignalsInStateMachine.Matcher getSignalsInStateMachine(final ViatraQueryEngine engine) {
    return SignalsInStateMachine.Matcher.on(engine);
  }
  
  public MainRegions getMainRegions() {
    return MainRegions.instance();
  }
  
  public MainRegions.Matcher getMainRegions(final ViatraQueryEngine engine) {
    return MainRegions.Matcher.on(engine);
  }
  
  public StatesInMainRegion getStatesInMainRegion() {
    return StatesInMainRegion.instance();
  }
  
  public StatesInMainRegion.Matcher getStatesInMainRegion(final ViatraQueryEngine engine) {
    return StatesInMainRegion.Matcher.on(engine);
  }
  
  public StatesInRegions getStatesInRegions() {
    return StatesInRegions.instance();
  }
  
  public StatesInRegions.Matcher getStatesInRegions(final ViatraQueryEngine engine) {
    return StatesInRegions.Matcher.on(engine);
  }
  
  public ChoiceStates getChoiceStates() {
    return ChoiceStates.instance();
  }
  
  public ChoiceStates.Matcher getChoiceStates(final ViatraQueryEngine engine) {
    return ChoiceStates.Matcher.on(engine);
  }
  
  public Juncitons getJuncitons() {
    return Juncitons.instance();
  }
  
  public Juncitons.Matcher getJuncitons(final ViatraQueryEngine engine) {
    return Juncitons.Matcher.on(engine);
  }
  
  public FinalStates getFinalStates() {
    return FinalStates.instance();
  }
  
  public FinalStates.Matcher getFinalStates(final ViatraQueryEngine engine) {
    return FinalStates.Matcher.on(engine);
  }
  
  public RegionsInStates getRegionsInStates() {
    return RegionsInStates.instance();
  }
  
  public RegionsInStates.Matcher getRegionsInStates(final ViatraQueryEngine engine) {
    return RegionsInStates.Matcher.on(engine);
  }
  
  public Transitions getTransitions() {
    return Transitions.instance();
  }
  
  public Transitions.Matcher getTransitions(final ViatraQueryEngine engine) {
    return Transitions.Matcher.on(engine);
  }
  
  public RegionsInStatechart getRegionsInStatechart() {
    return RegionsInStatechart.instance();
  }
  
  public RegionsInStatechart.Matcher getRegionsInStatechart(final ViatraQueryEngine engine) {
    return RegionsInStatechart.Matcher.on(engine);
  }
  
  public OwnedTransitions getOwnedTransitions() {
    return OwnedTransitions.instance();
  }
  
  public OwnedTransitions.Matcher getOwnedTransitions(final ViatraQueryEngine engine) {
    return OwnedTransitions.Matcher.on(engine);
  }
  
  public Triggers getTriggers() {
    return Triggers.instance();
  }
  
  public Triggers.Matcher getTriggers(final ViatraQueryEngine engine) {
    return Triggers.Matcher.on(engine);
  }
  
  public Signals getSignals() {
    return Signals.instance();
  }
  
  public Signals.Matcher getSignals(final ViatraQueryEngine engine) {
    return Signals.Matcher.on(engine);
  }
  
  public GuardsInStateMachine getGuardsInStateMachine() {
    return GuardsInStateMachine.instance();
  }
  
  public GuardsInStateMachine.Matcher getGuardsInStateMachine(final ViatraQueryEngine engine) {
    return GuardsInStateMachine.Matcher.on(engine);
  }
  
  public RelativeTimeEventsInStateMachine getRelativeTimeEventsInStateMachine() {
    return RelativeTimeEventsInStateMachine.instance();
  }
  
  public RelativeTimeEventsInStateMachine.Matcher getRelativeTimeEventsInStateMachine(final ViatraQueryEngine engine) {
    return RelativeTimeEventsInStateMachine.Matcher.on(engine);
  }
  
  public PropertiesInStateMachine getPropertiesInStateMachine() {
    return PropertiesInStateMachine.instance();
  }
  
  public PropertiesInStateMachine.Matcher getPropertiesInStateMachine(final ViatraQueryEngine engine) {
    return PropertiesInStateMachine.Matcher.on(engine);
  }
  
  public Actions getActions() {
    return Actions.instance();
  }
  
  public Actions.Matcher getActions(final ViatraQueryEngine engine) {
    return Actions.Matcher.on(engine);
  }
  
  public ActionsOnTransitions getActionsOnTransitions() {
    return ActionsOnTransitions.instance();
  }
  
  public ActionsOnTransitions.Matcher getActionsOnTransitions(final ViatraQueryEngine engine) {
    return ActionsOnTransitions.Matcher.on(engine);
  }
  
  public EntryActions getEntryActions() {
    return EntryActions.instance();
  }
  
  public EntryActions.Matcher getEntryActions(final ViatraQueryEngine engine) {
    return EntryActions.Matcher.on(engine);
  }
  
  public ExitActions getExitActions() {
    return ExitActions.instance();
  }
  
  public ExitActions.Matcher getExitActions(final ViatraQueryEngine engine) {
    return ExitActions.Matcher.on(engine);
  }
}
