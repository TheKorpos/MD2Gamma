package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.google.common.collect.Sets;
import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.StateMachine;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.uppaal.transformation.batch.StatechartToUppaalTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionsInStatechart;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateMachines;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StatechartTrace;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.MagicdrawToGammaTransformer;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage;




public class TransformToGammaAction extends MDAction {
		private static final long serialVersionUID = 8437220468635496371L;
		
		private List<StateMachine> statemachines = new ArrayList<>();
		private Set<Resource> createdResources = new HashSet<>();

		public TransformToGammaAction(String id, String name) {
			super(id, name, null, null);
		}

		/**
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent evnt) {
			Project project = Application.getInstance().getProject();
			
			if (!SessionManager.getInstance().isSessionCreated(project)) {
				SessionManager.getInstance().createSession(project, "Gamma Transformation");
			}
			
			//loading packages
			StatechartModelPackage.eINSTANCE.getNsURI();
			TracePackage.eINSTANCE.getNsURI();
			
			final String saveDir = Application.getInstance().getProject()
					.getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID).getValueStringRepresentation();
					
			ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
			AdvancedViatraQueryEngine engine = adapter.getEngine();
			
			ResourceSet mainResourceSet = new ResourceSetImpl();
			
			Resource traceModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/.trace.md2g"));
			MD2GTrace traceRoot = TraceFactory.eINSTANCE.createMD2GTrace();
			traceModel.getContents().add(traceRoot);
			createdResources.add(traceModel);
			
			//collect statechartdefinitions and create resources
			StateMachines.instance().getMatcher(engine).forEachMatch( match -> {
				Resource constraintModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/" + match.getName() + "/constraints.gsm"));
				Resource statechartModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/" + match.getName() + "/" + match.getName() + ".gsm"));
				Resource interfaceModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/" + match.getName() + "/interfaces.gsm"));
			
				
				Trace trace = TraceFactory.eINSTANCE.createTrace();
				
				trace.getSource().add(match.getStateMachine());
				Package p = StatechartModelFactory.eINSTANCE.createPackage();
				p.setName(match.getStateMachine().getName().toLowerCase());
				
				statechartModel.getContents().add(p);
				
				StatechartDefinition statechartDefinition = StatechartModelFactory.eINSTANCE.createStatechartDefinition();
				statechartDefinition.setName(match.getName());
				
				p.getComponents().add(statechartDefinition);
				
				trace.getTarget().add(statechartDefinition);			
				
				traceRoot.getTraces().add(trace);
				
				Package interfacesPackage = StatechartModelFactory.eINSTANCE.createPackage();
				interfacesPackage.setName(match.getName().toLowerCase()+".interface");
				
				p.getImports().add(interfacesPackage);
				
				interfaceModel.getContents().add(interfacesPackage);
				
				createdResources.add(statechartModel);
				createdResources.add(constraintModel);
				createdResources.add(interfaceModel);	
			});
			
			
			//rs hozzájuk és mappok
			Set<Resource> scopeSet = Sets.newHashSet();
			scopeSet.addAll(createdResources);
			scopeSet.add(project.getPrimaryModel().eResource());
			
			BaseIndexOptions options = new BaseIndexOptions();
			
			AdvancedViatraQueryEngine commonEngine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(scopeSet, options));
			
			
			MagicdrawToGammaTransformer statechartTransformer = new MagicdrawToGammaTransformer(engine, commonEngine, traceRoot);
			statechartTransformer.execute();
			
			StatechartTrace.instance().getMatcher(commonEngine).forEachMatch(match -> {
				System.out.println(match);
			});
			
			//Collection<RegionsInStatechart.Match> matches = RegionsInStatechart.instance().getMatcher(engine).getAllMatches();
			//matches.forEach(RegionsInStatechart.Match::prettyPrint);
			
			//save all created resources
			try {
				for (Resource res: createdResources) {
					res.save(null);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			//remove all created resources
			createdResources.forEach(Resource::unload);
			commonEngine.dispose();
			statechartTransformer.dispose();
			
			SessionManager.getInstance().closeSession(project);
			
		}
	
	}