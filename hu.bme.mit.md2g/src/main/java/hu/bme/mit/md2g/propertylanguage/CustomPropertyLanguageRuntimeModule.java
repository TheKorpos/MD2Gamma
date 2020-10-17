package hu.bme.mit.md2g.propertylanguage;

import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import hu.bme.mit.gamma.property.language.PropertyLanguageRuntimeModule;

public class CustomPropertyLanguageRuntimeModule extends PropertyLanguageRuntimeModule {
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return CustomQualifiedNameProvider.class;
	}
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return CustomPropertyLanguageLinker.class;
	}
	
}
