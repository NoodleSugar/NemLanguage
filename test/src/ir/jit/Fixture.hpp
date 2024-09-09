#pragma once

#include <llvm/IRReader/IRReader.h>

#include <catch2/catch_test_macros.hpp>
#include <catch2/generators/catch_generators.hpp>

#include "nem/ir/IRModule.hpp"
#include "nem/ir/Jit.hpp"

using namespace nem::ir;

class JitFixture
{
	char  str[1]	= "";
	char* strArr[1] = {str};

	int	   argc = 0;
	char** argv = strArr;

	Jit jit;

protected:
	JitFixture() :
		jit((Jit::init(), argc), argv) {}

	int getResultFromFile(const std::string& filename)
	{
		auto module = IRModule::fromFile(filename.c_str());

		jit.addModule(std::move(module));

		auto f = jit.lookUp<int(void)>("main");
		return f();
	}
};
