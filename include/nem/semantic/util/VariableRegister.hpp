#pragma once

#include <map>
#include <string>
#include <utility>
#include <vector>

#include <llvm/ADT/StringRef.h>
#include <llvm/IR/Instructions.h>

namespace nem::util
{

class VariableRegister
{
	using Layer = std::map<llvm::StringRef, llvm::AllocaInst*>;

	std::vector<Layer> m_layers;

public:
	void pushLayer();
	void popLayer();

	bool contains(const llvm::StringRef&) const;

	llvm::AllocaInst* get(const llvm::StringRef&);

	void add(const llvm::StringRef&, llvm::AllocaInst*);
	void set(const llvm::StringRef&, llvm::AllocaInst*);
	void remove(const llvm::StringRef&);
};

} // namespace nem::util