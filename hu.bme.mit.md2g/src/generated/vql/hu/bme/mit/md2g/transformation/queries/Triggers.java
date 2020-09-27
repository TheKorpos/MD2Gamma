/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
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
 *         pattern Triggers(transition: Transition, trigger: Trigger){
 *         	Transition.trigger(transition, trigger);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Triggers extends BaseGeneratedEMFQuerySpecification<Triggers.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.Triggers pattern,
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
    
    private Trigger fTrigger;
    
    private static List<String> parameterNames = makeImmutableList("transition", "trigger");
    
    private Match(final Transition pTransition, final Trigger pTrigger) {
      this.fTransition = pTransition;
      this.fTrigger = pTrigger;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "transition": return this.fTransition;
          case "trigger": return this.fTrigger;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTransition;
          case 1: return this.fTrigger;
          default: return null;
      }
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public Trigger getTrigger() {
      return this.fTrigger;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("trigger".equals(parameterName) ) {
          this.fTrigger = (Trigger) newValue;
          return true;
      }
      return false;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setTrigger(final Trigger pTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrigger = pTrigger;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.Triggers";
    }
    
    @Override
    public List<String> parameterNames() {
      return Triggers.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTransition, fTrigger};
    }
    
    @Override
    public Triggers.Match toImmutable() {
      return isMutable() ? newMatch(fTransition, fTrigger) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"trigger\"=" + prettyPrintValue(fTrigger));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTransition, fTrigger);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Triggers.Match)) {
          Triggers.Match other = (Triggers.Match) obj;
          return Objects.equals(fTransition, other.fTransition) && Objects.equals(fTrigger, other.fTrigger);
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
    public Triggers specification() {
      return Triggers.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Triggers.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Triggers.Match newMutableMatch(final Transition pTransition, final Trigger pTrigger) {
      return new Mutable(pTransition, pTrigger);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Triggers.Match newMatch(final Transition pTransition, final Trigger pTrigger) {
      return new Immutable(pTransition, pTrigger);
    }
    
    private static final class Mutable extends Triggers.Match {
      Mutable(final Transition pTransition, final Trigger pTrigger) {
        super(pTransition, pTrigger);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Triggers.Match {
      Immutable(final Transition pTransition, final Trigger pTrigger) {
        super(pTransition, pTrigger);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.Triggers pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern Triggers(transition: Transition, trigger: Trigger){
   * 	Transition.trigger(transition, trigger);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Triggers
   * 
   */
  public static class Matcher extends BaseMatcher<Triggers.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Triggers.Matcher on(final ViatraQueryEngine engine) {
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
    public static Triggers.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRANSITION = 0;
    
    private static final int POSITION_TRIGGER = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Triggers.Matcher.class);
    
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
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Triggers.Match> getAllMatches(final Transition pTransition, final Trigger pTrigger) {
      return rawStreamAllMatches(new Object[]{pTransition, pTrigger}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Triggers.Match> streamAllMatches(final Transition pTransition, final Trigger pTrigger) {
      return rawStreamAllMatches(new Object[]{pTransition, pTrigger});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Triggers.Match> getOneArbitraryMatch(final Transition pTransition, final Trigger pTrigger) {
      return rawGetOneArbitraryMatch(new Object[]{pTransition, pTrigger});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Transition pTransition, final Trigger pTrigger) {
      return rawHasMatch(new Object[]{pTransition, pTrigger});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Transition pTransition, final Trigger pTrigger) {
      return rawCountMatches(new Object[]{pTransition, pTrigger});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Transition pTransition, final Trigger pTrigger, final Consumer<? super Triggers.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTransition, pTrigger}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Triggers.Match newMatch(final Transition pTransition, final Trigger pTrigger) {
      return Triggers.Match.newMatch(pTransition, pTrigger);
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
    public Stream<Transition> streamAllValuesOftransition(final Triggers.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final Trigger pTrigger) {
      return rawStreamAllValuesOftransition(new Object[]{null, pTrigger});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final Triggers.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final Trigger pTrigger) {
      return rawStreamAllValuesOftransition(new Object[]{null, pTrigger}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Trigger> rawStreamAllValuesOftrigger(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRIGGER, parameters).map(Trigger.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trigger> getAllValuesOftrigger() {
      return rawStreamAllValuesOftrigger(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Trigger> streamAllValuesOftrigger() {
      return rawStreamAllValuesOftrigger(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Trigger> streamAllValuesOftrigger(final Triggers.Match partialMatch) {
      return rawStreamAllValuesOftrigger(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Trigger> streamAllValuesOftrigger(final Transition pTransition) {
      return rawStreamAllValuesOftrigger(new Object[]{pTransition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trigger> getAllValuesOftrigger(final Triggers.Match partialMatch) {
      return rawStreamAllValuesOftrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trigger> getAllValuesOftrigger(final Transition pTransition) {
      return rawStreamAllValuesOftrigger(new Object[]{pTransition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Triggers.Match tupleToMatch(final Tuple t) {
      try {
          return Triggers.Match.newMatch((Transition) t.get(POSITION_TRANSITION), (Trigger) t.get(POSITION_TRIGGER));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Triggers.Match arrayToMatch(final Object[] match) {
      try {
          return Triggers.Match.newMatch((Transition) match[POSITION_TRANSITION], (Trigger) match[POSITION_TRIGGER]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Triggers.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Triggers.Match.newMutableMatch((Transition) match[POSITION_TRANSITION], (Trigger) match[POSITION_TRIGGER]);
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
    public static IQuerySpecification<Triggers.Matcher> querySpecification() {
      return Triggers.instance();
    }
  }
  
  private Triggers() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Triggers instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Triggers.Matcher instantiate(final ViatraQueryEngine engine) {
    return Triggers.Matcher.on(engine);
  }
  
  @Override
  public Triggers.Matcher instantiate() {
    return Triggers.Matcher.create();
  }
  
  @Override
  public Triggers.Match newEmptyMatch() {
    return Triggers.Match.newEmptyMatch();
  }
  
  @Override
  public Triggers.Match newMatch(final Object... parameters) {
    return Triggers.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition) parameters[0], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Triggers} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Triggers#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Triggers INSTANCE = new Triggers();
    
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
    private static final Triggers.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_transition = new PParameter("transition", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_trigger = new PParameter("trigger", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_transition, parameter_trigger);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.Triggers";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","trigger");
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
          PVariable var_trigger = body.getOrCreateVariableByName("trigger");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_trigger, parameter_trigger)
          ));
          // 	Transition.trigger(transition, trigger)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "trigger")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")));
          new Equality(body, var__virtual_0_, var_trigger);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
