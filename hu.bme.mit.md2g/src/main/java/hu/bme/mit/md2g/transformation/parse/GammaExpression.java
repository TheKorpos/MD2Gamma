package hu.bme.mit.md2g.transformation.parse;

import java.io.StringReader;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.commonbehaviors.mdcommunications.Signal;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;

import hu.bme.mit.gamma.action.language.ActionLanguageStandaloneSetup;
import hu.bme.mit.gamma.action.language.parser.antlr.ActionLanguageParser;
import hu.bme.mit.gamma.action.language.services.ActionLanguageGrammarAccess;
import hu.bme.mit.gamma.action.model.Action;
import hu.bme.mit.gamma.action.model.ActionModelFactory;
import hu.bme.mit.gamma.action.model.ExpressionStatement;
import hu.bme.mit.gamma.expression.model.Declaration;
import hu.bme.mit.gamma.expression.model.Expression;
import hu.bme.mit.gamma.expression.model.ExpressionModelFactory;
import hu.bme.mit.gamma.expression.model.OpaqueExpression;
import hu.bme.mit.gamma.expression.model.ReferenceExpression;
import hu.bme.mit.gamma.statechart.interface_.Event;
import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.language.parser.antlr.StatechartLanguageParser;
import hu.bme.mit.gamma.statechart.language.services.StatechartLanguageGrammarAccess;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelFactory;
import hu.bme.mit.gamma.statechart.statechart.StatechartModelPackage;

public class GammaExpression {
	
	static {
		StatechartLanguageStandaloneSetup.doSetup();
	}
	
	private static final Injector INJECTOR = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	
	public static Expression guard(String expression, Map<String, Declaration> scope) {
		
		ParserRule expressionRule = INJECTOR.getInstance(StatechartLanguageGrammarAccess.class).getExpressionRule();
		
		IParseResult result = INJECTOR.getInstance(StatechartLanguageParser.class).parse(expressionRule, new StringReader(expression));
		
		if (result.hasSyntaxErrors()){
			
			String harmoizedExpression = SyntaxHarmonizer.createHarmonizedGammaExpression(expression);
			
			result = INJECTOR.getInstance(StatechartLanguageParser.class).parse(expressionRule, new StringReader(harmoizedExpression));
			
			if (result.hasSyntaxErrors()) {
				
				result.getSyntaxErrors()
					  .forEach(node -> Application.getInstance().getGUILog().log(node.getSyntaxErrorMessage().getMessage() + '\n'));
				
				return createOpaqueExpression(expression);
			}
		}
		
		try {
			resolveReferences(scope, result);	
			
			return (Expression) result.getRootASTElement();
			
		} catch (NoSuchElementException e) { }
	
		return createOpaqueExpression(expression);
	}
	
	public static Action action(String action, Map<String, Declaration> scope, Map<Signal, Event> signalTraces, Map<Port, hu.bme.mit.gamma.statechart.interface_.Port> portTraces) {
		ParserRule expressionRule = INJECTOR.getInstance(StatechartLanguageGrammarAccess.class).getActionRule();
		
		IParseResult result = INJECTOR.getInstance(StatechartLanguageParser.class).parse(expressionRule, new StringReader(action));
		
		if (result.hasSyntaxErrors()){
			
			String harmoizedExpression = SyntaxHarmonizer.createHarmonizedGammaExpression(action);
			
			result = INJECTOR.getInstance(StatechartLanguageParser.class).parse(expressionRule, new StringReader(harmoizedExpression));
			
			if (result.hasSyntaxErrors()) {
				
				result.getSyntaxErrors()
					  .forEach(node -> Application.getInstance().getGUILog().log(node.getSyntaxErrorMessage().getMessage() + '\n'));
				
				return packExpression(createOpaqueExpression(action));
			}
		}
		
		try {
			resolveReferences(scope, result);	
			
			return (Action) result.getRootASTElement();
			
		} catch (NoSuchElementException e) { }
	
		return packExpression(createOpaqueExpression(action));
	}
	
	private static Action packExpression(Expression exp) {
		ExpressionStatement expressionStatement = ActionModelFactory.eINSTANCE.createExpressionStatement();
		expressionStatement.setExpression(exp);
		return expressionStatement;
	}
	
	private static void resolveReferences(Map<String, Declaration> scope, IParseResult result, Map<Signal, Event> signalTraces, Map<Port, hu.bme.mit.gamma.statechart.interface_.Port> portTraces) {
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
	}

	private static void resolveReferences(Map<String, Declaration> scope, IParseResult result) {
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
	}

	private static Expression createOpaqueExpression(String expression) {
		OpaqueExpression opaqueExpression = ExpressionModelFactory.eINSTANCE.createOpaqueExpression();
		opaqueExpression.setExpression(expression);
		return opaqueExpression;
	}

}
