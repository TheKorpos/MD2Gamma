package hu.bme.mit.md2g.transformation.backannotation.objects;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;

import hu.bme.mit.md2g.util.profile.Gamma;

public class InstanceStateConstant extends InstanceStateObject {


	private State state;
	private Property part;

	public InstanceStateConstant(Project project, Property part, State state) {
		super(project, createName(part, state));
		this.part = part;
		this.state = state;
	}

	private static String createName(Property part2, State state2) {
		return part2.getName() + "." + state2.getName();
	}

	@Override
	protected Stereotype getStereotype() {
		return Gamma.getInstance(project).getInstanceStateConstant();
	}
	
	
	@Override
	public Class createObject() {
		Class object = super.createObject();
		
		Gamma.InstanceState.setReferencedPart(object, part);
		Gamma.InstanceStateConstant.setReferencedState(object, state);
		
		return object;
	}
}
