package org.nem.ast.instruction;

import org.nem.ast.value.LValue;

public record PostIncr(LValue lvalue) implements Instruction {
}
