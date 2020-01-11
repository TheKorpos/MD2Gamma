package hu.bme.mit.md2g.transformation.parse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import hu.bme.mit.gamma.expression.language.ExpressionLanguageStandaloneSetup;
import hu.bme.mit.gamma.expression.model.ExpressionPackage;

public class CustomConstraintLanguageStandaloneSetup extends ExpressionLanguageStandaloneSetup{
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(new Module[]{new CustomRuntimeModule()});
	}
}
