package hu.bme.mit.magicdraw2gamma.plugin;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;
import com.nomagic.magicdraw.plugins.Plugin;
import com.nomagic.magicdraw.ui.MagicDrawProgressStatusRunner;

import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.profilehelper.GammaProfile;
import hu.bme.mit.magicdraw2gamma.plugin.queries.SearchQueries;
import hu.bme.mit.magicdraw2gamma.plugin.ui.browser.GammaBrowserConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.ui.menu.MainMenuConfigurator;

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
				
					GammaProfile.initialize(engine);
					
					progress.setCurrent(1);
					
				}, "Registering Gamma Transformations", false, 0);
			}
			
			@Override
			public void projectClosed(Project project) {
				//TransformationServiceProvider.getInstance().disposeAll();
			}
			
		});
		
		
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		//adding main menu configurators
		manager.addMainMenuConfigurator(new MainMenuConfigurator());
		//adding browser configurators
		manager.addContainmentBrowserContextConfigurator(new GammaBrowserConfigurator());
		//adding project options configurators
		ProjectOptions.addConfigurator(new GammaProjectOptionsConfigurator());
	}
	
	
	

	@Override
	public boolean isSupported() {
		return true;
	}
	
	
	
	

	

}
