package org.nem.ast.instruction;

import org.nem.ast.value.LValue;

public record PostDecr(LValue lvalue) implements Instruction {
}
