/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries.internal;

import hu.bme.mit.md2g.transformation.queries.Actions;
import hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions;
import hu.bme.mit.md2g.transformation.queries.DeepHistoryInStateMachine;
import hu.bme.mit.md2g.transformation.queries.EntryActions;
import hu.bme.mit.md2g.transformation.queries.ExitActions;
import hu.bme.mit.md2g.transformation.queries.FinalStates;
import hu.bme.mit.md2g.transformation.queries.ForksInStateMachine;
import hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.InitialStatesInStatemachine;
import hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine;
import hu.bme.mit.md2g.transformation.queries.MainRegions;
import hu.bme.mit.md2g.transformation.queries.OwnedTransitions;
import hu.bme.mit.md2g.transformation.queries.ParametersInStateMachine;
import hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine;
import hu.bme.mit.md2g.transformation.queries.PseudoStates;
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
import hu.bme.mit.md2g.transformation.queries.internal.InnerRegion;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in StatechartQueries.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
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
 * <li>PseudoStates</li>
 * <li>FinalStates</li>
 * <li>RegionsInStates</li>
 * <li>Transitions</li>
 * <li>InnerRegion</li>
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
public final class StatechartQueriesAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static StatechartQueriesAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new StatechartQueriesAll();
    }
    return INSTANCE;
  }
  
  private static StatechartQueriesAll INSTANCE;
  
  private StatechartQueriesAll() {
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
    querySpecifications.add(PseudoStates.instance());
    querySpecifications.add(FinalStates.instance());
    querySpecifications.add(RegionsInStates.instance());
    querySpecifications.add(Transitions.instance());
    querySpecifications.add(InnerRegion.instance());
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
}
