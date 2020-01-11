/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.SignalEvent;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
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
 *         pattern SignalsInStateMachine(stateMachine: StateMachine, signal: Signal, event: SignalEvent){
 *         	StateMachine.event(stateMachine, event);
 *         	SignalEvent.signal(event, signal);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SignalsInStateMachine extends BaseGeneratedEMFQuerySpecification<SignalsInStateMachine.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine pattern,
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
    
    private Signal fSignal;
    
    private SignalEvent fEvent;
    
    private static List<String> parameterNames = makeImmutableList("stateMachine", "signal", "event");
    
    private Match(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      this.fStateMachine = pStateMachine;
      this.fSignal = pSignal;
      this.fEvent = pEvent;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("stateMachine".equals(parameterName)) return this.fStateMachine;
      if ("signal".equals(parameterName)) return this.fSignal;
      if ("event".equals(parameterName)) return this.fEvent;
      return null;
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    public Signal getSignal() {
      return this.fSignal;
    }
    
    public SignalEvent getEvent() {
      return this.fEvent;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      if ("signal".equals(parameterName) ) {
          this.fSignal = (Signal) newValue;
          return true;
      }
      if ("event".equals(parameterName) ) {
          this.fEvent = (SignalEvent) newValue;
          return true;
      }
      return false;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setSignal(final Signal pSignal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSignal = pSignal;
    }
    
    public void setEvent(final SignalEvent pEvent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEvent = pEvent;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine";
    }
    
    @Override
    public List<String> parameterNames() {
      return SignalsInStateMachine.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStateMachine, fSignal, fEvent};
    }
    
    @Override
    public SignalsInStateMachine.Match toImmutable() {
      return isMutable() ? newMatch(fStateMachine, fSignal, fEvent) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
      result.append("\"event\"=" + prettyPrintValue(fEvent));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStateMachine, fSignal, fEvent);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SignalsInStateMachine.Match)) {
          SignalsInStateMachine.Match other = (SignalsInStateMachine.Match) obj;
          return Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fSignal, other.fSignal) && Objects.equals(fEvent, other.fEvent);
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
    public SignalsInStateMachine specification() {
      return SignalsInStateMachine.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SignalsInStateMachine.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SignalsInStateMachine.Match newMutableMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return new Mutable(pStateMachine, pSignal, pEvent);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SignalsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return new Immutable(pStateMachine, pSignal, pEvent);
    }
    
    private static final class Mutable extends SignalsInStateMachine.Match {
      Mutable(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
        super(pStateMachine, pSignal, pEvent);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends SignalsInStateMachine.Match {
      Immutable(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
        super(pStateMachine, pSignal, pEvent);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern SignalsInStateMachine(stateMachine: StateMachine, signal: Signal, event: SignalEvent){
   * 	StateMachine.event(stateMachine, event);
   * 	SignalEvent.signal(event, signal);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SignalsInStateMachine
   * 
   */
  public static class Matcher extends BaseMatcher<SignalsInStateMachine.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SignalsInStateMachine.Matcher on(final ViatraQueryEngine engine) {
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
    public static SignalsInStateMachine.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_SIGNAL = 1;
    
    private static final int POSITION_EVENT = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SignalsInStateMachine.Matcher.class);
    
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
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SignalsInStateMachine.Match> getAllMatches(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pSignal, pEvent}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SignalsInStateMachine.Match> streamAllMatches(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pSignal, pEvent});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SignalsInStateMachine.Match> getOneArbitraryMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pSignal, pEvent});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return rawHasMatch(new Object[]{pStateMachine, pSignal, pEvent});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return rawCountMatches(new Object[]{pStateMachine, pSignal, pEvent});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent, final Consumer<? super SignalsInStateMachine.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStateMachine, pSignal, pEvent}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param pEvent the fixed value of pattern parameter event, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SignalsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Signal pSignal, final SignalEvent pEvent) {
      return SignalsInStateMachine.Match.newMatch(pStateMachine, pSignal, pEvent);
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final SignalsInStateMachine.Match partialMatch) {
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final Signal pSignal, final SignalEvent pEvent) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pSignal, pEvent});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final SignalsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final Signal pSignal, final SignalEvent pEvent) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pSignal, pEvent}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Signal> rawStreamAllValuesOfsignal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SIGNAL, parameters).map(Signal.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Signal> getAllValuesOfsignal() {
      return rawStreamAllValuesOfsignal(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Signal> streamAllValuesOfsignal() {
      return rawStreamAllValuesOfsignal(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Signal> streamAllValuesOfsignal(final SignalsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfsignal(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Signal> streamAllValuesOfsignal(final StateMachine pStateMachine, final SignalEvent pEvent) {
      return rawStreamAllValuesOfsignal(new Object[]{pStateMachine, null, pEvent});
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Signal> getAllValuesOfsignal(final SignalsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfsignal(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Signal> getAllValuesOfsignal(final StateMachine pStateMachine, final SignalEvent pEvent) {
      return rawStreamAllValuesOfsignal(new Object[]{pStateMachine, null, pEvent}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SignalEvent> rawStreamAllValuesOfevent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_EVENT, parameters).map(SignalEvent.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SignalEvent> getAllValuesOfevent() {
      return rawStreamAllValuesOfevent(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SignalEvent> streamAllValuesOfevent() {
      return rawStreamAllValuesOfevent(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SignalEvent> streamAllValuesOfevent(final SignalsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfevent(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SignalEvent> streamAllValuesOfevent(final StateMachine pStateMachine, final Signal pSignal) {
      return rawStreamAllValuesOfevent(new Object[]{pStateMachine, pSignal, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SignalEvent> getAllValuesOfevent(final SignalsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfevent(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for event.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SignalEvent> getAllValuesOfevent(final StateMachine pStateMachine, final Signal pSignal) {
      return rawStreamAllValuesOfevent(new Object[]{pStateMachine, pSignal, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected SignalsInStateMachine.Match tupleToMatch(final Tuple t) {
      try {
          return SignalsInStateMachine.Match.newMatch((StateMachine) t.get(POSITION_STATEMACHINE), (Signal) t.get(POSITION_SIGNAL), (SignalEvent) t.get(POSITION_EVENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SignalsInStateMachine.Match arrayToMatch(final Object[] match) {
      try {
          return SignalsInStateMachine.Match.newMatch((StateMachine) match[POSITION_STATEMACHINE], (Signal) match[POSITION_SIGNAL], (SignalEvent) match[POSITION_EVENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SignalsInStateMachine.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SignalsInStateMachine.Match.newMutableMatch((StateMachine) match[POSITION_STATEMACHINE], (Signal) match[POSITION_SIGNAL], (SignalEvent) match[POSITION_EVENT]);
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
    public static IQuerySpecification<SignalsInStateMachine.Matcher> querySpecification() {
      return SignalsInStateMachine.instance();
    }
  }
  
  private SignalsInStateMachine() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SignalsInStateMachine instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalsInStateMachine.Matcher instantiate(final ViatraQueryEngine engine) {
    return SignalsInStateMachine.Matcher.on(engine);
  }
  
  @Override
  public SignalsInStateMachine.Matcher instantiate() {
    return SignalsInStateMachine.Matcher.create();
  }
  
  @Override
  public SignalsInStateMachine.Match newEmptyMatch() {
    return SignalsInStateMachine.Match.newEmptyMatch();
  }
  
  @Override
  public SignalsInStateMachine.Match newMatch(final Object... parameters) {
    return SignalsInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal) parameters[1], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.SignalEvent) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine (visibility: PUBLIC, simpleName: SignalsInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine (visibility: PUBLIC, simpleName: SignalsInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SignalsInStateMachine INSTANCE = new SignalsInStateMachine();
    
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
    private static final SignalsInStateMachine.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_signal = new PParameter("signal", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")), PParameterDirection.INOUT);
    
    private final PParameter parameter_event = new PParameter("event", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.SignalEvent", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stateMachine, parameter_signal, parameter_event);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.SignalsInStateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","signal","event");
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
          PVariable var_signal = body.getOrCreateVariableByName("signal");
          PVariable var_event = body.getOrCreateVariableByName("event");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_signal, parameter_signal),
             new ExportedParameter(body, var_event, parameter_event)
          ));
          // 	StateMachine.event(stateMachine, event)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior", "event")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Event")));
          new Equality(body, var__virtual_0_, var_event);
          // 	SignalEvent.signal(event, signal)
          new TypeConstraint(body, Tuples.flatTupleOf(var_event), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_event, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent", "signal")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")));
          new Equality(body, var__virtual_1_, var_signal);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
