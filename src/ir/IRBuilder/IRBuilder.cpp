#include "nem/ir/IRBuilder.hpp"

namespace nem::ir
{

IRBuilder::IRBuilder(llvm::LLVMContext& context,
					 llvm::Module&		module) :
	llvmContext(context),
	llvmModule(module),
	builder(context) {};

} // namespace nem::ir
