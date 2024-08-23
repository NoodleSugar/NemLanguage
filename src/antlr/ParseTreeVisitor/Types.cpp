#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;


std::any ParseTreeVisitor::visitTypeInt(NEMParser::TypeIntContext* ctx)
{
	return buildNodeValue<NativeType>(ctx, NativeTypeEnum::Int);
}

std::any ParseTreeVisitor::visitTypeUInt(NEMParser::TypeUIntContext* ctx)
{
	return buildNodeValue<NativeType>(ctx, NativeTypeEnum::UInt);
}

std::any ParseTreeVisitor::visitTypeReal(NEMParser::TypeRealContext* ctx)
{
	return buildNodeValue<NativeType>(ctx, NativeTypeEnum::Real);
}

} // namespace nem::antlr
