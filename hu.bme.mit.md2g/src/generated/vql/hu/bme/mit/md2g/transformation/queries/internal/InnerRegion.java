/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries.internal;

import hu.bme.mit.md2g.transformation.queries.RegionsInStates;
import hu.bme.mit.md2g.transformation.queries.StatesInRegions;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecificationWithGenericMatcher;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate GenericPatternMatcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         private pattern InnerRegion(region: Region, innerRegion: Region){
 *         	find StatesInRegions(region, state);
 *         	find RegionsInStates(state, innerRegion);
 *         }
 * </pre></code>
 * 
 * @see GenericPatternMatcher
 * @see GenericPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class InnerRegion extends BaseGeneratedEMFQuerySpecificationWithGenericMatcher {
  private InnerRegion() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static InnerRegion instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.internal.InnerRegion (visibility: PUBLIC, simpleName: InnerRegion, identifier: hu.bme.mit.md2g.transformation.queries.internal.InnerRegion, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.internal.InnerRegion (visibility: PUBLIC, simpleName: InnerRegion, identifier: hu.bme.mit.md2g.transformation.queries.internal.InnerRegion, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries.internal) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final InnerRegion INSTANCE = new InnerRegion();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final InnerRegion.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_region = new PParameter("region", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_innerRegion = new PParameter("innerRegion", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_region, parameter_innerRegion);
    
    private GeneratedPQuery() {
      super(PVisibility.PRIVATE);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.InnerRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("region","innerRegion");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_region = body.getOrCreateVariableByName("region");
          PVariable var_innerRegion = body.getOrCreateVariableByName("innerRegion");
          PVariable var_state = body.getOrCreateVariableByName("state");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_innerRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_region, parameter_region),
             new ExportedParameter(body, var_innerRegion, parameter_innerRegion)
          ));
          // 	find StatesInRegions(region, state)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_region, var_state), StatesInRegions.instance().getInternalQueryRepresentation());
          // 	find RegionsInStates(state, innerRegion)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_state, var_innerRegion), RegionsInStates.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
