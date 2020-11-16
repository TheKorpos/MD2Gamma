package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.impl.ElementsFactory;

public abstract class TraceFactory {
	
	protected final Project project;
	
	protected TraceFactory(Project project) {
		this.project = project;
	}
	
	protected abstract Stereotype getStereotype();
	protected abstract String getName();
	
	public Class createObject() {
		Stereotype stereotype = getStereotype();
		ElementsFactory elementsFactory = project.getElementsFactory();
		Class createClassInstance = elementsFactory.createClassInstance();
		
		StereotypesHelper.addStereotype(createClassInstance, stereotype);
		createClassInstance.setName(getName());
		
		return createClassInstance;
	}
}
