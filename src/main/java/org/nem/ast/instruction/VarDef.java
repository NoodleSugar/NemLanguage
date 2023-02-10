package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.type.Type;

import java.util.Optional;

public class VarDef implements Instruction {
	public final String name;
	public final Optional<Type> type;
	public final Expression expression;

	public VarDef(String name, Expression expression) {
		this.name = name;
		this.type = Optional.empty();
		this.expression = expression;
	}

	public VarDef(String name, Type type, Expression expression) {
		this.name = name;
		this.type = Optional.of(type);
		this.expression = expression;
	}
}
