package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

public abstract class ActObject extends TraceFactory {

	private String name;

	protected ActObject(Project project, String name) {
		super(project);
		this.name = name;
	}


	@Override
	protected String getName() {
		return name;
	}
}
