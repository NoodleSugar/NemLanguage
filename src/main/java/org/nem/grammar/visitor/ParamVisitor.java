package org.nem.grammar.visitor;

import org.nem.ast.function.Parameter;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class ParamVisitor extends NEMParserBaseVisitor<Parameter> {
	@Override
	public Parameter visitParam(NEMParser.ParamContext ctx) {
		Type type = TypeFactory.get(ctx.varType().getText());
		String name = ctx.IDENTIFIER().getText();

		return new Parameter(type, name);
	}
}
