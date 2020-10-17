package hu.bme.mit.md2g.propertylanguage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionScope.Scope;

import com.google.common.base.Predicate;

public class CustomPropertyGlobalScopeProvider implements IGlobalScopeProvider {

	@Override
	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		
		
		return null;
	}

}
