/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
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
 *         pattern OwnedTransitions(stmt: StateMachine, transition: Transition){
 *         	find RegionsInStatechart(stmt, region);
 *         	Region.transition(region, transition);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class OwnedTransitions extends BaseGeneratedEMFQuerySpecification<OwnedTransitions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.OwnedTransitions pattern,
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
    private StateMachine fStmt;
    
    private Transition fTransition;
    
    private static List<String> parameterNames = makeImmutableList("stmt", "transition");
    
    private Match(final StateMachine pStmt, final Transition pTransition) {
      this.fStmt = pStmt;
      this.fTransition = pTransition;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("stmt".equals(parameterName)) return this.fStmt;
      if ("transition".equals(parameterName)) return this.fTransition;
      return null;
    }
    
    public StateMachine getStmt() {
      return this.fStmt;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stmt".equals(parameterName) ) {
          this.fStmt = (StateMachine) newValue;
          return true;
      }
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      return false;
    }
    
    public void setStmt(final StateMachine pStmt) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStmt = pStmt;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.OwnedTransitions";
    }
    
    @Override
    public List<String> parameterNames() {
      return OwnedTransitions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStmt, fTransition};
    }
    
    @Override
    public OwnedTransitions.Match toImmutable() {
      return isMutable() ? newMatch(fStmt, fTransition) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stmt\"=" + prettyPrintValue(fStmt) + ", ");
      result.append("\"transition\"=" + prettyPrintValue(fTransition));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStmt, fTransition);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof OwnedTransitions.Match)) {
          OwnedTransitions.Match other = (OwnedTransitions.Match) obj;
          return Objects.equals(fStmt, other.fStmt) && Objects.equals(fTransition, other.fTransition);
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
    public OwnedTransitions specification() {
      return OwnedTransitions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static OwnedTransitions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static OwnedTransitions.Match newMutableMatch(final StateMachine pStmt, final Transition pTransition) {
      return new Mutable(pStmt, pTransition);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static OwnedTransitions.Match newMatch(final StateMachine pStmt, final Transition pTransition) {
      return new Immutable(pStmt, pTransition);
    }
    
    private static final class Mutable extends OwnedTransitions.Match {
      Mutable(final StateMachine pStmt, final Transition pTransition) {
        super(pStmt, pTransition);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends OwnedTransitions.Match {
      Immutable(final StateMachine pStmt, final Transition pTransition) {
        super(pStmt, pTransition);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.OwnedTransitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern OwnedTransitions(stmt: StateMachine, transition: Transition){
   * 	find RegionsInStatechart(stmt, region);
   * 	Region.transition(region, transition);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see OwnedTransitions
   * 
   */
  public static class Matcher extends BaseMatcher<OwnedTransitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static OwnedTransitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static OwnedTransitions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STMT = 0;
    
    private static final int POSITION_TRANSITION = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(OwnedTransitions.Matcher.class);
    
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
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<OwnedTransitions.Match> getAllMatches(final StateMachine pStmt, final Transition pTransition) {
      return rawStreamAllMatches(new Object[]{pStmt, pTransition}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<OwnedTransitions.Match> streamAllMatches(final StateMachine pStmt, final Transition pTransition) {
      return rawStreamAllMatches(new Object[]{pStmt, pTransition});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<OwnedTransitions.Match> getOneArbitraryMatch(final StateMachine pStmt, final Transition pTransition) {
      return rawGetOneArbitraryMatch(new Object[]{pStmt, pTransition});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final StateMachine pStmt, final Transition pTransition) {
      return rawHasMatch(new Object[]{pStmt, pTransition});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final StateMachine pStmt, final Transition pTransition) {
      return rawCountMatches(new Object[]{pStmt, pTransition});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final StateMachine pStmt, final Transition pTransition, final Consumer<? super OwnedTransitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStmt, pTransition}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStmt the fixed value of pattern parameter stmt, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public OwnedTransitions.Match newMatch(final StateMachine pStmt, final Transition pTransition) {
      return OwnedTransitions.Match.newMatch(pStmt, pTransition);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<StateMachine> rawStreamAllValuesOfstmt(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STMT, parameters).map(StateMachine.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstmt() {
      return rawStreamAllValuesOfstmt(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstmt() {
      return rawStreamAllValuesOfstmt(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstmt(final OwnedTransitions.Match partialMatch) {
      return rawStreamAllValuesOfstmt(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<StateMachine> streamAllValuesOfstmt(final Transition pTransition) {
      return rawStreamAllValuesOfstmt(new Object[]{null, pTransition});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstmt(final OwnedTransitions.Match partialMatch) {
      return rawStreamAllValuesOfstmt(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stmt.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<StateMachine> getAllValuesOfstmt(final Transition pTransition) {
      return rawStreamAllValuesOfstmt(new Object[]{null, pTransition}).collect(Collectors.toSet());
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
    public Stream<Transition> streamAllValuesOftransition(final OwnedTransitions.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final StateMachine pStmt) {
      return rawStreamAllValuesOftransition(new Object[]{pStmt, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final OwnedTransitions.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final StateMachine pStmt) {
      return rawStreamAllValuesOftransition(new Object[]{pStmt, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected OwnedTransitions.Match tupleToMatch(final Tuple t) {
      try {
          return OwnedTransitions.Match.newMatch((StateMachine) t.get(POSITION_STMT), (Transition) t.get(POSITION_TRANSITION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected OwnedTransitions.Match arrayToMatch(final Object[] match) {
      try {
          return OwnedTransitions.Match.newMatch((StateMachine) match[POSITION_STMT], (Transition) match[POSITION_TRANSITION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected OwnedTransitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return OwnedTransitions.Match.newMutableMatch((StateMachine) match[POSITION_STMT], (Transition) match[POSITION_TRANSITION]);
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
    public static IQuerySpecification<OwnedTransitions.Matcher> querySpecification() {
      return OwnedTransitions.instance();
    }
  }
  
  private OwnedTransitions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static OwnedTransitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected OwnedTransitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return OwnedTransitions.Matcher.on(engine);
  }
  
  @Override
  public OwnedTransitions.Matcher instantiate() {
    return OwnedTransitions.Matcher.create();
  }
  
  @Override
  public OwnedTransitions.Match newEmptyMatch() {
    return OwnedTransitions.Match.newEmptyMatch();
  }
  
  @Override
  public OwnedTransitions.Match newMatch(final Object... parameters) {
    return OwnedTransitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.OwnedTransitions (visibility: PUBLIC, simpleName: OwnedTransitions, identifier: hu.bme.mit.md2g.transformation.queries.OwnedTransitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.OwnedTransitions (visibility: PUBLIC, simpleName: OwnedTransitions, identifier: hu.bme.mit.md2g.transformation.queries.OwnedTransitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final OwnedTransitions INSTANCE = new OwnedTransitions();
    
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
    private static final OwnedTransitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stmt = new PParameter("stmt", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")), PParameterDirection.INOUT);
    
    private final PParameter parameter_transition = new PParameter("transition", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stmt, parameter_transition);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.OwnedTransitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stmt","transition");
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
          PVariable var_stmt = body.getOrCreateVariableByName("stmt");
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_region = body.getOrCreateVariableByName("region");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stmt), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StateMachine")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stmt, parameter_stmt),
             new ExportedParameter(body, var_transition, parameter_transition)
          ));
          // 	find RegionsInStatechart(stmt, region)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_stmt, var_region), RegionsInStatechart.instance().getInternalQueryRepresentation());
          // 	Region.transition(region, transition)
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          new Equality(body, var__virtual_0_, var_transition);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
