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
 *         pattern JoinsInStateMachine(stateMachine: StateMachine, joinState: Pseudostate){
 *         	find RegionsInStatemachine(stateMachine, region);
 *         	Region.subvertex(region, joinState);
 *         	Pseudostate.kind(joinState, ::join);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class JoinsInStateMachine extends BaseGeneratedEMFQuerySpecification<JoinsInStateMachine.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine pattern,
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
    
    private Pseudostate fJoinState;
    
    private static List<String> parameterNames = makeImmutableList("stateMachine", "joinState");
    
    private Match(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      this.fStateMachine = pStateMachine;
      this.fJoinState = pJoinState;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("stateMachine".equals(parameterName)) return this.fStateMachine;
      if ("joinState".equals(parameterName)) return this.fJoinState;
      return null;
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    public Pseudostate getJoinState() {
      return this.fJoinState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      if ("joinState".equals(parameterName) ) {
          this.fJoinState = (Pseudostate) newValue;
          return true;
      }
      return false;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setJoinState(final Pseudostate pJoinState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fJoinState = pJoinState;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine";
    }
    
    @Override
    public List<String> parameterNames() {
      return JoinsInStateMachine.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStateMachine, fJoinState};
    }
    
    @Override
    public JoinsInStateMachine.Match toImmutable() {
      return isMutable() ? newMatch(fStateMachine, fJoinState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"joinState\"=" + prettyPrintValue(fJoinState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStateMachine, fJoinState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof JoinsInStateMachine.Match)) {
          JoinsInStateMachine.Match other = (JoinsInStateMachine.Match) obj;
          return Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fJoinState, other.fJoinState);
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
    public JoinsInStateMachine specification() {
      return JoinsInStateMachine.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static JoinsInStateMachine.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static JoinsInStateMachine.Match newMutableMatch(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return new Mutable(pStateMachine, pJoinState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static JoinsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return new Immutable(pStateMachine, pJoinState);
    }
    
    private static final class Mutable extends JoinsInStateMachine.Match {
      Mutable(final StateMachine pStateMachine, final Pseudostate pJoinState) {
        super(pStateMachine, pJoinState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends JoinsInStateMachine.Match {
      Immutable(final StateMachine pStateMachine, final Pseudostate pJoinState) {
        super(pStateMachine, pJoinState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern JoinsInStateMachine(stateMachine: StateMachine, joinState: Pseudostate){
   * 	find RegionsInStatemachine(stateMachine, region);
   * 	Region.subvertex(region, joinState);
   * 	Pseudostate.kind(joinState, ::join);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see JoinsInStateMachine
   * 
   */
  public static class Matcher extends BaseMatcher<JoinsInStateMachine.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static JoinsInStateMachine.Matcher on(final ViatraQueryEngine engine) {
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
    public static JoinsInStateMachine.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_JOINSTATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(JoinsInStateMachine.Matcher.class);
    
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
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<JoinsInStateMachine.Match> getAllMatches(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pJoinState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<JoinsInStateMachine.Match> streamAllMatches(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pJoinState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<JoinsInStateMachine.Match> getOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pJoinState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return rawHasMatch(new Object[]{pStateMachine, pJoinState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return rawCountMatches(new Object[]{pStateMachine, pJoinState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Pseudostate pJoinState, final Consumer<? super JoinsInStateMachine.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStateMachine, pJoinState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pJoinState the fixed value of pattern parameter joinState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public JoinsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Pseudostate pJoinState) {
      return JoinsInStateMachine.Match.newMatch(pStateMachine, pJoinState);
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final JoinsInStateMachine.Match partialMatch) {
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final Pseudostate pJoinState) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pJoinState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final JoinsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final Pseudostate pJoinState) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pJoinState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Pseudostate> rawStreamAllValuesOfjoinState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_JOINSTATE, parameters).map(Pseudostate.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfjoinState() {
      return rawStreamAllValuesOfjoinState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfjoinState() {
      return rawStreamAllValuesOfjoinState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfjoinState(final JoinsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfjoinState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfjoinState(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfjoinState(new Object[]{pStateMachine, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfjoinState(final JoinsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfjoinState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for joinState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfjoinState(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfjoinState(new Object[]{pStateMachine, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected JoinsInStateMachine.Match tupleToMatch(final Tuple t) {
      try {
          return JoinsInStateMachine.Match.newMatch((StateMachine) t.get(POSITION_STATEMACHINE), (Pseudostate) t.get(POSITION_JOINSTATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected JoinsInStateMachine.Match arrayToMatch(final Object[] match) {
      try {
          return JoinsInStateMachine.Match.newMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_JOINSTATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected JoinsInStateMachine.Match arrayToMatchMutable(final Object[] match) {
      try {
          return JoinsInStateMachine.Match.newMutableMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_JOINSTATE]);
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
    public static IQuerySpecification<JoinsInStateMachine.Matcher> querySpecification() {
      return JoinsInStateMachine.instance();
    }
  }
  
  private JoinsInStateMachine() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static JoinsInStateMachine instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected JoinsInStateMachine.Matcher instantiate(final ViatraQueryEngine engine) {
    return JoinsInStateMachine.Matcher.on(engine);
  }
  
  @Override
  public JoinsInStateMachine.Matcher instantiate() {
    return JoinsInStateMachine.Matcher.create();
  }
  
  @Override
  public JoinsInStateMachine.Match newEmptyMatch() {
    return JoinsInStateMachine.Match.newEmptyMatch();
  }
  
  @Override
  public JoinsInStateMachine.Match newMatch(final Object... parameters) {
    return JoinsInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine (visibility: PUBLIC, simpleName: JoinsInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine (visibility: PUBLIC, simpleName: JoinsInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final JoinsInStateMachine INSTANCE = new JoinsInStateMachine();
    
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
    private static final JoinsInStateMachine.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_joinState = new PParameter("joinState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stateMachine, parameter_joinState);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.JoinsInStateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","joinState");
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
          PVariable var_joinState = body.getOrCreateVariableByName("joinState");
          PVariable var_region = body.getOrCreateVariableByName("region");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_joinState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_joinState, parameter_joinState)
          ));
          // 	find RegionsInStatemachine(stateMachine, region)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_stateMachine, var_region), RegionsInStatemachine.instance().getInternalQueryRepresentation());
          // 	Region.subvertex(region, joinState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_joinState);
          // 	Pseudostate.kind(joinState, ::join)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum.get("join"));
          new TypeConstraint(body, Tuples.flatTupleOf(var_joinState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_joinState, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate", "kind")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")));
          new Equality(body, var__virtual_2_, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
