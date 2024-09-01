#pragma once

#include "nem/util/VisitorHelper.hpp"

#include "Forward.hpp"
#include "element/helper/Visitor.hpp"

namespace nem::ast
{

class Visitor
{
public:
	NEM_DECLARE_ALL_AST_TYPES_VISIT_METHOD

	template<class... Types>
	void visit(std::variant<Types...>& var)
	{
		const auto visitor =
		 VisitorOverload{[this](auto& elt)
						 { this->visit(elt); }};

		std::visit(visitor, var);
	}

	template<class T>
	void visit(std::shared_ptr<T>& ptr)
	{
		visit(*ptr);
	}

	template<class T>
	void visit(std::vector<T>& vec)
	{
		for(auto& elt: vec)
			visit(elt);
	}

	template<class T>
	void visit(std::optional<T>& opt)
	{
		if(opt)
			visit(opt);
	}

	template<class T>
	void visit(T&)
	{
	}

	virtual ~Visitor() {}
};

} // namespace nem::ast
