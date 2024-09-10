#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"

namespace nem::ir
{

using namespace nem::ast;

void IRBuilder::build(const File& file)
{
	for(const auto& function: file.functions)
		createFunctionPrototype(function);

	for(const auto& function: file.functions)
		build(function);
}

} // namespace nem::ir
