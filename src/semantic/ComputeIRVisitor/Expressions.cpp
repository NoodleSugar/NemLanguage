#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>
#include <nem/semantic/util/LiteralParser.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::Value* ComputeIRVisitor::visitExpr(const Node& node)
{
	switch(node.type)
	{
	case NodeType::FunctionCall:
		return visit(ast_cast<FunctionCall>(node));
	case NodeType::Literal:
		return visit(ast_cast<Literal>(node));
	case NodeType::Minus:
		return visit(ast_cast<Minus>(node));
	case NodeType::Arithmetic:
		return visit(ast_cast<Arithmetic>(node));
	case NodeType::Identifier:
	{
		auto alloca = visit(ast_cast<Identifier>(node));
		return m_builder.CreateLoad(alloca->getAllocatedType(), alloca);
	}
	default:
		llvm::errs() << "ComputeIRVisitor::visitExpr : Unexpected node type\n";
		return nullptr;
	}
}

inline std::string keepOnlyDigit(const std::string& s)
{
	std::string str;
	str.reserve(s.size());
	std::remove_copy(s.cbegin(), s.cend(), str.begin(), '\'');
	return str;
}

llvm::Value* ComputeIRVisitor::visit(const Literal& expr)
{
	switch(expr.type)
	{
	case LiteralType::Boolean:
	{
		auto value = util::parseBool(expr.value.c_str());
		return value ?
				m_builder.getTrue() :
				m_builder.getFalse();
	}
	case LiteralType::Integer:
	{
		auto str   = keepOnlyDigit(expr.value.c_str());
		auto value = util::parseInt(str.c_str());
		return m_builder.getInt64(value);
	}
	case LiteralType::Real:
	{
		auto value = util::parseReal(expr.value.c_str());
		return llvm::ConstantFP::get(m_builder.getDoubleTy(), value);
	}
	}
}

llvm::Value* ComputeIRVisitor::visit(const Minus& expr)
{
	const auto value = visitExpr(*expr.expression);
	const auto type	 = value->getType();

	if(!type->isIntegerTy())
	{
		llvm::errs() << "ComputeIRVisitor::visit(Minus) : Value type is not integer\n";
		return nullptr;
	}

	const auto zero = llvm::ConstantInt::get(type, 0);

	return m_builder.CreateSub(zero, value, "minustmp");
}

llvm::Value* ComputeIRVisitor::visit(const Arithmetic& expr)
{
	auto left  = visitExpr(*expr.left);
	auto right = visitExpr(*expr.right);

	auto typeLeft  = left->getType();
	auto typeRight = right->getType();

	if(!typeLeft->isIntegerTy())
	{
		llvm::errs() << "ComputeIRVisitor::visit(Arithmetic) : Left value type is not integer\n";
		return nullptr;
	}

	if(!typeRight->isIntegerTy())
	{
		llvm::errs() << "ComputeIRVisitor::visit(Arithmetic) : Right value type is not integer\n";
		return nullptr;
	}

	switch(expr.op)
	{
	case ArithOp::Addition:
		return m_builder.CreateAdd(left, right, "add");
	case ArithOp::Substraction:
		return m_builder.CreateSub(left, right, "sub");
	case ArithOp::Multiplication:
		return m_builder.CreateMul(left, right, "mul");
	case ArithOp::Division:
		return m_builder.CreateSDiv(left, right, "div");
	case ArithOp::Modulo:
		return m_builder.CreateSRem(left, right, "mod");
	}
}
