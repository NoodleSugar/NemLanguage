#include "llvm/Passes/PassBuilder.h"
#include "llvm/Transforms/InstCombine/InstCombine.h"
#include "llvm/Transforms/Scalar/GVN.h"
#include "llvm/Transforms/Scalar/Reassociate.h"
#include "llvm/Transforms/Scalar/SimplifyCFG.h"

#include "nem/ir/IROptimizer.hpp"

namespace nem::ir
{

IROptimizer::IROptimizer(llvm::LLVMContext& context) :
	funPassMan(),
	loopAnaMan(),
	funAnaMan(),
	cgAnaMan(),
	modAnaMan(),
	passInstrCb(),
	stdInstr(context, true)
{
	stdInstr.registerCallbacks(passInstrCb, &modAnaMan);
	funPassMan.addPass(llvm::InstCombinePass());
	funPassMan.addPass(llvm::ReassociatePass());
	funPassMan.addPass(llvm::GVNPass());
	funPassMan.addPass(llvm::SimplifyCFGPass());

	llvm::PassBuilder passBuilder;
	passBuilder.registerModuleAnalyses(modAnaMan);
	passBuilder.registerFunctionAnalyses(funAnaMan);
	passBuilder.crossRegisterProxies(loopAnaMan, funAnaMan, cgAnaMan, modAnaMan);
};

void IROptimizer::run(llvm::Function& fn)
{
	funPassMan.run(fn, funAnaMan);
}

} // namespace nem::ir
