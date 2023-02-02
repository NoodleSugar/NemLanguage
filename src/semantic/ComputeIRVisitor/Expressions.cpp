#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>
#include <nem/semantic/util/LiteralParser.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::Value* ComputeIRVisitor::visitExpr(const Node& node)
{
	switch(node.getType())
	{
	case AstType::FunctionCall:
		return visit(node_cast<FunctionCall>(node));
	case AstType::Literal:
		return visit(node_cast<Literal>(node));
	case AstType::Minus:
		return visit(node_cast<Minus>(node));
	case AstType::Arithmetic:
		return visit(node_cast<Arithmetic>(node));
	case AstType::Variable:
	{
		auto alloca = visit(node_cast<Variable>(node));
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
	case Literal::Type::Integer:
		auto str   = keepOnlyDigit(expr.value.c_str());
		auto value = util::LiteralParser::parseInt(str.c_str());
		return m_builder.getInt64(value);
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
