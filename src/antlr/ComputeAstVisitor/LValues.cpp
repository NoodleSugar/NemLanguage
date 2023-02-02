#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

using nem::ast::Node;

std::any ComputeAstVisitor::visitVariable(NEMParser::VariableContext* ctx)
{
	return Node::Ptr(new VariableNode{ctx->IDENTIFIER()->getText()});
}