#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/DumpAstVisitor.hpp>

using namespace nem::ast;

DumpAstVisitor::DumpAstVisitor(std::ostream& stream, bool isCompact) :
	m_out(stream), m_indentCount(0), m_isCompact(isCompact) {}

void DumpAstVisitor::visit(const Node& node)
{
	switch(node.getType())
	{
#define X(T)                       \
	case AstType::T:               \
		visit(node_cast<T>(node)); \
		break;
		LIST_OF_AST_TYPES
#undef X
	};
}

//////////
// Dump //
//////////

void DumpAstVisitor::dumpBreak()
{
	if(m_isCompact)
		return;

	m_out << '\n';
	for(unsigned int i = 0; i < m_indentCount; i++)
		m_out << '\t';
}

void DumpAstVisitor::visit(const File& file)
{
	for(const auto& function: file.functions)
		visit(function);

	dumpBreak();
}

void DumpAstVisitor::visit(const Function& fun)
{
	m_out << getAstCode<Function>()
		  << OPEN
		  << fun.name
		  << SEPARATOR;

	visit(*fun.returnType);

	m_out << SEPARATOR
		  << fun.parameters.size();

	m_indentCount++;
	for(const auto& parameter: fun.parameters)
	{
		m_out << SEPARATOR;
		dumpBreak();

		visit(parameter);
	}

	for(const auto& instruction: fun.block.instructions)
	{
		m_out << SEPARATOR;
		dumpBreak();
		visit(*instruction);
	}
	m_indentCount--;

	dumpBreak();
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Parameter& param)
{
	m_out << OPEN
		  << param.name
		  << SEPARATOR;
	visit(*param.type);
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const FunctionCall& funCall)
{
	m_out << getAstCode<FunctionCall>()
		  << OPEN
		  << funCall.name
		  << SEPARATOR
		  << funCall.arguments.size();

	m_indentCount++;
	for(const auto& arg: funCall.arguments)
	{
		m_out << SEPARATOR;
		dumpBreak();
		visit(*arg);
	}
	m_indentCount--;

	dumpBreak();
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Block& block)
{
	m_out << getAstCode<Block>()
		  << OPEN;

	m_indentCount++;
	for(const auto& instruction: block.instructions)
	{
		m_out << SEPARATOR;
		dumpBreak();
		visit(*instruction);
	}
	m_indentCount--;

	dumpBreak();
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Declaration& decl)
{
	m_out << getAstCode<Declaration>()
		  << OPEN
		  << decl.name
		  << SEPARATOR;

	visit(*decl.type);

	m_out << CLOSE;
}
void DumpAstVisitor::visit(const Definition& def)
{
	m_out << getAstCode<Definition>()
		  << OPEN
		  << def.name
		  << SEPARATOR;

	if(def.type.has_value())
		visit(*def.type.value());

	m_out << SEPARATOR;

	m_indentCount++;
	dumpBreak();
	visit(*def.value);
	m_indentCount--;

	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Assignment& assign)
{
	m_out << getOpCode(assign.op)
		  << OPEN;

	visit(*assign.left);
	m_out << SEPARATOR;

	m_indentCount++;
	dumpBreak();
	visit(*assign.right);
	m_indentCount--;

	dumpBreak();
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Return& ret)
{
	m_out << getAstCode<Return>()
		  << OPEN;

	if(ret.value.has_value())
		visit(*ret.value.value());

	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Literal& literal)
{
	m_out << getAstCode<Literal>()
		  << OPEN
		  << getTyCode(literal.type)
		  << SEPARATOR
		  << literal.value
		  << CLOSE;
}

void DumpAstVisitor::visit(const Minus& minus)
{
	m_out << getAstCode<Minus>()
		  << OPEN;

	visit(*minus.expression);

	m_out << CLOSE;
}

void DumpAstVisitor::visit(const Arithmetic& arith)
{
	m_out << getOpCode(arith.op)
		  << OPEN;

	m_indentCount++;
	dumpBreak();
	visit(*arith.left);
	m_out << SEPARATOR;

	dumpBreak();
	visit(*arith.right);
	m_indentCount--;

	dumpBreak();
	m_out << CLOSE;
}

void DumpAstVisitor::visit(const QualifiedType& type)
{
	m_out << getAstCode<QualifiedType>()
		  << OPEN
		  << getQCode(type.qualifier)
		  << SEPARATOR;

	visit(*type.type);

	m_out << CLOSE;
}

void DumpAstVisitor::visit(const NativeType& type)
{
	m_out << getAstCode<NativeType>()
		  << OPEN
		  << getTyCode(type.name)
		  << CLOSE;
}

void DumpAstVisitor::visit(const Variable& var)
{
	m_out << getAstCode<Variable>()
		  << OPEN
		  << var.name
		  << CLOSE;
}