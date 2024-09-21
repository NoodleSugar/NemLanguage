#pragma once

#include <llvm/Analysis/CGSCCPassManager.h>
#include <llvm/Analysis/LoopAnalysisManager.h>
#include <llvm/Passes/StandardInstrumentations.h>

namespace nem::ir
{

class IROptimizer
{
	llvm::FunctionPassManager		   funPassMan;
	llvm::LoopAnalysisManager		   loopAnaMan;
	llvm::FunctionAnalysisManager	   funAnaMan;
	llvm::CGSCCAnalysisManager		   cgAnaMan;
	llvm::ModuleAnalysisManager		   modAnaMan;
	llvm::PassInstrumentationCallbacks passInstrCb;
	llvm::StandardInstrumentations	   stdInstr;

public:
	IROptimizer(llvm::LLVMContext&);

	void run(llvm::Function&);
};

} // namespace nem::ir
