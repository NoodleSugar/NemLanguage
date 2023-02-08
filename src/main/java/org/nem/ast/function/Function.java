package org.nem.ast.function;

import org.nem.ast.instruction.Instruction;
import org.nem.ast.type.Type;

import java.util.List;

public class Function {
	public final String name;
	public final Type returnType;
	public final List<Parameter> parameters;
	public final List<Instruction> instructions;

	public Function(
		String name,
		Type returnType,
		List<Parameter> parameters,
		List<Instruction> instructions) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
		this.instructions = instructions;
	}
}
