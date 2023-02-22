package org.nem.ast.type;

public final class NativeType implements Type {

	public static final NativeType VOID = new NativeType(TypeEnum.Void);
	public static final NativeType INT = new NativeType(TypeEnum.Int);

	private TypeEnum t;

	NativeType(TypeEnum t) {
		this.t = t;
	}

	public TypeEnum type() {
		return t;
	}

	private enum TypeEnum {
		Void,
		Int
	}
}
