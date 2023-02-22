package org.nem.ast.expression;

public record ExprArith(
		ArithOp operation,
		Expression left,
		Expression right) implements Expression {
}
