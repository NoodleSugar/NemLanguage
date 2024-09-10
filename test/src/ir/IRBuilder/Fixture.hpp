#pragma once

#include <fstream>
#include <sstream>

#include <llvm/Support/raw_os_ostream.h>

#include <catch2/catch_test_macros.hpp>
#include <catch2/generators/catch_generators.hpp>

#include "nem/ir/IRBuilder.hpp"
#include "nem/ir/IRModule.hpp"
#include "nem/parser/Parser.hpp"

using namespace nem::ast;
using namespace nem::parser;
using namespace nem::ir;

class IRBuilderFixture
{
protected:
	IRModule  module;
	IRBuilder builder;

	IRBuilderFixture() :
		builder(module.createBuilder()) {}

	template<class T = File>
	std::string getIRString(const std::string& code, ParserRule::Type rule)
	{
		auto  astElement = Parser(code).parse(rule);
		auto& ast		 = std::get<T>(astElement);

		auto ir = builder.build(ast);

		std::stringstream irStream;
		llvm::raw_os_ostream(irStream) << *ir;

		return irStream.str();
	}

	template<>
	std::string getIRString<File>(const std::string& code, ParserRule::Type rule)
	{
		auto  astElement = Parser(code).parse(rule);
		auto& ast		 = std::get<File>(astElement);

		builder.build(ast);

		std::stringstream irStream;
		irStream << module;

		return irStream.str();
	}

	std::string getFileContent(const std::string& filename)
	{
		std::ifstream stream(filename);
		return std::string((std::istreambuf_iterator<char>(stream)),
						   (std::istreambuf_iterator<char>()));
	}
};

class IRBuilderInstructionFixture : public IRBuilderFixture
{
protected:
	IRBuilderInstructionFixture() :
		IRBuilderFixture()
	{
		const SourceInfo emptyInfo{};
		const Literal	 zeroInt{{emptyInfo}, LiteralType::Int, "0"};

		builder.build(
		 Function{{emptyInfo},
				  Identifier{{emptyInfo}, "main"},
				  NativeType{{emptyInfo}, NativeTypeE::Int},
				  Block{{emptyInfo},
						{Return{{emptyInfo}, zeroInt}}}});
	}
};
