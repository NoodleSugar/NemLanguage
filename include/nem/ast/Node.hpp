#pragma once

#include <nem/util/SourceInfo.hpp>

namespace nem::ast
{

template<class T>
struct Node : public T
{
	SourceInfo info;

	template<class... Args>
	Node(SourceInfo i, Args&&... args) :
		T{std::forward<Args>(args)...}, info(i)
	{
	}
	Node(const Node&) = default;
	Node(Node&&)	  = default;

	Node& operator=(const Node&) = default;
	Node& operator=(Node&&)		 = default;
};

} // namespace nem::ast