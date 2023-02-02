add_executable(ComputeAstVisitorTest)

target_sources(ComputeAstVisitorTest
	PRIVATE
		ComputeAstVisitor/TopLevels.cpp
		ComputeAstVisitor/Instructions.cpp
		ComputeAstVisitor/Expressions.cpp
		ComputeAstVisitor/Types.cpp
		ComputeAstVisitor/LValues.cpp
)

set_target_properties(ComputeAstVisitorTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(ComputeAstVisitorTest ${NEM_ANTLR})

catch_discover_tests(ComputeAstVisitorTest TEST_PREFIX ComputeAstVisitor)