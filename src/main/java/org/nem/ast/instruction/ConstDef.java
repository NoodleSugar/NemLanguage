package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.type.Type;

import java.util.Optional;

public record ConstDef(
		String name,
		Optional<Type> type,
		Expression expression) implements Instruction {

	public ConstDef(String n, Expression e) {
		this(n, Optional.empty(), e);
	}

	public ConstDef(String n, Type t, Expression e) {
		this(n, Optional.of(t), e);
	}
}
