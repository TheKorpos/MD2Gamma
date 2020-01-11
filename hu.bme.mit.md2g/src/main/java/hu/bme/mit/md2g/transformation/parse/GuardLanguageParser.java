package hu.bme.mit.md2g.transformation.parse;

import java.io.StringReader;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;

import hu.bme.mit.gamma.expression.model.Declaration;
import hu.bme.mit.gamma.expression.model.Expression;
import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.OpaqueExpression;
import hu.bme.mit.gamma.expression.model.ReferenceExpression;

public class GuardLanguageParser {
	
	Injector injector = new CustomConstraintLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	
	public Expression parse(String expression, Map<String, Declaration> scope) {
		
		
		IParseResult result = injector.getInstance(CustomConstraintLanguageParser.class).parse(new StringReader(expression));
		
		if (result.hasSyntaxErrors()){
			return createOpaqueExpression(expression);
		}
		
		try {
			for (INode node: result.getRootNode().getLeafNodes()) {
				if (node.getGrammarElement() instanceof CrossReference) {
					final ReferenceExpression refExp = (ReferenceExpression) node.getSemanticElement();
					
					Declaration decl = scope.get(node.getText());
					
					if (decl != null) {
						refExp.setDeclaration(decl);					
					} else {
						throw new NoSuchElementException();
					}
					
				}	
			}	
			
			return (Expression) result.getRootASTElement();
			
		} catch (NoSuchElementException e) { }
	
		return createOpaqueExpression(expression);
	}

	private Expression createOpaqueExpression(String expression) {
		OpaqueExpression opaqueExpression = ExpressionModelFactory.eINSTANCE.createOpaqueExpression();
		opaqueExpression.setExpression(expression);
		return opaqueExpression;
	}

}
