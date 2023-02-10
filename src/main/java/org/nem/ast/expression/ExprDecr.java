package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public class ExprDecr implements Expression {
	private final LValue lvalue;

	public ExprDecr(LValue lvalue) {
		this.lvalue = lvalue;
	}
}
