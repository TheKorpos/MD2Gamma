/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger;
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
 *         pattern Signals(trigger: Trigger, signal: Signal){
 *         	Trigger.event(trigger, signalEvent);
 *         	SignalEvent.signal(signalEvent, signal);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Signals extends BaseGeneratedEMFQuerySpecification<Signals.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.Signals pattern,
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
    private Trigger fTrigger;
    
    private Signal fSignal;
    
    private static List<String> parameterNames = makeImmutableList("trigger", "signal");
    
    private Match(final Trigger pTrigger, final Signal pSignal) {
      this.fTrigger = pTrigger;
      this.fSignal = pSignal;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "trigger": return this.fTrigger;
          case "signal": return this.fSignal;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTrigger;
          case 1: return this.fSignal;
          default: return null;
      }
    }
    
    public Trigger getTrigger() {
      return this.fTrigger;
    }
    
    public Signal getSignal() {
      return this.fSignal;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("trigger".equals(parameterName) ) {
          this.fTrigger = (Trigger) newValue;
          return true;
      }
      if ("signal".equals(parameterName) ) {
          this.fSignal = (Signal) newValue;
          return true;
      }
      return false;
    }
    
    public void setTrigger(final Trigger pTrigger) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrigger = pTrigger;
    }
    
    public void setSignal(final Signal pSignal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSignal = pSignal;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.Signals";
    }
    
    @Override
    public List<String> parameterNames() {
      return Signals.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fTrigger, fSignal};
    }
    
    @Override
    public Signals.Match toImmutable() {
      return isMutable() ? newMatch(fTrigger, fSignal) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"trigger\"=" + prettyPrintValue(fTrigger) + ", ");
      result.append("\"signal\"=" + prettyPrintValue(fSignal));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fTrigger, fSignal);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Signals.Match)) {
          Signals.Match other = (Signals.Match) obj;
          return Objects.equals(fTrigger, other.fTrigger) && Objects.equals(fSignal, other.fSignal);
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
    public Signals specification() {
      return Signals.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Signals.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Signals.Match newMutableMatch(final Trigger pTrigger, final Signal pSignal) {
      return new Mutable(pTrigger, pSignal);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Signals.Match newMatch(final Trigger pTrigger, final Signal pSignal) {
      return new Immutable(pTrigger, pSignal);
    }
    
    private static final class Mutable extends Signals.Match {
      Mutable(final Trigger pTrigger, final Signal pSignal) {
        super(pTrigger, pSignal);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Signals.Match {
      Immutable(final Trigger pTrigger, final Signal pSignal) {
        super(pTrigger, pSignal);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.Signals pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern Signals(trigger: Trigger, signal: Signal){
   * 	Trigger.event(trigger, signalEvent);
   * 	SignalEvent.signal(signalEvent, signal);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Signals
   * 
   */
  public static class Matcher extends BaseMatcher<Signals.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Signals.Matcher on(final ViatraQueryEngine engine) {
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
    public static Signals.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_TRIGGER = 0;
    
    private static final int POSITION_SIGNAL = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Signals.Matcher.class);
    
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
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Signals.Match> getAllMatches(final Trigger pTrigger, final Signal pSignal) {
      return rawStreamAllMatches(new Object[]{pTrigger, pSignal}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Signals.Match> streamAllMatches(final Trigger pTrigger, final Signal pSignal) {
      return rawStreamAllMatches(new Object[]{pTrigger, pSignal});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Signals.Match> getOneArbitraryMatch(final Trigger pTrigger, final Signal pSignal) {
      return rawGetOneArbitraryMatch(new Object[]{pTrigger, pSignal});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Trigger pTrigger, final Signal pSignal) {
      return rawHasMatch(new Object[]{pTrigger, pSignal});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Trigger pTrigger, final Signal pSignal) {
      return rawCountMatches(new Object[]{pTrigger, pSignal});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Trigger pTrigger, final Signal pSignal, final Consumer<? super Signals.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTrigger, pSignal}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
     * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Signals.Match newMatch(final Trigger pTrigger, final Signal pSignal) {
      return Signals.Match.newMatch(pTrigger, pSignal);
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
    public Stream<Trigger> streamAllValuesOftrigger(final Signals.Match partialMatch) {
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
    public Stream<Trigger> streamAllValuesOftrigger(final Signal pSignal) {
      return rawStreamAllValuesOftrigger(new Object[]{null, pSignal});
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trigger> getAllValuesOftrigger(final Signals.Match partialMatch) {
      return rawStreamAllValuesOftrigger(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for trigger.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Trigger> getAllValuesOftrigger(final Signal pSignal) {
      return rawStreamAllValuesOftrigger(new Object[]{null, pSignal}).collect(Collectors.toSet());
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
    public Stream<Signal> streamAllValuesOfsignal(final Signals.Match partialMatch) {
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
    public Stream<Signal> streamAllValuesOfsignal(final Trigger pTrigger) {
      return rawStreamAllValuesOfsignal(new Object[]{pTrigger, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Signal> getAllValuesOfsignal(final Signals.Match partialMatch) {
      return rawStreamAllValuesOfsignal(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for signal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Signal> getAllValuesOfsignal(final Trigger pTrigger) {
      return rawStreamAllValuesOfsignal(new Object[]{pTrigger, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Signals.Match tupleToMatch(final Tuple t) {
      try {
          return Signals.Match.newMatch((Trigger) t.get(POSITION_TRIGGER), (Signal) t.get(POSITION_SIGNAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Signals.Match arrayToMatch(final Object[] match) {
      try {
          return Signals.Match.newMatch((Trigger) match[POSITION_TRIGGER], (Signal) match[POSITION_SIGNAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Signals.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Signals.Match.newMutableMatch((Trigger) match[POSITION_TRIGGER], (Signal) match[POSITION_SIGNAL]);
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
    public static IQuerySpecification<Signals.Matcher> querySpecification() {
      return Signals.instance();
    }
  }
  
  private Signals() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Signals instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Signals.Matcher instantiate(final ViatraQueryEngine engine) {
    return Signals.Matcher.on(engine);
  }
  
  @Override
  public Signals.Matcher instantiate() {
    return Signals.Matcher.create();
  }
  
  @Override
  public Signals.Match newEmptyMatch() {
    return Signals.Match.newEmptyMatch();
  }
  
  @Override
  public Signals.Match newMatch(final Object... parameters) {
    return Signals.Match.newMatch((com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger) parameters[0], (com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link Signals} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link Signals#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Signals INSTANCE = new Signals();
    
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
    private static final Signals.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_trigger = new PParameter("trigger", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Trigger", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")), PParameterDirection.INOUT);
    
    private final PParameter parameter_signal = new PParameter("signal", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_trigger, parameter_signal);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.Signals";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("trigger","signal");
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
          PVariable var_trigger = body.getOrCreateVariableByName("trigger");
          PVariable var_signal = body.getOrCreateVariableByName("signal");
          PVariable var_signalEvent = body.getOrCreateVariableByName("signalEvent");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_trigger, parameter_trigger),
             new ExportedParameter(body, var_signal, parameter_signal)
          ));
          // 	Trigger.event(trigger, signalEvent)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trigger, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Trigger", "event")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Event")));
          new Equality(body, var__virtual_0_, var_signalEvent);
          // 	SignalEvent.signal(signalEvent, signal)
          new TypeConstraint(body, Tuples.flatTupleOf(var_signalEvent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_signalEvent, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "SignalEvent", "signal")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Signal")));
          new Equality(body, var__virtual_1_, var_signal);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
