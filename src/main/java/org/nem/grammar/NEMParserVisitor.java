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
	 * Visit a parse tree produced by {@link NEMParser#file_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile_content(NEMParser.File_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#top_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_level(NEMParser.Top_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_def(NEMParser.Fn_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_signature(NEMParser.Fn_signatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#param_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_seq(NEMParser.Param_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(NEMParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#op_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_call(NEMParser.Op_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#arg_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_seq(NEMParser.Arg_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#instr_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr_block(NEMParser.Instr_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#instr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr_seq(NEMParser.Instr_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr(NEMParser.InstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(NEMParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def(NEMParser.Var_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#const_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_def(NEMParser.Const_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(NEMParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#assign_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_operator(NEMParser.Assign_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_call(NEMParser.Fn_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NEMParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(NEMParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(NEMParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(NEMParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_type(NEMParser.Primitive_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(NEMParser.Return_typeContext ctx);
}