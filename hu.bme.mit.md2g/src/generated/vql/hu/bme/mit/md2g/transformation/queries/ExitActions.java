/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import hu.bme.mit.md2g.transformation.queries.Actions;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern ExitActions(state: State, body: java String, effect: Behavior){
 *         	State.exit(state, effect);
 *         	find Actions(effect, body);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ExitActions extends BaseGeneratedEMFQuerySpecification<ExitActions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.ExitActions pattern,
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
    private State fState;
    
    private String fBody;
    
    private Behavior fEffect;
    
    private static List<String> parameterNames = makeImmutableList("state", "body", "effect");
    
    private Match(final State pState, final String pBody, final Behavior pEffect) {
      this.fState = pState;
      this.fBody = pBody;
      this.fEffect = pEffect;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "state": return this.fState;
          case "body": return this.fBody;
          case "effect": return this.fEffect;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fState;
          case 1: return this.fBody;
          case 2: return this.fEffect;
          default: return null;
      }
    }
    
    public State getState() {
      return this.fState;
    }
    
    public String getBody() {
      return this.fBody;
    }
    
    public Behavior getEffect() {
      return this.fEffect;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("state".equals(parameterName) ) {
          this.fState = (State) newValue;
          return true;
      }
      if ("body".equals(parameterName) ) {
          this.fBody = (String) newValue;
          return true;
      }
      if ("effect".equals(parameterName) ) {
          this.fEffect = (Behavior) newValue;
          return true;
      }
      return false;
    }
    
    public void setState(final State pState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fState = pState;
    }
    
    public void setBody(final String pBody) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBody = pBody;
    }
    
    public void setEffect(final Behavior pEffect) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEffect = pEffect;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.ExitActions";
    }
    
    @Override
    public List<String> parameterNames() {
      return ExitActions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fState, fBody, fEffect};
    }
    
    @Override
    public ExitActions.Match toImmutable() {
      return isMutable() ? newMatch(fState, fBody, fEffect) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
      result.append("\"body\"=" + prettyPrintValue(fBody) + ", ");
      result.append("\"effect\"=" + prettyPrintValue(fEffect));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fState, fBody, fEffect);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ExitActions.Match)) {
          ExitActions.Match other = (ExitActions.Match) obj;
          return Objects.equals(fState, other.fState) && Objects.equals(fBody, other.fBody) && Objects.equals(fEffect, other.fEffect);
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
    public ExitActions specification() {
      return ExitActions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ExitActions.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ExitActions.Match newMutableMatch(final State pState, final String pBody, final Behavior pEffect) {
      return new Mutable(pState, pBody, pEffect);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ExitActions.Match newMatch(final State pState, final String pBody, final Behavior pEffect) {
      return new Immutable(pState, pBody, pEffect);
    }
    
    private static final class Mutable extends ExitActions.Match {
      Mutable(final State pState, final String pBody, final Behavior pEffect) {
        super(pState, pBody, pEffect);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ExitActions.Match {
      Immutable(final State pState, final String pBody, final Behavior pEffect) {
        super(pState, pBody, pEffect);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.ExitActions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern ExitActions(state: State, body: java String, effect: Behavior){
   * 	State.exit(state, effect);
   * 	find Actions(effect, body);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ExitActions
   * 
   */
  public static class Matcher extends BaseMatcher<ExitActions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ExitActions.Matcher on(final ViatraQueryEngine engine) {
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
    public static ExitActions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATE = 0;
    
    private static final int POSITION_BODY = 1;
    
    private static final int POSITION_EFFECT = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ExitActions.Matcher.class);
    
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
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ExitActions.Match> getAllMatches(final State pState, final String pBody, final Behavior pEffect) {
      return rawStreamAllMatches(new Object[]{pState, pBody, pEffect}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ExitActions.Match> streamAllMatches(final State pState, final String pBody, final Behavior pEffect) {
      return rawStreamAllMatches(new Object[]{pState, pBody, pEffect});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ExitActions.Match> getOneArbitraryMatch(final State pState, final String pBody, final Behavior pEffect) {
      return rawGetOneArbitraryMatch(new Object[]{pState, pBody, pEffect});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final State pState, final String pBody, final Behavior pEffect) {
      return rawHasMatch(new Object[]{pState, pBody, pEffect});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final State pState, final String pBody, final Behavior pEffect) {
      return rawCountMatches(new Object[]{pState, pBody, pEffect});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final State pState, final String pBody, final Behavior pEffect, final Consumer<? super ExitActions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pState, pBody, pEffect}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pState the fixed value of pattern parameter state, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ExitActions.Match newMatch(final State pState, final String pBody, final Behavior pEffect) {
      return ExitActions.Match.newMatch(pState, pBody, pEffect);
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
    public Stream<State> streamAllValuesOfstate(final ExitActions.Match partialMatch) {
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
    public Stream<State> streamAllValuesOfstate(final String pBody, final Behavior pEffect) {
      return rawStreamAllValuesOfstate(new Object[]{null, pBody, pEffect});
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final ExitActions.Match partialMatch) {
      return rawStreamAllValuesOfstate(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for state.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<State> getAllValuesOfstate(final String pBody, final Behavior pEffect) {
      return rawStreamAllValuesOfstate(new Object[]{null, pBody, pEffect}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfbody(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BODY, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody() {
      return rawStreamAllValuesOfbody(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfbody() {
      return rawStreamAllValuesOfbody(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfbody(final ExitActions.Match partialMatch) {
      return rawStreamAllValuesOfbody(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfbody(final State pState, final Behavior pEffect) {
      return rawStreamAllValuesOfbody(new Object[]{pState, null, pEffect});
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final ExitActions.Match partialMatch) {
      return rawStreamAllValuesOfbody(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final State pState, final Behavior pEffect) {
      return rawStreamAllValuesOfbody(new Object[]{pState, null, pEffect}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Behavior> rawStreamAllValuesOfeffect(final Object[] parameters) {
      return rawStreamAllValues(POSITION_EFFECT, parameters).map(Behavior.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfeffect() {
      return rawStreamAllValuesOfeffect(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfeffect() {
      return rawStreamAllValuesOfeffect(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfeffect(final ExitActions.Match partialMatch) {
      return rawStreamAllValuesOfeffect(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfeffect(final State pState, final String pBody) {
      return rawStreamAllValuesOfeffect(new Object[]{pState, pBody, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfeffect(final ExitActions.Match partialMatch) {
      return rawStreamAllValuesOfeffect(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfeffect(final State pState, final String pBody) {
      return rawStreamAllValuesOfeffect(new Object[]{pState, pBody, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ExitActions.Match tupleToMatch(final Tuple t) {
      try {
          return ExitActions.Match.newMatch((State) t.get(POSITION_STATE), (String) t.get(POSITION_BODY), (Behavior) t.get(POSITION_EFFECT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ExitActions.Match arrayToMatch(final Object[] match) {
      try {
          return ExitActions.Match.newMatch((State) match[POSITION_STATE], (String) match[POSITION_BODY], (Behavior) match[POSITION_EFFECT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ExitActions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ExitActions.Match.newMutableMatch((State) match[POSITION_STATE], (String) match[POSITION_BODY], (Behavior) match[POSITION_EFFECT]);
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
    public static IQuerySpecification<ExitActions.Matcher> querySpecification() {
      return ExitActions.instance();
    }
  }
  
  private ExitActions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ExitActions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExitActions.Matcher instantiate(final ViatraQueryEngine engine) {
    return ExitActions.Matcher.on(engine);
  }
  
  @Override
  public ExitActions.Matcher instantiate() {
    return ExitActions.Matcher.create();
  }
  
  @Override
  public ExitActions.Match newEmptyMatch() {
    return ExitActions.Match.newEmptyMatch();
  }
  
  @Override
  public ExitActions.Match newMatch(final Object... parameters) {
    return ExitActions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State) parameters[0], (java.lang.String) parameters[1], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ExitActions} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ExitActions#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ExitActions INSTANCE = new ExitActions();
    
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
    private static final ExitActions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_state = new PParameter("state", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")), PParameterDirection.INOUT);
    
    private final PParameter parameter_body = new PParameter("body", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_effect = new PParameter("effect", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_state, parameter_body, parameter_effect);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.ExitActions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("state","body","effect");
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
          PVariable var_state = body.getOrCreateVariableByName("state");
          PVariable var_body = body.getOrCreateVariableByName("body");
          PVariable var_effect = body.getOrCreateVariableByName("effect");
          new TypeConstraint(body, Tuples.flatTupleOf(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_effect), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_state, parameter_state),
             new ExportedParameter(body, var_body, parameter_body),
             new ExportedParameter(body, var_effect, parameter_effect)
          ));
          // 	State.exit(state, effect)
          new TypeConstraint(body, Tuples.flatTupleOf(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_state, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "State", "exit")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          new Equality(body, var__virtual_0_, var_effect);
          // 	find Actions(effect, body)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_effect, var_body), Actions.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
