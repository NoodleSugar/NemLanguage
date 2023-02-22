package org.nem.ast.expression;

import org.nem.ast.value.LValue;

public record ExprIncr(LValue lvalue) implements Expression {
}
