package hu.bme.mit.md2g.ui.menu;

import java.awt.Composite;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

import hu.bme.mit.md2g.transformation.queries.CompositeQueries;
import hu.bme.mit.md2g.transformation.queries.StatechartQueries;

public class GammaMenuConfigurator implements AMConfigurator {

	@Override
	public int getPriority() {
		return HIGH_PRIORITY;
	}

	@Override
	public void configure(ActionsManager actionManager) {
		ActionsCategory gammaCategory = new ActionsCategory("GAMMA_MAIN_MENU", "Gamma");
		gammaCategory.setNested(true);
		actionManager.addCategory(gammaCategory);
		
		gammaCategory.addAction(new NMAction("GAMMA_VIATRA_INIT", "Initialize VIATRA", null, null) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Project project = Application.getInstance().getProject();
				ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
				AdvancedViatraQueryEngine engine = adapter.getEngine();
				
				try {
					engine.getBaseIndex().coalesceTraversals(new Callable<Void>() {

						@Override
						public Void call() throws Exception {
							
							StatechartQueries.instance().prepare(engine);
							CompositeQueries.instance().prepare(engine);
							
							return null;
						}
						
					});
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
