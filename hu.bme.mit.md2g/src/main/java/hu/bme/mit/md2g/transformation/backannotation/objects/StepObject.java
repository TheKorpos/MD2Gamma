package hu.bme.mit.md2g.transformation.backannotation.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import hu.bme.mit.md2g.util.profile.Gamma;

public class StepObject extends TraceFactory {

	private Class traceModel;
	private int number;
	
	private List<ActObject> acts = new LinkedList<>();
	private List<InstanceStateObject> instanceStates = new LinkedList<>();
	private List<ActObject> out = new LinkedList<>();
	

	public StepObject(Project project, Class traceModel, int number) {
		super(project);
		this.traceModel = traceModel;
		this.number =  number;
	}

	@Override
	protected Stereotype getStereotype() {
		return Gamma.getInstance(project).getStep();
	}

	@Override
	protected String getName() {
		return Integer.toString(number);
	}

	public List<ActObject> getOut() {
		return out;
	}
	
	public List<ActObject> getActs() {
		return acts;
	}
	
	public List<InstanceStateObject> getInstanceStates() {
		return instanceStates;
	}
	
	private Class getOrCreateActGroup(Class parent, String name) {
		Optional<Class> maybeActions = parent.getOwnedElement().stream()
				.filter(Gamma::isActGroup).map(Class.class::cast).filter(c -> name.equals(c.getName())).findFirst();
		
		return  maybeActions.orElseGet(()  ->  {
			Class grp = project.getElementsFactory().createClassInstance();
			grp.setOwner(parent);
			grp.setName(name);
			StereotypesHelper.addStereotype(grp, Gamma.getInstance(project).getActGroup());
			return grp;
		});
	}
	
	private Class getOrCreateStateGroup(Class parent) {
		Optional<Class> maybeActions = parent.getOwnedElement().stream()
				.filter(el -> StereotypesHelper.hasStereotype(el, "StateGroup")).map(Class.class::cast).findFirst();
		
		return  maybeActions.orElseGet(()  ->  {
			Class grp = project.getElementsFactory().createClassInstance();
			grp.setOwner(parent);
			grp.setName("InstanceStates");
			StereotypesHelper.addStereotypeByString(grp, "StateGroup");
			return grp;
		});
	}
	
	@Override
	public Class createObject() {
		Class object = super.createObject();
		
		Class actions = null;
		
		if (!acts.isEmpty()) {
			actions =  getOrCreateActGroup(object, "Actions");
		}
		
		Class outputActions =  null;
		
		if (!out.isEmpty()) {
			outputActions =  getOrCreateActGroup(object, "OutEvents");
		}
		
		for (ActObject act: acts) {
			Class actClass = act.createObject();
			actClass.setOwner(actions);
		}
		
		for (ActObject raise: out) {
			Class raiseClass = raise.createObject();
			raiseClass.setOwner(outputActions);
		}
		
		for (InstanceStateObject state: instanceStates) {
			Class instanceStateClass = state.createObject();
			instanceStateClass.setOwner(getOrCreateStateGroup(object));
		}
		
		return object;
	}
}
