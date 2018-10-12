/*
 *
 * Copyright (c) 2002 NoMagic, Inc. All Rights Reserved.
 */

package hu.bme.mit.magicdraw2gamma.plugin.ui;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;

import hu.bme.mit.magicdraw2gamma.plugin.ui.action.SetGammaWorkdirAction;
import hu.bme.mit.magicdraw2gamma.plugin.ui.action.TestVerificationAction;
import hu.bme.mit.magicdraw2gamma.plugin.ui.action.TransformToGammaAction;

public class MainMenuConfigurator implements AMConfigurator {

	String MD2G = "MD2G";

	/**
	 * Action will be added to manager.
	 */

	/**
	 * Creates configurator.
	 * 
	 * @param action
	 *            action to be added to main menu.
	 */
	public MainMenuConfigurator() {
	}

	/**
	 * @see com.nomagic.actions.AMConfigurator#configure(ActionsManager) Methods
	 *      adds action to given manager Examples category.
	 */
	@Override
	public void configure(ActionsManager manager) {
		// searching for Examples action category
		ActionsCategory category = (ActionsCategory) manager.getActionFor(MD2G);

		if (category == null) {
			// creating new category
			category = new MDActionsCategory(MD2G, MD2G);
			category.setNested(true);
			manager.addCategory(category);
		}
		category.addAction(new SetGammaWorkdirAction("SET_GAMMA_WORKDIR", "Set Gamma working directory"));
		category.addAction(new TransformToGammaAction("TRANSFORM", "Transform to Gamma"));
		category.addAction(new TestVerificationAction("TESTACTION", "TEST"));
	}

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}
	
	

}