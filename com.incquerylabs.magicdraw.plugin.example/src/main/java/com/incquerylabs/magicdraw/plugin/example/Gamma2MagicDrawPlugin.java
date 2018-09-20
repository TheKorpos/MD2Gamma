package com.incquerylabs.magicdraw.plugin.example;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.magicdraw.plugin.example.trafos.FullModelBatchTransformation;
import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;

public class Gamma2MagicDrawPlugin extends Plugin {
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addMainMenuConfigurator(new MainMenuConfigurator(new PortTypeCorrectorAction("PORT_CORRECTOR_TRANSFORMATION", "Correct all port type")));	
	}

	@Override
	public boolean isSupported() {
		return true;
	}

	class PortTypeCorrectorAction extends MDAction {
		private static final long serialVersionUID = 8437220468635496371L;

		public PortTypeCorrectorAction(String id, String name) {
			super(id, name, null, null);
		}

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Project project = Application.getInstance().getProject();
			ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
			AdvancedViatraQueryEngine engine = adapter.getEngine();
			
			final String mdHome = Application.environment().getInstallRoot();
			
			FullModelBatchTransformation trafo = new FullModelBatchTransformation(engine);
			trafo.execute();
			trafo.getStatechartDefs().forEach((md, ga) -> {
				try {
					ResourceSet rs = new ResourceSetImpl();
					Resource r = rs.createResource(URI.createFileURI(mdHome+"\\gammaOut\\"+md.getHumanName()+".xml"));
					r.getContents().add(ga);
					r.save(null);
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			});
			
			Application.getInstance().getGUILog().showMessage("Exported as XML to" + mdHome + "\\gammaOut\\");
				
		}

	}

}
