cmake_minimum_required(VERSION 3.22.0)
project(
	Nem
		VERSION 0.1.0
		DESCRIPTION "Nem Language Compiler"
		LANGUAGES CXX C
)

include(cmake/Antlr.cmake)

# Main targets
set(NEM_ANTLR "nemantlr")
set(TARGET_LIST ${NEM_ANTLR})

add_library(${NEM_ANTLR} STATIC)

set_target_properties(${TARGET_LIST} PROPERTIES CXX_STANDARD 17)

# Nem Antlr
target_include_directories(${NEM_ANTLR} PUBLIC include)
target_link_libraries(${NEM_ANTLR} PUBLIC ANTLR)

target_sources(${NEM_ANTLR}
	PRIVATE
		src/antlr/ParseTreeVisitor/Helpers.cpp
		src/antlr/ParseTreeVisitor/Instructions.cpp
		src/antlr/ParseTreeVisitor/Expressions.cpp
		src/antlr/ParseTreeVisitor/Types.cpp
)

# Tests
find_package(Catch2 REQUIRED)
include(CTest)
include(Catch)

enable_testing()

add_subdirectory(test)