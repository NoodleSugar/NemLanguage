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

} // namespace nem::ir
