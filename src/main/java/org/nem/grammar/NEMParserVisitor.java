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
	 * Visit a parse tree produced by {@link NEMParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(NEMParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#top_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_level(NEMParser.Top_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#module_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_path(NEMParser.Module_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#module_import}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_import(NEMParser.Module_importContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#module_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_decl(NEMParser.Module_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#module_export}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_export(NEMParser.Module_exportContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(NEMParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(NEMParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#param_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_seq(NEMParser.Param_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#arg_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_seq(NEMParser.Arg_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_signature(NEMParser.Fn_signatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_decl(NEMParser.Fn_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_def(NEMParser.Fn_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#fn_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_call(NEMParser.Fn_callContext ctx);
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
	 * Visit a parse tree produced by {@link NEMParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(NEMParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(NEMParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NEMParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#arith_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_expr(NEMParser.Arith_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#bool_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expr(NEMParser.Bool_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(NEMParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(NEMParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_type(NEMParser.Primitive_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#var_type_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type_seq(NEMParser.Var_type_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(NEMParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#generic_arg_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_arg_seq(NEMParser.Generic_arg_seqContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#generic_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric_arg(NEMParser.Generic_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link NEMParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(NEMParser.Return_typeContext ctx);
}