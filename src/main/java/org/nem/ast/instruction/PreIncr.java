package org.nem.ast.instruction;

import org.nem.ast.value.LValue;

public record PreIncr(LValue lvalue) implements Instruction {
}
