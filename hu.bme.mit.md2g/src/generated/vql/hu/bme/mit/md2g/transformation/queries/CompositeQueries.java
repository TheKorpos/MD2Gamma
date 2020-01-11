/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/CompositeQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import hu.bme.mit.md2g.transformation.queries.PortConnections;
import hu.bme.mit.md2g.transformation.queries.PortsOnComponents;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in CompositeQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file CompositeQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.md2g.transformation.queries, the group contains the definition of the following patterns: <ul>
 * <li>portsOnComponents</li>
 * <li>portConnections</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class CompositeQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static CompositeQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new CompositeQueries();
    }
    return INSTANCE;
  }
  
  private static CompositeQueries INSTANCE;
  
  private CompositeQueries() {
    querySpecifications.add(PortsOnComponents.instance());
    querySpecifications.add(PortConnections.instance());
  }
  
  public PortsOnComponents getPortsOnComponents() {
    return PortsOnComponents.instance();
  }
  
  public PortsOnComponents.Matcher getPortsOnComponents(final ViatraQueryEngine engine) {
    return PortsOnComponents.Matcher.on(engine);
  }
  
  public PortConnections getPortConnections() {
    return PortConnections.instance();
  }
  
  public PortConnections.Matcher getPortConnections(final ViatraQueryEngine engine) {
    return PortConnections.Matcher.on(engine);
  }
}
