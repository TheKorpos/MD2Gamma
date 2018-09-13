package com.incquerylabs.magicdraw.plugin.example.trafos

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import com.incquerylabs.magicdraw.plugin.example.queries.DeduciblePortType
import com.incquerylabs.magicdraw.plugin.example.queries.BlockWithStateMachine
import com.google.common.collect.Lists
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import java.util.List
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import java.util.Collection

class FullModelBatchTransformation {

    /* Transformation-related extensions */
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine
    
    /** VIATRA Query Pattern Group */
    val extension BlockWithStateMachine deduciblePortType = BlockWithStateMachine.instance
    
    val List<StatechartDefinition> gammaStateDefs = Lists.newArrayList
    
    /** Rules */
    val portTypeCorrectorRule = createRule.precondition(deduciblePortType).action[
    	
    	val stateDef = StatechartModelFactory.eINSTANCE.createStatechartDefinition
    	gammaStateDefs += stateDef
    	
    ].build

    new(ViatraQueryEngine engine) {
        this.engine = engine
        createTransformation
    }

    public def execute() {
    	// Fire the defined rules here
    	portTypeCorrectorRule.fireAllCurrent
    }

    private def createTransformation() {
        //Create VIATRA model manipulations
        this.manipulation = new SimpleModelManipulations(engine)
        //Create VIATRA Batch transformation
        transformation = BatchTransformation.forEngine(engine).build
        //Initialize batch transformation statements
        statements = transformation.transformationStatements
    }
    
     public def Collection<StatechartDefinition> getStateChartDefinitions(){
    	gammaStateDefs
    }
    

    def dispose() {
        transformation = null
        return
    }
}
