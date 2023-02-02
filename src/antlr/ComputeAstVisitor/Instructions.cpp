#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

Node::Ptr ComputeAstVisitor::computeInstrAssign(AssignOp				   op,
													 NEMParser::LValueContext* lValueCtx,
													 NEMParser::ExprContext*   exprCtx)
{
	auto left  = nodeFromVisit(lValueCtx);
	auto right = nodeFromVisit(exprCtx);

	return Node::Ptr(new AssignmentNode{op, left, right});
}

std::any ComputeAstVisitor::visitBlock(NEMParser::BlockContext* ctx)
{
	Block block;
	block.instructions.reserve(ctx->instr().size());

	for(auto instr: ctx->instr())
		block.instructions.push_back(nodeFromVisit(instr));

	return block;
}

std::any ComputeAstVisitor::visitInstrBlock(NEMParser::InstrBlockContext* ctx)
{
	auto block = std::any_cast<Block>(visitBlock(ctx->block()));

	return Node::Ptr(new BlockNode{block});
}

std::any ComputeAstVisitor::visitInstrTerminated(NEMParser::InstrTerminatedContext* ctx)
{
	return ctx->terminatedInstr()->accept(this);
}

std::any ComputeAstVisitor::visitInstrVarDecl(NEMParser::InstrVarDeclContext* ctx)
{
	auto name = ctx->IDENTIFIER()->getText();
	auto type = nodeFromVisit(ctx->varType());

	return Node::Ptr(new DeclarationNode{name, type});
}

std::any ComputeAstVisitor::visitInstrVarDefWithType(NEMParser::InstrVarDefWithTypeContext* ctx)
{
	auto name  = ctx->IDENTIFIER()->getText();
	auto type  = nodeFromVisit(ctx->varType());
	auto value = nodeFromVisit(ctx->expr());

	return Node::Ptr(new DefinitionNode{name, type, value});
}

std::any ComputeAstVisitor::visitInstrVarDefWithoutType(NEMParser::InstrVarDefWithoutTypeContext* ctx)
{
	auto name  = ctx->IDENTIFIER()->getText();
	auto value = nodeFromVisit(ctx->expr());

	return Node::Ptr(new DefinitionNode{name, std::nullopt, value});
}

std::any ComputeAstVisitor::visitInstrAssignSimple(NEMParser::InstrAssignSimpleContext* ctx)
{
	return computeInstrAssign(AssignOp::Equal,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrAssignAdd(NEMParser::InstrAssignAddContext* ctx)
{
	return computeInstrAssign(AssignOp::AddEqual,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrAssignSub(NEMParser::InstrAssignSubContext* ctx)
{
	return computeInstrAssign(AssignOp::SubEqual,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrAssignMul(NEMParser::InstrAssignMulContext* ctx)
{
	return computeInstrAssign(AssignOp::MulEqual,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrAssignDiv(NEMParser::InstrAssignDivContext* ctx)
{
	return computeInstrAssign(AssignOp::DivEqual,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrAssignMod(NEMParser::InstrAssignModContext* ctx)
{
	return computeInstrAssign(AssignOp::ModEqual,
							  ctx->lValue(),
							  ctx->expr());
}

std::any ComputeAstVisitor::visitInstrReturnWithValue(NEMParser::InstrReturnWithValueContext* ctx)
{
	auto value = nodeFromVisit(ctx->expr());

	return Node::Ptr(new ReturnNode{value});
}

std::any ComputeAstVisitor::visitInstrReturnWithoutValue(NEMParser::InstrReturnWithoutValueContext*)
{
	return Node::Ptr(new ReturnNode);
}