#pragma once

#include <any>

#include <llvm/IR/IRBuilder.h>

#include "util/VariableRegister.hpp"
#include <nem/ast/Forward.hpp>

namespace nem::semantic
{

class ComputeIRVisitor
{
	std::unique_ptr<llvm::LLVMContext> m_llvmContext;
	std::unique_ptr<llvm::Module>	   m_llvmModule;
	llvm::IRBuilder<>				   m_builder;

	util::VariableRegister m_variableRegister;

	llvm::Function* createFunctionPrototype(const ast::Function& function);

public:
	ComputeIRVisitor();

	std::unique_ptr<llvm::LLVMContext>&& getContext();
	std::unique_ptr<llvm::Module>&&		 getModule();

	void			visit(const ast::File&);
	llvm::Function* visit(const ast::Function&);

	llvm::Value* visit(const ast::FunctionCall&);

	void visitInstr(const ast::Node&);
	void visit(const ast::Block&);
	void visit(const ast::Declaration&);
	void visit(const ast::Definition&);
	void visit(const ast::Assignment&);
	void visit(const ast::Return&);

	llvm::Value* visitExpr(const ast::Node&);
	llvm::Value* visit(const ast::Literal&);
	llvm::Value* visit(const ast::Minus&);
	llvm::Value* visit(const ast::Arithmetic&);

	llvm::Type* visitType(const ast::Node&);
	llvm::Type* visit(const ast::QualifiedType&);
	llvm::Type* visit(const ast::NativeType&);

	llvm::AllocaInst* visitLValue(const ast::Node&);
	llvm::AllocaInst* visit(const ast::Identifier&);
};

} // namespace nem::semantic