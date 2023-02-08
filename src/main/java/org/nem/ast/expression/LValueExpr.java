package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public class LValueExpr implements Expression {
	public final LValue lvalue;

	LValueExpr(LValue lvalue) {
		this.lvalue = lvalue;
	}
}
