package hu.bme.mit.md2g.serialization.statechartlanguage;

import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;

import hu.bme.mit.gamma.statechart.language.StatechartLanguageRuntimeModule;

public class CustomStatechartLanguageRuntimeModule extends StatechartLanguageRuntimeModule {
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return CustomStatechartPackageLinker.class;
	}
	
	@Override
	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return CustomCrossReferenceSerializer.class;
	}
}
