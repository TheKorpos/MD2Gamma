package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StateNode
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage
import hu.bme.mit.gamma.statechart.model.TimeSpecification
import hu.bme.mit.gamma.statechart.model.Transition
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import hu.bme.mit.magicdraw2gamma.plugin.parsing.ActionParser
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Event
import hu.bme.mit.gamma.statechart.model.EventTrigger
import hu.bme.mit.gamma.statechart.model.EventReference
import hu.bme.mit.gamma.statechart.model.PortEventReference

class MagicdrawToGammaTransformer {

    /* Transformation-related extensions */ 
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation
    
    /* Other extensions */
    extension Tracer tracer
    extension SearchQueries searchQueries = SearchQueries.instance
	extension StatechartModelPackage statechartPackage = StatechartModelPackage.eINSTANCE
	extension InterfacePackage interfacePackage = InterfacePackage.eINSTANCE
	extension ConstraintModelPackage constraintModelPackage = ConstraintModelPackage.eINSTANCE
    
	MD2GTrace traceRoot;
	ViatraQueryEngine engine
	
	val timeP = new ActionParser
	
	new(ViatraQueryEngine engine, Tracer tracer){
		this.engine = engine
		this.traceRoot = traceRoot
		this.tracer = tracer
		
		
		createTransformation
	}

    def execute() {
    	operationsRule.fireAllCurrent
    	collectEventsRule.fireAllCurrent
		mainRegionRule.fireAllCurrent
		statePrepareRule.fireAllCurrent
		regionsInStatesRule.fireAllCurrent
		statesInRegionsRule.fireAllCurrent
		pseudoStateRule.fireAllCurrent
		transitionRule.fireAllCurrent
		callOperationTrigger.fireAllCurrent
//		eventTriggerRule.fireAllCurrent
		timeEventRule.fireAllCurrent
//		propertyRule.fireAllCurrent
//		transitionActionRule.fireAllCurrent
//		guardRule.fireAllCurrent
	}
    
    //operations owned by block
    val operationsRule = createRule(ownedOperations).action[match |
    	val gInterface = match.GInterface
    	val gEventDeclaration = gInterface.createChild(interface_Events, eventDeclaration) as EventDeclaration => [
    		it.direction = EventDirection.IN
    	]
    	
    	val gEvent = gEventDeclaration.createChild(eventDeclaration_Event, event) as hu.bme.mit.gamma.statechart.model.interface_.Event => [
    		it.name = "Operation_Call_" + match.operation.name
    	]
    	
    	createInterfaceTrace(match.operation, gEvent)
    ].build
    
    //all the events used on triggers without source port
    val collectEventsRule = createRule(signalsInStateMachine).action[match |
    	
    	val mdTrigger = match.trigger
    	val mdSourcePorts = mdTrigger.port
    	
    	if (mdSourcePorts.size > 0){
    		//TODO: 
    	} else {
    		//no source port
    		val mdSignal = match.signal
			val gInterface = match.GInterface
			
			val gEventDeclaration = gInterface.createChild(interface_Events, eventDeclaration) as EventDeclaration => [
	    		it.direction = EventDirection.IN
	    	]
	    	
	    	val gEvent = gEventDeclaration.createChild(eventDeclaration_Event, event) as hu.bme.mit.gamma.statechart.model.interface_.Event => [
	    		it.name = "Signal_" + mdSignal.name
	    	]
	    	
	    	createInterfaceTrace(mdSignal, gEvent)
    	}
	].build
    
    //transform main regions
	val mainRegionRule = createRule(mainRegions).action[ match | 
		val mdStateMachine = match.stateMachine		
		val mdRegion = match.region
		val gStatechartDefinition = mdStateMachine.pairs.head
		val gRegion = gStatechartDefinition.createChild(compositeElement_Regions, region) as Region => [
			it.name = if (mdRegion.name == "")  "R_" + (mdRegion.objectParent as NamedElement).name else region.name
		]
	
		createTrace(mdRegion, gRegion)
	].build
	
	val statePrepareRule = createRule(statesInStatemachine).action[ match |
		val mdStateMachine = match.stateMachine
		val mdState = match.state
		val gStatechart = mdStateMachine.pairs.head
		
		//we just put every state in the first region for now
		val gState = gStatechart.regions.head.createChild(region_StateNodes, state) as State => [
			it.name = mdState.name
		]
		
		createTrace(mdState, gState)
	].build
	
	val regionsInStatesRule = createRule(regionsInStates).action[match |
		val mdState = match.containingState
		val mdRegion = match.region
		
		val gState = mdState.pairs.head
		val gRegion = gState.createChild(compositeElement_Regions, region) 
		
		(gRegion as Region).name = mdRegion.name
		
		createTrace(mdRegion, gRegion)
	].build

	val statesInRegionsRule = createRule(statesInRegions).action[match |
		val mdRegion = match.containingRegion
		val mdState = match.state
		
		val gRegion = mdRegion.pairs.head
		val gState = mdState.pairs.head
		//move states where they actually belong
		gState.moveTo(gRegion, region_StateNodes)
	].build
		
