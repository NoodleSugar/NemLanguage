#pragma once

#include <istream>

#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

ast::FileNode computeAstFile(std::istream&);

} // namespace nem::antlr
