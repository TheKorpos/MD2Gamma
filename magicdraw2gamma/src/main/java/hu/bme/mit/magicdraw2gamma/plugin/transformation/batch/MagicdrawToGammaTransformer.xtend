package hu.bme.mit.magicdraw2gamma.plugin.transformation.batch

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString
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
import hu.bme.mit.gamma.statechart.model.interface_.Interface
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import hu.bme.mit.magicdraw2gamma.plugin.parsing.GammaExpressionParser
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.plugin.transformation.NameFormatter
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import java.util.ArrayList
import org.eclipse.emf.ecore.EClass
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import hu.bme.mit.gamma.statechart.model.OpaqueTrigger
import hu.bme.mit.gamma.action.model.ActionModelPackage
import hu.bme.mit.gamma.action.model.Action
import hu.bme.mit.gamma.action.model.Statement

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
	extension ActionModelPackage actionModelPackage = ActionModelPackage.eINSTANCE
	extension NameFormatter nameFormatter = new NameFormatter
	
	val masseges = new ArrayList<String>
    
	MD2GTrace traceRoot;
	ViatraQueryEngine engine
	
	val timeP = new GammaExpressionParser
	
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
		anyTriggerRule.fireAllCurrent
		timeEventRule.fireAllCurrent
		opaqueTriggerRule.fireAllCurrent
		guardRule.fireAllCurrent
		actionRule.fireAllCurrent
		entryActionRule.fireAllCurrent
		exitActionRule.fireAllCurrent
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
		val mdSignal = match.signal
		val gInterface = match.GInterface as Interface
		
		
		val gEventDeclaration = gInterface.createChild(interface_Events, eventDeclaration) as EventDeclaration => [
    		it.direction = EventDirection.IN
    	]
    	
    	val gEvent = gEventDeclaration.createChild(eventDeclaration_Event, event) as Event => [
    		it.name = mdSignal.name.fomratName
    	]
    	
    	createInterfaceTrace(mdSignal, gEvent)
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
		
		val stateCount = mainRegion.stateNodes.size
		
		val gState = mainRegion.createChild(region_StateNodes, state) as State => [
			if (mdState.name === null || mdState.name==""){		
				it.name = "state_" + stateCount	
			} else {
				//we apply a suffix so state names never collide
				it.name = mdState.name.fomratName + "_" + stateCount	
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
		var cName = "" 
		
		switch mdStateKind{
			case PseudostateKindEnum.INITIAL: {
				cName = "init"
				pseudoState = gRegion.createChild(region_StateNodes, initialState) as StateNode
			}
			case PseudostateKindEnum.SHALLOWHISTORY: {
				cName = "s_history"
				pseudoState = gRegion.createChild(region_StateNodes, shallowHistoryState) as StateNode
			}
			case PseudostateKindEnum.CHOICE: {
				cName = "choice"
				pseudoState = gRegion.createChild(region_StateNodes, choiceState) as StateNode
			}
			case PseudostateKindEnum.FORK: {
				cName = "fork"
				pseudoState = gRegion.createChild(region_StateNodes, forkState) as StateNode
			}
			case PseudostateKindEnum.JOIN: {
				cName = "join"
				pseudoState = gRegion.createChild(region_StateNodes, joinState) as StateNode
			}
			case PseudostateKindEnum.DEEPHISTORY:{
				cName = "d_history"
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
			pseudoState.name = cName + "_"+ statecount +"_in_" + gRegion.name
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
				val expr = mdEvent.when.expr as LiteralString
				
				try {	
					val gTimeSpecification = timeP.parseTimeSpecification(gStatechart, expr.value.fomratName) as TimeSpecification
					
					if (gTimeSpecification === null || gTimeSpecification.value === null ){
						throw new Exception("Could not parse: " + expr.value)
					}
					
					val gTimeoutDeclaration = gStatechart.createChild(statechartDefinition_TimeoutDeclarations, timeoutDeclaration)	 as TimeoutDeclaration
				
					gTimeoutDeclaration.name = "timeout_" + gStatechart.timeoutDeclarations.size
				
					val gSetTimeoutAction = gStateNode.createChild(state_EntryActions, setTimeoutAction) as SetTimeoutAction
					gSetTimeoutAction.timeoutDeclaration = gTimeoutDeclaration
					
								
						
					gSetTimeoutAction.time = gTimeSpecification
					
					val gTrigger = gTransition.createChild(transition_Trigger, eventTrigger)
					val gTmeoutEventReference = gTrigger.createChild(eventTrigger_EventReference, timeoutEventReference) as TimeoutEventReference
				
					gTmeoutEventReference.timeout = gTimeoutDeclaration
			
					createOnetToManyTrace(match.transition.trigger.head, #[gTimeoutDeclaration, gSetTimeoutAction, gTrigger])
				} catch (Exception e){
					this.masseges += "invalid element: " + match.event.humanName + ", falling back to opaque trigger\n" + " reason: " + e.message
					
					val gTrigger = gTransition.createChild(transition_Trigger, opaqueTrigger) as OpaqueTrigger => [
						it.trigger =  "after(" + expr.value.fomratName + ")";
					]
				
					createTrace(mdTransition.trigger.head, gTrigger)
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
		
		createTrace(mdTransition.trigger.head, gEventTrigger)
	].build
	
	val anyTriggerRule = createRule(anyEventTriggers).action[match |
		val mdTransition = match.transition
		val gTransition = match.GTransition
		
		val gAnyTrigger = gTransition.createChild(transition_Trigger, anyTrigger)
		
		createTrace(mdTransition.trigger.head, gAnyTrigger)
	].build
	
	val opaqueTriggerRule = createRule(opaqueTriggers).action[match |
		val mdTransition = match.transition
		val gTransition = match.GTransition
		
		if (match.trigger.name !== null && match.trigger.name != ""){
			val gOpaqueTrigger = gTransition.createChild(transition_Trigger, opaqueTrigger) as OpaqueTrigger => [
				it.trigger = if (match.trigger.event !== null) match.trigger.event.name.fomratName else match.trigger.name.fomratName 
			]
			
			createTrace(mdTransition.trigger.head, gOpaqueTrigger);
		}

	].build
	
	val guardRule = createRule(guardsInStateMachine).action[match |
		val gTranistion = match.transition.pairs.head
		val guardString = match.body

		val guardExpr = gTranistion.createChild(transition_Guard, opaqueExpression) as OpaqueExpression => [
			it.expression = guardString.fomratName
		]
		
		createManyToManyTrace(#[match.transition, match.opaqueExpression], #[gTranistion, guardExpr])
	].build
	
	val actionRule = createRule(actionsOnTransitions).action[match | 
		val mdTransition = match.transition
		val body = match.body
		
		val gTransition = mdTransition.pairs.head
		
		val gAction = gTransition.createChild(transition_Effects, expressionStatement)
		gAction.createChild(expressionStatement_Expression, opaqueExpression) as OpaqueExpression => [
			it.expression = body
		]
		
		createManyToManyTrace(#[mdTransition, match.effect],  #[gAction])
	].build
	
	val entryActionRule = createRule(entryActions).action[match |
		val mdState = match.state
		val body = match.body
		
		val gState = mdState.pairs.head
		
		val gAction = gState.createChild(state_EntryActions, expressionStatement)
		
		gAction.createChild(expressionStatement_Expression, opaqueExpression) as OpaqueExpression => [
			it.expression = body
		]
		
		createManyToManyTrace(#[mdState, match.effect],  #[gAction])
	].build
	
	val exitActionRule = createRule(exitActions).action[match |
		val mdState = match.state
		val body = match.body
		
		val gState = mdState.pairs.head
		
		val gAction = gState.createChild(state_ExitActions, expressionStatement)
		
		gAction.createChild(expressionStatement_Expression, opaqueExpression) as OpaqueExpression => [
			it.expression = body
		]
		
		createManyToManyTrace(#[mdState, match.effect],  #[gAction])
	].build
	
//	val doActionRule = createRule(doActions).action[match |
//		val mdState = match.state
//		val body = match.body
//		
//		val gState = mdState.pairs.head
//		
//		val gAction = gState.createChild(state_EntryActions, expressionStatement)
//		
//		gAction.createChild(expressionStatement_Expression, opaqueExpression) as OpaqueExpression => [
//			it.expression = body
//		]
//		
//		createManyToManyTrace(#[mdState, match.effect],  #[gAction])
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
