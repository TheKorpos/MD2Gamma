package hu.bme.mit.md2g;

import com.google.inject.Injector;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.md2g.listener.ProjectSpecificFeatureInitializer;
import hu.bme.mit.md2g.ui.browser.GammaBrowserConfigurator;
import hu.bme.mit.md2g.ui.menu.GammaMenuConfigurator;


public class MD2GPlugin extends Plugin {
	
	private static MD2GPlugin INSTANCE;
	private Injector injector;
	
	@Override
	public boolean close() {
		INSTANCE = null;
		return true;
	}

	@Override
	public void init() {
		injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
		Application.getInstance().addProjectEventListener(new ProjectSpecificFeatureInitializer());
		
		
		
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addContainmentBrowserContextConfigurator(new GammaBrowserConfigurator());
		manager.addMainMenuConfigurator(new GammaMenuConfigurator());
		
		INSTANCE = this;
	}
	

	@Override
	public boolean isSupported() {
		return true;
	}
	
	public static MD2GPlugin getInstance() {
		return INSTANCE;
	}
	
	public Injector getInjector() {
		return injector;
	}
}
