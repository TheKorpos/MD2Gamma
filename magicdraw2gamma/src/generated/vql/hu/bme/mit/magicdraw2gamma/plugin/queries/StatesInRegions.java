/**
 * Generated from platform:/resource/magicdraw2gamma/src/main/java/hu/bme/mit/magicdraw2gamma/plugin/queries/SearchQueries.vql
 */
package hu.bme.mit.magicdraw2gamma.plugin.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern StatesInRegions(region: Region, vertex: Vertex){
 *         	Region.subvertex(region, vertex);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class StatesInRegions extends BaseGeneratedEMFQuerySpecification<StatesInRegions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Region fRegion;
    
    private Vertex fVertex;
    
    private static List<String> parameterNames = makeImmutableList("region", "vertex");
    
    private Match(final Region pRegion, final Vertex pVertex) {
      this.fRegion = pRegion;
      this.fVertex = pVertex;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("region".equals(parameterName)) return this.fRegion;
      if ("vertex".equals(parameterName)) return this.fVertex;
      return null;
    }
    
    public Region getRegion() {
      return this.fRegion;
    }
    
    public Vertex getVertex() {
      return this.fVertex;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("region".equals(parameterName) ) {
          this.fRegion = (Region) newValue;
          return true;
      }
      if ("vertex".equals(parameterName) ) {
          this.fVertex = (Vertex) newValue;
          return true;
      }
      return false;
    }
    
    public void setRegion(final Region pRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRegion = pRegion;
    }
    
    public void setVertex(final Vertex pVertex) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fVertex = pVertex;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions";
    }
    
    @Override
    public List<String> parameterNames() {
      return StatesInRegions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fRegion, fVertex};
    }
    
    @Override
    public StatesInRegions.Match toImmutable() {
      return isMutable() ? newMatch(fRegion, fVertex) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
      result.append("\"vertex\"=" + prettyPrintValue(fVertex));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fRegion, fVertex);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof StatesInRegions.Match)) {
          StatesInRegions.Match other = (StatesInRegions.Match) obj;
          return Objects.equals(fRegion, other.fRegion) && Objects.equals(fVertex, other.fVertex);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public StatesInRegions specification() {
      return StatesInRegions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static StatesInRegions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static StatesInRegions.Match newMutableMatch(final Region pRegion, final Vertex pVertex) {
      return new Mutable(pRegion, pVertex);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static StatesInRegions.Match newMatch(final Region pRegion, final Vertex pVertex) {
      return new Immutable(pRegion, pVertex);
    }
    
    private static final class Mutable extends StatesInRegions.Match {
      Mutable(final Region pRegion, final Vertex pVertex) {
        super(pRegion, pVertex);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends StatesInRegions.Match {
      Immutable(final Region pRegion, final Vertex pVertex) {
        super(pRegion, pVertex);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern StatesInRegions(region: Region, vertex: Vertex){
   * 	Region.subvertex(region, vertex);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see StatesInRegions
   * 
   */
  public static class Matcher extends BaseMatcher<StatesInRegions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static StatesInRegions.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static StatesInRegions.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_REGION = 0;
    
    private final static int POSITION_VERTEX = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(StatesInRegions.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<StatesInRegions.Match> getAllMatches(final Region pRegion, final Vertex pVertex) {
      return rawStreamAllMatches(new Object[]{pRegion, pVertex}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<StatesInRegions.Match> streamAllMatches(final Region pRegion, final Vertex pVertex) {
      return rawStreamAllMatches(new Object[]{pRegion, pVertex});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<StatesInRegions.Match> getOneArbitraryMatch(final Region pRegion, final Vertex pVertex) {
      return rawGetOneArbitraryMatch(new Object[]{pRegion, pVertex});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Region pRegion, final Vertex pVertex) {
      return rawHasMatch(new Object[]{pRegion, pVertex});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Region pRegion, final Vertex pVertex) {
      return rawCountMatches(new Object[]{pRegion, pVertex});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Region pRegion, final Vertex pVertex, final Consumer<? super StatesInRegions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pRegion, pVertex}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pVertex the fixed value of pattern parameter vertex, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public StatesInRegions.Match newMatch(final Region pRegion, final Vertex pVertex) {
      return StatesInRegions.Match.newMatch(pRegion, pVertex);
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Region> rawStreamAllValuesOfregion(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REGION, parameters).map(Region.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion() {
      return rawStreamAllValuesOfregion(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion() {
      return rawStreamAllValuesOfregion(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion(final StatesInRegions.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion(final Vertex pVertex) {
      return rawStreamAllValuesOfregion(new Object[]{null, pVertex});
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final StatesInRegions.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final Vertex pVertex) {
      return rawStreamAllValuesOfregion(new Object[]{null, pVertex}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vertex> rawStreamAllValuesOfvertex(final Object[] parameters) {
      return rawStreamAllValues(POSITION_VERTEX, parameters).map(Vertex.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfvertex() {
      return rawStreamAllValuesOfvertex(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfvertex() {
      return rawStreamAllValuesOfvertex(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfvertex(final StatesInRegions.Match partialMatch) {
      return rawStreamAllValuesOfvertex(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfvertex(final Region pRegion) {
      return rawStreamAllValuesOfvertex(new Object[]{pRegion, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfvertex(final StatesInRegions.Match partialMatch) {
      return rawStreamAllValuesOfvertex(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for vertex.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfvertex(final Region pRegion) {
      return rawStreamAllValuesOfvertex(new Object[]{pRegion, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected StatesInRegions.Match tupleToMatch(final Tuple t) {
      try {
          return StatesInRegions.Match.newMatch((Region) t.get(POSITION_REGION), (Vertex) t.get(POSITION_VERTEX));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatesInRegions.Match arrayToMatch(final Object[] match) {
      try {
          return StatesInRegions.Match.newMatch((Region) match[POSITION_REGION], (Vertex) match[POSITION_VERTEX]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatesInRegions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return StatesInRegions.Match.newMutableMatch((Region) match[POSITION_REGION], (Vertex) match[POSITION_VERTEX]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<StatesInRegions.Matcher> querySpecification() {
      return StatesInRegions.instance();
    }
  }
  
  private StatesInRegions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static StatesInRegions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected StatesInRegions.Matcher instantiate(final ViatraQueryEngine engine) {
    return StatesInRegions.Matcher.on(engine);
  }
  
  @Override
  public StatesInRegions.Matcher instantiate() {
    return StatesInRegions.Matcher.create();
  }
  
  @Override
  public StatesInRegions.Match newEmptyMatch() {
    return StatesInRegions.Match.newEmptyMatch();
  }
  
  @Override
  public StatesInRegions.Match newMatch(final Object... parameters) {
    return StatesInRegions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions (visibility: PUBLIC, simpleName: StatesInRegions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions (visibility: PUBLIC, simpleName: StatesInRegions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static StatesInRegions INSTANCE = new StatesInRegions();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StatesInRegions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_region = new PParameter("region", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_vertex = new PParameter("vertex", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Vertex")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_region, parameter_vertex);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("region","vertex");
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
          PVariable var_vertex = body.getOrCreateVariableByName("vertex");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_vertex), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Vertex")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_region, parameter_region),
             new ExportedParameter(body, var_vertex, parameter_vertex)
          ));
          // 	Region.subvertex(region, vertex)
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Vertex")));
          new Equality(body, var__virtual_0_, var_vertex);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
