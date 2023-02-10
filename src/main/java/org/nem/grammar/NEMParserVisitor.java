// Generated from java-escape by ANTLR 4.11.1
package org.nem.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NEMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NEMParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NEMParser#fileContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileContent(NEMParser.FileContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevel(NEMParser.TopLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fnDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnDef(NEMParser.FnDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fnSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnSignature(NEMParser.FnSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#paramSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamSeq(NEMParser.ParamSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamWithoutName}
	 * labeled alternative in {@link NEMParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamWithoutName(NEMParser.ParamWithoutNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamWithName}
	 * labeled alternative in {@link NEMParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamWithName(NEMParser.ParamWithNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#callOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallOp(NEMParser.CallOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#argSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgSeq(NEMParser.ArgSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#instrBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrBlock(NEMParser.InstrBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr(NEMParser.InstrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrPreIncr}
	 * labeled alternative in {@link NEMParser#incrInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrPreIncr(NEMParser.InstrPreIncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrPreDecr}
	 * labeled alternative in {@link NEMParser#incrInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrPreDecr(NEMParser.InstrPreDecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrPostIncr}
	 * labeled alternative in {@link NEMParser#incrInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrPostIncr(NEMParser.InstrPostIncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrPostDecr}
	 * labeled alternative in {@link NEMParser#incrInstr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrPostDecr(NEMParser.InstrPostDecrContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(NEMParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDefWithoutType}
	 * labeled alternative in {@link NEMParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefWithoutType(NEMParser.VarDefWithoutTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDefWithType}
	 * labeled alternative in {@link NEMParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefWithType(NEMParser.VarDefWithTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDefWithoutType}
	 * labeled alternative in {@link NEMParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDefWithoutType(NEMParser.ConstDefWithoutTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDefWithType}
	 * labeled alternative in {@link NEMParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDefWithType(NEMParser.ConstDefWithTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(NEMParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#assignOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOp(NEMParser.AssignOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnCall(NEMParser.FnCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFnCall}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFnCall(NEMParser.ExprFnCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprlValue}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlValue(NEMParser.ExprlValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMinus}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMinus(NEMParser.ExprMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecr}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecr(NEMParser.ExprDecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(NEMParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(NEMParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParenthesis}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenthesis(NEMParser.ExprParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIncr}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIncr(NEMParser.ExprIncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMul}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMul(NEMParser.ExprMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiv(NEMParser.ExprDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(NEMParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMod}
	 * labeled alternative in {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMod(NEMParser.ExprModContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(NEMParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LValueId}
	 * labeled alternative in {@link NEMParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLValueId(NEMParser.LValueIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LValueIncr}
	 * labeled alternative in {@link NEMParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLValueIncr(NEMParser.LValueIncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LValueDecr}
	 * labeled alternative in {@link NEMParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLValueDecr(NEMParser.LValueDecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LValueParenthesis}
	 * labeled alternative in {@link NEMParser#lValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLValueParenthesis(NEMParser.LValueParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link NEMParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(NEMParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithoutReturnType}
	 * labeled alternative in {@link NEMParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithoutReturnType(NEMParser.WithoutReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WithReturnType}
	 * labeled alternative in {@link NEMParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithReturnType(NEMParser.WithReturnTypeContext ctx);
}