package org.nem.grammar.visitor;

import org.nem.ast.value.LValue;
import org.nem.ast.value.LValueDecr;
import org.nem.ast.value.LValueIncr;
import org.nem.ast.value.LValueVar;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class LValueVisitor extends NEMParserBaseVisitor<LValue> {


	@Override
	public LValue visitLValueId(NEMParser.LValueIdContext ctx) {
		return new LValueVar(ctx.getText());
	}

	@Override
	public LValue visitLValueDecr(NEMParser.LValueDecrContext ctx) {
		return new LValueDecr(ctx.lValue().accept(this));
	}

	@Override
	public LValue visitLValueIncr(NEMParser.LValueIncrContext ctx) {
		return new LValueIncr(ctx.lValue().accept(this));
	}

	@Override
	public LValue visitLValueParenthesis(NEMParser.LValueParenthesisContext ctx) {
		return ctx.lValue().accept(this);
	}
}
