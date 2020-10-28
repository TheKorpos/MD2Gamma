package hu.bme.mit.md2g.transformation.backannotation;


import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

import hu.bme.mit.gamma.statechart.interface_.Component;
import hu.bme.mit.gamma.trace.model.ExecutionTrace;
import hu.bme.mit.md2g.transformation.TraceModelManager;
import hu.bme.mit.md2g.util.profile.Gamma;

public class MDBackAnnotator {
	
	private ExecutionTrace executionTrace;
	private Package workspace;
	private Project project;

	public MDBackAnnotator(Package mdPackage, ExecutionTrace gammaTrace) {
		this.executionTrace = gammaTrace;
		this.workspace = mdPackage;
		project = Project.getProject(workspace);
	}
	
	public void executeInSession(TraceModelManager manager) {
		
		SessionManager.getInstance().executeInsideSession(project, "Creating trace model", () -> {
			
			Package tracePackage = project.getElementsFactory().createPackageInstance();
			tracePackage.setOwner(getOrCreateTracesPackage());
			tracePackage.setName(executionTrace.getName());
			
			Class backAnnot = project.getElementsFactory().createClassInstance();
			StereotypesHelper.addStereotype(backAnnot, Gamma.getInstance(project).getExecutionTrace());
			backAnnot.setOwner(tracePackage);
			backAnnot.setName(executionTrace.getName());
			
			Component component = executionTrace.getComponent();
			
//			Set<NamedElement> tracedComponents = manager.g2md(component);
//			
//			if (!tracedComponents.isEmpty()) {
//				Gamma.ExecutionTrace.setComponent(backAnnot, tracedComponents.iterator().next());
//			}
		});
	}
	
	private Package getOrCreateTracesPackage() {
		
		return workspace.getOwnedElement().stream().filter(Package.class::isInstance).map(Package.class::cast)
				.filter(it -> "_Traces".equals(it.getName())).findFirst().orElseGet(() -> {
					Package newPackage = project.getElementsFactory().createPackageInstance();
					newPackage.setName("_Traces");
					newPackage.setOwner(workspace);
					return newPackage;
				});
	}
	
	

}
