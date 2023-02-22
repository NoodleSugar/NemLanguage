package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public record ExprLValue(LValue lvalue) implements Expression {
}
