package hu.bme.mit.md2g.transformation.parse;

import hu.bme.mit.gamma.expression.language.parser.antlr.ExpressionLanguageParser;

public class CustomConstraintLanguageParser extends ExpressionLanguageParser{
	
	@Override
	protected String getDefaultRuleName() {
		return "Expression";
	}
	
}
