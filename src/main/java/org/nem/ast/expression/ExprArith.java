package org.nem.ast.expression;

public class ExprArith implements Expression {
	public final ArithOp operation;
	public final Expression left;
	public final Expression right;

	public ExprArith(
			ArithOp operation,
			Expression left,
			Expression right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}
}
