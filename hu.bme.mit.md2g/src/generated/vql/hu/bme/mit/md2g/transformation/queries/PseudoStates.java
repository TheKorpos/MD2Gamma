/**
 * Generated from platform:/resource/hu.bme.mit.md2g/src/main/java/hu/bme/mit/md2g/transformation/queries/StatechartQueries.vql
 */
package hu.bme.mit.md2g.transformation.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
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
 *         pattern PseudoStates(containingRegion: Region, pseudoState: Pseudostate, kind: PseudostateKind){
 *         	Region.subvertex(containingRegion, pseudoState);
 *         	Pseudostate.kind(pseudoState, kind);
 *         
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PseudoStates extends BaseGeneratedEMFQuerySpecification<PseudoStates.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.md2g.transformation.queries.PseudoStates pattern,
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
    private Region fContainingRegion;
    
    private Pseudostate fPseudoState;
    
    private PseudostateKind fKind;
    
    private static List<String> parameterNames = makeImmutableList("containingRegion", "pseudoState", "kind");
    
    private Match(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      this.fContainingRegion = pContainingRegion;
      this.fPseudoState = pPseudoState;
      this.fKind = pKind;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "containingRegion": return this.fContainingRegion;
          case "pseudoState": return this.fPseudoState;
          case "kind": return this.fKind;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fContainingRegion;
          case 1: return this.fPseudoState;
          case 2: return this.fKind;
          default: return null;
      }
    }
    
    public Region getContainingRegion() {
      return this.fContainingRegion;
    }
    
    public Pseudostate getPseudoState() {
      return this.fPseudoState;
    }
    
    public PseudostateKind getKind() {
      return this.fKind;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("containingRegion".equals(parameterName) ) {
          this.fContainingRegion = (Region) newValue;
          return true;
      }
      if ("pseudoState".equals(parameterName) ) {
          this.fPseudoState = (Pseudostate) newValue;
          return true;
      }
      if ("kind".equals(parameterName) ) {
          this.fKind = (PseudostateKind) newValue;
          return true;
      }
      return false;
    }
    
    public void setContainingRegion(final Region pContainingRegion) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fContainingRegion = pContainingRegion;
    }
    
    public void setPseudoState(final Pseudostate pPseudoState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPseudoState = pPseudoState;
    }
    
    public void setKind(final PseudostateKind pKind) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fKind = pKind;
    }
    
    @Override
    public String patternName() {
      return "hu.bme.mit.md2g.transformation.queries.PseudoStates";
    }
    
    @Override
    public List<String> parameterNames() {
      return PseudoStates.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fContainingRegion, fPseudoState, fKind};
    }
    
    @Override
    public PseudoStates.Match toImmutable() {
      return isMutable() ? newMatch(fContainingRegion, fPseudoState, fKind) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"containingRegion\"=" + prettyPrintValue(fContainingRegion) + ", ");
      result.append("\"pseudoState\"=" + prettyPrintValue(fPseudoState) + ", ");
      result.append("\"kind\"=" + prettyPrintValue(fKind));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fContainingRegion, fPseudoState, fKind);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PseudoStates.Match)) {
          PseudoStates.Match other = (PseudoStates.Match) obj;
          return Objects.equals(fContainingRegion, other.fContainingRegion) && Objects.equals(fPseudoState, other.fPseudoState) && Objects.equals(fKind, other.fKind);
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
    public PseudoStates specification() {
      return PseudoStates.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PseudoStates.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PseudoStates.Match newMutableMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return new Mutable(pContainingRegion, pPseudoState, pKind);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PseudoStates.Match newMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return new Immutable(pContainingRegion, pPseudoState, pKind);
    }
    
    private static final class Mutable extends PseudoStates.Match {
      Mutable(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
        super(pContainingRegion, pPseudoState, pKind);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PseudoStates.Match {
      Immutable(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
        super(pContainingRegion, pPseudoState, pKind);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the hu.bme.mit.md2g.transformation.queries.PseudoStates pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern PseudoStates(containingRegion: Region, pseudoState: Pseudostate, kind: PseudostateKind){
   * 	Region.subvertex(containingRegion, pseudoState);
   * 	Pseudostate.kind(pseudoState, kind);
   * 
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PseudoStates
   * 
   */
  public static class Matcher extends BaseMatcher<PseudoStates.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PseudoStates.Matcher on(final ViatraQueryEngine engine) {
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
    public static PseudoStates.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CONTAININGREGION = 0;
    
    private static final int POSITION_PSEUDOSTATE = 1;
    
    private static final int POSITION_KIND = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PseudoStates.Matcher.class);
    
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
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PseudoStates.Match> getAllMatches(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawStreamAllMatches(new Object[]{pContainingRegion, pPseudoState, pKind}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PseudoStates.Match> streamAllMatches(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawStreamAllMatches(new Object[]{pContainingRegion, pPseudoState, pKind});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PseudoStates.Match> getOneArbitraryMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawGetOneArbitraryMatch(new Object[]{pContainingRegion, pPseudoState, pKind});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawHasMatch(new Object[]{pContainingRegion, pPseudoState, pKind});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawCountMatches(new Object[]{pContainingRegion, pPseudoState, pKind});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind, final Consumer<? super PseudoStates.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pContainingRegion, pPseudoState, pKind}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pContainingRegion the fixed value of pattern parameter containingRegion, or null if not bound.
     * @param pPseudoState the fixed value of pattern parameter pseudoState, or null if not bound.
     * @param pKind the fixed value of pattern parameter kind, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PseudoStates.Match newMatch(final Region pContainingRegion, final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return PseudoStates.Match.newMatch(pContainingRegion, pPseudoState, pKind);
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Region> rawStreamAllValuesOfcontainingRegion(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONTAININGREGION, parameters).map(Region.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion() {
      return rawStreamAllValuesOfcontainingRegion(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion() {
      return rawStreamAllValuesOfcontainingRegion(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion(final PseudoStates.Match partialMatch) {
      return rawStreamAllValuesOfcontainingRegion(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Region> streamAllValuesOfcontainingRegion(final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawStreamAllValuesOfcontainingRegion(new Object[]{null, pPseudoState, pKind});
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion(final PseudoStates.Match partialMatch) {
      return rawStreamAllValuesOfcontainingRegion(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for containingRegion.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Region> getAllValuesOfcontainingRegion(final Pseudostate pPseudoState, final PseudostateKind pKind) {
      return rawStreamAllValuesOfcontainingRegion(new Object[]{null, pPseudoState, pKind}).collect(Collectors.toSet());
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
    public Stream<Pseudostate> streamAllValuesOfpseudoState(final PseudoStates.Match partialMatch) {
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
    public Stream<Pseudostate> streamAllValuesOfpseudoState(final Region pContainingRegion, final PseudostateKind pKind) {
      return rawStreamAllValuesOfpseudoState(new Object[]{pContainingRegion, null, pKind});
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfpseudoState(final PseudoStates.Match partialMatch) {
      return rawStreamAllValuesOfpseudoState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for pseudoState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Pseudostate> getAllValuesOfpseudoState(final Region pContainingRegion, final PseudostateKind pKind) {
      return rawStreamAllValuesOfpseudoState(new Object[]{pContainingRegion, null, pKind}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<PseudostateKind> rawStreamAllValuesOfkind(final Object[] parameters) {
      return rawStreamAllValues(POSITION_KIND, parameters).map(PseudostateKind.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PseudostateKind> getAllValuesOfkind() {
      return rawStreamAllValuesOfkind(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<PseudostateKind> streamAllValuesOfkind() {
      return rawStreamAllValuesOfkind(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PseudostateKind> streamAllValuesOfkind(final PseudoStates.Match partialMatch) {
      return rawStreamAllValuesOfkind(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<PseudostateKind> streamAllValuesOfkind(final Region pContainingRegion, final Pseudostate pPseudoState) {
      return rawStreamAllValuesOfkind(new Object[]{pContainingRegion, pPseudoState, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PseudostateKind> getAllValuesOfkind(final PseudoStates.Match partialMatch) {
      return rawStreamAllValuesOfkind(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for kind.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<PseudostateKind> getAllValuesOfkind(final Region pContainingRegion, final Pseudostate pPseudoState) {
      return rawStreamAllValuesOfkind(new Object[]{pContainingRegion, pPseudoState, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PseudoStates.Match tupleToMatch(final Tuple t) {
      try {
          return PseudoStates.Match.newMatch((Region) t.get(POSITION_CONTAININGREGION), (Pseudostate) t.get(POSITION_PSEUDOSTATE), (PseudostateKind) t.get(POSITION_KIND));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PseudoStates.Match arrayToMatch(final Object[] match) {
      try {
          return PseudoStates.Match.newMatch((Region) match[POSITION_CONTAININGREGION], (Pseudostate) match[POSITION_PSEUDOSTATE], (PseudostateKind) match[POSITION_KIND]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PseudoStates.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PseudoStates.Match.newMutableMatch((Region) match[POSITION_CONTAININGREGION], (Pseudostate) match[POSITION_PSEUDOSTATE], (PseudostateKind) match[POSITION_KIND]);
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
    public static IQuerySpecification<PseudoStates.Matcher> querySpecification() {
      return PseudoStates.instance();
    }
  }
  
  private PseudoStates() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PseudoStates instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PseudoStates.Matcher instantiate(final ViatraQueryEngine engine) {
    return PseudoStates.Matcher.on(engine);
  }
  
  @Override
  public PseudoStates.Matcher instantiate() {
    return PseudoStates.Matcher.create();
  }
  
  @Override
  public PseudoStates.Match newEmptyMatch() {
    return PseudoStates.Match.newEmptyMatch();
  }
  
  @Override
  public PseudoStates.Match newMatch(final Object... parameters) {
    return PseudoStates.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate) parameters[1], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link PseudoStates} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link PseudoStates#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PseudoStates INSTANCE = new PseudoStates();
    
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
    private static final PseudoStates.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_containingRegion = new PParameter("containingRegion", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pseudoState = new PParameter("pseudoState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")), PParameterDirection.INOUT);
    
    private final PParameter parameter_kind = new PParameter("kind", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKind", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_containingRegion, parameter_pseudoState, parameter_kind);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.md2g.transformation.queries.PseudoStates";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("containingRegion","pseudoState","kind");
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
          PVariable var_containingRegion = body.getOrCreateVariableByName("containingRegion");
          PVariable var_pseudoState = body.getOrCreateVariableByName("pseudoState");
          PVariable var_kind = body.getOrCreateVariableByName("kind");
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_kind), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_containingRegion, parameter_containingRegion),
             new ExportedParameter(body, var_pseudoState, parameter_pseudoState),
             new ExportedParameter(body, var_kind, parameter_kind)
          ));
          // 	Region.subvertex(containingRegion, pseudoState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_containingRegion, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Region", "subvertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_pseudoState);
          // 	Pseudostate.kind(pseudoState, kind)
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_pseudoState, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Pseudostate", "kind")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "PseudostateKind")));
          new Equality(body, var__virtual_1_, var_kind);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
