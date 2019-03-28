package hu.bme.mit.magicdraw2gamma.plugin.transformation.eventdriven

import com.nomagic.magicdraw.core.Application
import com.nomagic.magicdraw.core.options.ProjectOptions
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator
import hu.bme.mit.magicdraw2gamma.plugin.transformation.queries.TransformableStateMachine
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation

class Test {



    /* Transformation-related extensions */
    extension EventDrivenTransformation transformation
    
    /* Transformation rule-related extensions */
    extension EventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine
    protected Resource resource
    protected ResourceSet resourceSet;
    protected MD2GTrace traceModel;
    
    extension StatechartModelFactory statechartModelFactory = StatechartModelFactory.eINSTANCE;
    extension TraceFactory traceFactory = TraceFactory.eINSTANCE

    new(ViatraQueryEngine engine, ResourceSet resourceSet) {
        this.engine = engine
     	this.resourceSet = resourceSet;
        createTransformation
        
        
        val file = new File(gammaWorkspaceDir + ".tracemodel.md2g");
        var Resource traceResource;
        
         if (!file.exists){
         	this.traceModel = createMD2GTrace
        	traceResource = resourceSet.createResource(URI.createFileURI(file.absolutePath)) 
	        traceResource.contents += this.traceModel
	        traceResource.save(null)
        } else {
        	traceResource = resourceSet.getResource(URI.createFileURI(file.absolutePath), true)
        	this.traceModel =  traceResource.contents.head as MD2GTrace
        }      
    }
    
    def gammaWorkspaceDir(){
    	Application.instance.project.options.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,
						GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID
					).valueStringRepresentation
	}

    public def execute() {
        transformation.executionSchema.startUnscheduledExecution
    }

    private def createTransformation() {
        //Initialize model manipulation API
        this.manipulation = new SimpleModelManipulations(engine)
        //Initialize event-driven transformation
        transformation = EventDrivenTransformation.forEngine(engine).addRule(stateMachineRule)
            //.addRule(exampleRule)
            .build
    }
    
    
    private def qualifierToResourcePath(String qualifiedName){
    	gammaWorkspaceDir + File.separator + qualifiedName.replace("::", File.separator) + ".gsm"
    	gammaWorkspaceDir.toLowerCase  
    }
    
    private val stateMachineRule = createRule(TransformableStateMachine.instance)
    	.action(CRUDActivationStateEnum.CREATED)[
    		try{
    			val stmt = it.stateMachine
    			val qualifiedName = stmt.qualifiedName
	    		
	    		val resource = resourceSet.createResource(URI.createFileURI(qualifierToResourcePath(qualifiedName)))
	    	
	    		val name = it.stateMachine.name
	    		
	    		val statechartDefinition = createStatechartDefinition => [
	    			it.name = name
	    		]
	    		
	    		val gammaPackage = createPackage => [ it.name = "test"]
	    		
	    		gammaPackage.components += statechartDefinition
	    		
	    		resource.contents += gammaPackage
	    		
	    		resource.save(null);
	    		
	    		val trace = createTrace => [
	    			it.source += stmt
	    			it.target += statechartDefinition
	    		]
	    		
	    		traceModel.traces += trace
	    		
    		} catch(Exception e) {
    			e.printStackTrace
    		}
    	]
    	 .action(
            CRUDActivationStateEnum.UPDATED) [
          
        ]
        .action(
            CRUDActivationStateEnum.DELETED) [
            	try{
            		val stmt = it.stateMachine
	            	val qualifiedName = stmt.qualifiedName
	            	val resource = resourceSet.getResource(URI.createFileURI(qualifierToResourcePath(qualifiedName)), true)
            		resource.delete(null)
            	} catch (Exception e){
            		e.printStackTrace
            	}
        ]
        .addLifeCycle(Lifecycles.getDefault(true, true)).build
    
    


    // Dispose model transformation
    def dispose() {
        if (transformation != null) {
            transformation.dispose
        }
        transformation = null
        return
    }
}
