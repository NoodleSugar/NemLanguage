package org.nem.ast.function;

import org.nem.ast.instruction.Instruction;
import org.nem.ast.type.Type;

import java.util.List;

public record Function(
		String name,
		Type returnType,
		List<Parameter> parameters,
		List<Instruction> instructions) {
}
