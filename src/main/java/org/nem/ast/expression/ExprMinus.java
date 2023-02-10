package org.nem.ast.expression;

public class ExprMinus implements Expression {
	public final Expression expression;

	public ExprMinus(Expression expression) {
		this.expression = expression;
	}
}
