package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.Gamma;

public class ScheduleAct extends ActObject {

	public ScheduleAct(Project project, String name) {
		super(project, name);
	}

	@Override
	protected Stereotype getStereotype() {
		return Gamma.getInstance(project).getComponentSchedule();
	}

}
