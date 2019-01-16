package hu.bme.mit.magicdraw2gamma.plugin.trafos

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartTrace
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace
import org.eclipse.emf.ecore.EObject
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import hu.bme.mit.magicdraw2gamma.plugin.queries.VertexTrace
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionTrace
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition
import hu.bme.mit.magicdraw2gamma.plugin.queries.TransitionTrace
import java.util.Optional
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateTrace
import java.util.Collection

class Tracer {
	
	val ViatraQueryEngine engine
	val MD2GTrace root;
	
	new (MD2GTrace root, ViatraQueryEngine engine){
		this.engine = engine
		this.root = root;
	}
	
	public def createTrace(EObject source, EObject target){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += target
		root.traces += ret
	}
	
	public def createOnetToManyTrace(EObject source, Collection<EObject> targets){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += targets
		root.traces += ret
	}
	
	public def createManyToManyTrace(Collection<EObject> source, Collection<EObject> targets){
		val ret = TraceFactory.eINSTANCE.createTrace
		ret.source += source
		ret.target += targets
		root.traces += ret
	}
	
	
	public def trace(StateMachine stmt){
		val matcher = StatechartTrace.instance.getMatcher(engine)
		val topMatch = matcher.getAllMatches(stmt, null).head
		if (topMatch !== null) return Optional.of(topMatch.target);
		return Optional.empty
	}
	
	public def trace(Region region){
		val matcher = RegionTrace.instance.getMatcher(engine)
		val topMatch = matcher.getAllMatches(region, null).head
		if (topMatch !== null) return Optional.of(topMatch.target);
		return Optional.empty
	}
	
	public def trace(com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State state){
		val matcher = StateTrace.instance.getMatcher(engine)
		val topMatch = matcher.getAllMatches(state, null).head
		if (topMatch !== null) return Optional.of(topMatch.target);
		return Optional.empty
	}
	
	public def trace(Transition transition){
		val matcher = TransitionTrace.instance.getMatcher(engine)
		val topMatch = matcher.getAllMatches(transition, null).head
		if (topMatch !== null) return Optional.of(topMatch.target);
		return Optional.empty
	}
	
	
	public def trace(Vertex vertex){
		val matcher = VertexTrace.instance.getMatcher(engine)
		val topMatch = matcher.getAllMatches(vertex, null).head
		if (topMatch !== null) return Optional.of(topMatch.target);
		return Optional.empty
	}	
}