/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
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
 *         pattern Transitions(source: Vertex, transition: Transition, target: Vertex){
 *         	Transition.source(transition, source);
 *         	Transition.target(transition, target);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Transitions extends BaseGeneratedEMFQuerySpecification<Transitions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.Transitions pattern,
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
    private Vertex fSource;
    
    private Transition fTransition;
    
    private Vertex fTarget;
    
    private static List<String> parameterNames = makeImmutableList("source", "transition", "target");
    
    private Match(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      this.fSource = pSource;
      this.fTransition = pTransition;
      this.fTarget = pTarget;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("source".equals(parameterName)) return this.fSource;
      if ("transition".equals(parameterName)) return this.fTransition;
      if ("target".equals(parameterName)) return this.fTarget;
      return null;
    }
    
    public Vertex getSource() {
      return this.fSource;
    }
    
    public Transition getTransition() {
      return this.fTransition;
    }
    
    public Vertex getTarget() {
      return this.fTarget;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("source".equals(parameterName) ) {
          this.fSource = (Vertex) newValue;
          return true;
      }
      if ("transition".equals(parameterName) ) {
          this.fTransition = (Transition) newValue;
          return true;
      }
      if ("target".equals(parameterName) ) {
          this.fTarget = (Vertex) newValue;
          return true;
      }
      return false;
    }
    
    public void setSource(final Vertex pSource) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSource = pSource;
    }
    
    public void setTransition(final Transition pTransition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTransition = pTransition;
    }
    
    public void setTarget(final Vertex pTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTarget = pTarget;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.Transitions";
    }
    
    @Override
    public List<String> parameterNames() {
      return Transitions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSource, fTransition, fTarget};
    }
    
    @Override
    public Transitions.Match toImmutable() {
      return isMutable() ? newMatch(fSource, fTransition, fTarget) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
      result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
      result.append("\"target\"=" + prettyPrintValue(fTarget));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSource, fTransition, fTarget);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Transitions.Match)) {
          Transitions.Match other = (Transitions.Match) obj;
          return Objects.equals(fSource, other.fSource) && Objects.equals(fTransition, other.fTransition) && Objects.equals(fTarget, other.fTarget);
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
    public Transitions specification() {
      return Transitions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Transitions.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Transitions.Match newMutableMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return new Mutable(pSource, pTransition, pTarget);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Transitions.Match newMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return new Immutable(pSource, pTransition, pTarget);
    }
    
    private static final class Mutable extends Transitions.Match {
      Mutable(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
        super(pSource, pTransition, pTarget);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Transitions.Match {
      Immutable(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
        super(pSource, pTransition, pTarget);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.Transitions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern Transitions(source: Vertex, transition: Transition, target: Vertex){
   * 	Transition.source(transition, source);
   * 	Transition.target(transition, target);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Transitions
   * 
   */
  public static class Matcher extends BaseMatcher<Transitions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Transitions.Matcher on(final ViatraQueryEngine engine) {
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
    public static Transitions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SOURCE = 0;
    
    private static final int POSITION_TRANSITION = 1;
    
    private static final int POSITION_TARGET = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Transitions.Matcher.class);
    
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
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Transitions.Match> getAllMatches(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return rawStreamAllMatches(new Object[]{pSource, pTransition, pTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Transitions.Match> streamAllMatches(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return rawStreamAllMatches(new Object[]{pSource, pTransition, pTarget});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Transitions.Match> getOneArbitraryMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pSource, pTransition, pTarget});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return rawHasMatch(new Object[]{pSource, pTransition, pTarget});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return rawCountMatches(new Object[]{pSource, pTransition, pTarget});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget, final Consumer<? super Transitions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSource, pTransition, pTarget}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Transitions.Match newMatch(final Vertex pSource, final Transition pTransition, final Vertex pTarget) {
      return Transitions.Match.newMatch(pSource, pTransition, pTarget);
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vertex> rawStreamAllValuesOfsource(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCE, parameters).map(Vertex.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsource(final Transitions.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsource(final Transition pTransition, final Vertex pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{null, pTransition, pTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsource(final Transitions.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsource(final Transition pTransition, final Vertex pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{null, pTransition, pTarget}).collect(Collectors.toSet());
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
    public Stream<Transition> streamAllValuesOftransition(final Transitions.Match partialMatch) {
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
    public Stream<Transition> streamAllValuesOftransition(final Vertex pSource, final Vertex pTarget) {
      return rawStreamAllValuesOftransition(new Object[]{pSource, null, pTarget});
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final Transitions.Match partialMatch) {
      return rawStreamAllValuesOftransition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for transition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Transition> getAllValuesOftransition(final Vertex pSource, final Vertex pTarget) {
      return rawStreamAllValuesOftransition(new Object[]{pSource, null, pTarget}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vertex> rawStreamAllValuesOftarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGET, parameters).map(Vertex.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftarget(final Transitions.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftarget(final Vertex pSource, final Transition pTransition) {
      return rawStreamAllValuesOftarget(new Object[]{pSource, pTransition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftarget(final Transitions.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftarget(final Vertex pSource, final Transition pTransition) {
      return rawStreamAllValuesOftarget(new Object[]{pSource, pTransition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Transitions.Match tupleToMatch(final Tuple t) {
      try {
          return Transitions.Match.newMatch((Vertex) t.get(POSITION_SOURCE), (Transition) t.get(POSITION_TRANSITION), (Vertex) t.get(POSITION_TARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Transitions.Match arrayToMatch(final Object[] match) {
      try {
          return Transitions.Match.newMatch((Vertex) match[POSITION_SOURCE], (Transition) match[POSITION_TRANSITION], (Vertex) match[POSITION_TARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Transitions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Transitions.Match.newMutableMatch((Vertex) match[POSITION_SOURCE], (Transition) match[POSITION_TRANSITION], (Vertex) match[POSITION_TARGET]);
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
    public static IQuerySpecification<Transitions.Matcher> querySpecification() {
      return Transitions.instance();
    }
  }
  
  private Transitions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Transitions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Transitions.Matcher instantiate(final ViatraQueryEngine engine) {
    return Transitions.Matcher.on(engine);
  }
  
  @Override
  public Transitions.Matcher instantiate() {
    return Transitions.Matcher.create();
  }
  
  @Override
  public Transitions.Match newEmptyMatch() {
    return Transitions.Match.newEmptyMatch();
  }
  
  @Override
  public Transitions.Match newMatch(final Object... parameters) {
    return Transitions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition) parameters[1], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.Transitions (visibility: PUBLIC, simpleName: Transitions, identifier: hu.bme.mit.md2g.transformation.queries.Transitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.Transitions (visibility: PUBLIC, simpleName: Transitions, identifier: hu.bme.mit.md2g.transformation.queries.Transitions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Transitions INSTANCE = new Transitions();
    
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
    private static final Transitions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_source = new PParameter("source", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")), PParameterDirection.INOUT);
    
    private final PParameter parameter_transition = new PParameter("transition", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")), PParameterDirection.INOUT);
    
    private final PParameter parameter_target = new PParameter("target", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_source, parameter_transition, parameter_target);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.Transitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("source","transition","target");
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
          PVariable var_source = body.getOrCreateVariableByName("source");
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          PVariable var_target = body.getOrCreateVariableByName("target");
          new TypeConstraint(body, Tuples.flatTupleOf(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_source, parameter_source),
             new ExportedParameter(body, var_transition, parameter_transition),
             new ExportedParameter(body, var_target, parameter_target)
          ));
          // 	Transition.source(transition, source)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_source);
          // 	Transition.target(transition, target)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_1_, var_target);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
