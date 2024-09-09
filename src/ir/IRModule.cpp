#include <llvm/IRReader/IRReader.h>
#include <llvm/Support/SourceMgr.h>
#include <llvm/Support/raw_os_ostream.h>

#include "nem/ir/IRModule.hpp"

namespace nem::ir
{

IRModule::IRModule() :
	llvmContext(std::make_unique<llvm::LLVMContext>()),
	llvmModule(std::make_unique<llvm::Module>("default", *llvmContext)) {}

IRModule::IRModule(LLVMContextPtr context, LLVMModulePtr module) :
	llvmContext(std::move(context)),
	llvmModule(std::move(module)) {}

IRBuilder IRModule::createBuilder() { return IRBuilder(*llvmContext, *llvmModule); }

IRModule IRModule::fromFile(const char* filename)
{
	llvm::SMDiagnostic diag;

	auto context = std::make_unique<llvm::LLVMContext>();
	auto module	 = llvm::parseIRFile(filename, diag, *context);

	return IRModule(std::move(context), std::move(module));
}

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
