#pragma once

#include <ostream>

#include <nem/ast/ForwardAst.hpp>

namespace nem::ast
{

class DumpAstVisitor
{
	std::ostream& m_out;
	unsigned int  m_indentCount;
	bool		  m_isCompact;

	constexpr static char OPEN		= '<';
	constexpr static char CLOSE		= '>';
	constexpr static char SEPARATOR = ',';

	void dumpBreak();

public:
	DumpAstVisitor(std::ostream&, bool isCompact = false);

	void visit(const Node&);

#define X(T) void visit(const T&);
	LIST_OF_AST_TYPES
#undef X
};

} // namespace nem::ast