package hu.bme.mit.md2g.test.runner;

import com.nomagic.magicdraw.commandline.CommandLineActionManager;
import com.nomagic.magicdraw.plugins.Plugin;

public class TestPlugin extends Plugin {

	@Override
	public void init() {
		CommandLineActionManager.getInstance().addAction(new TestRunner());
	}

	@Override
	public boolean close() {
		return true;
	}

	@Override
	public boolean isSupported() {
		return true;
	}
}