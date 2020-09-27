/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.FinalState;
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
 *         pattern FinalStates(containingRegion: Region, finalState: FinalState){
 *         	Region.subvertex(containingRegion, finalState);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class FinalStates extends BaseGeneratedEMFQuerySpecification<FinalStates.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.FinalStates pattern,
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
    private Region fContainingRegion;
    
    private FinalState fFinalState;
    
    private static List<String> parameterNames = makeImmutableList("containingRegion", "finalState");
    
    private Match(final Region pContainingRegion, final FinalState pFinalState) {
      this.fContainingRegion = pContainingRegion;
      this.fFinalState = pFinalState;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "containingRegion": return this.fContainingRegion;
          case "finalState": return this.fFinalState;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fContainingRegion;
          case 1: return this.fFinalState;
          default: return null;
      }
    }
    
    public Region getContainingRegion() {
      return this.fContainingRegion;
    }
    
    public FinalState getFinalState() {
      return this.fFinalState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("containingRegion".equals(parameterName) ) {
          this.fContainingRegion = (Region) newValue;
          return true;
      }
      if ("finalState".equals(parameterName) ) {
          this.fFinalState = (FinalState) newValue;
          return true;
      }
      return false;
    }
    
    public void setContainingRegion(final Region pContainingRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fContainingRegion = pContainingRegion;
    }
    
    public void setFinalState(final FinalState pFinalState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fFinalState = pFinalState;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.FinalStates";
    }
    
    @Override
    public List<String> parameterNames() {
      return FinalStates.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fContainingRegion, fFinalState};
    }
    
    @Override
    public FinalStates.Match toImmutable() {
      return isMutable() ? newMatch(fContainingRegion, fFinalState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"containingRegion\"=" + prettyPrintValue(fContainingRegion) + ", ");
      result.append("\"finalState\"=" + prettyPrintValue(fFinalState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fContainingRegion, fFinalState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof FinalStates.Match)) {
          FinalStates.Match other = (FinalStates.Match) obj;
          return Objects.equals(fContainingRegion, other.fContainingRegion) && Objects.equals(fFinalState, other.fFinalState);
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
    public FinalStates specification() {
      return FinalStates.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static FinalStates.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static FinalStates.Match newMutableMatch(final Region pContainingRegion, final FinalState pFinalState) {
      return new Mutable(pContainingRegion, pFinalState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static FinalStates.Match newMatch(final Region pContainingRegion, final FinalState pFinalState) {
      return new Immutable(pContainingRegion, pFinalState);
    }
    
    private static final class Mutable extends FinalStates.Match {
      Mutable(final Region pContainingRegion, final FinalState pFinalState) {
        super(pContainingRegion, pFinalState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends FinalStates.Match {
      Immutable(final Region pContainingRegion, final FinalState pFinalState) {
        super(pContainingRegion, pFinalState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.FinalStates pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern FinalStates(containingRegion: Region, finalState: FinalState){
   * 	Region.subvertex(containingRegion, finalState);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see FinalStates
   * 
   */
  public static class Matcher extends BaseMatcher<FinalStates.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static FinalStates.Matcher on(final ViatraQueryEngine engine) {
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
    public static FinalStates.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CONTAININGREGION = 0;
    
    private static final int POSITION_FINALSTATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FinalStates.Matcher.class);
    
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
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<FinalStates.Match> getAllMatches(final Region pContainingRegion, final FinalState pFinalState) {
      return rawStreamAllMatches(new Object[]{pContainingRegion, pFinalState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<FinalStates.Match> streamAllMatches(final Region pContainingRegion, final FinalState pFinalState) {
      return rawStreamAllMatches(new Object[]{pContainingRegion, pFinalState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<FinalStates.Match> getOneArbitraryMatch(final Region pContainingRegion, final FinalState pFinalState) {
      return rawGetOneArbitraryMatch(new Object[]{pContainingRegion, pFinalState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Region pContainingRegion, final FinalState pFinalState) {
      return rawHasMatch(new Object[]{pContainingRegion, pFinalState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Region pContainingRegion, final FinalState pFinalState) {
      return rawCountMatches(new Object[]{pContainingRegion, pFinalState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Region pContainingRegion, final FinalState pFinalState, final Consumer<? super FinalStates.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pContainingRegion, pFinalState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pFinalState the fixed value of pattern parameter finalState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public FinalStates.Match newMatch(final Region pContainingRegion, final FinalState pFinalState) {
      return FinalStates.Match.newMatch(pContainingRegion, pFinalState);
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Region> rawStreamAllValuesOfcontainingRegion(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONTAININGREGION, parameters).map(Region.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion() {
      return rawStreamAllValuesOfcontainingRegion(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion() {
      return rawStreamAllValuesOfcontainingRegion(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion(final FinalStates.Match partialMatch) {
      return rawStreamAllValuesOfcontainingRegion(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion(final FinalState pFinalState) {
      return rawStreamAllValuesOfcontainingRegion(new Object[]{null, pFinalState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion(final FinalStates.Match partialMatch) {
      return rawStreamAllValuesOfcontainingRegion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion(final FinalState pFinalState) {
      return rawStreamAllValuesOfcontainingRegion(new Object[]{null, pFinalState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<FinalState> rawStreamAllValuesOffinalState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_FINALSTATE, parameters).map(FinalState.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<FinalState> getAllValuesOffinalState() {
      return rawStreamAllValuesOffinalState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<FinalState> streamAllValuesOffinalState() {
      return rawStreamAllValuesOffinalState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<FinalState> streamAllValuesOffinalState(final FinalStates.Match partialMatch) {
      return rawStreamAllValuesOffinalState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<FinalState> streamAllValuesOffinalState(final Region pContainingRegion) {
      return rawStreamAllValuesOffinalState(new Object[]{pContainingRegion, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<FinalState> getAllValuesOffinalState(final FinalStates.Match partialMatch) {
      return rawStreamAllValuesOffinalState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for finalState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<FinalState> getAllValuesOffinalState(final Region pContainingRegion) {
      return rawStreamAllValuesOffinalState(new Object[]{pContainingRegion, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected FinalStates.Match tupleToMatch(final Tuple t) {
      try {
          return FinalStates.Match.newMatch((Region) t.get(POSITION_CONTAININGREGION), (FinalState) t.get(POSITION_FINALSTATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected FinalStates.Match arrayToMatch(final Object[] match) {
      try {
          return FinalStates.Match.newMatch((Region) match[POSITION_CONTAININGREGION], (FinalState) match[POSITION_FINALSTATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected FinalStates.Match arrayToMatchMutable(final Object[] match) {
      try {
          return FinalStates.Match.newMutableMatch((Region) match[POSITION_CONTAININGREGION], (FinalState) match[POSITION_FINALSTATE]);
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
    public static IQuerySpecification<FinalStates.Matcher> querySpecification() {
      return FinalStates.instance();
    }
  }
  
  private FinalStates() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static FinalStates instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected FinalStates.Matcher instantiate(final ViatraQueryEngine engine) {
    return FinalStates.Matcher.on(engine);
  }
  
  @Override
  public FinalStates.Matcher instantiate() {
    return FinalStates.Matcher.create();
  }
  
  @Override
  public FinalStates.Match newEmptyMatch() {
    return FinalStates.Match.newEmptyMatch();
  }
  
  @Override
  public FinalStates.Match newMatch(final Object... parameters) {
    return FinalStates.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.FinalState) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link FinalStates} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link FinalStates#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final FinalStates INSTANCE = new FinalStates();
    
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
    private static final FinalStates.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_containingRegion = new PParameter("containingRegion", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_finalState = new PParameter("finalState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.FinalState", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "FinalState")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_containingRegion, parameter_finalState);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.FinalStates";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("containingRegion","finalState");
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
          PVariable var_containingRegion = body.getOrCreateVariableByName("containingRegion");
          PVariable var_finalState = body.getOrCreateVariableByName("finalState");
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_finalState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "FinalState")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_containingRegion, parameter_containingRegion),
             new ExportedParameter(body, var_finalState, parameter_finalState)
          ));
          // 	Region.subvertex(containingRegion, finalState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_finalState);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
