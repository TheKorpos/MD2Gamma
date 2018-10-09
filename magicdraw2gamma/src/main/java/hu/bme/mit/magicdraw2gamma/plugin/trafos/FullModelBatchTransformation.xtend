package hu.bme.mit.magicdraw2gamma.plugin.trafos

import com.google.common.collect.Maps
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element
import hu.bme.mit.gamma.statechart.model.Region
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import java.util.Map
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import java.util.List
import com.google.common.collect.Lists

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State
import hu.bme.mit.gamma.statechart.model.StateNode
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate

import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartDefinitions
import hu.bme.mit.magicdraw2gamma.plugin.queries.MainRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatesInRegions
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStates

class FullModelBatchTransformation {
 
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

    val List<Element> processedRegions = Lists.newArrayList
    val List<Element> unProcessedRegions = Lists.newArrayList
    
    /** Rules */
    val statechartDefinitionCreationRule = createRule.precondition(statechartDefinitions).action[ match |
    	val statechartDef = f.createStatechartDefinition
    	gammaStateDefs.put(match.statechartDefinition, statechartDef);
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
    	statechartDefinitionCreationRule.fireAllCurrent
    	mainRegionsCreationRule.fireAllCurrent
    	statesInRegionsCreationRule.fireAllCurrent
    	processRemainingRegions()
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

    def dispose() {
        transformation = null
        return
    }
}
