/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/CompositeQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         pattern portConnections(end1: Property, end2: Property, connection: Connector){
 *         	Connector.end.partWithPort(connection, end1);
 *         	Connector.end.partWithPort(connection, end2);
 *         	end1 != end2;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PortConnections extends BaseGeneratedEMFQuerySpecification<PortConnections.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.portConnections pattern,
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
    private Property fEnd1;
    
    private Property fEnd2;
    
    private Connector fConnection;
    
    private static List<String> parameterNames = makeImmutableList("end1", "end2", "connection");
    
    private Match(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      this.fEnd1 = pEnd1;
      this.fEnd2 = pEnd2;
      this.fConnection = pConnection;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("end1".equals(parameterName)) return this.fEnd1;
      if ("end2".equals(parameterName)) return this.fEnd2;
      if ("connection".equals(parameterName)) return this.fConnection;
      return null;
    }
    
    public Property getEnd1() {
      return this.fEnd1;
    }
    
    public Property getEnd2() {
      return this.fEnd2;
    }
    
    public Connector getConnection() {
      return this.fConnection;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("end1".equals(parameterName) ) {
          this.fEnd1 = (Property) newValue;
          return true;
      }
      if ("end2".equals(parameterName) ) {
          this.fEnd2 = (Property) newValue;
          return true;
      }
      if ("connection".equals(parameterName) ) {
          this.fConnection = (Connector) newValue;
          return true;
      }
      return false;
    }
    
    public void setEnd1(final Property pEnd1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEnd1 = pEnd1;
    }
    
    public void setEnd2(final Property pEnd2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fEnd2 = pEnd2;
    }
    
    public void setConnection(final Connector pConnection) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fConnection = pConnection;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.portConnections";
    }
    
    @Override
    public List<String> parameterNames() {
      return PortConnections.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fEnd1, fEnd2, fConnection};
    }
    
    @Override
    public PortConnections.Match toImmutable() {
      return isMutable() ? newMatch(fEnd1, fEnd2, fConnection) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"end1\"=" + prettyPrintValue(fEnd1) + ", ");
      result.append("\"end2\"=" + prettyPrintValue(fEnd2) + ", ");
      result.append("\"connection\"=" + prettyPrintValue(fConnection));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fEnd1, fEnd2, fConnection);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PortConnections.Match)) {
          PortConnections.Match other = (PortConnections.Match) obj;
          return Objects.equals(fEnd1, other.fEnd1) && Objects.equals(fEnd2, other.fEnd2) && Objects.equals(fConnection, other.fConnection);
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
    public PortConnections specification() {
      return PortConnections.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PortConnections.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PortConnections.Match newMutableMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return new Mutable(pEnd1, pEnd2, pConnection);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PortConnections.Match newMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return new Immutable(pEnd1, pEnd2, pConnection);
    }
    
    private static final class Mutable extends PortConnections.Match {
      Mutable(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
        super(pEnd1, pEnd2, pConnection);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PortConnections.Match {
      Immutable(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
        super(pEnd1, pEnd2, pConnection);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.portConnections pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern portConnections(end1: Property, end2: Property, connection: Connector){
   * 	Connector.end.partWithPort(connection, end1);
   * 	Connector.end.partWithPort(connection, end2);
   * 	end1 != end2;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PortConnections
   * 
   */
  public static class Matcher extends BaseMatcher<PortConnections.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PortConnections.Matcher on(final ViatraQueryEngine engine) {
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
    public static PortConnections.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_END1 = 0;
    
    private static final int POSITION_END2 = 1;
    
    private static final int POSITION_CONNECTION = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PortConnections.Matcher.class);
    
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
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PortConnections.Match> getAllMatches(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return rawStreamAllMatches(new Object[]{pEnd1, pEnd2, pConnection}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PortConnections.Match> streamAllMatches(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return rawStreamAllMatches(new Object[]{pEnd1, pEnd2, pConnection});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PortConnections.Match> getOneArbitraryMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return rawGetOneArbitraryMatch(new Object[]{pEnd1, pEnd2, pConnection});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return rawHasMatch(new Object[]{pEnd1, pEnd2, pConnection});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return rawCountMatches(new Object[]{pEnd1, pEnd2, pConnection});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection, final Consumer<? super PortConnections.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pEnd1, pEnd2, pConnection}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pEnd1 the fixed value of pattern parameter end1, or null if not bound.
     * @param pEnd2 the fixed value of pattern parameter end2, or null if not bound.
     * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PortConnections.Match newMatch(final Property pEnd1, final Property pEnd2, final Connector pConnection) {
      return PortConnections.Match.newMatch(pEnd1, pEnd2, pConnection);
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfend1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_END1, parameters).map(Property.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend1() {
      return rawStreamAllValuesOfend1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend1() {
      return rawStreamAllValuesOfend1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend1(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfend1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend1(final Property pEnd2, final Connector pConnection) {
      return rawStreamAllValuesOfend1(new Object[]{null, pEnd2, pConnection});
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend1(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfend1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend1(final Property pEnd2, final Connector pConnection) {
      return rawStreamAllValuesOfend1(new Object[]{null, pEnd2, pConnection}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfend2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_END2, parameters).map(Property.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend2() {
      return rawStreamAllValuesOfend2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend2() {
      return rawStreamAllValuesOfend2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend2(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfend2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfend2(final Property pEnd1, final Connector pConnection) {
      return rawStreamAllValuesOfend2(new Object[]{pEnd1, null, pConnection});
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend2(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfend2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for end2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfend2(final Property pEnd1, final Connector pConnection) {
      return rawStreamAllValuesOfend2(new Object[]{pEnd1, null, pConnection}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Connector> rawStreamAllValuesOfconnection(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONNECTION, parameters).map(Connector.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnection() {
      return rawStreamAllValuesOfconnection(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnection() {
      return rawStreamAllValuesOfconnection(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnection(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfconnection(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnection(final Property pEnd1, final Property pEnd2) {
      return rawStreamAllValuesOfconnection(new Object[]{pEnd1, pEnd2, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnection(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfconnection(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connection.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnection(final Property pEnd1, final Property pEnd2) {
      return rawStreamAllValuesOfconnection(new Object[]{pEnd1, pEnd2, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PortConnections.Match tupleToMatch(final Tuple t) {
      try {
          return PortConnections.Match.newMatch((Property) t.get(POSITION_END1), (Property) t.get(POSITION_END2), (Connector) t.get(POSITION_CONNECTION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortConnections.Match arrayToMatch(final Object[] match) {
      try {
          return PortConnections.Match.newMatch((Property) match[POSITION_END1], (Property) match[POSITION_END2], (Connector) match[POSITION_CONNECTION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortConnections.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PortConnections.Match.newMutableMatch((Property) match[POSITION_END1], (Property) match[POSITION_END2], (Connector) match[POSITION_CONNECTION]);
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
    public static IQuerySpecification<PortConnections.Matcher> querySpecification() {
      return PortConnections.instance();
    }
  }
  
  private PortConnections() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PortConnections instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PortConnections.Matcher instantiate(final ViatraQueryEngine engine) {
    return PortConnections.Matcher.on(engine);
  }
  
  @Override
  public PortConnections.Matcher instantiate() {
    return PortConnections.Matcher.create();
  }
  
  @Override
  public PortConnections.Match newEmptyMatch() {
    return PortConnections.Match.newEmptyMatch();
  }
  
  @Override
  public PortConnections.Match newMatch(final Object... parameters) {
    return PortConnections.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[1], (com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PortConnections (visibility: PUBLIC, simpleName: PortConnections, identifier: hu.bme.mit.md2g.transformation.queries.PortConnections, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: hu.bme.mit.md2g.transformation.queries.PortConnections (visibility: PUBLIC, simpleName: PortConnections, identifier: hu.bme.mit.md2g.transformation.queries.PortConnections, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: hu.bme.mit.md2g.transformation.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PortConnections INSTANCE = new PortConnections();
    
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
    private static final PortConnections.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_end1 = new PParameter("end1", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_end2 = new PParameter("end2", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_connection = new PParameter("connection", "com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_end1, parameter_end2, parameter_connection);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.portConnections";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("end1","end2","connection");
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
          PVariable var_end1 = body.getOrCreateVariableByName("end1");
          PVariable var_end2 = body.getOrCreateVariableByName("end2");
          PVariable var_connection = body.getOrCreateVariableByName("connection");
          new TypeConstraint(body, Tuples.flatTupleOf(var_end1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_end2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_connection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_end1, parameter_end1),
             new ExportedParameter(body, var_end2, parameter_end2),
             new ExportedParameter(body, var_connection, parameter_connection)
          ));
          // 	Connector.end.partWithPort(connection, end1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_connection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_connection, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd", "partWithPort")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new Equality(body, var__virtual_1_, var_end1);
          // 	Connector.end.partWithPort(connection, end2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_connection), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_connection, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd", "partWithPort")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          new Equality(body, var__virtual_3_, var_end2);
          // 	end1 != end2
          new Inequality(body, var_end1, var_end2);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
