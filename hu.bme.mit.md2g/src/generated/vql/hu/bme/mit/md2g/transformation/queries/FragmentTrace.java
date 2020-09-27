/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/TraceQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         pattern fragmentTrace(uriFragment: java String, elemnet: NamedElement){
 *         	Property.name(attr, uriFragment);
 *         	Class.ownedAttribute(c, attr);
 *         	Class.appliedStereotypeInstance(c, stereotypeInstance);
 *         	InstanceSpecification.classifier.name(stereotypeInstance, "GammaModel");
 *         	
 *         	Abstraction.client(dep, attr);
 *         	Abstraction.supplier(dep, elemnet);
 *         	Abstraction.appliedStereotypeInstance.classifier.name(dep, "Trace");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class FragmentTrace extends BaseGeneratedEMFQuerySpecification<FragmentTrace.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.fragmentTrace pattern,
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
    private String fUriFragment;
    
    private NamedElement fElemnet;
    
    private static List<String> parameterNames = makeImmutableList("uriFragment", "elemnet");
    
    private Match(final String pUriFragment, final NamedElement pElemnet) {
      this.fUriFragment = pUriFragment;
      this.fElemnet = pElemnet;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "uriFragment": return this.fUriFragment;
          case "elemnet": return this.fElemnet;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUriFragment;
          case 1: return this.fElemnet;
          default: return null;
      }
    }
    
    public String getUriFragment() {
      return this.fUriFragment;
    }
    
    public NamedElement getElemnet() {
      return this.fElemnet;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("uriFragment".equals(parameterName) ) {
          this.fUriFragment = (String) newValue;
          return true;
      }
      if ("elemnet".equals(parameterName) ) {
          this.fElemnet = (NamedElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setUriFragment(final String pUriFragment) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUriFragment = pUriFragment;
    }
    
    public void setElemnet(final NamedElement pElemnet) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElemnet = pElemnet;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.fragmentTrace";
    }
    
    @Override
    public List<String> parameterNames() {
      return FragmentTrace.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fUriFragment, fElemnet};
    }
    
    @Override
    public FragmentTrace.Match toImmutable() {
      return isMutable() ? newMatch(fUriFragment, fElemnet) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"uriFragment\"=" + prettyPrintValue(fUriFragment) + ", ");
      result.append("\"elemnet\"=" + prettyPrintValue(fElemnet));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fUriFragment, fElemnet);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof FragmentTrace.Match)) {
          FragmentTrace.Match other = (FragmentTrace.Match) obj;
          return Objects.equals(fUriFragment, other.fUriFragment) && Objects.equals(fElemnet, other.fElemnet);
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
    public FragmentTrace specification() {
      return FragmentTrace.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static FragmentTrace.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static FragmentTrace.Match newMutableMatch(final String pUriFragment, final NamedElement pElemnet) {
      return new Mutable(pUriFragment, pElemnet);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static FragmentTrace.Match newMatch(final String pUriFragment, final NamedElement pElemnet) {
      return new Immutable(pUriFragment, pElemnet);
    }
    
    private static final class Mutable extends FragmentTrace.Match {
      Mutable(final String pUriFragment, final NamedElement pElemnet) {
        super(pUriFragment, pElemnet);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends FragmentTrace.Match {
      Immutable(final String pUriFragment, final NamedElement pElemnet) {
        super(pUriFragment, pElemnet);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.fragmentTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern fragmentTrace(uriFragment: java String, elemnet: NamedElement){
   * 	Property.name(attr, uriFragment);
   * 	Class.ownedAttribute(c, attr);
   * 	Class.appliedStereotypeInstance(c, stereotypeInstance);
   * 	InstanceSpecification.classifier.name(stereotypeInstance, "GammaModel");
   * 	
   * 	Abstraction.client(dep, attr);
   * 	Abstraction.supplier(dep, elemnet);
   * 	Abstraction.appliedStereotypeInstance.classifier.name(dep, "Trace");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see FragmentTrace
   * 
   */
  public static class Matcher extends BaseMatcher<FragmentTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static FragmentTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static FragmentTrace.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_URIFRAGMENT = 0;
    
    private static final int POSITION_ELEMNET = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FragmentTrace.Matcher.class);
    
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
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<FragmentTrace.Match> getAllMatches(final String pUriFragment, final NamedElement pElemnet) {
      return rawStreamAllMatches(new Object[]{pUriFragment, pElemnet}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<FragmentTrace.Match> streamAllMatches(final String pUriFragment, final NamedElement pElemnet) {
      return rawStreamAllMatches(new Object[]{pUriFragment, pElemnet});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<FragmentTrace.Match> getOneArbitraryMatch(final String pUriFragment, final NamedElement pElemnet) {
      return rawGetOneArbitraryMatch(new Object[]{pUriFragment, pElemnet});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final String pUriFragment, final NamedElement pElemnet) {
      return rawHasMatch(new Object[]{pUriFragment, pElemnet});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final String pUriFragment, final NamedElement pElemnet) {
      return rawCountMatches(new Object[]{pUriFragment, pElemnet});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final String pUriFragment, final NamedElement pElemnet, final Consumer<? super FragmentTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUriFragment, pElemnet}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUriFragment the fixed value of pattern parameter uriFragment, or null if not bound.
     * @param pElemnet the fixed value of pattern parameter elemnet, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public FragmentTrace.Match newMatch(final String pUriFragment, final NamedElement pElemnet) {
      return FragmentTrace.Match.newMatch(pUriFragment, pElemnet);
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfuriFragment(final Object[] parameters) {
      return rawStreamAllValues(POSITION_URIFRAGMENT, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfuriFragment() {
      return rawStreamAllValuesOfuriFragment(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfuriFragment() {
      return rawStreamAllValuesOfuriFragment(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfuriFragment(final FragmentTrace.Match partialMatch) {
      return rawStreamAllValuesOfuriFragment(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfuriFragment(final NamedElement pElemnet) {
      return rawStreamAllValuesOfuriFragment(new Object[]{null, pElemnet});
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfuriFragment(final FragmentTrace.Match partialMatch) {
      return rawStreamAllValuesOfuriFragment(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for uriFragment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfuriFragment(final NamedElement pElemnet) {
      return rawStreamAllValuesOfuriFragment(new Object[]{null, pElemnet}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElement> rawStreamAllValuesOfelemnet(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEMNET, parameters).map(NamedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelemnet() {
      return rawStreamAllValuesOfelemnet(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelemnet() {
      return rawStreamAllValuesOfelemnet(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelemnet(final FragmentTrace.Match partialMatch) {
      return rawStreamAllValuesOfelemnet(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelemnet(final String pUriFragment) {
      return rawStreamAllValuesOfelemnet(new Object[]{pUriFragment, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelemnet(final FragmentTrace.Match partialMatch) {
      return rawStreamAllValuesOfelemnet(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elemnet.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelemnet(final String pUriFragment) {
      return rawStreamAllValuesOfelemnet(new Object[]{pUriFragment, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected FragmentTrace.Match tupleToMatch(final Tuple t) {
      try {
          return FragmentTrace.Match.newMatch((String) t.get(POSITION_URIFRAGMENT), (NamedElement) t.get(POSITION_ELEMNET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected FragmentTrace.Match arrayToMatch(final Object[] match) {
      try {
          return FragmentTrace.Match.newMatch((String) match[POSITION_URIFRAGMENT], (NamedElement) match[POSITION_ELEMNET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected FragmentTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return FragmentTrace.Match.newMutableMatch((String) match[POSITION_URIFRAGMENT], (NamedElement) match[POSITION_ELEMNET]);
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
    public static IQuerySpecification<FragmentTrace.Matcher> querySpecification() {
      return FragmentTrace.instance();
    }
  }
  
  private FragmentTrace() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static FragmentTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected FragmentTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return FragmentTrace.Matcher.on(engine);
  }
  
  @Override
  public FragmentTrace.Matcher instantiate() {
    return FragmentTrace.Matcher.create();
  }
  
  @Override
  public FragmentTrace.Match newEmptyMatch() {
    return FragmentTrace.Match.newEmptyMatch();
  }
  
  @Override
  public FragmentTrace.Match newMatch(final Object... parameters) {
    return FragmentTrace.Match.newMatch((java.lang.String) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link FragmentTrace} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link FragmentTrace#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final FragmentTrace INSTANCE = new FragmentTrace();
    
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
    private static final FragmentTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_uriFragment = new PParameter("uriFragment", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_elemnet = new PParameter("elemnet", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_uriFragment, parameter_elemnet);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.fragmentTrace";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("uriFragment","elemnet");
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
          PVariable var_uriFragment = body.getOrCreateVariableByName("uriFragment");
          PVariable var_elemnet = body.getOrCreateVariableByName("elemnet");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var_c = body.getOrCreateVariableByName("c");
          PVariable var_stereotypeInstance = body.getOrCreateVariableByName("stereotypeInstance");
          PVariable var_dep = body.getOrCreateVariableByName("dep");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_uriFragment), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_elemnet), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_uriFragment, parameter_uriFragment),
             new ExportedParameter(body, var_elemnet, parameter_elemnet)
          ));
          // 	Property.name(attr, uriFragment)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_0_, var_uriFragment);
          // 	Class.ownedAttribute(c, attr)
          new TypeConstraint(body, Tuples.flatTupleOf(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_c, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new Equality(body, var__virtual_1_, var_attr);
          // 	Class.appliedStereotypeInstance(c, stereotypeInstance)
          new TypeConstraint(body, Tuples.flatTupleOf(var_c), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_c, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          new Equality(body, var__virtual_2_, var_stereotypeInstance);
          // 	InstanceSpecification.classifier.name(stereotypeInstance, "GammaModel")
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new ConstantValue(body, var__virtual_3_, "GammaModel");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotypeInstance), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotypeInstance, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_5_, var__virtual_3_);
          // 		Abstraction.client(dep, attr)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Abstraction")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency", "client")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          new Equality(body, var__virtual_6_, var_attr);
          // 	Abstraction.supplier(dep, elemnet)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Abstraction")));
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency", "supplier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_7_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          new Equality(body, var__virtual_7_, var_elemnet);
          // 	Abstraction.appliedStereotypeInstance.classifier.name(dep, "Trace")
          PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
          new ConstantValue(body, var__virtual_8_, "Trace");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Abstraction")));
          PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_9_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_9_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          PVariable var__virtual_10_ = body.getOrCreateVariableByName(".virtual{10}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_9_, var__virtual_10_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_10_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          PVariable var__virtual_11_ = body.getOrCreateVariableByName(".virtual{11}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_10_, var__virtual_11_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_11_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_11_, var__virtual_8_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
