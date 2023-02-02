package org.nem.ast.type;

import org.nem.ast.type.primitive.IntType;
import org.nem.ast.type.primitive.PrimitiveType;
import org.nem.ast.type.primitive.VoidType;

import java.util.Map;

public class TypeFactory {
	static private TypeFactory factory;

	static private Map<PrimitiveType, Type> primitivesTypes;

	static {
		factory = new TypeFactory();
        primitivesTypes.put(PrimitiveType.VOID, new VoidType());
        primitivesTypes.put(PrimitiveType.INT, new IntType());
	};

	static public Type get(PrimitiveType t) {
		return factory.primitivesTypes.get(t);
	}
}
