package hu.bme.mit.md2g.ui.menu;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;

public class GammaMenuConfigurator implements AMConfigurator {

	@Override
	public int getPriority() {
		return HIGH_PRIORITY;
	}

	@Override
	public void configure(ActionsManager actionManager) {
		ActionsCategory gammaCategory = new ActionsCategory("GAMMA_MAIN_MENU", "Gamma");
		actionManager.addCategory(gammaCategory);
	}
}
