package hu.bme.mit.md2g.propertylanguage;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hu.bme.mit.gamma.property.language.PropertyLanguageStandaloneSetup;
import hu.bme.mit.gamma.property.language.PropertyLanguageStandaloneSetupGenerated;

public class CustomPropertyLanguageStandaloneSetup extends PropertyLanguageStandaloneSetupGenerated {
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(new CustomPropertyLanguageRuntimeModule());
	}

}
