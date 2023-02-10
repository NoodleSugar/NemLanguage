package org.nem.ast.value;

public class LValueVar implements LValue {
	public final String name;

	public LValueVar(String name) {
		this.name = name;
	}
}
