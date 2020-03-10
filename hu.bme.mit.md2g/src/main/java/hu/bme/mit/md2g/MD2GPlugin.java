package hu.bme.mit.md2g;

import org.bridj.OSGiBundleActivator;
import org.eclipse.core.internal.registry.osgi.OSGIUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EEnum;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

import hu.bme.mit.gamma.genmodel.model.GenmodelPackage;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.md2g.listener.ProjectSpecificFeatureInitializer;
import hu.bme.mit.md2g.ui.browser.GammaBrowserConfigurator;
import hu.bme.mit.md2g.ui.menu.GammaMenuConfigurator;


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
		manager.addMainMenuConfigurator(new GammaMenuConfigurator());
	}

	@Override
	public boolean isSupported() {
		return true;
	}

}
