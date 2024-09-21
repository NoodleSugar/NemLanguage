#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"
#include "nem/ir/util/LiteralParser.hpp"
#include "nem/util/VisitorHelper.hpp"

#define NEM_IR_DEFINE_VISITOR_METHOD(E) \
	[this](const E& x) -> llvm::Value* { return build(x); },

namespace nem::ir
{

using namespace nem::ast;

// clang-format off
llvm::Value* IRBuilder::build(const Expression& expr)
{
	const auto visitor = VisitorOverload
	{
		NEM_FOR_EACH(NEM_IR_DEFINE_VISITOR_METHOD, NEM_AST_LIST_OF_EXPRESSION_NODES)
		[](const auto& x) -> llvm::Value*
		{
			llvm::errs() << "IRBuilder::build(const Expression&) : Unhandled expression\n";
			return nullptr;
		}
	};

	return std::visit(visitor, expr);
}
// clang-format on

inline std::string removeSeparator(const std::string& s)
{
	std::string str;
	str.reserve(s.size());
	std::remove_copy(s.cbegin(), s.cend(), std::back_inserter(str), '\'');
	return str;
}

llvm::Constant* IRBuilder::build(const Literal& lit)
{
	switch(lit.type)
	{
	case LiteralType::Bool:
	{
		auto str   = removeSeparator(lit.value);
		auto value = parseBool(str.c_str());
		return builder.getInt1(value);
	}
	case LiteralType::Int:
	{
		auto str   = removeSeparator(lit.value);
		auto value = parseInt(str.c_str());
		return builder.getInt64(value);
	}
	case LiteralType::Real:
	{
		auto value = parseReal(lit.value.c_str());
		return llvm::ConstantFP::get(builder.getDoubleTy(), value);
	}
	}
}

llvm::Value* IRBuilder::build(const ast::Identifier& id)
{
	auto alloc = namedValues.get(id.string);

	return builder.CreateLoad(alloc->getAllocatedType(), alloc, id.string);
}

llvm::Value* IRBuilder::build(const UnaryOperation& op)
{
	const auto value = build(*op.expr);
	const auto type	 = value->getType();

	if(isIntType(type))
	{
		const auto zero = llvm::ConstantInt::get(type, 0);

		return builder.CreateSub(zero, value, "subtmp");
	}
	else if(isRealType(type))
	{
		const auto zero = llvm::ConstantFP::get(type, 0);

		return builder.CreateFSub(zero, value, "fsubtmp");
	}
	else
	{
		llvm::errs() << "IRBuilder::build(const UnaryOperation&) :"
						"Unsupported operands type ["
					 << type->getStructName()
					 << "]\n";
		return nullptr;
	}
}

llvm::Value* IRBuilder::build(const BinaryOperation& op)
{
	auto left  = build(*op.left);
	auto right = build(*op.right);

	auto typeLeft  = left->getType();
	auto typeRight = right->getType();

	if(typeLeft != typeRight)
	{
		llvm::errs() << "IRBuilder::build(const BinaryOperation&) : "
						"Operands should have the same type\n";
		return nullptr;
	}

	if(isBoolType(typeLeft))
	{
		switch(op.op)
		{
		case BinaryOp::Or:
			return builder.CreateOr(left, right, "ortmp");
		case BinaryOp::And:
			return builder.CreateAnd(left, right, "andtmp");
		default:
			llvm::errs() << "IRBuilder::build(const BinaryOperation&) : "
							"Bool operands only support bool operators\n";
			return nullptr;
		}
	}
	else if(isIntType(typeLeft))
	{
		switch(op.op)
		{
		case BinaryOp::Plus:
			return builder.CreateAdd(left, right, "addtmp");
		case BinaryOp::Minus:
			return builder.CreateSub(left, right, "subtmp");
		case BinaryOp::Star:
			return builder.CreateMul(left, right, "multmp");
		case BinaryOp::Slash:
			return builder.CreateSDiv(left, right, "sdivtmp");
		case BinaryOp::EQ:
			return builder.CreateICmpEQ(left, right, "icmpEQtmp");
		case BinaryOp::NE:
			return builder.CreateICmpNE(left, right, "icmpNEtmp");
		case BinaryOp::LE:
			return builder.CreateICmpSLE(left, right, "icmpSLEtmp");
		case BinaryOp::GE:
			return builder.CreateICmpSGE(left, right, "icmpSGEtmp");
		case BinaryOp::LT:
			return builder.CreateICmpSLT(left, right, "icmpSLTtmp");
		case BinaryOp::GT:
			return builder.CreateICmpSGT(left, right, "icmpSGTtmp");
		default:
			llvm::errs() << "IRBuilder::build(const BinaryOperation&) : "
							"Int operands only support numeric operators\n";
			return nullptr;
		}
	}
	else if(isRealType(typeLeft))
	{
		switch(op.op)
		{
		case BinaryOp::Plus:
			return builder.CreateFAdd(left, right, "faddtmp");
		case BinaryOp::Minus:
			return builder.CreateFSub(left, right, "fsubtmp");
		case BinaryOp::Star:
			return builder.CreateFMul(left, right, "fmultmp");
		case BinaryOp::Slash:
			return builder.CreateFDiv(left, right, "fdivtmp");
		case BinaryOp::EQ:
			return builder.CreateFCmpOEQ(left, right, "fcmpOEQtmp");
		case BinaryOp::NE:
			return builder.CreateFCmpONE(left, right, "fcmpONEtmp");
		case BinaryOp::LE:
			return builder.CreateFCmpOLE(left, right, "fcmpOLEtmp");
		case BinaryOp::GE:
			return builder.CreateFCmpOGE(left, right, "fcmpOGEtmp");
		case BinaryOp::LT:
			return builder.CreateFCmpOLT(left, right, "fcmpOLTtmp");
		case BinaryOp::GT:
			return builder.CreateFCmpOGT(left, right, "fcmpOGTtmp");
		default:
			llvm::errs() << "IRBuilder::build(const BinaryOperation&) : "
							"Real operands only support numeric operators\n";
			return nullptr;
		}
	}
	else
	{
		llvm::errs() << "IRBuilder::build(const BinaryOperation&) : "
						"Unsupported operands type ["
					 << typeLeft->getStructName()
					 << "]\n";
		return nullptr;
	}
}

} // namespace nem::ir
