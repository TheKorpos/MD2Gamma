package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

import hu.bme.mit.magicdraw2gamma.plugin.trafos.FullModelBatchTransformation;


public class TransformToGammaAction extends MDAction {
		private static final long serialVersionUID = 8437220468635496371L;

		public TransformToGammaAction(String id, String name) {
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