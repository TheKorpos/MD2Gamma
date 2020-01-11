package hu.bme.mit.md2g;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

import hu.bme.mit.md2g.listener.ProjectSpecificFeatureInitializer;
import hu.bme.mit.md2g.ui.browser.GammaBrowserConfigurator;


public class MD2GPlugin extends Plugin {
	
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {
		
		Application.getInstance().addProjectEventListener(new ProjectSpecificFeatureInitializer());
		
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addContainmentBrowserContextConfigurator(new GammaBrowserConfigurator());
	}

	@Override
	public boolean isSupported() {
		return true;
	}

}
