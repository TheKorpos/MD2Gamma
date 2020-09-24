package hu.bme.mit.md2g.transformation;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.ModelHelper;
import hu.bme.mit.md2g.util.profile.Gamma;


public class TraceModelCreator {
	
	private Map<EObject, NamedElement> traces;
	
	public TraceModelCreator(Map<EObject, NamedElement> traces) {
		this.traces = traces;
	}

	public void createWithoutSession(Class container, TreeIterator<EObject> treeIterator) {
		
		Project project = Project.getProject(container);
		
		treeIterator.forEachRemaining(elem -> {
			Resource resource = elem.eResource();
			String pathFragment = resource.getURIFragment(elem);
			
			if (traces.containsKey(elem)) {
				Property trace = project.getElementsFactory().createPropertyInstance();
				trace.setOwner(container);
				
				Stereotype traceStereotype = Gamma.getInstance(project).getMD2G_Trace();
				StereotypesHelper.addStereotype(trace, traceStereotype);
				Gamma.MD2G_Trace.setURIFragment(trace, pathFragment);
				NamedElement mdElement = traces.get(elem);
				ModelHelper.createTrace(trace, mdElement);
				trace.setName(mdElement.getQualifiedName());
			}
			
		});
	}

}
