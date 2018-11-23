package hu.bme.mit.magicdraw2gamma.plugin.trafos

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StateNode
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.PseudoStates
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.TranisitonsInStateMachine
import hu.bme.mit.magicdraw2gamma.plugin.queries.VertexTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements

class MagicdrawToGammaTransformer {

    /* Transformation-related extensions */ 
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine
    private ViatraQueryEngine targetModelEngine
    protected Resource resource
    private val f = StatechartModelFactory.eINSTANCE
	private MD2GTrace traceRoot;

    new(ViatraQueryEngine sourceModelEngine, ViatraQueryEngine targetModelEngine, MD2GTrace traceRoot) {
        engine = sourceModelEngine
        this.targetModelEngine = targetModelEngine
		this.traceRoot = traceRoot        
        createTransformation

    }
	

    public def execute() {
		mainRegionRule.fireAllCurrent
		statesInRegionsRule.fireAllCurrent	
		regionsInStatesRule.fireAllCurrent
		pseudoStateRule.fireAllCurrent
		transitionRule.fireAllCurrent
	}
    
    
    //transform main regions
	val mainRegionRule = createRule.precondition(MainRegions.instance).action[ match | 
		val trace = match.stateMachine.trace
		
		if (trace.present){
			val statechartdef = trace.get.target as StatechartDefinition
			val mainRegion = f.createRegion
			mainRegion.name = match.region.name
			statechartdef.regions += mainRegion
			
			traceRoot.makeAndAddTrace(match.region, mainRegion)	
		}
		
	].build
	

	val statesInRegionsRule = createRule.precondition(StatesInRegions.instance).action[match |
		val regionTrace = match.containingRegion.trace
		
		val gammaState = f.createState
		gammaState.name =  match.state.name
		traceRoot.makeAndAddTrace(match.state, gammaState)
		
		//check for transformed parent
		if (regionTrace.present) {
			val gammaRegion = regionTrace.get.target as hu.bme.mit.gamma.statechart.model.Region
			gammaRegion.stateNodes += gammaState
		} else {
		//create dangling tree
			val gammaRegion = f.createRegion
			gammaRegion.stateNodes += gammaState
			traceRoot.makeAndAddTrace(match.containingRegion, gammaRegion)
		}
		
	].build
	
	//finishing containment tree
	val regionsInStatesRule = createRule.precondition(RegionsInStates.instance).action[match |
		val t = match.containingState.trace
		val s = match.region.trace
		
		//these should exist at this point
		val gammaState = t.get.target as State
		
		if (!s.present){
			val gammaRegion = f.createRegion
			gammaRegion.name = match.region.name
			gammaState.regions += gammaRegion
			traceRoot.makeAndAddTrace(match.region, gammaRegion)
		} else {
			val gammaRegion = s.get.target as hu.bme.mit.gamma.statechart.model.Region
			gammaState.regions += gammaRegion
		}
	].build
	
	val pseudoStateRule = createRule.precondition(PseudoStates.instance).action[match| 
		
		//this should already exist
		val gammaRegion = match.containingRegion.trace.get.target as hu.bme.mit.gamma.statechart.model.Region
		var StateNode pseudoState = null;
		
		switch match.kind{
			case PseudostateKindEnum.INITIAL: {
				pseudoState = f.createInitialState
			}
			case PseudostateKindEnum.SHALLOWHISTORY: {
				pseudoState = f.createShallowHistoryState
			}
			case PseudostateKindEnum.CHOICE: {
				pseudoState = f.createChoiceState
			}
			case PseudostateKindEnum.FORK: {
				pseudoState = f.createForkState
			}
			case PseudostateKindEnum.JOIN: {
				pseudoState = f.createJoinState
			}
			case PseudostateKindEnum.DEEPHISTORY:{
				pseudoState = f.createDeepHistoryState
			}
			case PseudostateKindEnum.JUNCTION: {
				pseudoState = f.createMergeState
			}
		}
		
		gammaRegion.stateNodes += pseudoState
		traceRoot.makeAndAddTrace(match.pseudoState, pseudoState)
		
	].build
	
	val transitionRule = createRule.precondition(TranisitonsInStateMachine.instance).action[match |
		val transion = match.transition 
		val gammaTransition = f.createTransition
		match.stateMachine.trace.get.target.transitions += gammaTransition
		
		val gammaStateNodeS = transion.source.trace.get.target as StateNode
		val gammaStateNodeT = transion.target.trace.get.target as StateNode
		
		gammaTransition.sourceState = gammaStateNodeS
		gammaTransition.targetState = gammaStateNodeT
		
	].build
	
	
	private def trace(StateMachine stmt){
		val matcher = StatechartTrace.instance.getMatcher(targetModelEngine)
	
		val matches = matcher.getAllMatches(stmt, null, null)
		
		Optional.ofNullable(matches.head)
	}
	
	private def trace(Region region){
		val matcher = RegionTrace.instance.getMatcher(targetModelEngine)
		val matches = matcher.getAllMatches(region, null, null)
		
		Optional.ofNullable(matches.head)
	}
	
	private def trace(com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State state){
		val matcher = StateTrace.instance.getMatcher(targetModelEngine)
		val matches = matcher.getAllMatches(state, null, null)
		
		Optional.ofNullable(matches.head)
	}
	
	
	private def makeAndAddTrace(MD2GTrace root, EObject source, EObject target){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += target
		root.traces += ret
	}
	
	private def trace(Vertex vertex){
		val matcher = VertexTrace.instance.getMatcher(targetModelEngine)
		val matches = matcher.getAllMatches(vertex, null, null)
		Optional.ofNullable(matches.head)
	}
	

    private def createTransformation() {
        //Create VIATRA model manipulations
        this.manipulation = new SimpleModelManipulations(engine)
        //Create VIATRA Batch transformation
        transformation = BatchTransformation.forEngine(engine)
        .build
        //Initialize batch transformation statements
        statements = transformation.transformationStatements
    }
   
    def dispose() {
        transformation = null
        return
    }
}
