package hu.bme.mit.md2g.serialization.statechartlanguage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import hu.bme.mit.gamma.language.util.serialization.GammaLanguageCrossReferenceSerializer;
import hu.bme.mit.gamma.statechart.interface_.Package;

public class CustomCrossReferenceSerializer extends GammaLanguageCrossReferenceSerializer {

	public String getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref,
			EObject target, final IScope scope, Acceptor errors) {
		if (getContext().isInstance(semanticObject)) {
			if (getTarget().isInstance(target)) {
				Package gammaPack = (Package) target;
				return gammaPack.getName();
			}
		}
		return super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
	}
	
	
	@Override
	public Class<? extends EObject> getContext() {
		return hu.bme.mit.gamma.statechart.interface_.Package.class;
	}

	@Override
	public Class<? extends EObject> getTarget() {
		return hu.bme.mit.gamma.statechart.interface_.Package.class;
	}

}
