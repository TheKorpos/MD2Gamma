/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/TraceQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import hu.bme.mit.md2g.transformation.queries.FragmentTrace;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in TraceQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file TraceQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.md2g.transformation.queries, the group contains the definition of the following patterns: <ul>
 * <li>fragmentTrace</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class TraceQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TraceQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new TraceQueries();
    }
    return INSTANCE;
  }
  
  private static TraceQueries INSTANCE;
  
  private TraceQueries() {
    querySpecifications.add(FragmentTrace.instance());
  }
  
  public FragmentTrace getFragmentTrace() {
    return FragmentTrace.instance();
  }
  
  public FragmentTrace.Matcher getFragmentTrace(final ViatraQueryEngine engine) {
    return FragmentTrace.Matcher.on(engine);
  }
}
