#include <nem/ir/util/NamedValueRegister.hpp>

namespace nem::ir
{

void NamedValueRegister::pushLayer()
{
	layers.emplace_back();
}

void NamedValueRegister::popLayer()
{
	layers.pop_back();
}

bool NamedValueRegister::contains(const llvm::StringRef& name) const
{
	for(auto& layer: layers)
	{
		if(layer.count(name))
			return true;
	}
	return false;
}

llvm::Value* NamedValueRegister::get(const llvm::StringRef& name)
{
	for(auto& layer: layers)
	{
		if(layer.count(name))
			return layer.at(name);
	}
	return nullptr;
}

void NamedValueRegister::add(const llvm::StringRef& name, llvm::Value* value)
{
	layers.back()[name] = value;
}

void NamedValueRegister::set(const llvm::StringRef& name, llvm::Value* value)
{
	for(auto& layer: layers)
	{
		if(layer.count(name))
		{
			layer.at(name) = value;
			break;
		}
	}
}

void NamedValueRegister::remove(const llvm::StringRef& name)
{
	for(auto& layer: layers)
	{
		if(layer.count(name))
		{
			layer.erase(name);
			break;
		}
	}
}

} // namespace nem::ir
