/**
 * Generated from platform:/resource/magicdraw2gamma/src/main/java/hu/bme/mit/magicdraw2gamma/plugin/queries/SearchQueries.vql
 */
package hu.bme.mit.magicdraw2gamma.plugin.queries;

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
 *         pattern StatechartDefinitions(statechartDefinition: Class, stateMachine: StateMachine){
 *         	Class.appliedStereotypeInstance.classifier.name(statechartDefinition, "Block");
 *         	Class.ownedBehavior(statechartDefinition, stateMachine);
 *         	Class.name(statechartDefinition, className);
 *         	StateMachine.name(stateMachine, className);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class StatechartDefinitions extends BaseGeneratedEMFQuerySpecification<StatechartDefinitions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fStatechartDefinition;
    
    private StateMachine fStateMachine;
    
    private static List<String> parameterNames = makeImmutableList("statechartDefinition", "stateMachine");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      this.fStatechartDefinition = pStatechartDefinition;
      this.fStateMachine = pStateMachine;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("statechartDefinition".equals(parameterName)) return this.fStatechartDefinition;
      if ("stateMachine".equals(parameterName)) return this.fStateMachine;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getStatechartDefinition() {
      return this.fStatechartDefinition;
    }
    
    public StateMachine getStateMachine() {
      return this.fStateMachine;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("statechartDefinition".equals(parameterName) ) {
          this.fStatechartDefinition = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (StateMachine) newValue;
          return true;
      }
      return false;
    }
    
    public void setStatechartDefinition(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStatechartDefinition = pStatechartDefinition;
    }
    
    public void setStateMachine(final StateMachine pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions";
    }
    
    @Override
    public List<String> parameterNames() {
      return StatechartDefinitions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStatechartDefinition, fStateMachine};
    }
    
    @Override
    public StatechartDefinitions.Match toImmutable() {
      return isMutable() ? newMatch(fStatechartDefinition, fStateMachine) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"statechartDefinition\"=" + prettyPrintValue(fStatechartDefinition) + ", ");
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStatechartDefinition, fStateMachine);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof StatechartDefinitions.Match)) {
          StatechartDefinitions.Match other = (StatechartDefinitions.Match) obj;
          return Objects.equals(fStatechartDefinition, other.fStatechartDefinition) && Objects.equals(fStateMachine, other.fStateMachine);
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
    public StatechartDefinitions specification() {
      return StatechartDefinitions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static StatechartDefinitions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static StatechartDefinitions.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return new Mutable(pStatechartDefinition, pStateMachine);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static StatechartDefinitions.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return new Immutable(pStatechartDefinition, pStateMachine);
    }
    
    private static final class Mutable extends StatechartDefinitions.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
        super(pStatechartDefinition, pStateMachine);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends StatechartDefinitions.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
        super(pStatechartDefinition, pStateMachine);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern StatechartDefinitions(statechartDefinition: Class, stateMachine: StateMachine){
   * 	Class.appliedStereotypeInstance.classifier.name(statechartDefinition, "Block");
   * 	Class.ownedBehavior(statechartDefinition, stateMachine);
   * 	Class.name(statechartDefinition, className);
   * 	StateMachine.name(stateMachine, className);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see StatechartDefinitions
   * 
   */
  public static class Matcher extends BaseMatcher<StatechartDefinitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static StatechartDefinitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static StatechartDefinitions.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_STATECHARTDEFINITION = 0;
    
    private final static int POSITION_STATEMACHINE = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(StatechartDefinitions.Matcher.class);
    
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
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<StatechartDefinitions.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return rawStreamAllMatches(new Object[]{pStatechartDefinition, pStateMachine}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<StatechartDefinitions.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return rawStreamAllMatches(new Object[]{pStatechartDefinition, pStateMachine});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<StatechartDefinitions.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return rawGetOneArbitraryMatch(new Object[]{pStatechartDefinition, pStateMachine});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return rawHasMatch(new Object[]{pStatechartDefinition, pStateMachine});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return rawCountMatches(new Object[]{pStatechartDefinition, pStateMachine});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine, final Consumer<? super StatechartDefinitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStatechartDefinition, pStateMachine}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public StatechartDefinitions.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final StateMachine pStateMachine) {
      return StatechartDefinitions.Match.newMatch(pStatechartDefinition, pStateMachine);
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfstatechartDefinition(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATECHARTDEFINITION, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstatechartDefinition() {
      return rawStreamAllValuesOfstatechartDefinition(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstatechartDefinition() {
      return rawStreamAllValuesOfstatechartDefinition(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstatechartDefinition(final StatechartDefinitions.Match partialMatch) {
      return rawStreamAllValuesOfstatechartDefinition(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstatechartDefinition(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfstatechartDefinition(new Object[]{null, pStateMachine});
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstatechartDefinition(final StatechartDefinitions.Match partialMatch) {
      return rawStreamAllValuesOfstatechartDefinition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstatechartDefinition(final StateMachine pStateMachine) {
      return rawStreamAllValuesOfstatechartDefinition(new Object[]{null, pStateMachine}).collect(Collectors.toSet());
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final StatechartDefinitions.Match partialMatch) {
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
    public Stream<StateMachine> streamAllValuesOfstateMachine(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      return rawStreamAllValuesOfstateMachine(new Object[]{pStatechartDefinition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final StatechartDefinitions.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstateMachine(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      return rawStreamAllValuesOfstateMachine(new Object[]{pStatechartDefinition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected StatechartDefinitions.Match tupleToMatch(final Tuple t) {
      try {
          return StatechartDefinitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_STATECHARTDEFINITION), (StateMachine) t.get(POSITION_STATEMACHINE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatechartDefinitions.Match arrayToMatch(final Object[] match) {
      try {
          return StatechartDefinitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATECHARTDEFINITION], (StateMachine) match[POSITION_STATEMACHINE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected StatechartDefinitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return StatechartDefinitions.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATECHARTDEFINITION], (StateMachine) match[POSITION_STATEMACHINE]);
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
    public static IQuerySpecification<StatechartDefinitions.Matcher> querySpecification() {
      return StatechartDefinitions.instance();
    }
  }
  
  private StatechartDefinitions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static StatechartDefinitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected StatechartDefinitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return StatechartDefinitions.Matcher.on(engine);
  }
  
  @Override
  public StatechartDefinitions.Matcher instantiate() {
    return StatechartDefinitions.Matcher.create();
  }
  
  @Override
  public StatechartDefinitions.Match newEmptyMatch() {
    return StatechartDefinitions.Match.newEmptyMatch();
  }
  
  @Override
  public StatechartDefinitions.Match newMatch(final Object... parameters) {
    return StatechartDefinitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions (visibility: PUBLIC, simpleName: StatechartDefinitions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions (visibility: PUBLIC, simpleName: StatechartDefinitions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static StatechartDefinitions INSTANCE = new StatechartDefinitions();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StatechartDefinitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_statechartDefinition = new PParameter("statechartDefinition", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "StateMachine")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_statechartDefinition, parameter_stateMachine);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("statechartDefinition","stateMachine");
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
          PVariable var_statechartDefinition = body.getOrCreateVariableByName("statechartDefinition");
          PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
          PVariable var_className = body.getOrCreateVariableByName("className");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StateMachine")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_statechartDefinition, parameter_statechartDefinition),
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine)
          ));
          // 	Class.appliedStereotypeInstance.classifier.name(statechartDefinition, "Block")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Block");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "InstanceSpecification")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Classifier")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_3_, var__virtual_0_);
          // 	Class.ownedBehavior(statechartDefinition, stateMachine)
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "BehavioredClassifier", "ownedBehavior")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Behavior")));
          new Equality(body, var__virtual_4_, var_stateMachine);
          // 	Class.name(statechartDefinition, className)
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_5_, var_className);
          // 	StateMachine.name(stateMachine, className)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StateMachine")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_6_, var_className);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
