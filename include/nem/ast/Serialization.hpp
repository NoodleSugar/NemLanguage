#pragma once

#include <cereal/archives/xml.hpp>

#include <cereal/types/memory.hpp>
#include <cereal/types/optional.hpp>
#include <cereal/types/string.hpp>
#include <cereal/types/vector.hpp>

#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Node.hpp>

#define X(T)                                \
	CEREAL_REGISTER_TYPE(nem::ast::T##Node) \
	CEREAL_REGISTER_POLYMORPHIC_RELATION(nem::ast::Node, nem::ast::T##Node)
LIST_OF_NODE_TYPES
#undef X

namespace nem::ast
{

template<class T>
void serialize(T& object, std::ostream& out)
{
	cereal::XMLOutputArchive archive(out);
	archive(object);
}

template<class T>
void deserialize(T& object, std::istream& in)
{
	cereal::XMLInputArchive archive(in);
	archive(object);
}

template<class Archive>
void serialize(Archive& ar, nem::ast::FunctionCallNode& call)
{
	ar(CEREAL_NVP(call.name),
	   CEREAL_NVP(call.arguments));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::File& file)
{
	ar(cereal::make_nvp("functions", file.functions));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::Function& function)
{
	ar(cereal::make_nvp("name", function.name),
	   cereal::make_nvp("parameters", function.parameters),
	   cereal::make_nvp("returnType", function.returnType),
	   cereal::make_nvp("block", function.block.instructions));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::Parameter& parameter)
{
	ar(cereal::make_nvp("name", parameter.name),
	   cereal::make_nvp("type", parameter.type));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::BlockNode& block)
{
	ar(cereal::make_nvp("intructions", block.instructions));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::DeclarationNode& decl)
{
	ar(cereal::make_nvp("name", decl.name),
	   cereal::make_nvp("type", decl.type));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::DefinitionNode& def)
{
	ar(cereal::make_nvp("name", def.name),
	   cereal::make_nvp("type", def.type),
	   cereal::make_nvp("value", def.value));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::AssignmentNode& assign)
{
	ar(cereal::make_nvp("op", assign.op),
	   cereal::make_nvp("left", assign.left),
	   cereal::make_nvp("right", assign.right));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::ReturnNode& ret)
{
	ar(cereal::make_nvp("value", ret.value));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::LiteralNode& lit)
{
	ar(cereal::make_nvp("type", lit.type),
	   cereal::make_nvp("value", lit.value));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::MinusNode& minus)
{
	ar(cereal::make_nvp("expression", minus.expression));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::ArithmeticNode& arith)
{
	ar(cereal::make_nvp("op", arith.op),
	   cereal::make_nvp("left", arith.left),
	   cereal::make_nvp("right", arith.right));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::QualifiedTypeNode& type)
{
	ar(cereal::make_nvp("qualifier", type.qualifier),
	   cereal::make_nvp("type", type.type));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::NativeTypeNode& type)
{
	ar(cereal::make_nvp("name", type.name));
}

template<class Archive>
void serialize(Archive& ar, nem::ast::VariableNode& var)
{
	ar(cereal::make_nvp("name", var.name));
}

} // namespace nem::ast