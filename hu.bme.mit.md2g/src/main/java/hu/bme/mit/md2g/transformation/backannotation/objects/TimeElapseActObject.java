package hu.bme.mit.md2g.transformation.backannotation.objects;

import java.math.BigInteger;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.Gamma;

public class TimeElapseActObject extends ActObject {

	private BigInteger time;

	public TimeElapseActObject(Project project, String name, BigInteger time) {
		super(project, name);
		this.time = time;
	}

	@Override
	protected Stereotype getStereotype() {
		return Gamma.getInstance(project).getTimeElapse();
	}
	
	@Override
	public Class createObject() {
		Class object = super.createObject();
		
		Gamma.TimeElapse.setValue(object, time.intValue());
		
		return object;
	}

}
