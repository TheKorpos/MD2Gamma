/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import hu.bme.mit.md2g.transformation.queries.RegionsInStatechart;
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
 *         pattern ChoiceStates(statemachine: StateMachine, pseudoState: Pseudostate){
 *         	find RegionsInStatechart(statemachine, containingRegion);
 *         	Region.subvertex(containingRegion, pseudoState);
 *         	Pseudostate.kind(pseudoState, ::choice);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ChoiceStates extends BaseGeneratedEMFQuerySpecification<ChoiceStates.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.ChoiceStates pattern,
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
    private StateMachine fStatemachine;
    
    private Pseudostate fPseudoState;
    
    private static List<String> parameterNames = makeImmutableList("statemachine", "pseudoState");
    
    private Match(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      this.fStatemachine = pStatemachine;
      this.fPseudoState = pPseudoState;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "statemachine": return this.fStatemachine;
          case "pseudoState": return this.fPseudoState;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fStatemachine;
          case 1: return this.fPseudoState;
          default: return null;
      }
    }
    
    public StateMachine getStatemachine() {
      return this.fStatemachine;
    }
    
    public Pseudostate getPseudoState() {
      return this.fPseudoState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("statemachine".equals(parameterName) ) {
          this.fStatemachine = (StateMachine) newValue;
          return true;
      }
      if ("pseudoState".equals(parameterName) ) {
          this.fPseudoState = (Pseudostate) newValue;
          return true;
      }
      return false;
    }
    
    public void setStatemachine(final StateMachine pStatemachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStatemachine = pStatemachine;
    }
    
    public void setPseudoState(final Pseudostate pPseudoState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPseudoState = pPseudoState;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.ChoiceStates";
    }
    
    @Override
    public List<String> parameterNames() {
      return ChoiceStates.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStatemachine, fPseudoState};
    }
    
    @Override
    public ChoiceStates.Match toImmutable() {
      return isMutable() ? newMatch(fStatemachine, fPseudoState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"statemachine\"=" + prettyPrintValue(fStatemachine) + ", ");
      result.append("\"pseudoState\"=" + prettyPrintValue(fPseudoState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStatemachine, fPseudoState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ChoiceStates.Match)) {
          ChoiceStates.Match other = (ChoiceStates.Match) obj;
          return Objects.equals(fStatemachine, other.fStatemachine) && Objects.equals(fPseudoState, other.fPseudoState);
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
    public ChoiceStates specification() {
      return ChoiceStates.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ChoiceStates.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ChoiceStates.Match newMutableMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return new Mutable(pStatemachine, pPseudoState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ChoiceStates.Match newMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return new Immutable(pStatemachine, pPseudoState);
    }
    
    private static final class Mutable extends ChoiceStates.Match {
      Mutable(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
        super(pStatemachine, pPseudoState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ChoiceStates.Match {
      Immutable(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
        super(pStatemachine, pPseudoState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.ChoiceStates pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern ChoiceStates(statemachine: StateMachine, pseudoState: Pseudostate){
   * 	find RegionsInStatechart(statemachine, containingRegion);
   * 	Region.subvertex(containingRegion, pseudoState);
   * 	Pseudostate.kind(pseudoState, ::choice);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ChoiceStates
   * 
   */
  public static class Matcher extends BaseMatcher<ChoiceStates.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ChoiceStates.Matcher on(final ViatraQueryEngine engine) {
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
    public static ChoiceStates.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_PSEUDOSTATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ChoiceStates.Matcher.class);
    
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
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ChoiceStates.Match> getAllMatches(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return rawStreamAllMatches(new Object[]{pStatemachine, pPseudoState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ChoiceStates.Match> streamAllMatches(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return rawStreamAllMatches(new Object[]{pStatemachine, pPseudoState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ChoiceStates.Match> getOneArbitraryMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return rawGetOneArbitraryMatch(new Object[]{pStatemachine, pPseudoState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return rawHasMatch(new Object[]{pStatemachine, pPseudoState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return rawCountMatches(new Object[]{pStatemachine, pPseudoState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState, final Consumer<? super ChoiceStates.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStatemachine, pPseudoState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatemachine the fixed value of pattern parameter statemachine, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ChoiceStates.Match newMatch(final StateMachine pStatemachine, final Pseudostate pPseudoState) {
      return ChoiceStates.Match.newMatch(pStatemachine, pPseudoState);
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<StateMachine> rawStreamAllValuesOfstatemachine(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATEMACHINE, parameters).map(StateMachine.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstatemachine() {
      return rawStreamAllValuesOfstatemachine(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstatemachine() {
      return rawStreamAllValuesOfstatemachine(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstatemachine(final ChoiceStates.Match partialMatch) {
      return rawStreamAllValuesOfstatemachine(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstatemachine(final Pseudostate pPseudoState) {
      return rawStreamAllValuesOfstatemachine(new Object[]{null, pPseudoState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstatemachine(final ChoiceStates.Match partialMatch) {
      return rawStreamAllValuesOfstatemachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statemachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstatemachine(final Pseudostate pPseudoState) {
      return rawStreamAllValuesOfstatemachine(new Object[]{null, pPseudoState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Pseudostate> rawStreamAllValuesOfpseudoState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PSEUDOSTATE, parameters).map(Pseudostate.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfpseudoState() {
      return rawStreamAllValuesOfpseudoState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfpseudoState() {
      return rawStreamAllValuesOfpseudoState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfpseudoState(final ChoiceStates.Match partialMatch) {
      return rawStreamAllValuesOfpseudoState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Pseudostate> streamAllValuesOfpseudoState(final StateMachine pStatemachine) {
      return rawStreamAllValuesOfpseudoState(new Object[]{pStatemachine, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfpseudoState(final ChoiceStates.Match partialMatch) {
      return rawStreamAllValuesOfpseudoState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfpseudoState(final StateMachine pStatemachine) {
      return rawStreamAllValuesOfpseudoState(new Object[]{pStatemachine, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ChoiceStates.Match tupleToMatch(final Tuple t) {
      try {
          return ChoiceStates.Match.newMatch((StateMachine) t.get(POSITION_STATEMACHINE), (Pseudostate) t.get(POSITION_PSEUDOSTATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChoiceStates.Match arrayToMatch(final Object[] match) {
      try {
          return ChoiceStates.Match.newMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_PSEUDOSTATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ChoiceStates.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ChoiceStates.Match.newMutableMatch((StateMachine) match[POSITION_STATEMACHINE], (Pseudostate) match[POSITION_PSEUDOSTATE]);
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
    public static IQuerySpecification<ChoiceStates.Matcher> querySpecification() {
      return ChoiceStates.instance();
    }
  }
  
  private ChoiceStates() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ChoiceStates instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChoiceStates.Matcher instantiate(final ViatraQueryEngine engine) {
    return ChoiceStates.Matcher.on(engine);
  }
  
  @Override
  public ChoiceStates.Matcher instantiate() {
    return ChoiceStates.Matcher.create();
  }
  
  @Override
  public ChoiceStates.Match newEmptyMatch() {
    return ChoiceStates.Match.newEmptyMatch();
  }
  
  @Override
  public ChoiceStates.Match newMatch(final Object... parameters) {
    return ChoiceStates.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ChoiceStates} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ChoiceStates#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ChoiceStates INSTANCE = new ChoiceStates();
    
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
    private static final ChoiceStates.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_statemachine = new PParameter("statemachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pseudoState = new PParameter("pseudoState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_statemachine, parameter_pseudoState);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.ChoiceStates";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("statemachine","pseudoState");
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
          PVariable var_statemachine = body.getOrCreateVariableByName("statemachine");
          PVariable var_pseudoState = body.getOrCreateVariableByName("pseudoState");
          PVariable var_containingRegion = body.getOrCreateVariableByName("containingRegion");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statemachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_statemachine, parameter_statemachine),
             new ExportedParameter(body, var_pseudoState, parameter_pseudoState)
          ));
          // 	find RegionsInStatechart(statemachine, containingRegion)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_statemachine, var_containingRegion), RegionsInStatechart.instance().getInternalQueryRepresentation());
          // 	Region.subvertex(containingRegion, pseudoState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_pseudoState);
          // 	Pseudostate.kind(pseudoState, ::choice)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum.get("choice"));
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate", "kind")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")));
          new Equality(body, var__virtual_2_, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
