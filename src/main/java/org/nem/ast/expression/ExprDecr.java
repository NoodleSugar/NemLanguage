package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public record ExprDecr(LValue lvalue) implements Expression {
}
