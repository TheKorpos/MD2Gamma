package hu.bme.mit.md2g.ui.browser.action;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Queue;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Constraint;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.OpaqueExpression;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Pseudostate;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.PseudostateKindEnum;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Region;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.State;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Transition;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
import com.nomagic.uml2.impl.ElementsFactory;

import hu.bme.mit.md2g.util.profile.Gamma;

public class StatechartGeneratorAction extends NMAction{

	private Package pack;
	private Project project;
	private ElementsFactory factory;
	
	int blockCount = 0;
	int statemachineCount = 0;
	private int regionCount = 0;
	private int initialCount = 0;
	private int stateCount = 0;
	private int guardCount = 0;
	private int transitionCount = 0;
	
	public StatechartGeneratorAction(Package pack)
	{
		super("GAMMA_STM_GEN", "Generate Statemachine", null, null);
		this.pack = pack;
		this.project = Project.getProject(pack);
		this.factory = project.getElementsFactory();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String configuration = pack.getName();
		SessionManager.getInstance().executeInsideSession(project, "Generating statechart", () -> {
			
			String[] confList  = configuration.split("-");
			
			int elemCount = Integer.parseInt(confList[0]);
			int chainLength = Integer.parseInt(confList[1]);
			
			Pseudostate initial = createBase(pack);
			
			Queue <Vertex> vertexQueue1 = new LinkedList<>();
			Queue <State> vertexQueue2 = new LinkedList<>();
			vertexQueue1.add(initial);
			
			while (elemCount > 0) {
				while (!vertexQueue1.isEmpty() && elemCount > 0) {
					Vertex current = vertexQueue1.poll();
					
					State next = extendChain(current);
					vertexQueue2.add(next);
					elemCount--;
					
					for (int i = 1; i < chainLength && elemCount > 0; i++) {
						next = extendChain(next);
						vertexQueue2.add(next);
						elemCount--;
					}
				}
				
				while(!vertexQueue2.isEmpty() && elemCount > 0) {
					State current = vertexQueue2.poll();
					Pseudostate next = extendDepth(current);
					vertexQueue1.add(next);
					elemCount--;
				}
			}
			
			Application.getInstance().getGUILog().log(getPrintableCounts());
		});
	}
	
	private String getPrintableCounts() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("initial states: ");
		sb.append(initialCount);
		sb.append("<br>");
		sb.append("states: ");
		sb.append("<br>");
		sb.append(stateCount);
		sb.append("<br>");
		sb.append("guards: ");
		sb.append("<br>");
		sb.append(guardCount);
		sb.append("regions: ");
		sb.append("<br>");
		sb.append(regionCount);
		sb.append("transitions: ");
		sb.append("<br>");
		sb.append(transitionCount);
		
		return sb.toString();
	}

	private Pseudostate createBase(Package pack) {
		Class clazz = factory.createClassInstance();
		StereotypesHelper.addStereotype(clazz, Gamma.getInstance(project).getSynchrounousCompositeComponent());
		clazz.setOwner(pack);
		clazz.setName("b_" + blockCount++);
		
		StateMachine statemachine = factory.createStateMachineInstance();
		statemachine.setName("sm_" + statemachineCount++);
		statemachine.setOwner(clazz);
		
		Region region = factory.createRegionInstance();
		region.setName("r_" + regionCount ++);
		region.setOwner(statemachine);
		
		Pseudostate initial = factory.createPseudostateInstance();
		initial.setName("i_" + initialCount ++);
		initial.setKind(PseudostateKindEnum.INITIAL);
		initial.setOwner(region);
		
		return initial;
	}
	
	private State extendChain(Vertex sourceNode) {
		Element owner = sourceNode.getOwner();
		State target = factory.createStateInstance();
		target.setName("s_" + stateCount++);
		target.setOwner(owner);
		
		Transition transition = factory.createTransitionInstance();
		transition.setSource(sourceNode);
		transition.setTarget(target);
		transition.setOwner(owner);
		transitionCount++;
		
		if (! (sourceNode instanceof Pseudostate)) {
			Constraint guard = factory.createConstraintInstance();
			OpaqueExpression expression = factory.createOpaqueExpressionInstance();
			
			if (!expression.getBody().isEmpty()) {
				expression.getBody().clear();
			}
			
			expression.getBody().add("true");
			guard.setSpecification(expression);
			transition.setGuard(guard);
			guardCount++;
		}
		
		return target;
	}
	
	private Pseudostate extendDepth(State parent) {
		Region region = factory.createRegionInstance();
		region.setName("r_" + regionCount ++);
		region.setOwner(parent);
		
		Pseudostate initial = factory.createPseudostateInstance();
		initial.setName("i_" + initialCount ++);
		initial.setKind(PseudostateKindEnum.INITIAL);
		initial.setOwner(region);
		
		return initial;
	}
	
}
