package hu.bme.mit.magicdraw2gamma.plugin.parsing;

import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;

import hu.bme.mit.gamma.constraint.model.Declaration;
import hu.bme.mit.gamma.constraint.model.Expression;
import hu.bme.mit.gamma.constraint.model.ReferenceExpression;
import hu.bme.mit.gamma.constraint.model.VariableDeclaration;
import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.language.parser.antlr.StatechartLanguageParser;
import hu.bme.mit.gamma.statechart.language.services.StatechartLanguageGrammarAccess;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;


public class GammaExpressionParser {
	
	Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	
	public EObject parseTimeSpecification(StatechartDefinition statechart, String s) throws Exception {
		ParserRule rule = injector.getInstance(StatechartLanguageGrammarAccess.class).getTimeSpecificationRule();
		
		IParseResult result = injector.getInstance(StatechartLanguageParser.class).parse(rule, new StringReader(s));
		
		Set<Declaration> declarations = new HashSet<Declaration>();
		
		declarations.addAll(statechart.getParameterDeclarations());
		declarations.addAll(statechart.getVariableDeclarations());
		
		resolveReferences(declarations, result);
		
		EObject element = result.getRootASTElement();
		
		return element;
	}
	
	private void resolveReferences(Set<Declaration> scope, IParseResult result) throws Exception {
		for (INode node: result.getRootNode().getLeafNodes()) {
			if (node.getGrammarElement() instanceof CrossReference) {
				final ReferenceExpression refExp = (ReferenceExpression) node.getSemanticElement();
				List<Declaration> declarations = scope.stream().filter(decl -> node.getText().equals(decl.getName())).collect(Collectors.toList());
				
				if (declarations.size() > 1) throw new Exception(node.getText() + "is declared more than one time");
				if (declarations.isEmpty()) throw new Exception(node.getText() + "is not declared");
				
				refExp.setDeclaration(declarations.get(0));
			}
		}
	}
	
	public Expression parseGuard(ViatraQueryEngine engine, StatechartDefinition statechartDefinition, String s) throws Exception {
		ParserRule rule = injector.getInstance(StatechartLanguageGrammarAccess.class).getExpressionRule();
		IParseResult result = injector.getInstance(StatechartLanguageParser.class).parse(rule, new StringReader(s));
		
		for (INode node: result.getSyntaxErrors()) {
			throw new Exception(node.getSyntaxErrorMessage().getMessage());
		}
		
		for (INode node: result.getRootNode().getLeafNodes()) {
			if (node.getGrammarElement() instanceof CrossReference) {
				final ReferenceExpression refExp = (ReferenceExpression) node.getSemanticElement();
				List<VariableDeclaration> declarations = statechartDefinition.getVariableDeclarations().stream().filter(decl -> node.getText().equals(decl.getName())).collect(Collectors.toList());
				
				if (declarations.size() > 1) throw new Exception(node.getText() + "is declared more than one time");
				if (declarations.isEmpty()) throw new Exception(node.getText() + "is not declared");
				
				refExp.setDeclaration(declarations.get(0));
			}
		}
		
		return (Expression) result.getRootASTElement();
	}
}
