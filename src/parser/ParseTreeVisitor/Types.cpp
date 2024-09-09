#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitTypeInt(NEMParser::TypeIntContext* ctx)
{
	return buildParseTreeValue<NativeType>(ctx, NativeTypeE::Int);
}

std::any ParseTreeVisitor::visitTypeReal(NEMParser::TypeRealContext* ctx)
{
	return buildParseTreeValue<NativeType>(ctx, NativeTypeE::Real);
}

} // namespace nem::parser