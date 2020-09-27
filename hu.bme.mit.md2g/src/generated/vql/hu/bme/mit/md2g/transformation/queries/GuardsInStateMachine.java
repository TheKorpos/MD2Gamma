/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import hu.bme.mit.md2g.transformation.queries.TranisitonsInStateMachine;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
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
 *         pattern GuardsInStateMachine(stateMachine: StateMachine, transition: Transition, opaqueExpression: OpaqueExpression, body: java String){
 *         	find TranisitonsInStateMachine(stateMachine, transition);
 *         	Transition.guard(transition, guard);
 *         	Constraint.specification(guard, opaqueExpression);
 *         	OpaqueExpression.body(opaqueExpression, body);
 *         	check(!"".equals(body));
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class GuardsInStateMachine extends BaseGeneratedEMFQuerySpecification<GuardsInStateMachine.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine pattern,
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
    
    private Transition fTransition;
    
    private OpaqueExpression fOpaqueExpression;
    
    private String fBody;
    
    private static List<String> parameterNames = makeImmutableList("stateMachine", "transition", "opaqueExpression", "body");
    
    private Match(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      this.fStateMachine = pStateMachine;
      this.fTransition = pTransition;
      this.fOpaqueExpression = pOpaqueExpression;
      this.fBody = pBody;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "stateMachine": return this.fStateMachine;
          case "transition": return this.fTransition;
          case "opaqueExpression": return this.fOpaqueExpression;
          case "body": return this.fBody;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fStateMachine;
          case 1: return this.fTransition;
          case 2: return this.fOpaqueExpression;
          case 3: return this.fBody;
          default: return null;
      }
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public OpaqueExpression getOpaqueExpression() {
      return this.fOpaqueExpression;
    }
    
    public String getBody() {
      return this.fBody;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("opaqueExpression".equals(parameterName) ) {
          this.fOpaqueExpression = (OpaqueExpression) newValue;
          return true;
      }
      if ("body".equals(parameterName) ) {
          this.fBody = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setOpaqueExpression(final OpaqueExpression pOpaqueExpression) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fOpaqueExpression = pOpaqueExpression;
    }
    
    public void setBody(final String pBody) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBody = pBody;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine";
    }
    
    @Override
    public List<String> parameterNames() {
      return GuardsInStateMachine.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStateMachine, fTransition, fOpaqueExpression, fBody};
    }
    
    @Override
    public GuardsInStateMachine.Match toImmutable() {
      return isMutable() ? newMatch(fStateMachine, fTransition, fOpaqueExpression, fBody) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"opaqueExpression\"=" + prettyPrintValue(fOpaqueExpression) + ", ");
      result.append("\"body\"=" + prettyPrintValue(fBody));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStateMachine, fTransition, fOpaqueExpression, fBody);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof GuardsInStateMachine.Match)) {
          GuardsInStateMachine.Match other = (GuardsInStateMachine.Match) obj;
          return Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fTransition, other.fTransition) && Objects.equals(fOpaqueExpression, other.fOpaqueExpression) && Objects.equals(fBody, other.fBody);
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
    public GuardsInStateMachine specification() {
      return GuardsInStateMachine.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static GuardsInStateMachine.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static GuardsInStateMachine.Match newMutableMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return new Mutable(pStateMachine, pTransition, pOpaqueExpression, pBody);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static GuardsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return new Immutable(pStateMachine, pTransition, pOpaqueExpression, pBody);
    }
    
    private static final class Mutable extends GuardsInStateMachine.Match {
      Mutable(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
        super(pStateMachine, pTransition, pOpaqueExpression, pBody);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends GuardsInStateMachine.Match {
      Immutable(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
        super(pStateMachine, pTransition, pOpaqueExpression, pBody);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern GuardsInStateMachine(stateMachine: StateMachine, transition: Transition, opaqueExpression: OpaqueExpression, body: java String){
   * 	find TranisitonsInStateMachine(stateMachine, transition);
   * 	Transition.guard(transition, guard);
   * 	Constraint.specification(guard, opaqueExpression);
   * 	OpaqueExpression.body(opaqueExpression, body);
   * 	check(!"".equals(body));
   * }
   * </pre></code>
   * 
   * @see Match
   * @see GuardsInStateMachine
   * 
   */
  public static class Matcher extends BaseMatcher<GuardsInStateMachine.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static GuardsInStateMachine.Matcher on(final ViatraQueryEngine engine) {
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
    public static GuardsInStateMachine.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_TRANSITION = 1;
    
    private static final int POSITION_OPAQUEEXPRESSION = 2;
    
    private static final int POSITION_BODY = 3;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GuardsInStateMachine.Matcher.class);
    
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
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<GuardsInStateMachine.Match> getAllMatches(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<GuardsInStateMachine.Match> streamAllMatches(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<GuardsInStateMachine.Match> getOneArbitraryMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawHasMatch(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawCountMatches(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody, final Consumer<? super GuardsInStateMachine.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStateMachine, pTransition, pOpaqueExpression, pBody}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pOpaqueExpression the fixed value of pattern parameter opaqueExpression, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public GuardsInStateMachine.Match newMatch(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return GuardsInStateMachine.Match.newMatch(pStateMachine, pTransition, pOpaqueExpression, pBody);
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final GuardsInStateMachine.Match partialMatch) {
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pTransition, pOpaqueExpression, pBody});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final GuardsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final Transition pTransition, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pTransition, pOpaqueExpression, pBody}).collect(Collectors.toSet());
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
    public Stream<Transition> streamAllValuesOftransition(final GuardsInStateMachine.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final StateMachine pStateMachine, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllValuesOftransition(new Object[]{pStateMachine, null, pOpaqueExpression, pBody});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final GuardsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final StateMachine pStateMachine, final OpaqueExpression pOpaqueExpression, final String pBody) {
      return rawStreamAllValuesOftransition(new Object[]{pStateMachine, null, pOpaqueExpression, pBody}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<OpaqueExpression> rawStreamAllValuesOfopaqueExpression(final Object[] parameters) {
      return rawStreamAllValues(POSITION_OPAQUEEXPRESSION, parameters).map(OpaqueExpression.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<OpaqueExpression> getAllValuesOfopaqueExpression() {
      return rawStreamAllValuesOfopaqueExpression(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<OpaqueExpression> streamAllValuesOfopaqueExpression() {
      return rawStreamAllValuesOfopaqueExpression(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<OpaqueExpression> streamAllValuesOfopaqueExpression(final GuardsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfopaqueExpression(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<OpaqueExpression> streamAllValuesOfopaqueExpression(final StateMachine pStateMachine, final Transition pTransition, final String pBody) {
      return rawStreamAllValuesOfopaqueExpression(new Object[]{pStateMachine, pTransition, null, pBody});
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<OpaqueExpression> getAllValuesOfopaqueExpression(final GuardsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfopaqueExpression(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for opaqueExpression.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<OpaqueExpression> getAllValuesOfopaqueExpression(final StateMachine pStateMachine, final Transition pTransition, final String pBody) {
      return rawStreamAllValuesOfopaqueExpression(new Object[]{pStateMachine, pTransition, null, pBody}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfbody(final GuardsInStateMachine.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfbody(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression) {
      return rawStreamAllValuesOfbody(new Object[]{pStateMachine, pTransition, pOpaqueExpression, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final GuardsInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfbody(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final StateMachine pStateMachine, final Transition pTransition, final OpaqueExpression pOpaqueExpression) {
      return rawStreamAllValuesOfbody(new Object[]{pStateMachine, pTransition, pOpaqueExpression, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected GuardsInStateMachine.Match tupleToMatch(final Tuple t) {
      try {
          return GuardsInStateMachine.Match.newMatch((StateMachine) t.get(POSITION_STATEMACHINE), (Transition) t.get(POSITION_TRANSITION), (OpaqueExpression) t.get(POSITION_OPAQUEEXPRESSION), (String) t.get(POSITION_BODY));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected GuardsInStateMachine.Match arrayToMatch(final Object[] match) {
      try {
          return GuardsInStateMachine.Match.newMatch((StateMachine) match[POSITION_STATEMACHINE], (Transition) match[POSITION_TRANSITION], (OpaqueExpression) match[POSITION_OPAQUEEXPRESSION], (String) match[POSITION_BODY]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected GuardsInStateMachine.Match arrayToMatchMutable(final Object[] match) {
      try {
          return GuardsInStateMachine.Match.newMutableMatch((StateMachine) match[POSITION_STATEMACHINE], (Transition) match[POSITION_TRANSITION], (OpaqueExpression) match[POSITION_OPAQUEEXPRESSION], (String) match[POSITION_BODY]);
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
    public static IQuerySpecification<GuardsInStateMachine.Matcher> querySpecification() {
      return GuardsInStateMachine.instance();
    }
  }
  
  private GuardsInStateMachine() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static GuardsInStateMachine instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected GuardsInStateMachine.Matcher instantiate(final ViatraQueryEngine engine) {
    return GuardsInStateMachine.Matcher.on(engine);
  }
  
  @Override
  public GuardsInStateMachine.Matcher instantiate() {
    return GuardsInStateMachine.Matcher.create();
  }
  
  @Override
  public GuardsInStateMachine.Match newEmptyMatch() {
    return GuardsInStateMachine.Match.newEmptyMatch();
  }
  
  @Override
  public GuardsInStateMachine.Match newMatch(final Object... parameters) {
    return GuardsInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression) parameters[2], (java.lang.String) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link GuardsInStateMachine} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link GuardsInStateMachine#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final GuardsInStateMachine INSTANCE = new GuardsInStateMachine();
    
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
    private static final GuardsInStateMachine.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_transition = new PParameter("transition", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_opaqueExpression = new PParameter("opaqueExpression", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueExpression")), PParameterDirection.INOUT);
    
    private final PParameter parameter_body = new PParameter("body", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stateMachine, parameter_transition, parameter_opaqueExpression, parameter_body);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.GuardsInStateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","transition","opaqueExpression","body");
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
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_opaqueExpression = body.getOrCreateVariableByName("opaqueExpression");
          PVariable var_body = body.getOrCreateVariableByName("body");
          PVariable var_guard = body.getOrCreateVariableByName("guard");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_opaqueExpression), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueExpression")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_opaqueExpression, parameter_opaqueExpression),
             new ExportedParameter(body, var_body, parameter_body)
          ));
          // 	find TranisitonsInStateMachine(stateMachine, transition)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_stateMachine, var_transition), TranisitonsInStateMachine.instance().getInternalQueryRepresentation());
          // 	Transition.guard(transition, guard)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "guard")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Constraint")));
          new Equality(body, var__virtual_0_, var_guard);
          // 	Constraint.specification(guard, opaqueExpression)
          new TypeConstraint(body, Tuples.flatTupleOf(var_guard), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Constraint")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_guard, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Constraint", "specification")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ValueSpecification")));
          new Equality(body, var__virtual_1_, var_opaqueExpression);
          // 	OpaqueExpression.body(opaqueExpression, body)
          new TypeConstraint(body, Tuples.flatTupleOf(var_opaqueExpression), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueExpression")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_opaqueExpression, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueExpression", "body")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_2_, var_body);
          // 	check(!"".equals(body))
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern GuardsInStateMachine";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("body");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String body = (String) provider.getValue("body");
                  return evaluateExpression_1_1(body);
              }
          },  null); 
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final String body) {
    boolean _equals = "".equals(body);
    boolean _not = (!_equals);
    return _not;
  }
}
