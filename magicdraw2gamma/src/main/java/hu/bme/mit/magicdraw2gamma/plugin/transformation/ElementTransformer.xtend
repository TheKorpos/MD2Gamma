package hu.bme.mit.magicdraw2gamma.plugin.transformation

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory

class ElementTransformer {
	
	extension StatechartModelFactory statechartModelFactory = StatechartModelFactory.eINSTANCE
	
	def transform(Region region){
		createRegion => [it.name = if (region.name == "")  "R_" + (region.objectParent as NamedElement).name else region.name]
	}
	
	def transform(State state){
		createEventTrigger.eventReference
		createState => [ it.name = state.name]
	}
}