#pragma once

#include <memory>

namespace nem::ast
{

enum class AstType;

class Node
{
public:
	using Ptr = std::shared_ptr<Node>;

	virtual ~Node() {}

	// TODO Add information about original payload (file, line, column, length)
	virtual AstType getType() const = 0;
};

} // namespace nem::ast
