/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/CompositeQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
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
 *         pattern portsOnComponents(component: Class, port: Port, portType: Class){
 *         	Class.ownedAttribute(component, port);
 *         	Port.type(port, portType);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PortsOnComponents extends BaseGeneratedEMFQuerySpecification<PortsOnComponents.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.portsOnComponents pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fComponent;
    
    private Port fPort;
    
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fPortType;
    
    private static List<String> parameterNames = makeImmutableList("component", "port", "portType");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      this.fComponent = pComponent;
      this.fPort = pPort;
      this.fPortType = pPortType;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("component".equals(parameterName)) return this.fComponent;
      if ("port".equals(parameterName)) return this.fPort;
      if ("portType".equals(parameterName)) return this.fPortType;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getComponent() {
      return this.fComponent;
    }
    
    public Port getPort() {
      return this.fPort;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getPortType() {
      return this.fPortType;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("component".equals(parameterName) ) {
          this.fComponent = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("port".equals(parameterName) ) {
          this.fPort = (Port) newValue;
          return true;
      }
      if ("portType".equals(parameterName) ) {
          this.fPortType = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      return false;
    }
    
    public void setComponent(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fComponent = pComponent;
    }
    
    public void setPort(final Port pPort) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPort = pPort;
    }
    
    public void setPortType(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPortType = pPortType;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.portsOnComponents";
    }
    
    @Override
    public List<String> parameterNames() {
      return PortsOnComponents.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fComponent, fPort, fPortType};
    }
    
    @Override
    public PortsOnComponents.Match toImmutable() {
      return isMutable() ? newMatch(fComponent, fPort, fPortType) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
      result.append("\"port\"=" + prettyPrintValue(fPort) + ", ");
      result.append("\"portType\"=" + prettyPrintValue(fPortType));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fComponent, fPort, fPortType);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PortsOnComponents.Match)) {
          PortsOnComponents.Match other = (PortsOnComponents.Match) obj;
          return Objects.equals(fComponent, other.fComponent) && Objects.equals(fPort, other.fPort) && Objects.equals(fPortType, other.fPortType);
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
    public PortsOnComponents specification() {
      return PortsOnComponents.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PortsOnComponents.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PortsOnComponents.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return new Mutable(pComponent, pPort, pPortType);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PortsOnComponents.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return new Immutable(pComponent, pPort, pPortType);
    }
    
    private static final class Mutable extends PortsOnComponents.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
        super(pComponent, pPort, pPortType);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PortsOnComponents.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
        super(pComponent, pPort, pPortType);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.portsOnComponents pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern portsOnComponents(component: Class, port: Port, portType: Class){
   * 	Class.ownedAttribute(component, port);
   * 	Port.type(port, portType);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PortsOnComponents
   * 
   */
  public static class Matcher extends BaseMatcher<PortsOnComponents.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PortsOnComponents.Matcher on(final ViatraQueryEngine engine) {
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
    public static PortsOnComponents.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_COMPONENT = 0;
    
    private static final int POSITION_PORT = 1;
    
    private static final int POSITION_PORTTYPE = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PortsOnComponents.Matcher.class);
    
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
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PortsOnComponents.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllMatches(new Object[]{pComponent, pPort, pPortType}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PortsOnComponents.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllMatches(new Object[]{pComponent, pPort, pPortType});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PortsOnComponents.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawGetOneArbitraryMatch(new Object[]{pComponent, pPort, pPortType});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawHasMatch(new Object[]{pComponent, pPort, pPortType});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawCountMatches(new Object[]{pComponent, pPort, pPortType});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType, final Consumer<? super PortsOnComponents.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pComponent, pPort, pPortType}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pPort the fixed value of pattern parameter port, or null if not bound.
     * @param pPortType the fixed value of pattern parameter portType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PortsOnComponents.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return PortsOnComponents.Match.newMatch(pComponent, pPort, pPortType);
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfcomponent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_COMPONENT, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfcomponent() {
      return rawStreamAllValuesOfcomponent(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfcomponent() {
      return rawStreamAllValuesOfcomponent(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfcomponent(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfcomponent(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfcomponent(final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllValuesOfcomponent(new Object[]{null, pPort, pPortType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfcomponent(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfcomponent(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfcomponent(final Port pPort, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllValuesOfcomponent(new Object[]{null, pPort, pPortType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfport(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PORT, parameters).map(Port.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport() {
      return rawStreamAllValuesOfport(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport() {
      return rawStreamAllValuesOfport(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfport(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllValuesOfport(new Object[]{pComponent, null, pPortType});
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfport(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pPortType) {
      return rawStreamAllValuesOfport(new Object[]{pComponent, null, pPortType}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfportType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PORTTYPE, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfportType() {
      return rawStreamAllValuesOfportType(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfportType() {
      return rawStreamAllValuesOfportType(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfportType(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfportType(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfportType(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort) {
      return rawStreamAllValuesOfportType(new Object[]{pComponent, pPort, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfportType(final PortsOnComponents.Match partialMatch) {
      return rawStreamAllValuesOfportType(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for portType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfportType(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pComponent, final Port pPort) {
      return rawStreamAllValuesOfportType(new Object[]{pComponent, pPort, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PortsOnComponents.Match tupleToMatch(final Tuple t) {
      try {
          return PortsOnComponents.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_COMPONENT), (Port) t.get(POSITION_PORT), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_PORTTYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortsOnComponents.Match arrayToMatch(final Object[] match) {
      try {
          return PortsOnComponents.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_COMPONENT], (Port) match[POSITION_PORT], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PORTTYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortsOnComponents.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PortsOnComponents.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_COMPONENT], (Port) match[POSITION_PORT], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PORTTYPE]);
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
    public static IQuerySpecification<PortsOnComponents.Matcher> querySpecification() {
      return PortsOnComponents.instance();
    }
  }
  
  private PortsOnComponents() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PortsOnComponents instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PortsOnComponents.Matcher instantiate(final ViatraQueryEngine engine) {
    return PortsOnComponents.Matcher.on(engine);
  }
  
  @Override
  public PortsOnComponents.Matcher instantiate() {
    return PortsOnComponents.Matcher.create();
  }
  
  @Override
  public PortsOnComponents.Match newEmptyMatch() {
    return PortsOnComponents.Match.newEmptyMatch();
  }
  
  @Override
  public PortsOnComponents.Match newMatch(final Object... parameters) {
    return PortsOnComponents.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PortsOnComponents (visibility: PUBLIC, simpleName: PortsOnComponents, identifier: hu.bme.mit.md2g.transformation.queries.PortsOnComponents, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PortsOnComponents (visibility: PUBLIC, simpleName: PortsOnComponents, identifier: hu.bme.mit.md2g.transformation.queries.PortsOnComponents, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PortsOnComponents INSTANCE = new PortsOnComponents();
    
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
    private static final PortsOnComponents.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_component = new PParameter("component", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_port = new PParameter("port", "com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")), PParameterDirection.INOUT);
    
    private final PParameter parameter_portType = new PParameter("portType", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_component, parameter_port, parameter_portType);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.portsOnComponents";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("component","port","portType");
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
          PVariable var_component = body.getOrCreateVariableByName("component");
          PVariable var_port = body.getOrCreateVariableByName("port");
          PVariable var_portType = body.getOrCreateVariableByName("portType");
          new TypeConstraint(body, Tuples.flatTupleOf(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_port), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_portType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_component, parameter_component),
             new ExportedParameter(body, var_port, parameter_port),
             new ExportedParameter(body, var_portType, parameter_portType)
          ));
          // 	Class.ownedAttribute(component, port)
          new TypeConstraint(body, Tuples.flatTupleOf(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new Equality(body, var__virtual_0_, var_port);
          // 	Port.type(port, portType)
          new TypeConstraint(body, Tuples.flatTupleOf(var_port), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_port, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "TypedElement", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Type")));
          new Equality(body, var__virtual_1_, var_portType);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
