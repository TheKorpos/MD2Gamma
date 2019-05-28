package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum
import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage
import hu.bme.mit.gamma.constraint.model.OpaqueExpression
import hu.bme.mit.gamma.constraint.model.ParameterDeclaration
import hu.bme.mit.gamma.constraint.model.VariableDeclaration
import hu.bme.mit.gamma.statechart.model.PortEventReference
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.SetTimeoutAction
import hu.bme.mit.gamma.statechart.model.State
import hu.bme.mit.gamma.statechart.model.StateNode
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage
import hu.bme.mit.gamma.statechart.model.TimeSpecification
import hu.bme.mit.gamma.statechart.model.TimeoutDeclaration
import hu.bme.mit.gamma.statechart.model.TimeoutEventReference
import hu.bme.mit.gamma.statechart.model.Transition
import hu.bme.mit.gamma.statechart.model.interface_.Event
import hu.bme.mit.gamma.statechart.model.interface_.EventDeclaration
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import hu.bme.mit.magicdraw2gamma.plugin.parsing.ActionParser
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import org.eclipse.emf.ecore.EClass
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import hu.bme.mit.magicdraw2gamma.plugin.transformation.NameFormatter
import java.util.ArrayList
import hu.bme.mit.gamma.statechart.model.interface_.Interface

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
	extension NameFormatter nameFormatter = new NameFormatter
	
	val masseges = new ArrayList<String>
    
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
    	parameterRule.fireAllCurrent
    	propertyRule.fireAllCurrent
    	operationsRule.fireAllCurrent
    	collectEventsRule.fireAllCurrent
		mainRegionRule.fireAllCurrent
		statePrepareRule.fireAllCurrent
		regionsInStatesRule.fireAllCurrent
		statesInRegionsRule.fireAllCurrent
		pseudoStateRule.fireAllCurrent
		transitionRule.fireAllCurrent
		callOperationTrigger.fireAllCurrent
		guardRule.fireAllCurrent
//		eventTriggerRule.fireAllCurrent
		timeEventRule.fireAllCurrent
