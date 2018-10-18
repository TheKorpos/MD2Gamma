package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.StringProperty;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.impl.ElementsFactory;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.model.interface_.InterfacePackage;
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
			//StatechartModelPackage.eINSTANCE.getNsURI();
			//InterfacePackage.eINSTANCE.getNsURI();
			
			Project project = Application.getInstance().getProject();
			ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
			AdvancedViatraQueryEngine engine = adapter.getEngine();
			
			final String saveDir = Application.getInstance().getProject()
					.getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID).getValueStringRepresentation();
		
			
			MagicDrawToGammaTransformation trafo = new MagicDrawToGammaTransformation(engine);
			trafo.execute();
			//trafo.getStatechartDefs().forEach((md, ga) -> {
				try {
					ResourceSet rs = new ResourceSetImpl();
					Resource r = rs.createResource(URI.createFileURI(saveDir + "\\package.xml"));
					
					r.getContents().add(trafo.getStatechartsPackage());
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
					
					
					if (!SessionManager.getInstance().isSessionCreated(project))
						SessionManager.getInstance().createSession(project, "Creating Gamma Package");
					
					Optional<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package> optionalPackage = project.getPrimaryModel().getNestedPackage().stream().filter(p -> "Gamma".equals(p.getName())).findFirst();
					com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package p = null;
					ElementsFactory ef = project.getElementsFactory();
					if (!optionalPackage.isPresent()) {
					
						p = ef.createPackageInstance();
						p.setName("Gamma");
						p.setOwner(project.getPrimaryModel());
					}
					
					
					Optional<Class> ref = p.getOwnedElement().stream().filter(Class.class::isInstance)
						.map(Class.class::cast)
						.filter(cl -> "gamma_package".equals(cl.getName())).findFirst();
					
					Class gammaFilePointer = null;
					if (!ref.isPresent()) {
						gammaFilePointer = ef.createClassInstance();
						gammaFilePointer.setName("gamma_package");
						gammaFilePointer.setOwner(p);
					}
					
					
					SessionManager.getInstance().closeSession(project);
					
					
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			//});
			
			Application.getInstance().getGUILog().showMessage("Exported as XML to" + saveDir);
				
		}
	
	}