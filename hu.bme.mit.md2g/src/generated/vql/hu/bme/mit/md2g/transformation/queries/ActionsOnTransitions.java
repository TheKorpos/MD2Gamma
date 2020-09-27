/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
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
 *         pattern ActionsOnTransitions(transition: Transition, body: java String, effect: Behavior){
 *         	Transition.effect(transition, effect);
 *         	find Actions(effect, body);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ActionsOnTransitions extends BaseGeneratedEMFQuerySpecification<ActionsOnTransitions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions pattern,
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
    private Transition fTransition;
    
    private String fBody;
    
    private Behavior fEffect;
    
    private static List<String> parameterNames = makeImmutableList("transition", "body", "effect");
    
    private Match(final Transition pTransition, final String pBody, final Behavior pEffect) {
      this.fTransition = pTransition;
      this.fBody = pBody;
      this.fEffect = pEffect;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "transition": return this.fTransition;
          case "body": return this.fBody;
          case "effect": return this.fEffect;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTransition;
          case 1: return this.fBody;
          case 2: return this.fEffect;
          default: return null;
      }
    }
    
    public Transition getTransition() {
      return this.fTransition;
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
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
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
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
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
      return "hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions";
    }
    
    @Override
    public List<String> parameterNames() {
      return ActionsOnTransitions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTransition, fBody, fEffect};
    }
    
    @Override
    public ActionsOnTransitions.Match toImmutable() {
      return isMutable() ? newMatch(fTransition, fBody, fEffect) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"body\"=" + prettyPrintValue(fBody) + ", ");
      result.append("\"effect\"=" + prettyPrintValue(fEffect));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTransition, fBody, fEffect);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ActionsOnTransitions.Match)) {
          ActionsOnTransitions.Match other = (ActionsOnTransitions.Match) obj;
          return Objects.equals(fTransition, other.fTransition) && Objects.equals(fBody, other.fBody) && Objects.equals(fEffect, other.fEffect);
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
    public ActionsOnTransitions specification() {
      return ActionsOnTransitions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ActionsOnTransitions.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ActionsOnTransitions.Match newMutableMatch(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return new Mutable(pTransition, pBody, pEffect);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ActionsOnTransitions.Match newMatch(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return new Immutable(pTransition, pBody, pEffect);
    }
    
    private static final class Mutable extends ActionsOnTransitions.Match {
      Mutable(final Transition pTransition, final String pBody, final Behavior pEffect) {
        super(pTransition, pBody, pEffect);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ActionsOnTransitions.Match {
      Immutable(final Transition pTransition, final String pBody, final Behavior pEffect) {
        super(pTransition, pBody, pEffect);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern ActionsOnTransitions(transition: Transition, body: java String, effect: Behavior){
   * 	Transition.effect(transition, effect);
   * 	find Actions(effect, body);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ActionsOnTransitions
   * 
   */
  public static class Matcher extends BaseMatcher<ActionsOnTransitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ActionsOnTransitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static ActionsOnTransitions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRANSITION = 0;
    
    private static final int POSITION_BODY = 1;
    
    private static final int POSITION_EFFECT = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ActionsOnTransitions.Matcher.class);
    
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
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ActionsOnTransitions.Match> getAllMatches(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return rawStreamAllMatches(new Object[]{pTransition, pBody, pEffect}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ActionsOnTransitions.Match> streamAllMatches(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return rawStreamAllMatches(new Object[]{pTransition, pBody, pEffect});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ActionsOnTransitions.Match> getOneArbitraryMatch(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return rawGetOneArbitraryMatch(new Object[]{pTransition, pBody, pEffect});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return rawHasMatch(new Object[]{pTransition, pBody, pEffect});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return rawCountMatches(new Object[]{pTransition, pBody, pEffect});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Transition pTransition, final String pBody, final Behavior pEffect, final Consumer<? super ActionsOnTransitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTransition, pBody, pEffect}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ActionsOnTransitions.Match newMatch(final Transition pTransition, final String pBody, final Behavior pEffect) {
      return ActionsOnTransitions.Match.newMatch(pTransition, pBody, pEffect);
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Transition> rawStreamAllValuesOftransition(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRANSITION, parameters).map(Transition.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition() {
      return rawStreamAllValuesOftransition(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition(final ActionsOnTransitions.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Transition> streamAllValuesOftransition(final String pBody, final Behavior pEffect) {
      return rawStreamAllValuesOftransition(new Object[]{null, pBody, pEffect});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final ActionsOnTransitions.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final String pBody, final Behavior pEffect) {
      return rawStreamAllValuesOftransition(new Object[]{null, pBody, pEffect}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfbody(final ActionsOnTransitions.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfbody(final Transition pTransition, final Behavior pEffect) {
      return rawStreamAllValuesOfbody(new Object[]{pTransition, null, pEffect});
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final ActionsOnTransitions.Match partialMatch) {
      return rawStreamAllValuesOfbody(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final Transition pTransition, final Behavior pEffect) {
      return rawStreamAllValuesOfbody(new Object[]{pTransition, null, pEffect}).collect(Collectors.toSet());
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
    public Stream<Behavior> streamAllValuesOfeffect(final ActionsOnTransitions.Match partialMatch) {
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
    public Stream<Behavior> streamAllValuesOfeffect(final Transition pTransition, final String pBody) {
      return rawStreamAllValuesOfeffect(new Object[]{pTransition, pBody, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfeffect(final ActionsOnTransitions.Match partialMatch) {
      return rawStreamAllValuesOfeffect(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for effect.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfeffect(final Transition pTransition, final String pBody) {
      return rawStreamAllValuesOfeffect(new Object[]{pTransition, pBody, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ActionsOnTransitions.Match tupleToMatch(final Tuple t) {
      try {
          return ActionsOnTransitions.Match.newMatch((Transition) t.get(POSITION_TRANSITION), (String) t.get(POSITION_BODY), (Behavior) t.get(POSITION_EFFECT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ActionsOnTransitions.Match arrayToMatch(final Object[] match) {
      try {
          return ActionsOnTransitions.Match.newMatch((Transition) match[POSITION_TRANSITION], (String) match[POSITION_BODY], (Behavior) match[POSITION_EFFECT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ActionsOnTransitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ActionsOnTransitions.Match.newMutableMatch((Transition) match[POSITION_TRANSITION], (String) match[POSITION_BODY], (Behavior) match[POSITION_EFFECT]);
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
    public static IQuerySpecification<ActionsOnTransitions.Matcher> querySpecification() {
      return ActionsOnTransitions.instance();
    }
  }
  
  private ActionsOnTransitions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ActionsOnTransitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ActionsOnTransitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return ActionsOnTransitions.Matcher.on(engine);
  }
  
  @Override
  public ActionsOnTransitions.Matcher instantiate() {
    return ActionsOnTransitions.Matcher.create();
  }
  
  @Override
  public ActionsOnTransitions.Match newEmptyMatch() {
    return ActionsOnTransitions.Match.newEmptyMatch();
  }
  
  @Override
  public ActionsOnTransitions.Match newMatch(final Object... parameters) {
    return ActionsOnTransitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition) parameters[0], (java.lang.String) parameters[1], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ActionsOnTransitions} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ActionsOnTransitions#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ActionsOnTransitions INSTANCE = new ActionsOnTransitions();
    
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
    private static final ActionsOnTransitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_transition = new PParameter("transition", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_body = new PParameter("body", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_effect = new PParameter("effect", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_transition, parameter_body, parameter_effect);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.ActionsOnTransitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","body","effect");
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
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_body = body.getOrCreateVariableByName("body");
          PVariable var_effect = body.getOrCreateVariableByName("effect");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_effect), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_body, parameter_body),
             new ExportedParameter(body, var_effect, parameter_effect)
          ));
          // 	Transition.effect(transition, effect)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "effect")));
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
