/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern Actions(action: Behavior, body: java String){
 *         	FunctionBehavior.body(action, body);
 *         } or {
 *         	OpaqueBehavior.body(action, body);
 *         } or {
 *         	//any other
 *         	neg FunctionBehavior(action);
 *         	neg OpaqueBehavior(action);
 *         	Behavior.name(action, body);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class Actions extends BaseGeneratedEMFQuerySpecification<Actions.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.Actions pattern,
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
    private Behavior fAction;
    
    private String fBody;
    
    private static List<String> parameterNames = makeImmutableList("action", "body");
    
    private Match(final Behavior pAction, final String pBody) {
      this.fAction = pAction;
      this.fBody = pBody;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("action".equals(parameterName)) return this.fAction;
      if ("body".equals(parameterName)) return this.fBody;
      return null;
    }
    
    public Behavior getAction() {
      return this.fAction;
    }
    
    public String getBody() {
      return this.fBody;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("action".equals(parameterName) ) {
          this.fAction = (Behavior) newValue;
          return true;
      }
      if ("body".equals(parameterName) ) {
          this.fBody = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setAction(final Behavior pAction) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAction = pAction;
    }
    
    public void setBody(final String pBody) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBody = pBody;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.Actions";
    }
    
    @Override
    public List<String> parameterNames() {
      return Actions.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fAction, fBody};
    }
    
    @Override
    public Actions.Match toImmutable() {
      return isMutable() ? newMatch(fAction, fBody) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"action\"=" + prettyPrintValue(fAction) + ", ");
      result.append("\"body\"=" + prettyPrintValue(fBody));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fAction, fBody);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof Actions.Match)) {
          Actions.Match other = (Actions.Match) obj;
          return Objects.equals(fAction, other.fAction) && Objects.equals(fBody, other.fBody);
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
    public Actions specification() {
      return Actions.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static Actions.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static Actions.Match newMutableMatch(final Behavior pAction, final String pBody) {
      return new Mutable(pAction, pBody);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static Actions.Match newMatch(final Behavior pAction, final String pBody) {
      return new Immutable(pAction, pBody);
    }
    
    private static final class Mutable extends Actions.Match {
      Mutable(final Behavior pAction, final String pBody) {
        super(pAction, pBody);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends Actions.Match {
      Immutable(final Behavior pAction, final String pBody) {
        super(pAction, pBody);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.Actions pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern Actions(action: Behavior, body: java String){
   * 	FunctionBehavior.body(action, body);
   * } or {
   * 	OpaqueBehavior.body(action, body);
   * } or {
   * 	//any other
   * 	neg FunctionBehavior(action);
   * 	neg OpaqueBehavior(action);
   * 	Behavior.name(action, body);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see Actions
   * 
   */
  public static class Matcher extends BaseMatcher<Actions.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static Actions.Matcher on(final ViatraQueryEngine engine) {
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
    public static Actions.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_ACTION = 0;
    
    private static final int POSITION_BODY = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(Actions.Matcher.class);
    
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
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<Actions.Match> getAllMatches(final Behavior pAction, final String pBody) {
      return rawStreamAllMatches(new Object[]{pAction, pBody}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<Actions.Match> streamAllMatches(final Behavior pAction, final String pBody) {
      return rawStreamAllMatches(new Object[]{pAction, pBody});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<Actions.Match> getOneArbitraryMatch(final Behavior pAction, final String pBody) {
      return rawGetOneArbitraryMatch(new Object[]{pAction, pBody});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Behavior pAction, final String pBody) {
      return rawHasMatch(new Object[]{pAction, pBody});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Behavior pAction, final String pBody) {
      return rawCountMatches(new Object[]{pAction, pBody});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Behavior pAction, final String pBody, final Consumer<? super Actions.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAction, pBody}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAction the fixed value of pattern parameter action, or null if not bound.
     * @param pBody the fixed value of pattern parameter body, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public Actions.Match newMatch(final Behavior pAction, final String pBody) {
      return Actions.Match.newMatch(pAction, pBody);
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Behavior> rawStreamAllValuesOfaction(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ACTION, parameters).map(Behavior.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfaction() {
      return rawStreamAllValuesOfaction(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfaction() {
      return rawStreamAllValuesOfaction(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfaction(final Actions.Match partialMatch) {
      return rawStreamAllValuesOfaction(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Behavior> streamAllValuesOfaction(final String pBody) {
      return rawStreamAllValuesOfaction(new Object[]{null, pBody});
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfaction(final Actions.Match partialMatch) {
      return rawStreamAllValuesOfaction(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for action.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Behavior> getAllValuesOfaction(final String pBody) {
      return rawStreamAllValuesOfaction(new Object[]{null, pBody}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfbody(final Actions.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfbody(final Behavior pAction) {
      return rawStreamAllValuesOfbody(new Object[]{pAction, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final Actions.Match partialMatch) {
      return rawStreamAllValuesOfbody(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for body.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfbody(final Behavior pAction) {
      return rawStreamAllValuesOfbody(new Object[]{pAction, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected Actions.Match tupleToMatch(final Tuple t) {
      try {
          return Actions.Match.newMatch((Behavior) t.get(POSITION_ACTION), (String) t.get(POSITION_BODY));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Actions.Match arrayToMatch(final Object[] match) {
      try {
          return Actions.Match.newMatch((Behavior) match[POSITION_ACTION], (String) match[POSITION_BODY]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected Actions.Match arrayToMatchMutable(final Object[] match) {
      try {
          return Actions.Match.newMutableMatch((Behavior) match[POSITION_ACTION], (String) match[POSITION_BODY]);
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
    public static IQuerySpecification<Actions.Matcher> querySpecification() {
      return Actions.instance();
    }
  }
  
  private Actions() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static Actions instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected Actions.Matcher instantiate(final ViatraQueryEngine engine) {
    return Actions.Matcher.on(engine);
  }
  
  @Override
  public Actions.Matcher instantiate() {
    return Actions.Matcher.create();
  }
  
  @Override
  public Actions.Match newEmptyMatch() {
    return Actions.Match.newEmptyMatch();
  }
  
  @Override
  public Actions.Match newMatch(final Object... parameters) {
    return Actions.Match.newMatch((com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.Actions (visibility: PUBLIC, simpleName: Actions, identifier: hu.bme.mit.md2g.transformation.queries.Actions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.Actions (visibility: PUBLIC, simpleName: Actions, identifier: hu.bme.mit.md2g.transformation.queries.Actions, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final Actions INSTANCE = new Actions();
    
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
    private static final Actions.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_action = new PParameter("action", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.Behavior", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")), PParameterDirection.INOUT);
    
    private final PParameter parameter_body = new PParameter("body", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_action, parameter_body);
    
    private class Embedded_1_FunctionBehavior extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.FunctionBehavior", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "FunctionBehavior")), PParameterDirection.INOUT);
      
      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0);
      
      public Embedded_1_FunctionBehavior() {
        super(PVisibility.EMBEDDED);
      }
      
      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_2_FunctionBehavior";
      }
      
      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }
      
      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0)
        ));
        //  FunctionBehavior(action)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "FunctionBehavior")));
        return Collections.singleton(body);
      }
    }
    
    private class Embedded_2_OpaqueBehavior extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueBehavior")), PParameterDirection.INOUT);
      
      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0);
      
      public Embedded_2_OpaqueBehavior() {
        super(PVisibility.EMBEDDED);
      }
      
      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_2_OpaqueBehavior";
      }
      
      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }
      
      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0)
        ));
        //  OpaqueBehavior(action)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueBehavior")));
        return Collections.singleton(body);
      }
    }
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.Actions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("action","body");
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
          PVariable var_action = body.getOrCreateVariableByName("action");
          PVariable var_body = body.getOrCreateVariableByName("body");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_action, parameter_action),
             new ExportedParameter(body, var_body, parameter_body)
          ));
          // 	FunctionBehavior.body(action, body)
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "FunctionBehavior")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueBehavior", "body")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_0_, var_body);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_action = body.getOrCreateVariableByName("action");
          PVariable var_body = body.getOrCreateVariableByName("body");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_action, parameter_action),
             new ExportedParameter(body, var_body, parameter_body)
          ));
          // 	OpaqueBehavior.body(action, body)
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueBehavior")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "OpaqueBehavior", "body")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_0_, var_body);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_action = body.getOrCreateVariableByName("action");
          PVariable var_body = body.getOrCreateVariableByName("body");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_body), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_action, parameter_action),
             new ExportedParameter(body, var_body, parameter_body)
          ));
          // 	//any other	neg FunctionBehavior(action)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_action), new Actions.GeneratedPQuery.Embedded_1_FunctionBehavior());
          // 	neg OpaqueBehavior(action)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_action), new Actions.GeneratedPQuery.Embedded_2_OpaqueBehavior());
          // 	Behavior.name(action, body)
          new TypeConstraint(body, Tuples.flatTupleOf(var_action), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Behavior")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_action, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_0_, var_body);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
