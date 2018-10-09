/**
 * Generated from platform:/resource/magicdraw2gamma/src/main/java/hu/bme/mit/magicdraw2gamma/plugin/queries/SearchQueries.vql
 */
package hu.bme.mit.magicdraw2gamma.plugin.queries;

import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in SearchQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file SearchQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.magicdraw2gamma.plugin.queries, the group contains the definition of the following patterns: <ul>
 * <li>StatechartDefinitions</li>
 * <li>MainRegions</li>
 * <li>StatesInRegions</li>
 * <li>RegionsInStates</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class SearchQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SearchQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new SearchQueries();
    }
    return INSTANCE;
  }
  
  private static SearchQueries INSTANCE;
  
  private SearchQueries() {
    querySpecifications.add(StatechartDefinitions.instance());
    querySpecifications.add(MainRegions.instance());
    querySpecifications.add(StatesInRegions.instance());
    querySpecifications.add(RegionsInStates.instance());
  }
  
  public StatechartDefinitions getStatechartDefinitions() {
    return StatechartDefinitions.instance();
  }
  
  public StatechartDefinitions.Matcher getStatechartDefinitions(final ViatraQueryEngine engine) {
    return StatechartDefinitions.Matcher.on(engine);
  }
  
  public MainRegions getMainRegions() {
    return MainRegions.instance();
  }
  
  public MainRegions.Matcher getMainRegions(final ViatraQueryEngine engine) {
    return MainRegions.Matcher.on(engine);
  }
  
  public StatesInRegions getStatesInRegions() {
    return StatesInRegions.instance();
  }
  
  public StatesInRegions.Matcher getStatesInRegions(final ViatraQueryEngine engine) {
    return StatesInRegions.Matcher.on(engine);
  }
  
  public RegionsInStates getRegionsInStates() {
    return RegionsInStates.instance();
  }
  
  public RegionsInStates.Matcher getRegionsInStates(final ViatraQueryEngine engine) {
    return RegionsInStates.Matcher.on(engine);
  }
}
