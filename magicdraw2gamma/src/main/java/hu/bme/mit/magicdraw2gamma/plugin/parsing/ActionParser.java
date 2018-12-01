package hu.bme.mit.magicdraw2gamma.plugin.parsing;

import java.io.StringReader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

import hu.bme.mit.gamma.constraint.model.ConstraintModelPackage;
import hu.bme.mit.gamma.constraint.model.Expression;
import hu.bme.mit.gamma.constraint.model.ReferenceExpression;
import hu.bme.mit.gamma.constraint.model.VariableDeclaration;
import hu.bme.mit.gamma.statechart.language.StatechartLanguageStandaloneSetup;
import hu.bme.mit.gamma.statechart.language.parser.antlr.StatechartLanguageParser;
import hu.bme.mit.gamma.statechart.language.services.StatechartLanguageGrammarAccess;
import hu.bme.mit.gamma.statechart.model.Action;
import hu.bme.mit.gamma.statechart.model.AssignmentAction;
import hu.bme.mit.gamma.statechart.model.RaiseEventAction;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.gamma.statechart.model.StatechartModelPackage;
import hu.bme.mit.gamma.statechart.model.interface_.Event;
//This class is experimental, it would be nice if the language parser could be used to parse parts of the grammar
public class ActionParser {
	
	Injector injector = new StatechartLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	
	public EObject parseTimeSpecification(String s) {
		ParserRule rule = injector.getInstance(StatechartLanguageGrammarAccess.class).getTimeSpecificationRule();
		
		IParseResult result = injector.getInstance(StatechartLanguageParser.class).parse(rule, new StringReader(s));
		EObject element = result.getRootASTElement();
		return element;
	}
	
	public Expression parseGuard(ViatraQueryEngine engine, StatechartDefinition statechartDefinition, String s) throws Exception {
		ParserRule rule = injector.getInstance(StatechartLanguageGrammarAccess.class).getAndExpressionRule();
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
	
	public List<Action> paresAction(ViatraQueryEngine engine, StatechartDefinition scope, String s) throws Exception {
		StatechartModelPackage.eINSTANCE.getNsURI();
		ConstraintModelPackage.eINSTANCE.getNsURI();
		
		ParserRule rule = injector.getInstance(StatechartLanguageGrammarAccess.class).getActionRule();
		
		String[] actionDefs = s.split(";");
		List<Action> actionList = Lists.newArrayList(); 
		
		for (int i = 0; i < actionDefs.length; i++) {
			
			IParseResult result = injector.getInstance(StatechartLanguageParser.class).parse(rule, new StringReader(s));
			
			for (INode node: result.getSyntaxErrors()) {
				throw new Exception(node.getSyntaxErrorMessage().getMessage());
			}
			
			//Manually resolve references
			if (result.getRootASTElement() instanceof AssignmentAction) {
				for (INode node :result.getRootNode().getLeafNodes()) {
					if (node.getGrammarElement() instanceof CrossReference) {
						final ReferenceExpression refExp = (ReferenceExpression) node.getSemanticElement();
						
						if (result.getRootASTElement() instanceof AssignmentAction) {
							Set<VariableDeclaration> named = scope.getVariableDeclarations().stream().filter( m -> node.getText().equals(m.getName())).collect(Collectors.toSet());
							
							if (named.size() > 1) throw new Exception(node.getText() + "is declared more than one time");
							if (named.isEmpty()) throw new Exception(node.getText() + "is not declared");
							
							refExp.setDeclaration(named.iterator().next());
							actionList.add((Action) result.getRootASTElement());	
						}
					}	
				}
			} else if (result.getRootASTElement() instanceof RaiseEventAction) {
				final RaiseEventAction action = (RaiseEventAction) result.getRootASTElement();
				
				for (INode node: result.getRootNode().getLeafNodes()) {
					if (!node.getText().equals("raise") && !" ".equals(node.getText()) && !".".equals(node.getText())) {
						if (node.getText().equals("All")) {
							action.setPort(scope.getPorts().get(0));
						} else {
							Set<Event> events = scope.getPorts().get(0).getInterfaceRealization().getInterface().getEvents().stream()
								.map(decl -> decl.getEvent())
								.filter(ev -> ev.getName().equals(node.getText()))
								.collect(Collectors.toSet());
							if (events.size() > 1) throw new Exception(node.getText() + " Multiple Signals with same name");
							if (events.isEmpty()) throw new Exception(node.getText() + " Signal is not used in statecmachine");
							
							action.setEvent(events.iterator().next());
							actionList.add(action);
		
						}
					}
				}
			} else throw new Exception("Unsupported action: " + s);
		
		}
		
		
		
		
		return actionList;
		
		
	}
	
	
}
