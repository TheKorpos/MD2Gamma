package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.StringProperty;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.validation.ErrorPatterns;
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.MagicDrawToGammaTransformation;


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
			StatechartModelPackage.eINSTANCE.getNsURI();
			
			Project project = Application.getInstance().getProject();
			ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
			AdvancedViatraQueryEngine engine = adapter.getEngine();
			
			final String saveDir = Application.getInstance().getProject()
					.getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID).getValueStringRepresentation();
		
			
			MagicDrawToGammaTransformation trafo = new MagicDrawToGammaTransformation(engine);
			trafo.execute();
			trafo.getStatechartDefs().forEach((md, ga) -> {
				try {
					ResourceSet rs = new ResourceSetImpl();
					Resource r = rs.createResource(URI.createFileURI(saveDir + "\\" + md.getHumanName() + ".xml"));
					r.getContents().add(ga);
					r.save(null);
					
					ViatraQueryEngine validationEngine = ViatraQueryEngine.on(new EMFScope(rs));
					
					ErrorPatterns.instance().getSpecifications().forEach(spec -> {
						System.out.println(spec.getSimpleName());
						validationEngine.getMatcher(spec).forEachMatch(ma -> {
							System.out.println(ma.prettyPrint());
						});
					});
					
					/*validationEngine.getCurrentMatchers().forEach( matcher -> {
						System.out.println(matcher.getPatternName());
						matcher.forEachMatch(IPatternMatch::prettyPrint);
					});*/
					
					
					
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			});
			
			Application.getInstance().getGUILog().showMessage("Exported as XML to" + saveDir);
				
		}
	
	}