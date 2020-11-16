package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.Gamma;

public class RaiseEventActObject extends ActObject {

	private Activity activity;

	public RaiseEventActObject(Project project, String name, Activity activity) {
		super(project, name);
		this.activity = activity;
	}

	@Override
	protected Stereotype getStereotype() {
		return Gamma.getInstance(project).getRaiseEventAct();
	}
	
	@Override
	public Class createObject() {
		Class object = super.createObject();
		
		object.setClassifierBehavior(activity);
		activity.setOwner(object);
		
		return object;
	}
}
