package org.nem.ast.function;

import org.nem.ast.type.Type;

import java.util.Optional;

public class Parameter {
	public final Type type;
	public final Optional<String> name;

	public Parameter(Type type){
		this.type = type;
		this.name = Optional.empty();
	}

	public Parameter(Type type, String name){
		this.type = type;
		this.name = Optional.of(name);
	}
}
