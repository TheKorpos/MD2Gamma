package hu.bme.mit.md2g.serialization.statechartlanguage;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetupGenerated;

public class CustomStatechartLanguageStandaloneSetup extends StatechartLanguageStandaloneSetupGenerated {
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(new CustomStatechartLanguageRuntimeModule());
	}
	
}
