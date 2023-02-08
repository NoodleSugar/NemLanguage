package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.value.LValue;

public class Assignment implements Instruction {
	public final AssignOp operator;
	public final LValue left;
	public final Expression right;

	public Assignment(
			LValue left,
			AssignOp operator,
			Expression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
}
