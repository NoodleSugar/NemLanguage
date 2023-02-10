package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public class ExprIncr implements  Expression{
	private final LValue lvalue;

	public ExprIncr(LValue lvalue) {
		this.lvalue = lvalue;
	}
}
