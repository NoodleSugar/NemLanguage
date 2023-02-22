package org.nem.ast.instruction;

import org.nem.ast.value.LValue;

public record PreDecr(LValue lvalue) implements Instruction {
}
