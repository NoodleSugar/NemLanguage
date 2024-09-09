#include <llvm/Support/raw_os_ostream.h>

#include "nem/ir/IRModule.hpp"

namespace nem::ir
{

IRModule::IRModule() :
	llvmContext(std::make_unique<llvm::LLVMContext>()),
	llvmModule(std::make_unique<llvm::Module>("default", *llvmContext)) {}

IRBuilder IRModule::createBuilder() { return IRBuilder(*llvmContext, *llvmModule); }

llvm::orc::ThreadSafeModule IRModule::toTSModule()
{
	return llvm::orc::ThreadSafeModule(std::move(llvmModule),
									   std::move(llvmContext));
}

llvm::raw_ostream& operator<<(llvm::raw_ostream& out, const IRModule& ir)
{
	return out << *ir.llvmModule;
}

std::ostream& operator<<(std::ostream& out, const IRModule& ir)
{
	llvm::raw_os_ostream(out) << ir;
	return out;
}

} // namespace nem::ir
