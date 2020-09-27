/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import hu.bme.mit.md2g.transformation.queries.RegionsInStatemachine;
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
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
 *         pattern ForksInStateMachine(stateMachine: StateMachine, forkState: Pseudostate){
 *         	find RegionsInStatemachine(stateMachine, region);
 *         	Region.subvertex(region, forkState);
 *         	Pseudostate.kind(forkState, ::fork);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ForksInStateMachine extends BaseGeneratedEMFQuerySpecification<ForksInStateMachine.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.ForksInStateMachine pattern,
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
    private StateMachine fStateMachine;
    
    private Pseudostate fForkState;
    
    private static List<String> parameterNames = makeImmutableList("stateMachine", "forkState");
    
    private Match(final StateMachine pStateMachine, final Pseudostate pForkState) {
      this.fStateMachine = pStateMachine;
      this.fForkState = pForkState;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "stateMachine": return this.fStateMachine;
          case "forkState": return this.fForkState;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fStateMachine;
          case 1: return this.fForkState;
          default: return null;
      }
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    public Pseudostate getForkState() {
      return this.fForkState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      if ("forkState".equals(parameterName) ) {
          this.fForkState = (Pseudostate) newValue;
          return true;
      }
      return false;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setForkState(final Pseudostate pForkState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fForkState = pForkState;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.ForksInStateMachine";
    }
    
    @Override
    public List<String> parameterNames() {
      return ForksInStateMachine.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStateMachine, fForkState};
    }
    
    @Override
    public ForksInStateMachine.Match toImmutable() {
      return isMutable() ? newMatch(fStateMachine, fForkState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"forkState\"=" + prettyPrintValue(fForkState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStateMachine, fForkState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ForksInStateMachine.Match)) {
          ForksInStateMachine.Match other = (ForksInStateMachine.Match) obj;
          return Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fForkState, other.fForkState);
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
    public ForksInStateMachine specification() {
      return ForksInStateMachine.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ForksInStateMachine.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ForksInStateMachine.Match newMutableMatch(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return new Mutable(pStateMachine, pForkState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ForksInStateMachine.Match newMatch(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return new Immutable(pStateMachine, pForkState);
    }
    
    private static final class Mutable extends ForksInStateMachine.Match {
      Mutable(final StateMachine pStateMachine, final Pseudostate pForkState) {
        super(pStateMachine, pForkState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ForksInStateMachine.Match {
      Immutable(final StateMachine pStateMachine, final Pseudostate pForkState) {
        super(pStateMachine, pForkState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.ForksInStateMachine pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern ForksInStateMachine(stateMachine: StateMachine, forkState: Pseudostate){
   * 	find RegionsInStatemachine(stateMachine, region);
   * 	Region.subvertex(region, forkState);
   * 	Pseudostate.kind(forkState, ::fork);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ForksInStateMachine
   * 
   */
  public static class Matcher extends BaseMatcher<ForksInStateMachine.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ForksInStateMachine.Matcher on(final ViatraQueryEngine engine) {
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
    public static ForksInStateMachine.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_FORKSTATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ForksInStateMachine.Matcher.class);
    
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
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ForksInStateMachine.Match> getAllMatches(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pForkState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ForksInStateMachine.Match> streamAllMatches(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pForkState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ForksInStateMachine.Match> getOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pForkState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return rawHasMatch(new Object[]{pStateMachine, pForkState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return rawCountMatches(new Object[]{pStateMachine, pForkState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pForkState, final Consumer<? super ForksInStateMachine.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStateMachine, pForkState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pForkState the fixed value of pattern parameter forkState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ForksInStateMachine.Match newMatch(final StateMachine pStateMachine, final Pseudostate pForkState) {
      return ForksInStateMachine.Match.newMatch(pStateMachine, pForkState);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<StateMachine> rawStreamAllValuesOfstateMachine(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATEMACHINE, parameters).map(StateMachine.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine() {
      return rawStreamAllValuesOfstateMachine(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine() {
      return rawStreamAllValuesOfstateMachine(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine(final ForksInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstateMachine(final Pseudostate pForkState) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pForkState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final ForksInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final Pseudostate pForkState) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pForkState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Pseudostate> rawStreamAllValuesOfforkState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_FORKSTATE, parameters).map(Pseudostate.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfforkState() {
      return rawStreamAllValuesOfforkState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfforkState() {
      return rawStreamAllValuesOfforkState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfforkState(final ForksInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfforkState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfforkState(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfforkState(new Object[]{pStateMachine, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfforkState(final ForksInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfforkState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for forkState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfforkState(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfforkState(new Object[]{pStateMachine, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ForksInStateMachine.Match tupleToMatch(final Tuple t) {
      try {
          return ForksInStateMachine.Match.newMatch((StateMachine) t.get(POSITION_STATEMACHINE), (Pseudostate) t.get(POSITION_FORKSTATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ForksInStateMachine.Match arrayToMatch(final Object[] match) {
      try {
          return ForksInStateMachine.Match.newMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_FORKSTATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ForksInStateMachine.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ForksInStateMachine.Match.newMutableMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_FORKSTATE]);
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
    public static IQuerySpecification<ForksInStateMachine.Matcher> querySpecification() {
      return ForksInStateMachine.instance();
    }
  }
  
  private ForksInStateMachine() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ForksInStateMachine instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForksInStateMachine.Matcher instantiate(final ViatraQueryEngine engine) {
    return ForksInStateMachine.Matcher.on(engine);
  }
  
  @Override
  public ForksInStateMachine.Matcher instantiate() {
    return ForksInStateMachine.Matcher.create();
  }
  
  @Override
  public ForksInStateMachine.Match newEmptyMatch() {
    return ForksInStateMachine.Match.newEmptyMatch();
  }
  
  @Override
  public ForksInStateMachine.Match newMatch(final Object... parameters) {
    return ForksInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ForksInStateMachine} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ForksInStateMachine#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ForksInStateMachine INSTANCE = new ForksInStateMachine();
    
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
    private static final ForksInStateMachine.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_forkState = new PParameter("forkState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stateMachine, parameter_forkState);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.ForksInStateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","forkState");
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
          PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
          PVariable var_forkState = body.getOrCreateVariableByName("forkState");
          PVariable var_region = body.getOrCreateVariableByName("region");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_forkState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_forkState, parameter_forkState)
          ));
          // 	find RegionsInStatemachine(stateMachine, region)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_stateMachine, var_region), RegionsInStatemachine.instance().getInternalQueryRepresentation());
          // 	Region.subvertex(region, forkState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_forkState);
          // 	Pseudostate.kind(forkState, ::fork)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum.get("fork"));
          new TypeConstraint(body, Tuples.flatTupleOf(var_forkState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_forkState, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate", "kind")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")));
          new Equality(body, var__virtual_2_, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
