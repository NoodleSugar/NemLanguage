package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public class ExprLValue implements Expression {
	public final LValue lvalue;

	public ExprLValue(LValue lvalue) {
		this.lvalue = lvalue;
	}
}
