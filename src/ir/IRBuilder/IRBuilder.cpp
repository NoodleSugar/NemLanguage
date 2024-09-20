#include "nem/ir/IRBuilder.hpp"

namespace nem::ir
{

IRBuilder::IRBuilder(llvm::LLVMContext& context,
					 llvm::Module&		module) :
	llvmContext(context),
	llvmModule(module),
	builder(context) {};

bool IRBuilder::isBoolType(llvm::Type* ty)
{
	return ty == builder.getInt1Ty();
}

bool IRBuilder::isIntType(llvm::Type* ty)
{
	return ty == builder.getInt64Ty();
}

bool IRBuilder::isRealType(llvm::Type* ty)
{
	return ty == builder.getDoubleTy();
}

} // namespace nem::ir
