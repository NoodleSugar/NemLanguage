package org.nem.ast.visitor;

import org.nem.ast.expression.*;
import org.nem.ast.expression.ExprFnCall;
import org.nem.ast.expression.ArithOp;
import org.nem.ast.value.LValue;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

import java.util.List;

public class ExprVisitor extends NEMParserBaseVisitor<Expression> {

	@Override
	public Expression visitExprLiteral(NEMParser.ExprLiteralContext ctx) {
		return new ExprNum(ctx.literal().L_NUM().getText());
	}

	@Override
	public Expression visitExprlValue(NEMParser.ExprlValueContext ctx) {
		return new ExprLValue(ctx.lValue().accept(new LValueVisitor()));
	}

	@Override
	public Expression visitExprIncr(NEMParser.ExprIncrContext ctx) {
		return new ExprIncr(ctx.lValue().accept(new LValueVisitor()));
	}

	@Override
	public Expression visitExprDecr(NEMParser.ExprDecrContext ctx) {
		return new ExprDecr(ctx.lValue().accept(new LValueVisitor()));
	}

	@Override
	public Expression visitExprFnCall(NEMParser.ExprFnCallContext ctx) {
		LValue fnName = ctx.fnCall().lValue().accept(new LValueVisitor());
		List<Expression> arguments = ctx
				.fnCall()
				.callOp()
				.argSeq()
				.expr()
				.stream()
				.map(arg -> arg.accept(this))
				.toList();

		return new ExprFnCall(fnName, arguments);
	}

	@Override
	public Expression visitExprParenthesis(NEMParser.ExprParenthesisContext ctx) {
		return ctx.expr().accept(this);
	}

	@Override
	public Expression visitExprMinus(NEMParser.ExprMinusContext ctx) {
		return new ExprMinus(ctx.expr().accept(this));
	}

	@Override
	public Expression visitExprAdd(NEMParser.ExprAddContext ctx) {
		final Expression left = ctx.left.accept(this);
		final Expression right = ctx.right.accept(this);

		return new ExprArith(ArithOp.Addition, left, right);
	}

	@Override
	public Expression visitExprSub(NEMParser.ExprSubContext ctx) {
		final Expression left = ctx.left.accept(this);
		final Expression right = ctx.right.accept(this);

		return new ExprArith(ArithOp.Substraction, left, right);
	}

	@Override
	public Expression visitExprMul(NEMParser.ExprMulContext ctx) {

		final Expression left = ctx.left.accept(this);
		final Expression right = ctx.right.accept(this);

		return new ExprArith(ArithOp.Multiplication, left, right);
	}

	@Override
	public Expression visitExprDiv(NEMParser.ExprDivContext ctx) {

		final Expression left = ctx.left.accept(this);
		final Expression right = ctx.right.accept(this);

		return new ExprArith(ArithOp.Division, left, right);
	}

	@Override
	public Expression visitExprMod(NEMParser.ExprModContext ctx) {

		final Expression left = ctx.left.accept(this);
		final Expression right = ctx.right.accept(this);

		return new ExprArith(ArithOp.Modulo, left, right);
	}
}
