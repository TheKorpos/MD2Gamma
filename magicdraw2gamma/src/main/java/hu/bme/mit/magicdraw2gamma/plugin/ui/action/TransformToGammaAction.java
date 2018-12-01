package hu.bme.mit.magicdraw2gamma.plugin.ui.action;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.google.common.collect.Sets;
import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.openapi.uml.SessionManager;

import hu.bme.mit.gamma.statechart.model.Package;
import hu.bme.mit.gamma.statechart.model.Port;
import hu.bme.mit.gamma.statechart.model.Region;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.model.TimeoutDeclaration;
import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.queries.RegionWithEmptyName;
import hu.bme.mit.magicdraw2gamma.plugin.queries.StateMachines;
import hu.bme.mit.magicdraw2gamma.plugin.queries.TimeoutDeclarationsWithEmptyName;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.InterfaceTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.MagicdrawToGammaTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.TransformationServiceProvider;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.MD2GTrace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.Trace;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TraceFactory;
import hu.bme.mit.magicdraw2gamma.trace.model.trace.TracePackage;




public class TransformToGammaAction extends MDAction {
		private static final long serialVersionUID = 8437220468635496371L;
		
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
			
			/*if (!SessionManager.getInstance().isSessionCreated(project)) {
				SessionManager.getInstance().createSession(project, "Gamma Transformation");
			}*/
			
			//loading packages
			StatechartModelPackage.eINSTANCE.getNsURI();
			TracePackage.eINSTANCE.getNsURI();
			
			final String saveDir = Application.getInstance().getProject()
					.getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, GammaProjectOptionsConfigurator.GAMMA_WORK_DIR_ID).getValueStringRepresentation();
					
			ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
			ViatraQueryEngine engine = adapter.getEngine();
			
			ResourceSet mainResourceSet = new ResourceSetImpl();
			
			Resource traceModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/.trace.md2g"));
			MD2GTrace traceRoot = TraceFactory.eINSTANCE.createMD2GTrace();
			traceModel.getContents().add(traceRoot);
			createdResources.add(traceModel);
		
			//creating resource for interfaces
			Resource interfaceModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/interfaces.gsm"));
			createdResources.add(interfaceModel);
			//Create package for interfaces and put it to the resource
			Package interfacePackage = StatechartModelFactory.eINSTANCE.createPackage();
			interfacePackage.setName("Interface");
			interfaceModel.getContents().add(interfacePackage);
			
			//collect statechartdefinitions and create resources
			StateMachines.instance().getMatcher(engine).forEachMatch( match -> {
				
				Resource constraintModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/" + match.getName() + "/constraints.gsm"));
				Resource statechartModel = mainResourceSet.createResource(URI.createFileURI(saveDir + "/" + match.getName() + "/" + match.getName() + ".gsm"));
			
				//create statecharts and set their names
				StatechartDefinition statechartDefinition = StatechartModelFactory.eINSTANCE.createStatechartDefinition();
				statechartDefinition.setName(match.getName());
				//Trace statecharts
				Trace trace = TraceFactory.eINSTANCE.createTrace();
				trace.getSource().add(match.getStateMachine());
				trace.getTarget().add(statechartDefinition);
				traceRoot.getTraces().add(trace);
				//Create a package for the statechart
				Package p = StatechartModelFactory.eINSTANCE.createPackage();
				p.setName(match.getStateMachine().getName().toLowerCase());
				p.getComponents().add(statechartDefinition);
				//Import interfaces
				p.getImports().add(interfacePackage);
				statechartModel.getContents().add(p);
				//Create port for handling events
				Port generatedPort = StatechartModelFactory.eINSTANCE.createPort();
				generatedPort.setName("GeneratedPort");
				generatedPort.setInterfaceRealization(StatechartModelFactory.eINSTANCE.createInterfaceRealization());
				statechartDefinition.getPorts().add(generatedPort);
				//Add models to  resources
				createdResources.add(statechartModel);
				createdResources.add(constraintModel);
			});
			
			//creating scope for the common engine
			Set<Resource> scopeSet = Sets.newHashSet();
			scopeSet.addAll(createdResources);
			scopeSet.add(project.getPrimaryModel().eResource());
			
			BaseIndexOptions options = new BaseIndexOptions();
			
			AdvancedViatraQueryEngine commonEngine = AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(scopeSet, options));
			
			InterfaceTransformer it = new InterfaceTransformer(engine);
			MagicdrawToGammaTransformer st = new MagicdrawToGammaTransformer(engine);
			
			try {
				
				it.execute(commonEngine, traceRoot, interfacePackage);	
				st.execute(commonEngine, traceRoot);
				
				RegionWithEmptyName.instance().getMatcher(commonEngine).getAllMatches().stream().map(m -> m.getParent()).forEach(state -> {
					List<Region> regions = state.getRegions().stream().filter(region -> "".equals(region.getName())).collect(Collectors.toList());
					int i = 1;
					for (Region r: regions) {
						r.setName(state.getName() + "_" + i++);
					}
				});
				
				int i = 0;
				List<TimeoutDeclaration> tDeclarations = TimeoutDeclarationsWithEmptyName.instance().getMatcher(commonEngine).getAllMatches().stream()
					.map(m -> m.getDeclaration()).collect(Collectors.toList());
				for (TimeoutDeclaration decl: tDeclarations) {
					decl.setName("GeneratedTimeout"+i++);
				}
				
				
				try {
					for (Resource res: createdResources) {
						res.save(null);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				createdResources.forEach(Resource::unload);
				createdResources.clear();
				it.dispose();
				st.dispose();
				commonEngine.dispose();
			}
			//Execute interface transformation first to get events for later use
			
			//TransformationServiceProvider.getInstance().getInterfaceTransformer().execute(commonEngine, traceRoot, interfacePackage);
			//Execute the statechart transformation
			//TransformationServiceProvider.getInstance().getStatechartTransformer().execute(commonEngine, traceRoot);
			
			
			//post-fix badly formed model
			//TODO: put fixes in trafo instead
			//fixing emtpy region names
			
			
			
			//save all created resources
			
			
			
			
			//remove all created resources
			
			
			//SessionManager.getInstance().closeSession(project);
			
		}
	
	}