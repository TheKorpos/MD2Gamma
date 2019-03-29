package hu.bme.mit.magicdraw2gamma.plugin.transformation

import com.nomagic.magicdraw.core.Application
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine
import hu.bme.mit.gamma.statechart.model.StatechartDefinition
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory
import hu.bme.mit.magicdraw2gamma.plugin.transformation.batch.MagicdrawToGammaTransformer
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory
import java.util.Collection
import java.util.HashSet
import javax.swing.JFileChooser
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions
import org.eclipse.viatra.query.runtime.emf.EMFScope
import java.io.File

class StateMachineTransformer {
	
	private def packageName(StateMachine c){
		c.qualifiedName.substring(0, c.qualifiedName.lastIndexOf("::")).replace("::", ".").toLowerCase
	}
	
	private def toFilePath(String s){
		s.replace(".", File.separator)
	}
	
	def void transform(Collection<Class> statechartDefinitions, ResourceSet resourceSet) {
			
		val mdSet = statechartDefinitions.map[it.ownedBehavior].flatten.filter(StateMachine).toSet
 		val traceRoot = TraceFactory.eINSTANCE.createMD2GTrace
 		val gSet = new HashSet<hu.bme.mit.gamma.statechart.model.Package>()
 		
		mdSet.forEach[ stmt |
			val gStatechart = StatechartModelFactory.eINSTANCE.createStatechartDefinition
			val trace = TraceFactory.eINSTANCE.createTrace
			
			val packageString = stmt.packageName
			val gPackage = StatechartModelFactory.eINSTANCE.createPackage => [
				it.name = packageString
			]
			
			gPackage.components += gStatechart
			
			gStatechart.name = stmt.name
			trace.source += stmt
			trace.target += gStatechart
			traceRoot.traces += trace
			gSet.add(gPackage)
		]
		
		val all = new HashSet<EObject>();
		all += mdSet
		all += gSet
		all += traceRoot
	

		val options = new BaseIndexOptions()
		val scope = new EMFScope(all, options)
		
		val engine = ViatraQueryEngine.on(scope);
		
		val  tra = new MagicdrawToGammaTransformer(engine, traceRoot)
		
		tra.execute()
		
		val rs = new ResourceSetImpl();
		

		val filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	
		
		val state = filechooser.showSaveDialog(Application.getInstance().getMainFrame());
		
		if (state == JFileChooser.APPROVE_OPTION) {
			
			val selectedFile = filechooser.getSelectedFile();
			
			gSet.filter(hu.bme.mit.gamma.statechart.model.Package).forEach[
				
				val statechartDef = it.components.filter(StatechartDefinition).head
				
				val r = rs.createResource(URI.createFileURI(
					selectedFile.absolutePath + File.separator + toFilePath(it.name) + File.separator + statechartDef.name + ".gsm"
				))
				
				r.contents += it
				r.save(null)	
			]
			
		}
	}
}
 