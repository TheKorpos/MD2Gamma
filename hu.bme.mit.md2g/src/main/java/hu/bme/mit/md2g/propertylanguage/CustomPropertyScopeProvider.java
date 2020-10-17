package hu.bme.mit.md2g.propertylanguage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import hu.bme.mit.gamma.property.language.scoping.PropertyLanguageScopeProvider;

public class CustomPropertyScopeProvider extends PropertyLanguageScopeProvider {
	
	public static int a = 0;
	public int b = a++;
	
	public CustomPropertyScopeProvider() {
		
	}
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		return super.getScope(context, reference);
	}
}
