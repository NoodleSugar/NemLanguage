#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitTypeBool(NEMParser::TypeBoolContext* ctx)
{
	return buildAstElement<NativeType>(ctx, NativeTypeE::Bool);
}

std::any ParseTreeVisitor::visitTypeInt(NEMParser::TypeIntContext* ctx)
{
	return buildAstElement<NativeType>(ctx, NativeTypeE::Int);
}

std::any ParseTreeVisitor::visitTypeReal(NEMParser::TypeRealContext* ctx)
{
	return buildAstElement<NativeType>(ctx, NativeTypeE::Real);
}

} // namespace nem::parser
