#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"
#include "nem/util/VisitorHelper.hpp"

#define NEM_IR_DEFINE_VISITOR_METHOD(T) \
	[this](const T& x) -> llvm::Type* { return build(x); },

namespace nem::ir
{

using namespace nem::ast;

// clang-format off
llvm::Type* IRBuilder::build(const Type& type)
{
	const auto visitor = VisitorOverload
	{
		NEM_FOR_EACH(NEM_IR_DEFINE_VISITOR_METHOD, NEM_AST_LIST_OF_TYPE_NODES)
		[](const auto& x) -> llvm::Type*
		{
			llvm::errs() << "IRBuilder::build(const Type&) : Unhandled type\n";
			return nullptr;
		}
	};

	return std::visit(visitor, type);
}
// clang-format on

llvm::Type* IRBuilder::build(const NativeType& type)
{
	switch(type.type)
	{
	case NativeTypeE::Int:
		return builder.getInt64Ty();
	case NativeTypeE::Real:
		return builder.getDoubleTy();
	}
}

} // namespace nem::ir
