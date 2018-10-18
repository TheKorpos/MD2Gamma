package hu.bme.mit.magicdraw2gamma.plugin.trafos

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.SignalEvent
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.FinalState
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.StateNode
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.gamma.statechart.model.Transition
import hu.bme.mit.gamma.statechart.model.interface_.Event
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.OwnedTransitions
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.Triggers
import java.util.List
import java.util.Map
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import hu.bme.mit.magicdraw2gamma.plugin.queries.Signals

class MagicDrawToGammaTransformation {
  
    /* Transformation-related extensions */
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine
    
    val f = StatechartModelFactory.eINSTANCE
    
    /** VIATRA Query Pattern Group */
    val extension StatechartDefinitions statechartDefinitions = StatechartDefinitions.instance
    
    val Map<Element, StatechartDefinition> gammaStateDefs = Maps.newHashMap
    val Map<Element, Region> gammaRegions = Maps.newHashMap
    val Map<Element, StateNode> gammaStateNode = Maps.newHashMap
	val Map<Element, Transition> gammaTransitions = Maps.newHashMap
	val Map<Element, Event> gammaEvents = Maps.newHashMap
	
	hu.bme.mit.gamma.statechart.model.Package statechartsPackage
	
    val List<Element> processedRegions = Lists.newArrayList
    val List<Element> unProcessedRegions = Lists.newArrayList
    
    val defInterface = InterfaceFactory.eINSTANCE.createInterface
    
    /** Rules */
    val statechartDefinitionCreationRule = createRule.precondition(statechartDefinitions).action[ match |
    	
    	val statechartDef = f.createStatechartDefinition
    	//TODO: this port and iterface should be removed once composite features are added
    	val defPort = f.createPort
    		
    	val interFaceRealization = f.createInterfaceRealization
    
    	defPort.name = "PlaceHolderPort"
    	
    	interFaceRealization.interface = defInterface
    	defPort.interfaceRealization = interFaceRealization
    	statechartDef.ports += defPort
    	
    	gammaStateDefs.put(match.statechartDefinition, statechartDef);
    	statechartsPackage.components += statechartDef
    	
    ].build
    
    val mainRegionsCreationRule = createRule.precondition(MainRegions.instance).action[match |
    	val region = f.createRegion
    	region.name = match.region.name
    	gammaRegions.put(match.region, region);
    	gammaStateDefs.get(match.statechartDefinition).regions += region
    	processedRegions += match.region
    ].build
    
    val statesInRegionsCreationRule = createRule.precondition(StatesInRegions.instance).action[match |
    	val vertex = match.vertex
    	var StateNode statenode
    	if (vertex instanceof State) statenode = f.createState
    	if (vertex instanceof Pseudostate) statenode = f.createInitialState
    	if (vertex instanceof FinalState){ 
    		statenode = f.createState
    		statenode.name = "FinalState"
    	}
    	if (processedRegions.contains(match.region)) {
    		gammaRegions.get(match.region).stateNodes += statenode
    	} else {
    		if (!unProcessedRegions.contains(match.region)){
    			val region = f.createRegion
    			region.name = match.region.name
    			unProcessedRegions.add(match.region);
    			gammaRegions.put(match.region, region);
    		}
    		
    		gammaRegions.get(match.region).stateNodes += statenode
    	}
    	
    	statenode.name = vertex.name
    	gammaStateNode.put(match.vertex, statenode)
    	
    ].build
    
    val transitionsCreationRule = createRule.precondition(OwnedTransitions.instance).action[match |
    	val mdStatechartDef = match.stmt
    	val gammaStatechartDef = gammaStateDefs.get(mdStatechartDef)
    	val tra = f.createTransition
    	val source = match.transition.source
    	val target = match.transition.target
    	tra.sourceState = gammaStateNode.get(source)
    	tra.targetState = gammaStateNode.get(target)
    	gammaStatechartDef.transitions += tra
    	gammaTransitions.put(match.transition, tra)
    ].build
        
    val triggerCreationRule = createRule.precondition(Triggers.instance).action[match | 
    	val mdTra = match.transition
    	val mdTrigger = match.trigger
    	val tra = gammaTransitions.get(mdTra)
    	
    	val mdTriggerEvent = mdTrigger.event
    	
    	if (mdTriggerEvent instanceof SignalEvent){
    		val mdSignalEvent = mdTriggerEvent as SignalEvent
    		//mdSignalEvent.signal
    		//mdSignalEvent.signal
    		val gammaEvent = gammaEvents.get(mdSignalEvent.signal)
    		val gammaEventTrigger = f.createEventTrigger
    		tra.trigger = gammaEventTrigger
    		
    		val portEventReference = f.createPortEventReference
			portEventReference.event = gammaEvent
			    		
    		gammaEventTrigger.eventReference = portEventReference
    	}
    	
    ].build

    new(ViatraQueryEngine engine) {
        this.engine = engine
        createTransformation
    }
    
    private def processRemainingRegions(){
    	val matcher = RegionsInStates.instance.getMatcher(engine)
    	
    	unProcessedRegions.stream.forEach[r |
    		
    		val match = matcher.newEmptyMatch
    		match.set("region", r);
    		matcher.getAllMatches(match).forEach[
    			m |
    			val stateNode = gammaStateNode.get(m.state);
    			(stateNode as hu.bme.mit.gamma.statechart.model.State).regions += gammaRegions.get(r)
    		]
    	]
    	
    }

    public def execute() {
    	// Fire the defined rules here
    	statechartsPackage = f.createPackage
    	statechartsPackage.name = "statecharts"
    	
    	//create dummy interface for all events
    	
    	defInterface.name = "IPlaceHolder"
    	
    	//and just collect all used signals and add them to every statechart
    	engine.getMatcher(Signals.instance).forEachMatch([m | 
    		val event = InterfaceFactory.eINSTANCE.createEvent
    		event.name = m.signal.name
    		val eventDecl = InterfaceFactory.eINSTANCE.createEventDeclaration
    		eventDecl.event = event
    		defInterface.events += eventDecl
    		gammaEvents.put(m.signal, event)
    	])
    	
    	statechartsPackage.interfaces += defInterface
    	
    	statechartDefinitionCreationRule.fireAllCurrent
    	mainRegionsCreationRule.fireAllCurrent
    	statesInRegionsCreationRule.fireAllCurrent
    	processRemainingRegions()
    	transitionsCreationRule.fireAllCurrent
    	triggerCreationRule.fireAllCurrent
    }

    private def createTransformation() {
        //Create VIATRA model manipulations
        this.manipulation = new SimpleModelManipulations(engine)
        //Create VIATRA Batch transformation
        transformation = BatchTransformation.forEngine(engine).build
        //Initialize batch transformation statements
        statements = transformation.transformationStatements
    }
    
    def getStatechartDefs(){
    	gammaStateDefs
    }
    
    def getStatechartsPackage(){
    	statechartsPackage
    }

    def dispose() {
        transformation = null
        return
    }
}