	val pseudoStateRule = createRule(pseudoStates).action[match| 
		
		val mdRegion = match.containingRegion
		val mdVertex = match.pseudoState
		val mdStateKind = match.kind
		
		val gRegion = mdRegion.pairs.head
	
		var StateNode pseudoState = null;
		
		switch mdStateKind{
			case PseudostateKindEnum.INITIAL: {
				pseudoState = gRegion.createChild(region_StateNodes, initialState) as StateNode
			}
			case PseudostateKindEnum.SHALLOWHISTORY: {
				pseudoState = gRegion.createChild(region_StateNodes, shallowHistoryState) as StateNode
			}
			case PseudostateKindEnum.CHOICE: {
				pseudoState = gRegion.createChild(region_StateNodes, choiceState) as StateNode
			}
			case PseudostateKindEnum.FORK: {
				pseudoState = gRegion.createChild(region_StateNodes, forkState) as StateNode
			}
			case PseudostateKindEnum.JOIN: {
				pseudoState = gRegion.createChild(region_StateNodes, joinState) as StateNode
			}
			case PseudostateKindEnum.DEEPHISTORY:{
				pseudoState = gRegion.createChild(region_StateNodes, deepHistoryState) as StateNode
			}
			case PseudostateKindEnum.JUNCTION: {
				pseudoState = gRegion.createChild(region_StateNodes, mergeState) as StateNode
			}
			
			default: {
				//TODO: log
				System.out.println("not been converted " + mdVertex)
				return
			}
		}
		
		pseudoState.name = mdVertex.name
		createTrace(mdVertex, pseudoState)
		
	].build
	
	val transitionRule = createRule(tranisitonsInStateMachine).action[match |
		val mdTransition = match.transition
		val mdStateMachine = match.stateMachine
		
		val mdSource = mdTransition.source
		val mdTarget = mdTransition.target
		
		val gSource = mdSource.pairs.head
		val gTarget = mdTarget.pairs.head
		
		val gStatechart = mdStateMachine.pairs.head
		
		val gTransition = gStatechart.createChild(statechartDefinition_Transitions, transition) as Transition=> [
			it.sourceState = gSource
			it.targetState = gTarget
		]
		
		createTrace(mdTransition, gTransition)
	].build
	

	val timeEventRule = createRule(timeEventsInStateMachine).action[match | 
		//we don't support absolute yet
		if (match.event.relative){
			val mdTransition = match.transition
			val mdState = mdTransition.source
			
			if (mdState instanceof com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State){
				val gTransition = mdTransition.pairs.head
				val gStateNode = gTransition.sourceState
				val mdEvent = match.event
				val mdStateMachine = match.stateMachine
				val gStatechart = mdStateMachine.pairs.head
				
				val gTimeoutDeclaration = gStatechart.createChild(statechartDefinition_TimeoutDeclarations, timeoutDeclaration)	
			
				val gSetTimeoutAction = gStateNode.createChild(state_EntryActions, setTimeoutAction) as SetTimeoutAction
				gSetTimeoutAction.add(timeoutAction_TimeoutDeclaration, gTimeoutDeclaration)
				
				val expr = mdEvent.when.expr as LiteralString
				val gTimeSpecification = timeP.parseTimeSpecification(expr.value) as TimeSpecification
				gSetTimeoutAction.time = gTimeSpecification
				
				val gTrigger = gTransition.createChild(transition_Trigger, eventTrigger)
				val gTmeoutEventReference = gTrigger.createChild(eventTrigger_EventReference, timeoutEventReference)
				
				gTmeoutEventReference.addTo(timeoutEventReference_Timeout, gTimeoutDeclaration)
			
				createOnetToManyTrace(match.transition.trigger.head, #[gTimeoutDeclaration, gSetTimeoutAction, gTrigger])
			}
		}
	].build
	
	val callOperationTrigger = createRule(eventTriggers).action[match | 
		val mdTransition = match.transition
		val gTransition  = mdTransition.pairs.head
		
		val gEventTrigger = gTransition.createChild(transition_Trigger, eventTrigger)
		gEventTrigger.createChild(eventTrigger_EventReference, portEventReference) as PortEventReference => [
			it.port = match.GPort
			it.event = match.GEvent
		]
		
	].build
	
	
	
//	
//	val guardRule = createRule.precondition(GuardsInStateMachine.instance).action[match |
//		val statechartDefinition = match.stateMachine.trace.get
//		val guardString = match.body
//		val gammaTransition = match.transition.trace.get as Transition
//		val expr = timeP.parseGuard(targetModelEngine, statechartDefinition, guardString) 
//		gammaTransition.guard = expr
//		createTrace(match.opaqueExpression, expr)
//	].build
//	
//	val propertyRule = createRule.precondition(propertiesInStateMachine).action[match | 
//		val property = match.prop
//		var TypeDefinition def
//		
//		switch (property.type.name) {
//			case "Integer": 
//				def = fc.createIntegerTypeDefinition
//			case "Boolean": 
//				def = fc.createBooleanTypeDefinition
//		}
//		
//		val decl = fc.createVariableDeclaration
//		
//		decl.type = def
//		decl.name = match.prop.name
//		
//		match.stateMachine.trace.get.variableDeclarations += decl
//		
//		createTrace(property, decl)
//	].build
//	
//	val transitionActionRule = createRule.precondition(actionsOnTransitions).action[match | 
//		val body = match.body
//		val statechartDef = match.statemachine.trace.get
//		val action = timeP.paresAction(this.targetModelEngine, statechartDef, body)
//		
//		match.transition.trace.get.effects += action
//	].build
// 
//

	

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
