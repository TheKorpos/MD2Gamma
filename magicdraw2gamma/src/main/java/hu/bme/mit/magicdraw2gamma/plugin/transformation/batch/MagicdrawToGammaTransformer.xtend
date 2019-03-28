package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum
import hu.bme.mit.gamma.constraint.model.ConstraintModelFactory
import hu.bme.mit.gamma.constraint.model.TypeDefinition
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StateNode
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.gamma.statechart.model.TimeSpecification
import hu.bme.mit.gamma.statechart.model.Transition
import hu.bme.mit.magicdraw2gamma.plugin.parsing.ActionParser
import hu.bme.mit.magicdraw2gamma.plugin.queries.EventByName
import hu.bme.mit.magicdraw2gamma.plugin.queries.GuardsInStateMachine
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.PseudoStates
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries
import hu.bme.mit.magicdraw2gamma.plugin.queries.SignalsInStateMachine
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.TranisitonsInStateMachine
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
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
    extension Tracer backTracer
   
    val extension SearchQueries searchQueries = SearchQueries.instance

    protected ViatraQueryEngine engine
    private ViatraQueryEngine targetModelEngine
    protected Resource resource
    private val f = StatechartModelFactory.eINSTANCE
    private val fc = ConstraintModelFactory.eINSTANCE
	private MD2GTrace traceRoot;
	
	val timeP = new ActionParser

    new(ViatraQueryEngine sourceModelEngine) {
        engine = sourceModelEngine	
		
        createTransformation
    }
	

    def execute(ViatraQueryEngine targetModelEngine, MD2GTrace traceRoot) {
		this.targetModelEngine = targetModelEngine
		this.traceRoot = traceRoot

		backTracer = new Tracer(traceRoot, targetModelEngine)

		mainRegionRule.fireAllCurrent
		statesInRegionsRule.fireAllCurrent
		regionsInStatesRule.fireAllCurrent
		pseudoStateRule.fireAllCurrent
		transitionRule.fireAllCurrent
		eventTriggerRule.fireAllCurrent
		timeEventRule.fireAllCurrent
		propertyRule.fireAllCurrent
		transitionActionRule.fireAllCurrent
		guardRule.fireAllCurrent
	}
    
    
    //transform main regions
	val mainRegionRule = createRule.precondition(MainRegions.instance).action[ match | 
		val statechartTrace = match.stateMachine.trace
		
		if (statechartTrace.present){
			val statechartdef = statechartTrace.get as StatechartDefinition
			val mainRegion = f.createRegion
			mainRegion.name = "main_region" 
			statechartdef.regions += mainRegion
		
			createTrace(match.region, mainRegion)	
		}	
	].build
	

	val statesInRegionsRule = createRule.precondition(StatesInRegions.instance).action[match |
		val regionTrace = match.containingRegion.trace
		
		val gammaState = f.createState
		gammaState.name =  match.state.name
		createTrace(match.state, gammaState)
		
		//check for transformed parent
		if (regionTrace.present) {
			val gammaRegion = regionTrace.get as Region
			gammaRegion.stateNodes += gammaState
		} else {
		//create dangling sub-tree
			val gammaRegion = f.createRegion
			gammaRegion.name = match.containingRegion.name
			gammaRegion.stateNodes += gammaState
			createTrace(match.containingRegion, gammaRegion)
		}
		
	].build
	
	//finishing containment tree
	val regionsInStatesRule = createRule.precondition(RegionsInStates.instance).action[match |
		val t = match.containingState.trace
		val s = match.region.trace
		
		//these should exist at this point
		val gammaState = t.get
		
		if (!s.present){
			val gammaRegion = f.createRegion
			gammaRegion.name = match.region.name
			gammaState.regions += gammaRegion
			createTrace(match.region, gammaRegion)
		} else {
			val gammaRegion = s.get
			gammaState.regions += gammaRegion
		}
	].build
	
	val pseudoStateRule = createRule.precondition(PseudoStates.instance).action[match| 
		
		//this should already exist
		val gammaRegion = match.containingRegion.trace.get
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
		createTrace(match.pseudoState, pseudoState)
		
	].build
	
	val transitionRule = createRule.precondition(TranisitonsInStateMachine.instance).action[match |
		val transion = match.transition 
		val gammaTransition = f.createTransition
		match.stateMachine.trace.get.transitions += gammaTransition
		
		val gammaStateNodeS = transion.source.trace.get
		val gammaStateNodeT = transion.target.trace.get
		
		gammaTransition.sourceState = gammaStateNodeS
		gammaTransition.targetState = gammaStateNodeT
		
		createTrace(match.transition, gammaTransition)
		
	].build
	
	val eventTriggerRule = createRule.precondition(SignalsInStateMachine.instance).action[match |
		
		val gammaTransiton = match.transition.trace.get
		val statechartDefinition = match.stateMachine.trace.get as StatechartDefinition
		
		val matcher = EventByName.instance.getMatcher(targetModelEngine)
		matcher.getAllMatches(matcher.newMatch("IGenerated" + match.stateMachine.name, match.signal.name, null)).forEach[m |
			val trigger = f.createEventTrigger
			val portEventReference = f.createPortEventReference
			portEventReference.event = m.event
			trigger.eventReference = portEventReference
			//there is only port at this point
			portEventReference.port = statechartDefinition.ports.head
			gammaTransiton.trigger = trigger
		]
		
	].build
	
	val timeEventRule = createRule.precondition(timeEventsInStateMachine).action[match | 
		//we don't support absolute yet
		if (match.event.relative){
			val transition = match.transition.trace.get
			
			val stateNode = transition.sourceState
			if (stateNode instanceof State){
				val statechartDef = match.stateMachine.trace.get
				val state = stateNode as State
			
				//Add Timeout declaration to the statechartdef
				val timeOutDecl = f.createTimeoutDeclaration
				statechartDef.timeoutDeclarations += timeOutDecl
				
				val expr = match.event.when.expr as LiteralString
				val timeSpecification = timeP.parseTimeSpecification(expr.value) as TimeSpecification
				
				val setTimeoutAction = f.createSetTimeoutAction
				setTimeoutAction.timeoutDeclaration = timeOutDecl
				setTimeoutAction.time = timeSpecification
				state.entryActions += setTimeoutAction
				
				val timeOutEventReference = f.createTimeoutEventReference
				timeOutEventReference.timeout = timeOutDecl
				
				val trigger = f.createEventTrigger
				trigger.eventReference = timeOutEventReference
				
				transition.trigger = trigger
				
				createOnetToManyTrace(match.transition.trigger.head, #[timeOutDecl, setTimeoutAction, trigger])
			}
		}
	].build
	
	val guardRule = createRule.precondition(GuardsInStateMachine.instance).action[match |
		val statechartDefinition = match.stateMachine.trace.get
		val guardString = match.body
		val gammaTransition = match.transition.trace.get as Transition
		val expr = timeP.parseGuard(targetModelEngine, statechartDefinition, guardString) 
		gammaTransition.guard = expr
		createTrace(match.opaqueExpression, expr)
	].build
	
	val propertyRule = createRule.precondition(propertiesInStateMachine).action[match | 
		val property = match.prop
		var TypeDefinition def
		
		switch (property.type.name) {
			case "Integer": 
				def = fc.createIntegerTypeDefinition
			case "Boolean": 
				def = fc.createBooleanTypeDefinition
		}
		
		val decl = fc.createVariableDeclaration
		
		decl.type = def
		decl.name = match.prop.name
		
		match.stateMachine.trace.get.variableDeclarations += decl
		
		createTrace(property, decl)
	].build
	
	val transitionActionRule = createRule.precondition(actionsOnTransitions).action[match | 
		val body = match.body
		val statechartDef = match.statemachine.trace.get
		val action = timeP.paresAction(this.targetModelEngine, statechartDef, body)
		
		match.transition.trace.get.effects += action
	].build
 

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
        targetModelEngine = null
        return
    }
}
