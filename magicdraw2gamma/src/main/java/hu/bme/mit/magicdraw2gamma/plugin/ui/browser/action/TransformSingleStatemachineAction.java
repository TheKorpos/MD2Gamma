package hu.bme.mit.magicdraw2gamma.plugin.ui.browser.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nomagic.actions.NMAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;

import hu.bme.mit.magicdraw2gamma.plugin.transformation.StateMachineTransformer;

public class TransformSingleStatemachineAction extends NMAction {
	
	private Class target;
	
	public TransformSingleStatemachineAction(String id, String name, Class target) {
		super(id, name, 0, null);
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		StateMachineTransformer transformer = new StateMachineTransformer();
		ArrayList<Class> targetList = new ArrayList<>();
		targetList.add(target);
		
		
		
		transformer.transform(targetList, new ResourceSetImpl());
	}

}
