package hu.bme.mit.magicdraw2gamma.plugin.trafos

import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateMachines
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import hu.bme.mit.gamma.statechart.model.Package
import hu.bme.mit.magicdraw2gamma.plugin.queries.SignalsInStateMachine
import hu.bme.mit.gamma.constraint.model.ConstraintModelFactory
import hu.bme.mit.gamma.constraint.model.Declaration
import hu.bme.mit.gamma.constraint.model.TypeDeclaration
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries

//This class is responsible for creating the interfaces required to store events
class InterfaceTransformer {

    /* Transformation-related extensions */
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation
    
    val extension SearchQueries searchQueries = SearchQueries.instance
    
    extension Tracer bakcTracer

    protected ViatraQueryEngine engine
    protected Resource resource
    
    val f = StatechartModelFactory.eINSTANCE
    val fi = InterfaceFactory.eINSTANCE
    val fc = ConstraintModelFactory.eINSTANCE
    
    private Package interfacePackage;

    new(ViatraQueryEngine engine) {
        this.engine = engine
        
        
        createTransformation
    }

    public def execute(ViatraQueryEngine targetModelEngine, MD2GTrace traceroot, Package interfacePackage) {
    	bakcTracer = new Tracer(traceroot, targetModelEngine);
		this.interfacePackage = interfacePackage;
		
//		interfaceRule.fireAllCurrent
//		eventsRule.fireAllCurrent
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
    
//	val interfaceRule = createRule.precondition(StateMachines.instance).action[match | 
//		val mdStatemachine = match.stateMachine
//		val statechartDef = mdStatemachine.trace
//		
//		if (statechartDef.present) {
//			val generatedInterface = fi.createInterface
//			 generatedInterface.name = "IGenerated" + statechartDef.get.name.toFirstUpper
//			 statechartDef.get.ports.filter["GeneratedPort".equals(it.name)].head.interfaceRealization.interface = generatedInterface
//			 interfacePackage.interfaces += generatedInterface
//		}
//	].build
//	
//	val eventsRule = createRule.precondition(SignalsInStateMachine.instance).action[match | 
//		val mdStatemachine = match.stateMachine
//		val statechartDef = mdStatemachine.trace
//		
//		//We only have 1 port at this point
//		val genPort = statechartDef.get.ports.head
//		val events = genPort.interfaceRealization.interface.events
//		var event = events.map[it.event].findFirst[it.name == match.signal.name]
//	
//		if (event === null){
//			event = fi.createEvent
//			event.name = match.signal.name
//			val eventDecl = fi.createEventDeclaration
//			eventDecl.direction = EventDirection.INOUT
//			eventDecl.event = event
//			genPort.interfaceRealization.interface.events += eventDecl
//			//.head.interfaceRealization.interface.events += eventDecl
//			createManyToManyTrace(#[mdStatemachine, match.signal], #[event, eventDecl])
//		}
//	].build

    def dispose() {
        transformation = null
        return
    }
}
