cmake_minimum_required(VERSION 3.22.0)
project(
	Nem
		VERSION 0.1.0
		DESCRIPTION "Nem Language Compiler"
		LANGUAGES CXX C
)

include(cmake/LLVM.cmake)
include(cmake/Antlr.cmake)

# Main targets
set(NEM_PARSER "nemparser")
set(NEM_IR "nemir")
set(TARGET_LIST ${NEM_PARSER} ${NEM_IR})

add_library(${NEM_PARSER} STATIC)
add_library(${NEM_IR} STATIC)

set_target_properties(${TARGET_LIST} PROPERTIES CXX_STANDARD 17)

# Nem Parser
target_include_directories(${NEM_PARSER} PUBLIC include)
target_link_libraries(${NEM_PARSER} PUBLIC ANTLR)

target_sources(${NEM_PARSER}
	PRIVATE
		src/parser/Parser.cpp
		src/parser/ParseTreeVisitor/Helpers.cpp
		src/parser/ParseTreeVisitor/File.cpp
		src/parser/ParseTreeVisitor/Function.cpp
		src/parser/ParseTreeVisitor/Instructions.cpp
		src/parser/ParseTreeVisitor/Expressions.cpp
		src/parser/ParseTreeVisitor/Types.cpp
)

# Nem IR
target_include_directories(${NEM_IR} PUBLIC include)
target_link_libraries(${NEM_IR} PUBLIC LLVM)

target_sources(${NEM_IR}
	PRIVATE
		src/ir/Jit.cpp
		src/ir/IRModule.cpp
		src/ir/IRBuilder/IRBuilder.cpp
		src/ir/IRBuilder/Function.cpp
		src/ir/IRBuilder/Instructions.cpp
		src/ir/IRBuilder/Expressions.cpp
		src/ir/IRBuilder/Types.cpp
		src/ir/util/LiteralParser.cpp
)

# Tests
find_package(Catch2 REQUIRED)
include(CTest)
include(Catch)

enable_testing()

add_subdirectory(test)
