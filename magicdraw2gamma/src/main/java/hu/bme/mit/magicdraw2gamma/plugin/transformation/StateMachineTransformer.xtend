package hu.bme.mit.magicdraw2gamma.plugin.transformation

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import hu.bme.mit.gamma.statechart.model.Package
import hu.bme.mit.gamma.statechart.model.RealizationMode
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.plugin.transformation.batch.MagicdrawToGammaTransformer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import java.util.Collection
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions
import org.eclipse.viatra.query.runtime.emf.EMFScope

class StateMachineTransformer {
	
	extension NameFormatter formatter = new NameFormatter
	
	//input
	val Set<Class> mdSet 
		
	//initializing traceroot
 	val traceRoot = TraceFactory.eINSTANCE.createMD2GTrace
 		
 	//output
 	val gSet = new HashSet<Package>()
 	
 	val ResourceSet resourceSet
 	
	new(Collection<Class> statechartDefinitions, ResourceSet resourceSet) {
		this.resourceSet = resourceSet
		this.mdSet = statechartDefinitions.toSet
	}
			
	def transform() {
		
		//prepare simple statemacines
		mdSet.filter[it instanceof StateMachine].forEach[
			
			val mdStatemachine = it as StateMachine
			
			val gStatechart = StatechartModelFactory.eINSTANCE.createStatechartDefinition => [
				it.name = mdStatemachine.name.fomratName
			]
			
			//createPackage for statechart
			val gPackage = StatechartModelFactory.eINSTANCE.createPackage => [
				it.name = mdStatemachine.name.toLowerCase.fomratName
				it.components += gStatechart
			]
			
			gSet.add(gPackage)
			
			prepareStateMachine(mdStatemachine, gPackage, gStatechart)
		]
			
		//prepared block with classifier behavior	
		mdSet.filter[it.classifierBehavior instanceof StateMachine].forEach[
			val mdBlock = it
			val stmt = it.classifierBehavior as StateMachine
			
			//create interface for operations and receptions
			val gInterface = InterfaceFactory.eINSTANCE.createInterface => [
				it.name = "Block_Interface_For" + mdBlock.name.fomratName
			]
			
			//createStatechart
			val gStatechart = StatechartModelFactory.eINSTANCE.createStatechartDefinition => [
				it.name = stmt.name
				it.ports += StatechartModelFactory.eINSTANCE.createPort => [
					it.name = "Block_Port"
					it.interfaceRealization = StatechartModelFactory.eINSTANCE.createInterfaceRealization => [
						it.realizationMode = RealizationMode.PROVIDED
						it.interface = gInterface
					]
				]
			]
			
			val operationsInterfaceTrace = TraceFactory.eINSTANCE.createInterfaceTrace => [
				it.source += mdBlock
				it.target += gInterface
			]
			
			//createTrace					
			val trace = TraceFactory.eINSTANCE.createTrace =>[
				it.source += mdBlock
				it.target += gStatechart
			]
			
			//createPackage for statechart
			val gPackage = StatechartModelFactory.eINSTANCE.createPackage => [
				it.name = mdBlock.name.toLowerCase.fomratName
				it.components += gStatechart
				it.interfaces += gInterface
			]
			
			prepareStateMachine(stmt, gPackage, gStatechart)
			
	
			traceRoot.traces += #[trace, operationsInterfaceTrace]
			gSet.add(gPackage)
		]
		
		//making a scope for the transformation
		val all = new HashSet<EObject>();
		all += mdSet
		all += gSet
		all += traceRoot
	
		val options = new BaseIndexOptions()
		val scope = new EMFScope(all, options)
		
		InterfacePackage.eINSTANCE.nsURI
		
		//initialize engine on the scope	
		val engine = ViatraQueryEngine.on(scope);
		
		val tracer = new Tracer(traceRoot, engine)
		
		
		//create transformers
		val  tra = new MagicdrawToGammaTransformer(engine, tracer)
		
	
		//execute statechart transformer
		tra.execute
		
	
		
		return  #{"output" -> gSet, "messages" -> tra.message}
	}
	
	private def prepareStateMachine(StateMachine mdStateMachine, Package gPackage, StatechartDefinition gStatechart){
		
		val gInterface = InterfaceFactory.eINSTANCE.createInterface => [
			it.name = "StateMachine_Interface_For_" + mdStateMachine.name.fomratName 			
		]
		
		gStatechart => [
		
			it.ports += StatechartModelFactory.eINSTANCE.createPort => [
				it.name = "StateMachine_Port"
				it.interfaceRealization = StatechartModelFactory.eINSTANCE.createInterfaceRealization => [
					it.realizationMode = RealizationMode.PROVIDED
					it.interface = gInterface
				]
			]
		]
	
		//create trace for interface	
		val operationsInterfaceTrace = TraceFactory.eINSTANCE.createInterfaceTrace => [
			it.source += mdStateMachine
			it.target += gInterface
		]
		
		
		//create trace for the statemachine					
		val trace = TraceFactory.eINSTANCE.createTrace =>[
			it.source += mdStateMachine
			it.target += gStatechart
			
		]
		
		
		
		gPackage.interfaces += gInterface
	
		traceRoot.traces += #[trace, operationsInterfaceTrace]	
	}
}
 