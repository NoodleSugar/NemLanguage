package org.nem.ast.instruction;

import org.nem.ast.type.Type;

public record VarDecl(String name, Type type) implements Instruction {
}
