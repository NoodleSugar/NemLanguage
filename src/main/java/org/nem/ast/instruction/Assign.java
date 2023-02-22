package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.value.LValue;

public record Assign(
		AssignOp op,
		LValue left,
		Expression right) implements Instruction {
}
