package hu.bme.mit.md2g.serialization.propertylanguage;

import org.eclipse.xtext.linking.ILinkingService;

import hu.bme.mit.gamma.property.language.PropertyLanguageRuntimeModule;

public class CustomPropertyLanguageRuntimeModule extends PropertyLanguageRuntimeModule {
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return CustomPropertyLanguageLinker.class;
	}
	
}
