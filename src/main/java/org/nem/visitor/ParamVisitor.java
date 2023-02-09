package org.nem.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.nem.ast.function.Parameter;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class ParamVisitor extends NEMParserBaseVisitor<Parameter> {

	@Override
	public Parameter visitParam(NEMParser.ParamContext ctx) {
		Type type = TypeFactory.get(ctx.var_type().getText());

		if(ctx.IDENTIFIER() == null)
			return new Parameter(type);

		return new Parameter(type, ctx.IDENTIFIER().getText());
	}
}
