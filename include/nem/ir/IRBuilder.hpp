#pragma once

#include <map>
#include <string>

#include <llvm/IR/IRBuilder.h>

#include "nem/ast/Forward.hpp"
#include "util/NamedValueRegister.hpp"

namespace nem::ir
{

class IRBuilder
{
	llvm::LLVMContext& llvmContext;
	llvm::Module&	   llvmModule;
	llvm::IRBuilder<>  builder;

	NamedValueRegister namedValues;

	llvm::Function* createFunctionPrototype(const ast::Function& function);

	bool isBoolType(llvm::Type*);
	bool isIntType(llvm::Type*);
	bool isRealType(llvm::Type*);

public:
	IRBuilder(llvm::LLVMContext&, llvm::Module&);

	void build(const ast::File&);

	llvm::Function* build(const ast::Function&);
	llvm::CallInst* build(const ast::Call&);

	llvm::Value*	build(const ast::Expression&);
	llvm::Constant* build(const ast::Literal&);
	llvm::Value*	build(const ast::Identifier&);
	llvm::Value*	build(const ast::UnaryOperation&);
	llvm::Value*	build(const ast::BinaryOperation&);

	llvm::Instruction* build(const ast::Instruction&);
	llvm::Instruction* build(const ast::Block&);
	llvm::BranchInst*  build(const ast::If&);
	llvm::ReturnInst*  build(const ast::Return&);

	llvm::Type* build(const ast::Type&);
	llvm::Type* build(const ast::NativeType&);
};

} // namespace nem::ir
