#include <llvm/Support/TargetSelect.h>

#include "nem/ir/Jit.hpp"

namespace nem::ir
{

void Jit::init()
{
	llvm::InitializeNativeTarget();
	llvm::InitializeNativeTargetAsmPrinter();
}

Jit::Jit(int& argc, char**& argv) :
	initLLVM(argc, argv),
	jit(checkErr(llvm::orc::LLJITBuilder().create())) {}

void Jit::addModule(IRModule&& module)
{
	checkErr(jit->addIRModule(module.toTSModule()));
}

} // namespace nem::ir
