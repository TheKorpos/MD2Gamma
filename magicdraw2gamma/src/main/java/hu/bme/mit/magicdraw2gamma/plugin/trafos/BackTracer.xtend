package hu.bme.mit.magicdraw2gamma.plugin.trafos

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace

class BackTracer {
	
	val ViatraQueryEngine engine
	val MD2GTrace root;
	
	new (MD2GTrace root, ViatraQueryEngine engine){
		this.root = root;
		this.engine = engine;
	}
}