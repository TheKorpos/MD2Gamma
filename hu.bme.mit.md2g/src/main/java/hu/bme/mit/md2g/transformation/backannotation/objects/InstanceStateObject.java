package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.Gamma;

public abstract class InstanceStateObject extends TraceFactory{

	private String name;

	protected InstanceStateObject(Project project, String name) {
		super(project);
		this.name = name;
	}

	@Override
	protected String getName() {
		return name;
	}
}
