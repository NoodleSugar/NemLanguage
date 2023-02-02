package org.nem.ast.function;

import org.nem.ast.instruction.Instruction;
import org.nem.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Function {
	public final String name;
	public final Type returnType;
	public final List<Parameter> parameters;
	public final List<Instruction> instructions;

	private Function(
			String name,
			Type returnType,
			List<Parameter> parameters,
			List<Instruction> instructions) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
		this.instructions = instructions;
	}

	static public class Builder {
		private String name;
		private Type returnType;
		private List<Parameter> parameters;
		private List<Instruction> instructions;

		public Builder(String name, Type returnType) {
			this.name = name;
			this.returnType = returnType;
			this.parameters = new ArrayList<>();
			this.instructions = new ArrayList<>();
		}

		public Builder addParameter(Parameter p) {
			parameters.add(p);
			return this;
		}

		public Builder addInstruction(Instruction i) {
			instructions.add(i);
			return this;
		}

		public Function build() {
			return new Function(name, returnType, parameters, instructions);
		}
	}
}
