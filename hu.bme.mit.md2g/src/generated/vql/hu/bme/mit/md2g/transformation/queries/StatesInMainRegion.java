/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import hu.bme.mit.md2g.transformation.queries.MainRegions;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern StatesInMainRegion(region: Region, state: State){
 *         	find MainRegions(_, region);
 *         	Region.subvertex(region, state);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class StatesInMainRegion extends BaseGeneratedEMFQuerySpecification<StatesInMainRegion.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.StatesInMainRegion pattern,
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
    
    private State fState;
    
    private static List<String> parameterNames = makeImmutableList("region", "state");
    
    private Match(final Region pRegion, final State pState) {
      this.fRegion = pRegion;
      this.fState = pState;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "region": return this.fRegion;
          case "state": return this.fState;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fRegion;
          case 1: return this.fState;
          default: return null;
      }
    }
    
    public Region getRegion() {
      return this.fRegion;
    }
    
    public State getState() {
      return this.fState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("region".equals(parameterName) ) {
          this.fRegion = (Region) newValue;
          return true;
      }
      if ("state".equals(parameterName) ) {
          this.fState = (State) newValue;
          return true;
      }
      return false;
    }
    
    public void setRegion(final Region pRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRegion = pRegion;
    }
    
    public void setState(final State pState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fState = pState;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.StatesInMainRegion";
    }
    
    @Override
    public List<String> parameterNames() {
      return StatesInMainRegion.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fRegion, fState};
    }
    
    @Override
    public StatesInMainRegion.Match toImmutable() {
      return isMutable() ? newMatch(fRegion, fState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
      result.append("\"state\"=" + prettyPrintValue(fState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fRegion, fState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof StatesInMainRegion.Match)) {
          StatesInMainRegion.Match other = (StatesInMainRegion.Match) obj;
          return Objects.equals(fRegion, other.fRegion) && Objects.equals(fState, other.fState);
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
    public StatesInMainRegion specification() {
      return StatesInMainRegion.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static StatesInMainRegion.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static StatesInMainRegion.Match newMutableMatch(final Region pRegion, final State pState) {
      return new Mutable(pRegion, pState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static StatesInMainRegion.Match newMatch(final Region pRegion, final State pState) {
      return new Immutable(pRegion, pState);
    }
    
    private static final class Mutable extends StatesInMainRegion.Match {
      Mutable(final Region pRegion, final State pState) {
        super(pRegion, pState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends StatesInMainRegion.Match {
      Immutable(final Region pRegion, final State pState) {
        super(pRegion, pState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.StatesInMainRegion pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern StatesInMainRegion(region: Region, state: State){
   * 	find MainRegions(_, region);
   * 	Region.subvertex(region, state);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see StatesInMainRegion
   * 
   */
  public static class Matcher extends BaseMatcher<StatesInMainRegion.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static StatesInMainRegion.Matcher on(final ViatraQueryEngine engine) {
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
    public static StatesInMainRegion.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_REGION = 0;
    
    private static final int POSITION_STATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(StatesInMainRegion.Matcher.class);
    
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
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<StatesInMainRegion.Match> getAllMatches(final Region pRegion, final State pState) {
      return rawStreamAllMatches(new Object[]{pRegion, pState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<StatesInMainRegion.Match> streamAllMatches(final Region pRegion, final State pState) {
      return rawStreamAllMatches(new Object[]{pRegion, pState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<StatesInMainRegion.Match> getOneArbitraryMatch(final Region pRegion, final State pState) {
      return rawGetOneArbitraryMatch(new Object[]{pRegion, pState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Region pRegion, final State pState) {
      return rawHasMatch(new Object[]{pRegion, pState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Region pRegion, final State pState) {
      return rawCountMatches(new Object[]{pRegion, pState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Region pRegion, final State pState, final Consumer<? super StatesInMainRegion.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pRegion, pState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public StatesInMainRegion.Match newMatch(final Region pRegion, final State pState) {
      return StatesInMainRegion.Match.newMatch(pRegion, pState);
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
    public Stream<Region> streamAllValuesOfregion(final StatesInMainRegion.Match partialMatch) {
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
    public Stream<Region> streamAllValuesOfregion(final State pState) {
      return rawStreamAllValuesOfregion(new Object[]{null, pState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final StatesInMainRegion.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final State pState) {
      return rawStreamAllValuesOfregion(new Object[]{null, pState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<State> rawStreamAllValuesOfstate(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATE, parameters).map(State.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate() {
      return rawStreamAllValuesOfstate(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate() {
      return rawStreamAllValuesOfstate(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate(final StatesInMainRegion.Match partialMatch) {
      return rawStreamAllValuesOfstate(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<State> streamAllValuesOfstate(final Region pRegion) {
      return rawStreamAllValuesOfstate(new Object[]{pRegion, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final StatesInMainRegion.Match partialMatch) {
      return rawStreamAllValuesOfstate(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final Region pRegion) {
      return rawStreamAllValuesOfstate(new Object[]{pRegion, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected StatesInMainRegion.Match tupleToMatch(final Tuple t) {
      try {
          return StatesInMainRegion.Match.newMatch((Region) t.get(POSITION_REGION), (State) t.get(POSITION_STATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatesInMainRegion.Match arrayToMatch(final Object[] match) {
      try {
          return StatesInMainRegion.Match.newMatch((Region) match[POSITION_REGION], (State) match[POSITION_STATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatesInMainRegion.Match arrayToMatchMutable(final Object[] match) {
      try {
          return StatesInMainRegion.Match.newMutableMatch((Region) match[POSITION_REGION], (State) match[POSITION_STATE]);
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
    public static IQuerySpecification<StatesInMainRegion.Matcher> querySpecification() {
      return StatesInMainRegion.instance();
    }
  }
  
  private StatesInMainRegion() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static StatesInMainRegion instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected StatesInMainRegion.Matcher instantiate(final ViatraQueryEngine engine) {
    return StatesInMainRegion.Matcher.on(engine);
  }
  
  @Override
  public StatesInMainRegion.Matcher instantiate() {
    return StatesInMainRegion.Matcher.create();
  }
  
  @Override
  public StatesInMainRegion.Match newEmptyMatch() {
    return StatesInMainRegion.Match.newEmptyMatch();
  }
  
  @Override
  public StatesInMainRegion.Match newMatch(final Object... parameters) {
    return StatesInMainRegion.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link StatesInMainRegion} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link StatesInMainRegion#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final StatesInMainRegion INSTANCE = new StatesInMainRegion();
    
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
    private static final StatesInMainRegion.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_region = new PParameter("region", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_state = new PParameter("state", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_region, parameter_state);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.StatesInMainRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("region","state");
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
          PVariable var_state = body.getOrCreateVariableByName("state");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_region, parameter_region),
             new ExportedParameter(body, var_state, parameter_state)
          ));
          // 	find MainRegions(_, region)
          new PositivePatternCall(body, Tuples.flatTupleOf(var___0_, var_region), MainRegions.instance().getInternalQueryRepresentation());
          // 	Region.subvertex(region, state)
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_state);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
