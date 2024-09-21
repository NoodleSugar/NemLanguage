#pragma once

#include <map>
#include <string>

#include <llvm/IR/IRBuilder.h>

#include "IROptimizer.hpp"
#include "nem/ast/Forward.hpp"
#include "util/NamedValueRegister.hpp"

namespace nem::ir
{

class IRBuilder
{
	llvm::LLVMContext& llvmContext;
	llvm::Module&	   llvmModule;
	llvm::IRBuilder<>  builder;

	IROptimizer optimizer;

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

	void build(const ast::Instruction&);
	void build(const ast::Block&);
	void build(const ast::VarDef&);
	void build(const ast::If&);
	void build(const ast::Return&);

	llvm::Type* build(const ast::Type&);
	llvm::Type* build(const ast::NativeType&);
};

} // namespace nem::ir
