package hu.bme.mit.magicdraw2gamma.plugin;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.plugins.Plugin;

import hu.bme.mit.magicdraw2gamma.plugin.ui.MainMenuConfigurator;

public class MagicDraw2GammaPlugin extends Plugin {
	@Override
	public boolean close() {
		return true;
		
	}

	@Override
	public void init() {
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addMainMenuConfigurator(new MainMenuConfigurator());	
	}

	@Override
	public boolean isSupported() {
		return true;
	}

	

}
