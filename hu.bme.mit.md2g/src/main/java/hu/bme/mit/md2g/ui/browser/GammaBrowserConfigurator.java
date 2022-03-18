package hu.bme.mit.md2g.ui.browser;

import java.awt.event.ActionEvent;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdbasicbehaviors.OpaqueBehavior;
import com.nomagic.uml2.impl.ElementsFactory;

import hu.bme.mit.md2g.ui.browser.action.ExecuteVerificationAction;
import hu.bme.mit.md2g.ui.browser.action.ExportToGclAction;
import hu.bme.mit.md2g.ui.browser.action.SerializeUppaalModelAction;
import hu.bme.mit.md2g.ui.browser.action.StatechartGeneratorAction;
import hu.bme.mit.md2g.ui.browser.action.TransformWorkspaceModelsToUppaalAction;
import hu.bme.mit.md2g.ui.browser.action.TransformWorkspaceTargetToGammaAction;
import hu.bme.mit.md2g.util.MD2GModelHelper;
import hu.bme.mit.md2g.util.profile.Gamma;

public class GammaBrowserConfigurator implements BrowserContextAMConfigurator{

	private static final String EXPORT_STATE_MACHINE_AS_GCL = "Export State Machine as gcl";
	private static final String EXPORT_AS_GCL_NAME = "Export block structure as gcl";
	private static final String GAMMA_TRA_SINGLE = "GAMMA_TRA_SINGLE";
	private static final String GAMMA_TRA_COMP = "GAMMA_TRA_COMP";

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		
		MDActionsCategory category = new MDActionsCategory("GAMMA_BROWSER", "Gamma Transformation");
		category.setNested(true);
		manager.addCategory(category);
		
		for (final Node node: tree.getSelectedNodes()) {
			Object userObject = node.getUserObject();
			
			//selected object is a class
			if (userObject instanceof OpaqueBehavior) {
				
				OpaqueBehavior ob = (OpaqueBehavior) userObject;
				
				if (Gamma.isGammaCheckExpression(ob)) {
					category.addAction(new ExecuteVerificationAction(ob));
				}
				
			} else if (userObject instanceof Class) {
				Class selectedClass = (Class) userObject;
	
			} else if (userObject instanceof Package) {
				Package mdPackage = (Package) userObject;
				if (Gamma.isGammaWorkspace(mdPackage)) {
					category.addAction(new TransformWorkspaceTargetToGammaAction("GAMMA_WORKSPACE_TRA", "Transform Targeted Model", mdPackage));
					category.addAction(new TransformWorkspaceModelsToUppaalAction(mdPackage));
					category.addAction(new SerializeUppaalModelAction(mdPackage));
					category.addAction(new ExportToGclAction(mdPackage));
				} else {
					category.addAction(new StatechartGeneratorAction(mdPackage));
					category.addAction(new NMAction() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Project project = Application.getInstance().getProject();
							ElementsFactory elementsFactory = project.getElementsFactory();
							
							SessionManager.getInstance().createSession(project, "Session");
								Class classInstance = elementsFactory.createClassInstance();
								classInstance.setOwner(mdPackage);
								
								for (int i = 0 ; i < 9000; i++) {
									Property property = elementsFactory.createPropertyInstance();
									MD2GModelHelper.createTrace(property, classInstance);
									property.setOwner(classInstance);
								}
							SessionManager.getInstance().closeSession(project);
						}
					});
				}
				
			}
		}
	}
}