package hu.bme.mit.magicdraw2gamma.plugin.parsing;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import hu.bme.mit.gamma.constraint.model.BinaryExpression;
import hu.bme.mit.gamma.constraint.model.ConstraintModelFactory;
import hu.bme.mit.gamma.constraint.model.Expression;
import hu.bme.mit.gamma.constraint.model.IntegerLiteralExpression;
import hu.bme.mit.gamma.constraint.model.ReferenceExpression;
import hu.bme.mit.gamma.constraint.model.UnaryExpression;
import hu.bme.mit.gamma.statechart.model.StatechartDefinition;
import hu.bme.mit.magicdraw2gamma.plugin.queries.DeclarationsByName;

public class SimpleGuardParser {
	
	ConstraintModelFactory cf = ConstraintModelFactory.eINSTANCE;
	
	String codeToParse = null;
	HashSet<String> keywords = new HashSet<>();
	
	public SimpleGuardParser() {
		
		keywords.add("==");
		keywords.add("<=");
		keywords.add(">=");
		keywords.add("!=");
		keywords.add("<");
		keywords.add(">");
	}

	public Expression parse(StatechartDefinition statechartDefinition, ViatraQueryEngine engine, String code) throws Exception {
		if ("".equals(code)) return null;
		if ("else".equals(code.trim())) return cf.createElseExpression();
		if ("true".equals(code.trim())) return cf.createTrueExpression();
		if ("false".equals(code.trim())) return cf.createFalseExpression();
		
		Collection<String> foundKeyWords = keywords.stream().filter(it -> code.contains(it)).collect(Collectors.toList());
		
		if (foundKeyWords.size() > 1 || foundKeyWords.isEmpty()) throw new Exception("Badly formed expression");
		
		String keyword = foundKeyWords.iterator().next();
		
		String[] operands = code.split(keyword);
		
		Expression[] operandsE = new Expression[operands.length];
		
		for (int i = 0; i < operands.length; i++) {
			operandsE[i] = transformOperand(statechartDefinition, operands[i].trim(), engine);
		}
		
		Expression expr = null;
		boolean negate = false;
		
		switch (keyword) {
			case "==" : {
				 expr = cf.createEqualityExpression();
				break;
			}
			case "<" : {
				expr = cf.createLessExpression();
				break;
			}
			case ">" : {
				expr = cf.createGreaterExpression();
				break;
			}
			case "<=" : {
				expr = cf.createLessEqualExpression();
				break;
			}
			case ">=" : {
				expr = cf.createGreaterEqualExpression();
				break;
			}
			case "!=" : {
				expr = cf.createEqualityExpression();
				negate = true;
				break;
			}
		}
		
		((BinaryExpression) expr).setLeftOperand(operandsE[0]);
		((BinaryExpression) expr).setRightOperand(operandsE[1]);
		
		if (negate) {
			UnaryExpression ue = cf.createNotExpression();
			ue.setOperand(expr);
			return ue;
		}
		
		return expr;
	}
	
	
	public Expression transformOperand(StatechartDefinition statechartDefinition, String s, ViatraQueryEngine engine) throws Exception {
		
		try {
			Long lo = Long.parseLong(s);
			IntegerLiteralExpression literal = cf.createIntegerLiteralExpression();
			literal.setValue(BigInteger.valueOf(lo));
			return literal;
			
		} catch(NumberFormatException e) { }
		
		if ("true".equals(s)) return cf.createTrueExpression();
		if ("false".equals(s)) return cf.createFalseExpression();
		
		//not a number
		
		DeclarationsByName.Matcher matcher = DeclarationsByName.instance().getMatcher(engine);
		Collection<DeclarationsByName.Match> matches = 
				matcher.getAllMatches(statechartDefinition, s, null);
		
		Optional<DeclarationsByName.Match> m = matches.stream().findFirst();
		
		if (m.isPresent()) {
			ReferenceExpression ref = cf.createReferenceExpression();
			ref.setDeclaration(m.get().getDeclaration());
			return ref;
		}
		

		
		throw new Exception("Badly formed expression");
	}
}
