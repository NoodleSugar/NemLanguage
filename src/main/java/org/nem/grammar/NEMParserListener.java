// Generated from java-escape by ANTLR 4.11.1
package org.nem.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NEMParser}.
 */
public interface NEMParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NEMParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(NEMParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(NEMParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#top_level}.
	 * @param ctx the parse tree
	 */
	void enterTop_level(NEMParser.Top_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#top_level}.
	 * @param ctx the parse tree
	 */
	void exitTop_level(NEMParser.Top_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#module_path}.
	 * @param ctx the parse tree
	 */
	void enterModule_path(NEMParser.Module_pathContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#module_path}.
	 * @param ctx the parse tree
	 */
	void exitModule_path(NEMParser.Module_pathContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#module_import}.
	 * @param ctx the parse tree
	 */
	void enterModule_import(NEMParser.Module_importContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#module_import}.
	 * @param ctx the parse tree
	 */
	void exitModule_import(NEMParser.Module_importContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#module_decl}.
	 * @param ctx the parse tree
	 */
	void enterModule_decl(NEMParser.Module_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#module_decl}.
	 * @param ctx the parse tree
	 */
	void exitModule_decl(NEMParser.Module_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#module_export}.
	 * @param ctx the parse tree
	 */
	void enterModule_export(NEMParser.Module_exportContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#module_export}.
	 * @param ctx the parse tree
	 */
	void exitModule_export(NEMParser.Module_exportContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(NEMParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(NEMParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(NEMParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(NEMParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#param_seq}.
	 * @param ctx the parse tree
	 */
	void enterParam_seq(NEMParser.Param_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#param_seq}.
	 * @param ctx the parse tree
	 */
	void exitParam_seq(NEMParser.Param_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#arg_seq}.
	 * @param ctx the parse tree
	 */
	void enterArg_seq(NEMParser.Arg_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#arg_seq}.
	 * @param ctx the parse tree
	 */
	void exitArg_seq(NEMParser.Arg_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#fn_signature}.
	 * @param ctx the parse tree
	 */
	void enterFn_signature(NEMParser.Fn_signatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#fn_signature}.
	 * @param ctx the parse tree
	 */
	void exitFn_signature(NEMParser.Fn_signatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#fn_decl}.
	 * @param ctx the parse tree
	 */
	void enterFn_decl(NEMParser.Fn_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#fn_decl}.
	 * @param ctx the parse tree
	 */
	void exitFn_decl(NEMParser.Fn_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#fn_def}.
	 * @param ctx the parse tree
	 */
	void enterFn_def(NEMParser.Fn_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#fn_def}.
	 * @param ctx the parse tree
	 */
	void exitFn_def(NEMParser.Fn_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#fn_call}.
	 * @param ctx the parse tree
	 */
	void enterFn_call(NEMParser.Fn_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#fn_call}.
	 * @param ctx the parse tree
	 */
	void exitFn_call(NEMParser.Fn_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#instr_block}.
	 * @param ctx the parse tree
	 */
	void enterInstr_block(NEMParser.Instr_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#instr_block}.
	 * @param ctx the parse tree
	 */
	void exitInstr_block(NEMParser.Instr_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#instr_seq}.
	 * @param ctx the parse tree
	 */
	void enterInstr_seq(NEMParser.Instr_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#instr_seq}.
	 * @param ctx the parse tree
	 */
	void exitInstr_seq(NEMParser.Instr_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterInstr(NEMParser.InstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitInstr(NEMParser.InstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(NEMParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(NEMParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(NEMParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(NEMParser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(NEMParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(NEMParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(NEMParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(NEMParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NEMParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NEMParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArith_expr(NEMParser.Arith_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArith_expr(NEMParser.Arith_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(NEMParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#bool_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(NEMParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(NEMParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(NEMParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(NEMParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(NEMParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_type(NEMParser.Primitive_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_type(NEMParser.Primitive_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#var_type_seq}.
	 * @param ctx the parse tree
	 */
	void enterVar_type_seq(NEMParser.Var_type_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#var_type_seq}.
	 * @param ctx the parse tree
	 */
	void exitVar_type_seq(NEMParser.Var_type_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(NEMParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(NEMParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#generic_arg_seq}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_arg_seq(NEMParser.Generic_arg_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#generic_arg_seq}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_arg_seq(NEMParser.Generic_arg_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#generic_arg}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_arg(NEMParser.Generic_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#generic_arg}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_arg(NEMParser.Generic_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link NEMParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(NEMParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NEMParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(NEMParser.Return_typeContext ctx);
}