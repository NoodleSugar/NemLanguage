package org.nem.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.nem.ast.function.Parameter;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class ParamVisitor extends NEMParserBaseVisitor<Parameter> {

	@Override
	public Parameter visitParam(NEMParser.ParamContext ctx) {
		TerminalNode id = ctx.IDENTIFIER();
		TerminalNode colon = ctx.COLON();
		NEMParser.Var_typeContext p = ctx.var_type();
		return super.visitParam(ctx);
	}
}
