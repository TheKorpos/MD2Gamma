/**
 * Generated from platform:/resource/magicdraw2gamma/src/main/java/hu/bme/mit/magicdraw2gamma/plugin/queries/SearchQueries.vql
 */
package hu.bme.mit.magicdraw2gamma.plugin.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions;
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
 *         pattern MainRegions(statechartDefinition: Class, region: Region){
 *         	find StatechartDefinitions(statechartDefinition, stateMachine);
 *         	StateMachine.region(stateMachine, region);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class MainRegions extends BaseGeneratedEMFQuerySpecification<MainRegions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions pattern,
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
    
    private Region fRegion;
    
    private static List<String> parameterNames = makeImmutableList("statechartDefinition", "region");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      this.fStatechartDefinition = pStatechartDefinition;
      this.fRegion = pRegion;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("statechartDefinition".equals(parameterName)) return this.fStatechartDefinition;
      if ("region".equals(parameterName)) return this.fRegion;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getStatechartDefinition() {
      return this.fStatechartDefinition;
    }
    
    public Region getRegion() {
      return this.fRegion;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("statechartDefinition".equals(parameterName) ) {
          this.fStatechartDefinition = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("region".equals(parameterName) ) {
          this.fRegion = (Region) newValue;
          return true;
      }
      return false;
    }
    
    public void setStatechartDefinition(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStatechartDefinition = pStatechartDefinition;
    }
    
    public void setRegion(final Region pRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRegion = pRegion;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions";
    }
    
    @Override
    public List<String> parameterNames() {
      return MainRegions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStatechartDefinition, fRegion};
    }
    
    @Override
    public MainRegions.Match toImmutable() {
      return isMutable() ? newMatch(fStatechartDefinition, fRegion) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"statechartDefinition\"=" + prettyPrintValue(fStatechartDefinition) + ", ");
      result.append("\"region\"=" + prettyPrintValue(fRegion));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStatechartDefinition, fRegion);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MainRegions.Match)) {
          MainRegions.Match other = (MainRegions.Match) obj;
          return Objects.equals(fStatechartDefinition, other.fStatechartDefinition) && Objects.equals(fRegion, other.fRegion);
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
    public MainRegions specification() {
      return MainRegions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MainRegions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MainRegions.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return new Mutable(pStatechartDefinition, pRegion);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MainRegions.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return new Immutable(pStatechartDefinition, pRegion);
    }
    
    private static final class Mutable extends MainRegions.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
        super(pStatechartDefinition, pRegion);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends MainRegions.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
        super(pStatechartDefinition, pRegion);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern MainRegions(statechartDefinition: Class, region: Region){
   * 	find StatechartDefinitions(statechartDefinition, stateMachine);
   * 	StateMachine.region(stateMachine, region);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MainRegions
   * 
   */
  public static class Matcher extends BaseMatcher<MainRegions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MainRegions.Matcher on(final ViatraQueryEngine engine) {
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
    public static MainRegions.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_STATECHARTDEFINITION = 0;
    
    private final static int POSITION_REGION = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MainRegions.Matcher.class);
    
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
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MainRegions.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return rawStreamAllMatches(new Object[]{pStatechartDefinition, pRegion}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MainRegions.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return rawStreamAllMatches(new Object[]{pStatechartDefinition, pRegion});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MainRegions.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return rawGetOneArbitraryMatch(new Object[]{pStatechartDefinition, pRegion});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return rawHasMatch(new Object[]{pStatechartDefinition, pRegion});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return rawCountMatches(new Object[]{pStatechartDefinition, pRegion});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion, final Consumer<? super MainRegions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStatechartDefinition, pRegion}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStatechartDefinition the fixed value of pattern parameter statechartDefinition, or null if not bound.
     * @param pRegion the fixed value of pattern parameter region, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MainRegions.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition, final Region pRegion) {
      return MainRegions.Match.newMatch(pStatechartDefinition, pRegion);
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstatechartDefinition(final MainRegions.Match partialMatch) {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstatechartDefinition(final Region pRegion) {
      return rawStreamAllValuesOfstatechartDefinition(new Object[]{null, pRegion});
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstatechartDefinition(final MainRegions.Match partialMatch) {
      return rawStreamAllValuesOfstatechartDefinition(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for statechartDefinition.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstatechartDefinition(final Region pRegion) {
      return rawStreamAllValuesOfstatechartDefinition(new Object[]{null, pRegion}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Region> rawStreamAllValuesOfregion(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REGION, parameters).map(Region.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion() {
      return rawStreamAllValuesOfregion(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion() {
      return rawStreamAllValuesOfregion(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion(final MainRegions.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfregion(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      return rawStreamAllValuesOfregion(new Object[]{pStatechartDefinition, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final MainRegions.Match partialMatch) {
      return rawStreamAllValuesOfregion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for region.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfregion(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStatechartDefinition) {
      return rawStreamAllValuesOfregion(new Object[]{pStatechartDefinition, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected MainRegions.Match tupleToMatch(final Tuple t) {
      try {
          return MainRegions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_STATECHARTDEFINITION), (Region) t.get(POSITION_REGION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MainRegions.Match arrayToMatch(final Object[] match) {
      try {
          return MainRegions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATECHARTDEFINITION], (Region) match[POSITION_REGION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MainRegions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MainRegions.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATECHARTDEFINITION], (Region) match[POSITION_REGION]);
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
    public static IQuerySpecification<MainRegions.Matcher> querySpecification() {
      return MainRegions.instance();
    }
  }
  
  private MainRegions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MainRegions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected MainRegions.Matcher instantiate(final ViatraQueryEngine engine) {
    return MainRegions.Matcher.on(engine);
  }
  
  @Override
  public MainRegions.Matcher instantiate() {
    return MainRegions.Matcher.create();
  }
  
  @Override
  public MainRegions.Match newEmptyMatch() {
    return MainRegions.Match.newEmptyMatch();
  }
  
  @Override
  public MainRegions.Match newMatch(final Object... parameters) {
    return MainRegions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions (visibility: PUBLIC, simpleName: MainRegions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions (visibility: PUBLIC, simpleName: MainRegions, identifier: hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.magicdraw2gamma.plugin.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MainRegions INSTANCE = new MainRegions();
    
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
    private final static MainRegions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_statechartDefinition = new PParameter("statechartDefinition", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_region = new PParameter("region", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Region")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_statechartDefinition, parameter_region);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("statechartDefinition","region");
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
          PVariable var_region = body.getOrCreateVariableByName("region");
          PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
          new TypeConstraint(body, Tuples.flatTupleOf(var_statechartDefinition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Region")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_statechartDefinition, parameter_statechartDefinition),
             new ExportedParameter(body, var_region, parameter_region)
          ));
          // 	find StatechartDefinitions(statechartDefinition, stateMachine)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_statechartDefinition, var_stateMachine), StatechartDefinitions.instance().getInternalQueryRepresentation());
          // 	StateMachine.region(stateMachine, region)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StateMachine")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StateMachine", "region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Region")));
          new Equality(body, var__virtual_0_, var_region);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
