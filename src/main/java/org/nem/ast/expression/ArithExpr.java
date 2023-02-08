package org.nem.ast.expression;

public class ArithExpr implements Expression {
	public final ArithOp operation;
	public final Expression left;
	public final Expression right;

	public ArithExpr(
			ArithOp operation,
			Expression left,
			Expression right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}
}
