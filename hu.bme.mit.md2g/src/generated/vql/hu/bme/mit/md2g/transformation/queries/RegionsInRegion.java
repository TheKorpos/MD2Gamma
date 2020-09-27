/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
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
 *         pattern RegionsInRegion(container: Region, region: Region){
 *         	Region.subvertex(container, vertex);
 *         	State.region(vertex, region);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class RegionsInRegion extends BaseGeneratedEMFQuerySpecification<RegionsInRegion.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.RegionsInRegion pattern,
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
    private Region fContainer;
    
    private Region fRegion;
    
    private static List<String> parameterNames = makeImmutableList("container", "region");
    
    private Match(final Region pContainer, final Region pRegion) {
      this.fContainer = pContainer;
      this.fRegion = pRegion;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "container": return this.fContainer;
          case "region": return this.fRegion;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fContainer;
          case 1: return this.fRegion;
          default: return null;
      }
    }
    
    public Region getContainer() {
      return this.fContainer;
    }
    
    public Region getRegion() {
      return this.fRegion;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("container".equals(parameterName) ) {
          this.fContainer = (Region) newValue;
          return true;
      }
      if ("region".equals(parameterName) ) {
          this.fRegion = (Region) newValue;
          return true;
      }
      return false;
    }
    
    public void setContainer(final Region pContainer) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fContainer = pContainer;
    }
    
    public void setRegion(final Region pRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRegion = pRegion;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.RegionsInRegion";
    }
    
    @Override
    public List<String> parameterNames() {
      return RegionsInRegion.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fContainer, fRegion};
    }
    
    @Override
    public RegionsInRegion.Match toImmutable() {
      return isMutable() ? newMatch(fContainer, fRegion) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"container\"=" + prettyPrintValue(fContainer) + ", ");
      result.append("\"region\"=" + prettyPrintValue(fRegion));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fContainer, fRegion);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof RegionsInRegion.Match)) {
          RegionsInRegion.Match other = (RegionsInRegion.Match) obj;
          return Objects.equals(fContainer, other.fContainer) && Objects.equals(fRegion, other.fRegion);
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
    public RegionsInRegion specification() {
      return RegionsInRegion.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static RegionsInRegion.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static RegionsInRegion.Match newMutableMatch(final Region pContainer, final Region pRegion) {
      return new Mutable(pContainer, pRegion);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static RegionsInRegion.Match newMatch(final Region pContainer, final Region pRegion) {
      return new Immutable(pContainer, pRegion);
    }
    
    private static final class Mutable extends RegionsInRegion.Match {
      Mutable(final Region pContainer, final Region pRegion) {
        super(pContainer, pRegion);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends RegionsInRegion.Match {
      Immutable(final Region pContainer, final Region pRegion) {
        super(pContainer, pRegion);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.RegionsInRegion pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern RegionsInRegion(container: Region, region: Region){
   * 	Region.subvertex(container, vertex);
   * 	State.region(vertex, region);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see RegionsInRegion
   * 
   */
  public static class Matcher extends BaseMatcher<RegionsInRegion.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static RegionsInRegion.Matcher on(final ViatraQueryEngine engine) {
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
    public static RegionsInRegion.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CONTAINER = 0;
    
    private static final int POSITION_REGION = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(RegionsInRegion.Matcher.class);
    
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
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<RegionsInRegion.Match> getAllMatches(final Region pContainer, final Region pRegion) {
      return rawStreamAllMatches(new Object[]{pContainer, pRegion}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<RegionsInRegion.Match> streamAllMatches(final Region pContainer, final Region pRegion) {
      return rawStreamAllMatches(new Object[]{pContainer, pRegion});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<RegionsInRegion.Match> getOneArbitraryMatch(final Region pContainer, final Region pRegion) {
      return rawGetOneArbitraryMatch(new Object[]{pContainer, pRegion});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Region pContainer, final Region pRegion) {
      return rawHasMatch(new Object[]{pContainer, pRegion});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Region pContainer, final Region pRegion) {
      return rawCountMatches(new Object[]{pContainer, pRegion});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Region pContainer, final Region pRegion, final Consumer<? super RegionsInRegion.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pContainer, pRegion}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainer the fixed value of pattern parameter container, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public RegionsInRegion.Match newMatch(final Region pContainer, final Region pRegion) {
      return RegionsInRegion.Match.newMatch(pContainer, pRegion);
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Region> rawStreamAllValuesOfcontainer(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONTAINER, parameters).map(Region.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainer() {
      return rawStreamAllValuesOfcontainer(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainer() {
      return rawStreamAllValuesOfcontainer(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainer(final RegionsInRegion.Match partialMatch) {
      return rawStreamAllValuesOfcontainer(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainer(final Region pRegion) {
      return rawStreamAllValuesOfcontainer(new Object[]{null, pRegion});
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainer(final RegionsInRegion.Match partialMatch) {
      return rawStreamAllValuesOfcontainer(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for container.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainer(final Region pRegion) {
      return rawStreamAllValuesOfcontainer(new Object[]{null, pRegion}).collect(Collectors.toSet());
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
    public Stream<Region> streamAllValuesOfregion(final RegionsInRegion.Match partialMatch) {
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
    public Stream<Region> streamAllValuesOfregion(final Region pContainer) {
      return rawStreamAllValuesOfregion(new Object[]{pContainer, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final RegionsInRegion.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final Region pContainer) {
      return rawStreamAllValuesOfregion(new Object[]{pContainer, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected RegionsInRegion.Match tupleToMatch(final Tuple t) {
      try {
          return RegionsInRegion.Match.newMatch((Region) t.get(POSITION_CONTAINER), (Region) t.get(POSITION_REGION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected RegionsInRegion.Match arrayToMatch(final Object[] match) {
      try {
          return RegionsInRegion.Match.newMatch((Region) match[POSITION_CONTAINER], (Region) match[POSITION_REGION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected RegionsInRegion.Match arrayToMatchMutable(final Object[] match) {
      try {
          return RegionsInRegion.Match.newMutableMatch((Region) match[POSITION_CONTAINER], (Region) match[POSITION_REGION]);
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
    public static IQuerySpecification<RegionsInRegion.Matcher> querySpecification() {
      return RegionsInRegion.instance();
    }
  }
  
  private RegionsInRegion() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static RegionsInRegion instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected RegionsInRegion.Matcher instantiate(final ViatraQueryEngine engine) {
    return RegionsInRegion.Matcher.on(engine);
  }
  
  @Override
  public RegionsInRegion.Matcher instantiate() {
    return RegionsInRegion.Matcher.create();
  }
  
  @Override
  public RegionsInRegion.Match newEmptyMatch() {
    return RegionsInRegion.Match.newEmptyMatch();
  }
  
  @Override
  public RegionsInRegion.Match newMatch(final Object... parameters) {
    return RegionsInRegion.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link RegionsInRegion} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link RegionsInRegion#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final RegionsInRegion INSTANCE = new RegionsInRegion();
    
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
    private static final RegionsInRegion.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_container = new PParameter("container", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_region = new PParameter("region", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_container, parameter_region);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.RegionsInRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("container","region");
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
          PVariable var_container = body.getOrCreateVariableByName("container");
          PVariable var_region = body.getOrCreateVariableByName("region");
          PVariable var_vertex = body.getOrCreateVariableByName("vertex");
          new TypeConstraint(body, Tuples.flatTupleOf(var_container), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_container, parameter_container),
             new ExportedParameter(body, var_region, parameter_region)
          ));
          // 	Region.subvertex(container, vertex)
          new TypeConstraint(body, Tuples.flatTupleOf(var_container), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_container, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_vertex);
          // 	State.region(vertex, region)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vertex), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vertex, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State", "region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new Equality(body, var__virtual_1_, var_region);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
