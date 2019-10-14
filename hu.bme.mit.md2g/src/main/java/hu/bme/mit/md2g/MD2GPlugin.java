package hu.bme.mit.md2g;

import com.nomagic.magicdraw.plugins.Plugin;


public class MD2GPlugin extends Plugin {
	
	@Override
	public boolean close() {
		return true;
	}

	@Override
	public void init() {
		System.out.println("Plugin initialized");
	}

	@Override
	public boolean isSupported() {
		return true;
	}

}
