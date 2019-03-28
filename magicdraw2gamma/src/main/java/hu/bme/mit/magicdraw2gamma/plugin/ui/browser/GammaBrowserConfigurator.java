package hu.bme.mit.magicdraw2gamma.plugin.ui.browser;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;

import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.GammaProfile;
import hu.bme.mit.magicdraw2gamma.plugin.ui.browser.action.PerformCheckAction;



public class GammaBrowserConfigurator implements BrowserContextAMConfigurator{

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
			
			if (userObject instanceof Class) {
				Class selectedClass = (Class) userObject;
				
				try {	
					Classifier gammaCheckStereotype = GammaProfile.getInstance().getGammaCheckStereotype();
					InstanceSpecification instancespec = selectedClass.getAppliedStereotypeInstance();
					
					if (instancespec.getClassifier().contains(gammaCheckStereotype)) {
						category.addAction(new PerformCheckAction("GAMMA_BROWSER_CHECK", "Perform check"));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