//		propertyRule.fireAllCurrent
//		transitionActionRule.fireAllCurrent
		
	}
	
	
	def getMessage(){
		masseges
	}
	
	private def EClass getTypeByName(String mdTypeName){
		
		switch (mdTypeName) {
			case "Integer": 
				return integerTypeDefinition
			case "Boolean": 
				return booleanTypeDefinition
			case "Natural":
				return naturalTypeDefinition
			case "Real":
				return realTypeDefinition
				
			default: return integerTypeDefinition
		}
	}
    
    val parameterRule = createRule(parametersInStateMachine).action[match |
    	val mdStateMachine = match.stateMachine
    	val property = match.parameter
    	
    	val mdPropertyType = property.type
    	var EClass propertyType = null
    	
    	if (mdPropertyType === null){
    		
    	} else {
    		propertyType = mdPropertyType.name.typeByName;
    		
    	}
    	
    	
    	val gParameterDecl = mdStateMachine.pairs.head.createChild(parametricElement_ParameterDeclarations, parameterDeclaration) as ParameterDeclaration => [
    		it.name = property.name.fomratName
    	]
    	
    	gParameterDecl.createChild(declaration_Type, propertyType)
		
		createTrace(property, gParameterDecl)
    ].build
    
    
    
    val propertyRule = createRule(propertiesInStateMachine).action[match | 
		val property = match.prop
		
		var EClass propertyType = property.type.name.typeByName;
		
		
		val gDclaration = match.stateMachine.genericPair.head.createChild(statechartDefinition_VariableDeclarations, variableDeclaration) as VariableDeclaration => [
			it.name = property.name.fomratName
		]
		
		gDclaration.createChild(declaration_Type, propertyType)
		
		createTrace(property, gDclaration)
	].build
    
    
    //operations owned by block or statemachine
    val operationsRule = createRule(ownedOperations).action[match |
    	val gInterface = match.GInterface
    	val gEventDeclaration = gInterface.createChild(interface_Events, eventDeclaration) as EventDeclaration => [
    		it.direction = EventDirection.IN
    	]
    	
    	val gEvent = gEventDeclaration.createChild(eventDeclaration_Event, event) as Event => [
    		it.name = "Operation_Call_" + match.operation.name.fomratName
    	]
    	
    	createInterfaceTrace(match.operation, gEvent)
    ].build
    
    //all the events used on triggers without source port
    val collectEventsRule = createRule(signalsInStateMachine).action[match |  	
		//no source port
		val mdEvent = match.event
		val mdSignal = mdEvent.signal
		val gInterface = match.GInterface as Interface
		
		
		val gEventDeclaration = gInterface.createChild(interface_Events, eventDeclaration) as EventDeclaration => [
    		it.direction = EventDirection.IN
    	]
    	
    	val gEvent = gEventDeclaration.createChild(eventDeclaration_Event, event) as Event => [
    		if (mdSignal !== null)
    			it.name = "signal_event_" + if (mdEvent.name === null || mdEvent.name == "") mdSignal.name.fomratName else mdEvent.name.fomratName
    		else 
    			it.name = "signal_event_" + if (mdEvent.name === null || mdEvent.name == "") "signal_event_" + gInterface.events.size else mdEvent.name.fomratName
    	]
    	
    	createInterfaceTrace(mdEvent, gEvent)
	].build
    
    //transform main regions
	val mainRegionRule = createRule(mainRegions).action[ match | 
		val mdStateMachine = match.stateMachine		
		val mdRegion = match.region
		val gStatechartDefinition = mdStateMachine.pairs.head
		val gRegion = gStatechartDefinition.createChild(compositeElement_Regions, region) as Region => [
			it.name = if (mdRegion.name == "")  "main_region_of_" + gStatechartDefinition.name else region.name.fomratName
		]
	
		createTrace(mdRegion, gRegion)
	].build
	
	val statePrepareRule = createRule(statesInStatemachine).action[ match |
		val mdStateMachine = match.stateMachine
		val mdState = match.state
		val gStatechart = mdStateMachine.pairs.head
		
		//we just put every state in the first region for now
		val mainRegion = gStatechart.regions.head as Region;
		val gState = mainRegion.createChild(region_StateNodes, state) as State => [
			if (mdState.name === null || mdState.name==""){
				val stateCount = mainRegion.stateNodes.size
				it.name = "state_" + stateCount	
			} else {
				it.name = mdState.name.fomratName	
			}
		]
		
		createTrace(mdState, gState)
	].build
	
	val regionsInStatesRule = createRule(regionsInStates).action[match |
		val mdState = match.containingState
		val mdRegion = match.region
		
		val gState = mdState.pairs.head as State
		val gRegion = gState.createChild(compositeElement_Regions, region) as Region
		
			
		if (gRegion.name === null || gRegion.name == ""){
			val regionCount = gState.regions.size
			gRegion.name = "region_" + regionCount + "_in_" + gState.name
		} else {
			gRegion.name = mdRegion.name.fomratName	
		}
		
		
		createTrace(mdRegion, gRegion)
	].build

	val statesInRegionsRule = createRule(statesInRegions).action[match |
		val mdRegion = match.containingRegion
		val mdState = match.state
		
		val gRegion = mdRegion.pairs.head as Region
		val gState = mdState.pairs.head as State
		

		//move states where they actually belong
		gState.moveTo(gRegion, region_StateNodes)
	].build
		
	val pseudoStateRule = createRule(pseudoStates).action[match| 
		
		val mdRegion = match.containingRegion
		val mdVertex = match.pseudoState
		val mdStateKind = match.kind
		
		val gRegion = mdRegion.pairs.head as Region
	
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
				this.masseges.add(mdVertex.humanName + " is not supported, skipping")
				return
			}
		
		}
		
		if (mdVertex.name === null || mdVertex.name == ""){
			val statecount = gRegion.stateNodes.size
			pseudoState.name = "statenode_"+ statecount +"_in_" + gRegion.name
		} else {
			pseudoState.name = mdVertex.name.fomratName	
		}
		
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
				
				val gTimeoutDeclaration = gStatechart.createChild(statechartDefinition_TimeoutDeclarations, timeoutDeclaration)	 as TimeoutDeclaration
			
				gTimeoutDeclaration.name = "timeout_" + gStatechart.timeoutDeclarations.size
			
				val gSetTimeoutAction = gStateNode.createChild(state_EntryActions, setTimeoutAction) as SetTimeoutAction
				gSetTimeoutAction.timeoutDeclaration = gTimeoutDeclaration
				
				val expr = mdEvent.when.expr as LiteralString
				
				try {
					val gTimeSpecification = timeP.parseTimeSpecification(gStatechart, expr.value.fomratName) as TimeSpecification
					gSetTimeoutAction.time = gTimeSpecification
					
					val gTrigger = gTransition.createChild(transition_Trigger, eventTrigger)
					val gTmeoutEventReference = gTrigger.createChild(eventTrigger_EventReference, timeoutEventReference) as TimeoutEventReference
				
					gTmeoutEventReference.timeout = gTimeoutDeclaration
			
					createOnetToManyTrace(match.transition.trigger.head, #[gTimeoutDeclaration, gSetTimeoutAction, gTrigger])
				} catch (Exception e){
					this.masseges += "skipping " + match.event.humanName + " reason: " + e.message 
				}
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
	
	
	val guardRule = createRule(guardsInStateMachine).action[match |
		val gTranistion = match.transition.pairs.head
		val guardString = match.body

		val guardExpr = gTranistion.createChild(transition_Guard, opaqueExpression) as OpaqueExpression => [
			it.body = "\"" + guardString.fomratName + "\""
		]
		
		createManyToManyTrace(#[match.transition, match.opaqueExpression], #[gTranistion, guardExpr])
	].build

	
//	val transitionActionRule = createRule.precondition(actionsOnTransitions).action[match | 
//		val body = match.body
//		val statechartDef = match.statemachine.trace.get
//		val action = timeP.paresAction(this.targetModelEngine, statechartDef, body)
//		
//		match.transition.trace.get.effects += action
//	].build


	 

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
