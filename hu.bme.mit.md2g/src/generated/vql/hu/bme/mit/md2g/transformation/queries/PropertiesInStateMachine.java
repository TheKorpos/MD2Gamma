/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
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
 *         pattern PropertiesInStateMachine(stateMachine: Class, prop: Property){
 *         	Class.ownedAttribute(stateMachine, prop);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PropertiesInStateMachine extends BaseGeneratedEMFQuerySpecification<PropertiesInStateMachine.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fStateMachine;
    
    private Property fProp;
    
    private static List<String> parameterNames = makeImmutableList("stateMachine", "prop");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      this.fStateMachine = pStateMachine;
      this.fProp = pProp;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("stateMachine".equals(parameterName)) return this.fStateMachine;
      if ("prop".equals(parameterName)) return this.fProp;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getStateMachine() {
      return this.fStateMachine;
    }
    
    public Property getProp() {
      return this.fProp;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("stateMachine".equals(parameterName) ) {
          this.fStateMachine = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("prop".equals(parameterName) ) {
          this.fProp = (Property) newValue;
          return true;
      }
      return false;
    }
    
    public void setStateMachine(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fStateMachine = pStateMachine;
    }
    
    public void setProp(final Property pProp) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fProp = pProp;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine";
    }
    
    @Override
    public List<String> parameterNames() {
      return PropertiesInStateMachine.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fStateMachine, fProp};
    }
    
    @Override
    public PropertiesInStateMachine.Match toImmutable() {
      return isMutable() ? newMatch(fStateMachine, fProp) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"stateMachine\"=" + prettyPrintValue(fStateMachine) + ", ");
      result.append("\"prop\"=" + prettyPrintValue(fProp));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fStateMachine, fProp);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PropertiesInStateMachine.Match)) {
          PropertiesInStateMachine.Match other = (PropertiesInStateMachine.Match) obj;
          return Objects.equals(fStateMachine, other.fStateMachine) && Objects.equals(fProp, other.fProp);
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
    public PropertiesInStateMachine specification() {
      return PropertiesInStateMachine.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PropertiesInStateMachine.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PropertiesInStateMachine.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return new Mutable(pStateMachine, pProp);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PropertiesInStateMachine.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return new Immutable(pStateMachine, pProp);
    }
    
    private static final class Mutable extends PropertiesInStateMachine.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
        super(pStateMachine, pProp);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PropertiesInStateMachine.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
        super(pStateMachine, pProp);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern PropertiesInStateMachine(stateMachine: Class, prop: Property){
   * 	Class.ownedAttribute(stateMachine, prop);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PropertiesInStateMachine
   * 
   */
  public static class Matcher extends BaseMatcher<PropertiesInStateMachine.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PropertiesInStateMachine.Matcher on(final ViatraQueryEngine engine) {
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
    public static PropertiesInStateMachine.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_STATEMACHINE = 0;
    
    private static final int POSITION_PROP = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PropertiesInStateMachine.Matcher.class);
    
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
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PropertiesInStateMachine.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pProp}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PropertiesInStateMachine.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return rawStreamAllMatches(new Object[]{pStateMachine, pProp});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PropertiesInStateMachine.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return rawGetOneArbitraryMatch(new Object[]{pStateMachine, pProp});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return rawHasMatch(new Object[]{pStateMachine, pProp});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return rawCountMatches(new Object[]{pStateMachine, pProp});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp, final Consumer<? super PropertiesInStateMachine.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pStateMachine, pProp}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pStateMachine the fixed value of pattern parameter stateMachine, or null if not bound.
     * @param pProp the fixed value of pattern parameter prop, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PropertiesInStateMachine.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine, final Property pProp) {
      return PropertiesInStateMachine.Match.newMatch(pStateMachine, pProp);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfstateMachine(final Object[] parameters) {
      return rawStreamAllValues(POSITION_STATEMACHINE, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstateMachine() {
      return rawStreamAllValuesOfstateMachine(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstateMachine() {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstateMachine(final PropertiesInStateMachine.Match partialMatch) {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfstateMachine(final Property pProp) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pProp});
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstateMachine(final PropertiesInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfstateMachine(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for stateMachine.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfstateMachine(final Property pProp) {
      return rawStreamAllValuesOfstateMachine(new Object[]{null, pProp}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfprop(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PROP, parameters).map(Property.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfprop() {
      return rawStreamAllValuesOfprop(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfprop() {
      return rawStreamAllValuesOfprop(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfprop(final PropertiesInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfprop(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfprop(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine) {
      return rawStreamAllValuesOfprop(new Object[]{pStateMachine, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfprop(final PropertiesInStateMachine.Match partialMatch) {
      return rawStreamAllValuesOfprop(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for prop.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfprop(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pStateMachine) {
      return rawStreamAllValuesOfprop(new Object[]{pStateMachine, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PropertiesInStateMachine.Match tupleToMatch(final Tuple t) {
      try {
          return PropertiesInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_STATEMACHINE), (Property) t.get(POSITION_PROP));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PropertiesInStateMachine.Match arrayToMatch(final Object[] match) {
      try {
          return PropertiesInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATEMACHINE], (Property) match[POSITION_PROP]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PropertiesInStateMachine.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PropertiesInStateMachine.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_STATEMACHINE], (Property) match[POSITION_PROP]);
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
    public static IQuerySpecification<PropertiesInStateMachine.Matcher> querySpecification() {
      return PropertiesInStateMachine.instance();
    }
  }
  
  private PropertiesInStateMachine() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PropertiesInStateMachine instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertiesInStateMachine.Matcher instantiate(final ViatraQueryEngine engine) {
    return PropertiesInStateMachine.Matcher.on(engine);
  }
  
  @Override
  public PropertiesInStateMachine.Matcher instantiate() {
    return PropertiesInStateMachine.Matcher.create();
  }
  
  @Override
  public PropertiesInStateMachine.Match newEmptyMatch() {
    return PropertiesInStateMachine.Match.newEmptyMatch();
  }
  
  @Override
  public PropertiesInStateMachine.Match newMatch(final Object... parameters) {
    return PropertiesInStateMachine.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine (visibility: PUBLIC, simpleName: PropertiesInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine (visibility: PUBLIC, simpleName: PropertiesInStateMachine, identifier: hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PropertiesInStateMachine INSTANCE = new PropertiesInStateMachine();
    
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
    private static final PropertiesInStateMachine.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_stateMachine = new PParameter("stateMachine", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_prop = new PParameter("prop", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_stateMachine, parameter_prop);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.PropertiesInStateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","prop");
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
          PVariable var_prop = body.getOrCreateVariableByName("prop");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_prop), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_stateMachine, parameter_stateMachine),
             new ExportedParameter(body, var_prop, parameter_prop)
          ));
          // 	Class.ownedAttribute(stateMachine, prop)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stateMachine, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new Equality(body, var__virtual_0_, var_prop);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
