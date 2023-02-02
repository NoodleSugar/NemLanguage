package org.nem.ast.expression;

public class ArithExpression {
	public final ArithOperation operation;
	public final Expression left;
	public final Expression right;

	public ArithExpression(
			ArithOperation operation,
			Expression left,
			Expression right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}
}
