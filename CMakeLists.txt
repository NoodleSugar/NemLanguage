cmake_minimum_required(VERSION 3.22.0)
project(
	Nem
		VERSION 0.1.0
		DESCRIPTION "Nem Language Compiler"
		LANGUAGES CXX C
)

find_package(cereal REQUIRED)

include(cmake/LLVM.cmake)
include(cmake/Antlr.cmake)

# Main targets
set(NEM_ANTLR "nemantlr")
set(NEM_AST   "nemast")
set(NEM_SEM   "nemsem")
set(NEMC      "nemc")
set(TARGET_LIST ${NEM_ANTLR} ${NEM_AST} ${NEM_SEM} ${NEMC})

add_library(${NEM_ANTLR} STATIC)
add_library(${NEM_AST}   STATIC)
add_library(${NEM_SEM}   STATIC)
add_executable(${NEMC})

set_target_properties(${TARGET_LIST} PROPERTIES CXX_STANDARD 17)

# Nem Antlr
target_include_directories(${NEM_ANTLR} PUBLIC include)
target_link_libraries(${NEM_ANTLR} PUBLIC ANTLR)

target_sources(${NEM_ANTLR}
	PRIVATE
		src/antlr/AstComputer.cpp
		src/antlr/ParseTreeVisitor/Helpers.cpp
		src/antlr/ParseTreeVisitor/Files.cpp
		src/antlr/ParseTreeVisitor/Functions.cpp
		src/antlr/ParseTreeVisitor/Instructions.cpp
		src/antlr/ParseTreeVisitor/Expressions.cpp
		src/antlr/ParseTreeVisitor/Types.cpp
)

# Nem Ast
target_include_directories(${NEM_AST} PUBLIC include)
target_link_libraries(${NEM_AST} PUBLIC cereal::cereal)

target_sources(${NEM_AST}
	PRIVATE
		src/ast/Visitor.cpp
)

# Nem Semantic
target_include_directories(${NEM_SEM} PUBLIC include)
target_link_libraries(${NEM_SEM} PUBLIC LLVM ${NEM_AST})

target_sources(${NEM_SEM}
	PRIVATE
		src/semantic/symbol/SymbolTable.cpp
		src/semantic/symbol/SymbolTableBuilder.cpp
		src/semantic/symbol/SymbolTableComputer.cpp

		# src/semantic/ComputeIRVisitor/Visitor.cpp
		# src/semantic/ComputeIRVisitor/TopLevels.cpp
		# src/semantic/ComputeIRVisitor/Instructions.cpp
		# src/semantic/ComputeIRVisitor/Expressions.cpp
		# src/semantic/ComputeIRVisitor/Types.cpp

		# src/semantic/util/LiteralParser.cpp
		# src/semantic/util/VariableRegister.cpp
)

# Nem Compiler
target_sources(${NEMC} PRIVATE src/nemc.cpp)
target_link_libraries(${NEMC} ${NEM_ANTLR} ${NEM_AST} ${NEM_SEM})

# Tests
find_package(Catch2 REQUIRED)
include(CTest)
include(Catch)

enable_testing()

add_subdirectory(test)