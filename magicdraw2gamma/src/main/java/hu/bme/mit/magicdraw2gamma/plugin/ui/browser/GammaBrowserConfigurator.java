package hu.bme.mit.magicdraw2gamma.plugin.ui.browser;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;

import hu.bme.mit.magicdraw2gamma.plugin.ui.browser.action.TransformSingleStatemachineAction;



public class GammaBrowserConfigurator implements BrowserContextAMConfigurator{

	private static final String EXPORT_AS_GCL_NAME = "Export as gcl";
	private static final String GAMMA_TRA_SINGLE = "GAMMA_TRA_SINGLE";

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		
		MDActionsCategory category = new MDActionsCategory("GAMMA_BROWSER", "GAMMA_BROWSER");
		manager.addCategory(category);
		
		for (final Node node: tree.getSelectedNodes()) {
			Object userObject = node.getUserObject();
			
			//selected object is a class
			if (userObject instanceof Class) {
				Class selectedClass = (Class) userObject;
				if (selectedClass.getAppliedStereotypeInstance() != null) {
					try {	
//						Classifier gammaCheckStereotype = GammaProfile.getInstance().getGammaCheckStereotype();
//						Classifier gammaStatechartDefinitionStereotype = GammaProfile.getInstance().gammaStatechartDefinitionStereotype();
						InstanceSpecification instancespec = selectedClass.getAppliedStereotypeInstance();
						
						//it has block stereoptype on
						if (instancespec.getClassifier().stream().filter(it -> "Block".equals(it.getName())).findAny().isPresent()) {
							category.addAction(new TransformSingleStatemachineAction(GAMMA_TRA_SINGLE, EXPORT_AS_GCL_NAME, selectedClass));
						}
						
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}	
				}
			}
			
			if (userObject instanceof StateMachine) {
				
				StateMachine stateMachine = (StateMachine) userObject;
				category.addAction(new TransformSingleStatemachineAction(GAMMA_TRA_SINGLE, EXPORT_AS_GCL_NAME, stateMachine));
				
			}
		}
	}
}
