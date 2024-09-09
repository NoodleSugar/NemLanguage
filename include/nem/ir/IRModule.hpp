#pragma once

#include <llvm/ExecutionEngine/Orc/ThreadSafeModule.h>
#include <llvm/IR/LLVMContext.h>
#include <llvm/IR/Module.h>

#include "IRBuilder.hpp"

namespace nem::ir
{

class IRModule
{
	using LLVMContextPtr = std::unique_ptr<llvm::LLVMContext>;
	using LLVMModulePtr	 = std::unique_ptr<llvm::Module>;

	LLVMContextPtr llvmContext;
	LLVMModulePtr  llvmModule;

public:
	IRBuilder createBuilder();

	llvm::orc::ThreadSafeModule toTSModule();

	friend llvm::raw_ostream& operator<<(llvm::raw_ostream&, const IRModule&);
	friend std::ostream&	  operator<<(std::ostream&, const IRModule&);

	IRModule();
	IRModule(const IRModule&) = delete;
	IRModule(IRModule&&)	  = delete;

	IRModule& operator=(const IRModule&) = delete;
	IRModule& operator=(IRModule&&)		 = delete;
};

} // namespace nem::ir
