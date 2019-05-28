package hu.bme.mit.magicdraw2gamma.plugin;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.plugins.Plugin;

import hu.bme.mit.magicdraw2gamma.plugin.options.GammaProjectOptionsConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.ui.browser.GammaBrowserConfigurator;
import hu.bme.mit.magicdraw2gamma.plugin.ui.menu.MainMenuConfigurator;

public class MagicDraw2GammaPlugin extends Plugin {
	
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {
	
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
