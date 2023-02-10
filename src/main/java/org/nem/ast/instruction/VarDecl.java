package org.nem.ast.instruction;

import org.nem.ast.type.Type;

public class VarDecl implements Instruction {
	public final String name;
	public final Type type;

	public VarDecl(String name, Type type) {
		this.name = name;
		this.type = type;
	}
}
