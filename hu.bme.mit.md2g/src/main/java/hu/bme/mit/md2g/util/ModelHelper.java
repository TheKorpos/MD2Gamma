package hu.bme.mit.md2g.util;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Abstraction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.SysML;

public class ModelHelper {
	
	public static Package findNearesParentPackage(Element element) {
	
		element = element.getOwner();
		
		while (element != null && !(element instanceof Package)) {
			element = element.getOwner();
		}
		
		return element == null ? Application.getInstance().getProject().getPrimaryModel() : (Package) element;
	}
	
	
	public static Abstraction createTrace(NamedElement source, NamedElement target) {
		Project project = Project.getProject(source);
		Abstraction trace = project.getElementsFactory().createAbstractionInstance();
		Stereotype traceStereotype = SysML.getInstance(project).getTrace();
		StereotypesHelper.addStereotype(trace, traceStereotype);
		trace.getSupplier().add(target);
		trace.getClient().add(source);
		trace.setOwner(ModelHelper.findNearesParentPackage(source));
		
		return trace;
	}
}
