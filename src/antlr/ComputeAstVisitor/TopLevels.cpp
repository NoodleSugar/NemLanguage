#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

std::any ComputeAstVisitor::visitFile(NEMParser::FileContext* ctx)
{
	File file;
	for(auto topLevelCtx: ctx->topLevel())
	{
		auto function = std::any_cast<Function>(topLevelCtx->accept(this));
		file.functions.push_back(function);
	}

	return file;
}

std::any ComputeAstVisitor::visitFnDef(NEMParser::FnDefContext* ctx)
{
	auto signatureCtx  = ctx->fnSignature();
	auto returnTypeCtx = signatureCtx->type();
	auto paramSeqCtx   = signatureCtx->paramSeq();
	auto instrBlockCtx = ctx->block();

	auto name		= signatureCtx->IDENTIFIER()->getText();
	auto returnType = nodeFromVisit(returnTypeCtx);
	auto parameters = paramSeqCtx == nullptr ?
					   std::vector<Parameter>() :
					   std::any_cast<std::vector<Parameter>>(paramSeqCtx->accept(this));
	auto block		= std::any_cast<Block>(instrBlockCtx->accept(this));

	return Function{name, returnType, parameters, block};
}

std::any ComputeAstVisitor::visitParamSeq(NEMParser::ParamSeqContext* ctx)
{
	auto params = ctx->param();

	std::vector<Parameter> parameters;
	parameters.reserve(params.size());

	for(auto param: params)
	{
		auto p = std::any_cast<Parameter>(param->accept(this));
		parameters.push_back(p);
	}

	return parameters;
}

std::any ComputeAstVisitor::visitParam(NEMParser::ParamContext* ctx)
{
	auto name = ctx->IDENTIFIER()->getText();
	auto type = nodeFromVisit(ctx->varType());

	return Parameter{name, type};
}
