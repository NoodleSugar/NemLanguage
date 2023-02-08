package org.nem.ast.value;

public class Variable implements LValue{
	public final String name;

	Variable(String name) {
		this.name = name;
	}
}
