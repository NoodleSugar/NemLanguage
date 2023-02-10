package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.value.LValue;

public class Assignment implements Instruction {
	public final AssignOp op;
	public final LValue left;
	public final Expression right;

	public Assignment(
			AssignOp op,
			LValue left,
			Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
