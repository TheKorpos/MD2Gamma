package hu.bme.mit.magicdraw2gamma.plugin;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.magicdraw.task.BackgroundTaskRunner;
import com.nomagic.magicdraw.ui.MagicDrawProgressStatusRunner;
import com.nomagic.task.RunnableWithProgress;

import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.InterfaceTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.MagicdrawToGammaTransformer;
import hu.bme.mit.magicdraw2gamma.plugin.trafos.TransformationServiceProvider;
import hu.bme.mit.magicdraw2gamma.plugin.ui.MainMenuConfigurator;

public class MagicDraw2GammaPlugin extends Plugin {
	
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {
		Application.getInstance().getProjectsManager().addProjectListener(new ProjectEventListenerAdapter() {

			@Override
			public void projectOpened(Project project) {
				
				MagicDrawProgressStatusRunner.runWithProgressStatus(progress -> {
					progress.setMin(0);
					progress.setMax(1);
					ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
					//adding these so the firt transformation takes less time
					SearchQueries.instance().prepare(engine);
					
					progress.setCurrent(1);
					
				}, "Registering Gamma Transformations", false, 0);
			}
			
			@Override
			public void projectClosed(Project project) {
				//TransformationServiceProvider.getInstance().disposeAll();
			}
			
		});
		
		
		
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addMainMenuConfigurator(new MainMenuConfigurator());
		ProjectOptions.addConfigurator(new GammaProjectOptionsConfigurator());
	}
	
	
	

	@Override
	public boolean isSupported() {
		return true;
	}
	
	
	
	

	

}
