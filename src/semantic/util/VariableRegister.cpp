#include <nem/semantic/util/VariableRegister.hpp>

using namespace nem::util;

void VariableRegister::pushLayer()
{
	m_layers.emplace_back();
}

void VariableRegister::popLayer()
{
	m_layers.pop_back();
}

bool VariableRegister::contains(const llvm::StringRef& name) const
{
	for(auto& layer: m_layers)
	{
		if(layer.count(name))
			return true;
	}
	return false;
}

llvm::AllocaInst* VariableRegister::get(const llvm::StringRef& name)
{
	for(auto& layer: m_layers)
	{
		if(layer.count(name))
			return layer.at(name);
	}
	return nullptr;
}

void VariableRegister::add(const llvm::StringRef& name, llvm::AllocaInst* value)
{
	m_layers.back()[name] = value;
}

void VariableRegister::set(const llvm::StringRef& name, llvm::AllocaInst* value)
{
	for(auto& layer: m_layers)
	{
		if(layer.count(name))
		{
			layer.at(name) = value;
			break;
		}
	}
}

void VariableRegister::remove(const llvm::StringRef& name)
{
	for(auto& layer: m_layers)
	{
		if(layer.count(name))
		{
			layer.erase(name);
			break;
		}
	}
}
