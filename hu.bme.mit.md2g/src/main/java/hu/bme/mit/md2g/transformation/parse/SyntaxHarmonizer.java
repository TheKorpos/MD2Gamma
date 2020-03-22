package hu.bme.mit.md2g.transformation.parse;

import java.util.Arrays;

public class SyntaxHarmonizer {
	
	public static String createHarmonizedGammaExpression(String foreignExpression) {
		return new Harmonization(foreignExpression).harmonize();
	}
	
	private static class Harmonization{
		
		private String expression;

		public Harmonization(String expressionToHarmonize) {
			this.expression = expressionToHarmonize;
		}
		
		public String harmonize() {
			doHarmonize();
			return expression;
		}
		
		private void doHarmonize() {
			harmonizeAnd();
			harmonizeOr();
			harmonizeEquals();
		}
		
		private void harmonizeAnd() {
			expression = harmonizeWith("\\&\\&", " and ");
		}
		
		private void harmonizeOr() {
			expression = harmonizeWith("\\|\\|", " or ");
		}
		
		
		private void harmonizeEquals() {
			expression = harmonizeWith("==", " = ");
		}
		
		private String harmonizeWith(final String original, final String harmonized) {
			return  Arrays.stream(expression.split(original)).map(String::trim).reduce((p, n) -> p + harmonized + n).get();
		}
		
		
	}

}
