#include <catch2/catch_test_macros.hpp>

#include <llvm/ExecutionEngine/Orc/LLJIT.h>
#include <llvm/ExecutionEngine/Orc/ThreadSafeModule.h>
#include <llvm/Support/Error.h>
#include <llvm/Support/InitLLVM.h>
#include <llvm/Support/TargetSelect.h>

#include <nem/ast/Ast.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

TEST_CASE("ExecuteIR")
{
}