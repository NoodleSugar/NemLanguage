package org.nem.ast.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.nem.ast.function.Parameter;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class ParamVisitor extends NEMParserBaseVisitor<Parameter> {

	@Override
	public Parameter visitParamWithoutName(NEMParser.ParamWithoutNameContext ctx) {
		Type type = TypeFactory.get(ctx.varType().getText());
		return new Parameter(type);
	}

	@Override
	public Parameter visitParamWithName(NEMParser.ParamWithNameContext ctx) {
		Type type = TypeFactory.get(ctx.varType().getText());
		String name = ctx.IDENTIFIER().getText();

		return new Parameter(type, name);
	}
}
