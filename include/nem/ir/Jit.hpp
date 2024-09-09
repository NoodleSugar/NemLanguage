#pragma once

#include <llvm/ExecutionEngine/Orc/LLJIT.h>
#include <llvm/Support/Error.h>
#include <llvm/Support/InitLLVM.h>

#include "IRModule.hpp"

namespace nem::ir
{

class Jit
{
	llvm::InitLLVM	  initLLVM;
	llvm::ExitOnError checkErr;

	std::unique_ptr<llvm::orc::LLJIT> jit;

public:
	static void init();

	Jit(int& argc, char**& argv);

	void addModule(IRModule&&);

	template<class FnType>
	auto lookUp(const char* symbol)
	{
		auto mainAddr = checkErr(jit->lookup(symbol));

		return mainAddr.toPtr<FnType*>();
	}
};

} // namespace nem::ir
