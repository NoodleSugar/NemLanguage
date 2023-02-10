package org.nem.ast.expression;

import org.nem.ast.value.LValue;

import java.util.List;

public class ExprFnCall implements Expression {
	public final LValue fnName;
	public final List<Expression> arguments;

	public ExprFnCall(LValue fnName, List<Expression> arguments) {
		this.fnName = fnName;
		this.arguments = arguments;
	}
}
