#pragma once

#include <map>
#include <string>
#include <utility>
#include <vector>

#include <llvm/ADT/StringRef.h>
#include <llvm/IR/Value.h>

namespace nem::ir
{

class NamedValueRegister
{
	using Layer = std::map<llvm::StringRef, llvm::Value*>;

	std::vector<Layer> layers;

public:
	void pushLayer();
	void popLayer();

	bool contains(const llvm::StringRef&) const;

	llvm::Value* get(const llvm::StringRef&);

	void add(const llvm::StringRef&, llvm::Value*);
	void set(const llvm::StringRef&, llvm::Value*);
	void remove(const llvm::StringRef&);
};

} // namespace nem::util