package org.nem.ast.type;

import org.nem.ast.type.primitive.IntType;
import org.nem.ast.type.primitive.VoidType;

import java.util.HashMap;
import java.util.Map;

public class TypeFactory {
	static private TypeFactory factory;


	static {
		factory = new TypeFactory();
		factory.types.put("void", new VoidType());
		factory.types.put("int", new IntType());
	}

	private final Map<String, Type> types;

	private TypeFactory() {
		types = new HashMap<>();
	}

	static public Type get(String t) {
		return factory.types.get(t);
	}
}
