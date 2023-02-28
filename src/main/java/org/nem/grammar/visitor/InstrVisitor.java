package org.nem.grammar.visitor;

import org.nem.ast.expression.Expression;
import org.nem.ast.instruction.*;
import org.nem.ast.instruction.AssignOp;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.ast.value.LValue;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class InstrVisitor extends NEMParserBaseVisitor<Instruction> {
	@Override
	public Instruction visitInstr(NEMParser.InstrContext ctx) {

		return ctx.getChild(0).accept(this);
	}

	@Override
	public Instruction visitVarDecl(NEMParser.VarDeclContext ctx) {
		final String name = ctx.IDENTIFIER().getText();
		final Type type = TypeFactory.get(ctx.varType().getText());

		return new VarDecl(name, type);
	}

	@Override
	public Instruction visitConstDefWithoutType(NEMParser.ConstDefWithoutTypeContext ctx) {
		final String name = ctx.IDENTIFIER().getText();
		final Expression expression = ctx.expr().accept(new ExprVisitor());

		return new ConstDef(name,expression);
	}

	@Override
	public Instruction visitConstDefWithType(NEMParser.ConstDefWithTypeContext ctx) {
		final String name = ctx.IDENTIFIER().getText();
		final Type type = TypeFactory.get(ctx.varType().getText());
		final Expression expression = ctx.expr().accept(new ExprVisitor());

		return new ConstDef(name, type, expression);
	}

	@Override
	public Instruction visitVarDefWithoutType(NEMParser.VarDefWithoutTypeContext ctx) {
		final String name = ctx.IDENTIFIER().getText();
		final Expression expression = ctx.expr().accept(new ExprVisitor());

		return new VarDef(name, expression);
	}

	@Override
	public Instruction visitVarDefWithType(NEMParser.VarDefWithTypeContext ctx) {
		final String name = ctx.IDENTIFIER().getText();
		final Type type = TypeFactory.get(ctx.varType().getText());
		final Expression expression = ctx.expr().accept(new ExprVisitor());

		return new VarDef(name, type, expression);
	}

	@Override
	public Instruction visitAssign(NEMParser.AssignContext ctx) {
		AssignOp op = switch (ctx.assignOp().op.getType()) {
			case NEMParser.EQ -> AssignOp.Equal;
			case NEMParser.ADD_EQ -> AssignOp.AddEqual;
			case NEMParser.SUB_EQ -> AssignOp.SubEqual;
			case NEMParser.MUL_EQ -> AssignOp.MulEqual;
			case NEMParser.DIV_EQ -> AssignOp.DivEqual;
			case NEMParser.MOD_EQ -> AssignOp.ModEqual;
			default -> null;
		};

		LValue left = ctx.left.accept(new LValueVisitor());
		Expression right = ctx.right.accept(new ExprVisitor());
		return new Assign(op, left, right);
	}
}
