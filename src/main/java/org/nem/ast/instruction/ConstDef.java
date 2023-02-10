package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.type.Type;

import java.util.Optional;

public class ConstDef implements Instruction {
	public final String name;
	public final Optional<Type> type;
	public final Expression expression;

	public ConstDef(String name, Expression expression) {
		this.name = name;
		this.type = Optional.empty();
		this.expression = expression;
	}

	public ConstDef(String name, Type type, Expression expression) {
		this.name = name;
		this.type = Optional.of(type);
		this.expression = expression;
	}
}
