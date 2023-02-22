package org.nem.ast.type;

import java.util.HashMap;
import java.util.Map;

public class TypeFactory {
	static private TypeFactory factory;

	static {
		factory = new TypeFactory();
		factory.types.put("void", NativeType.VOID);
		factory.types.put("int", NativeType.INT);
	}

	private final Map<String, Type> types;

	private TypeFactory() {
		types = new HashMap<>();
	}

	static public Type get(String t) {
		return factory.types.get(t);
	}
}
