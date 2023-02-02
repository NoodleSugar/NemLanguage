#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

std::any ComputeAstVisitor::visitFnCall(NEMParser::FnCallContext* ctx)
{
	auto name	   = ctx->IDENTIFIER()->getText();
	auto arguments = std::vector<Node::Ptr>();
	auto argSeq	   = ctx->argSeq();

	if(argSeq != nullptr)
	{
		auto args = argSeq->expr();
		arguments.reserve(args.size());

		for(auto arg: args)
			arguments.push_back(nodeFromVisit(arg));
	}

	return Node::Ptr(new FunctionCallNode{name, arguments});
}