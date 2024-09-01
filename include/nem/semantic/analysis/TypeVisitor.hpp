#pragma once

#include <nem/ast/Visitor.hpp>

namespace nem::semantic
{

class TypeVisitor : public ast::Visitor
{
	void visit(const ast::NodePtr&);

#define X(T) void visit(const ast::T##Node&);
	LIST_OF_AST_NODES
#undef X

public:
	void visit(const ast::File&);
};

} // namespace nem::semantic