package hu.bme.mit.magicdraw2gamma.plugin.transformation

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Parameter
import hu.bme.mit.gamma.constraint.model.ConstraintModelFactory
import hu.bme.mit.gamma.statechart.model.interface_.EventDirection
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import java.util.Collection

class InterfaceTransformer {
	
	protected extension InterfaceFactory interfaceFactory = InterfaceFactory.eINSTANCE
	protected extension ConstraintModelFactory constraintModelFactory = ConstraintModelFactory.eINSTANCE
	protected extension Tracer tracer;
	
	val Collection<Class> mdClasses
	
	new(Collection<Class> mdClasses, Tracer tracer){
		this.mdClasses = mdClasses
		this.tracer = tracer
	}
	
	def transform(){
			
		mdClasses.forEach[
			transform(it)
		]
	}
	
	private def transform(Class mdClass){
			
		//create interface
		val gInterface = createInterface => [
			it.name = "I" + mdClass.name
		]
		
		// collect operations
		val mdOperations = mdClass.ownedOperation
		
		//translate operations
		mdOperations.forEach[
			val mdOperation = it
			
			val gEvent = createEvent => [
				it.name = "operationCall_" + mdOperation.name
			]
			
			
			mdOperation.ownedParameter.forEach[
				
				val mdParameter = it
				
				gEvent.parameterDeclarations += createParameterDeclaration => [
					it.name = mdParameter.name
					it.type = mdParameter.transformParameterType
				]
			]
			
			gInterface.events += createEventDeclaration => [
				it.event = gEvent
				it.direction = EventDirection.IN
			]
			
			
			createOnetToManyTrace(mdOperation, #[gInterface, gEvent])
		]
		
		val mdSignalReceptions = mdClass.ownedReception
		
		mdSignalReceptions.forEach[
			val mdReception = it
			
			val gEvent = createEvent => [
				it.name = "singalReceptionCall_" + mdReception.name
			]
			
			gInterface.events += createEventDeclaration => [
				it.event = gEvent
				it.direction = EventDirection.IN
			]
		]
		
		return gInterface
	}
	
	private def transformParameterType(Parameter parameter){
		val typeName = parameter.type.name
		switch(typeName){
			case "Integer": return createIntegerTypeDefinition
			default: throw new Exception(typeName + " type not supported")
		}
		
	}
}