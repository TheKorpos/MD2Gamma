package hu.bme.mit.magicdraw2gamma.plugin.transformation

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import hu.bme.mit.gamma.statechart.model.Package
import hu.bme.mit.gamma.statechart.model.RealizationMode
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.gamma.statechart.model.interface_.InterfaceFactory
import hu.bme.mit.magicdraw2gamma.plugin.trafos.Tracer
import hu.bme.mit.magicdraw2gamma.plugin.transformation.batch.MagicdrawToGammaTransformer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import java.io.File
import java.util.Collection
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions
import org.eclipse.viatra.query.runtime.emf.EMFScope
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage
import javax.swing.JOptionPane
import com.nomagic.magicdraw.core.Application

class StateMachineTransformer {
	
		
	private def packageName(StateMachine c){
		c.qualifiedName.substring(0, c.qualifiedName.lastIndexOf("::")).replace("::", ".").toLowerCase
	}
	
	private def toFilePath(String s){
		s.replace(".", File.separator)
	}
	
	def Set<Package> transform(Collection<Class> statechartDefinitions, ResourceSet resourceSet) {
		
		/*val p = new OCLParser;
		
		val name = JOptionPane.showInputDialog(Application.instance.mainFrame, "What's your name?");
		
		p.parse(statechartDefinitions.get(0), name);*/
		
		val mdSet = statechartDefinitions.toSet
 		val traceRoot = TraceFactory.eINSTANCE.createMD2GTrace
 		val gSet = new HashSet<Package>()
 		
 		//creating root elements
		statechartDefinitions.filter[it.classifierBehavior instanceof StateMachine].forEach[
			val mdBlock = it
			val stmt = it.classifierBehavior as StateMachine
			
			//create interface for operations and receptions
			val gInterface = InterfaceFactory.eINSTANCE.createInterface => [
				it.name = stmt.name + "_ClassInterface"
			]
			
			//createStatechart
			val gStatechart = StatechartModelFactory.eINSTANCE.createStatechartDefinition => [
				it.name = stmt.name
				it.ports += StatechartModelFactory.eINSTANCE.createPort => [
					it.name = stmt.name + "_ClassPort"
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
				it.source += stmt
				it.target += gStatechart
				
			]
			
			//createPackage for statechart
			val gPackage = StatechartModelFactory.eINSTANCE.createPackage => [
				it.name = stmt.packageName
				it.components += gStatechart
				it.interfaces += gInterface
			]
			
	
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
		
		
		return gSet
		
		
	}
}
 