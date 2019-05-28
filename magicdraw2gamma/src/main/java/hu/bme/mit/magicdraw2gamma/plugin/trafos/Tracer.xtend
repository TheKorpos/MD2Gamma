package hu.bme.mit.magicdraw2gamma.plugin.trafos

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.Trace
import hu.bme.mit.magicdraw2gamma.plugin.queries.TransitionTrace
import hu.bme.mit.magicdraw2gamma.plugin.queries.VertexTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage
import java.util.Collection
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import hu.bme.mit.gamma.statechart.model.StateNode
import java.util.Set
import hu.bme.mit.gamma.statechart.model.StatechartDefinition

class Tracer {
	
	val ViatraQueryEngine engine
	val MD2GTrace root;
	
	extension TracePackage tracePackage = TracePackage.eINSTANCE
	
	new (MD2GTrace root, ViatraQueryEngine engine){
		this.engine = engine
		this.root = root;
		nsURI
	}
	
	def createTrace(EObject source, EObject target){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += target
		root.traces += ret
	}
	
	def createOnetToManyTrace(EObject source, Collection<EObject> targets){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += targets
		root.traces += ret
	}
	
	def createManyToManyTrace(Collection<EObject> source, Collection<EObject> targets){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += targets
		root.traces += ret
	}
	
	
	def genericPair(Class mdClass){
		Trace.Matcher.on(engine).getAllValuesOftarget(mdClass)
	}
	
	def  Set<StatechartDefinition> pairs(StateMachine stateMachine){
		StatechartTrace.Matcher.on(engine).getAllValuesOftarget(stateMachine)
	}
	
	def  Set<StateNode> pairs(Vertex state){
		VertexTrace.Matcher.on(engine).getAllValuesOftarget(state)
	}
	
	def  Set<hu.bme.mit.gamma.statechart.model.Region> pairs(Region region){
		RegionTrace.Matcher.on(engine).getAllValuesOftarget(region)
	}
	
	
	def  Set<hu.bme.mit.gamma.statechart.model.Transition> pairs(Transition transition){
		TransitionTrace.Matcher.on(engine).getAllValuesOftarget(transition)
	}
	
	def createInterfaceTrace(EObject source, EObject target){
		val ret = TraceFactory.eINSTANCE.createInterfaceTrace
		ret.source += source
		ret.target += target
		root.traces += ret
	}
}