#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

void ComputeIRVisitor::visitInstr(const Node& node)
{
	switch(node.type)
	{
	case NodeType::FunctionCall:
		visit(ast_cast<FunctionCall>(node));
		break;
	case NodeType::Block:
		visit(ast_cast<Block>(node));
		break;
	case NodeType::Declaration:
		visit(ast_cast<Declaration>(node));
		break;
	case NodeType::Definition:
		visit(ast_cast<Definition>(node));
		break;
	case NodeType::Assignment:
		visit(ast_cast<Assignment>(node));
		break;
	case NodeType::Return:
		visit(ast_cast<Return>(node));
		break;
	default:
		llvm::errs() << "ComputeIRVisitor::visitInstr : Unexpected node type\n";
		break;
	}
}

void ComputeIRVisitor::visit(const Block& block)
{
	m_variableRegister.pushLayer();
	for(const auto& instr: block.instructions)
		visitInstr(*instr);
	m_variableRegister.popLayer();
}

void ComputeIRVisitor::visit(const Declaration& decl)
{
	if(m_variableRegister.contains(decl.name))
	{
		llvm::errs() << "ComputeIRVisitor::visit(Declatation) : variable \""
					 << decl.name
					 << "\" already declared\n";
		return;
	}

	auto llvmType	= visitType(*decl.type);
	auto llvmAlloca = m_builder.CreateAlloca(llvmType, nullptr, decl.name);

	m_variableRegister.add(decl.name, llvmAlloca);
}

void ComputeIRVisitor::visit(const Definition& def)
{
	if(m_variableRegister.contains(def.name))
	{
		llvm::errs() << "ComputeIRVisitor::visit(Definition) : variable \""
					 << def.name
					 << "\" already declared\n";
		return;
	}

	auto llvmValue	= visitExpr(*def.value);
	auto llvmType	= def.type.has_value() ?
					   visitType(*def.type.value()) :
					   llvmValue->getType();
	auto llvmAlloca = m_builder.CreateAlloca(llvmType, nullptr, def.name);

	m_variableRegister.add(def.name, llvmAlloca);

	m_builder.CreateStore(llvmValue, llvmAlloca);
}

void ComputeIRVisitor::visit(const Assignment& assign)
{
	auto llvmAlloca = visitLValue(*assign.left);
	auto llvmValue	= visitExpr(*assign.right);

	if(assign.op != AssignOp::Equal)
	{
		auto llvmLeftValue = m_builder.CreateLoad(llvmAlloca->getAllocatedType(), llvmAlloca, "loadtmp");

		switch(assign.op)
		{
		case AssignOp::AddEqual:
			llvmValue = m_builder.CreateAdd(llvmLeftValue, llvmValue, "addtmp");
			break;
		case AssignOp::SubEqual:
			llvmValue = m_builder.CreateSub(llvmLeftValue, llvmValue, "subtmp");
			break;
		case AssignOp::MulEqual:
			llvmValue = m_builder.CreateMul(llvmLeftValue, llvmValue, "multmp");
			break;
		case AssignOp::DivEqual:
			llvmValue = m_builder.CreateSDiv(llvmLeftValue, llvmValue, "divtmp");
			break;
		case AssignOp::ModEqual:
			llvmValue = m_builder.CreateSRem(llvmLeftValue, llvmValue, "modtmp");
			break;
		default:
			break;
		}
	}

	m_builder.CreateStore(llvmValue, llvmAlloca);
}

void ComputeIRVisitor::visit(const Return& ret)
{
	if(ret.value.has_value())
		m_builder.CreateRet(visitExpr(*ret.value.value()));
	else
		m_builder.CreateRetVoid();
}