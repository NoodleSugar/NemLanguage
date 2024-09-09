add_executable(IRBuilderTest)

target_sources(IRBuilderTest
	PRIVATE
		Function.cpp
		Instructions.cpp
		Expressions.cpp
		Types.cpp
)

set_target_properties(IRBuilderTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(IRBuilderTest ${NEM_PARSER} ${NEM_IR})

catch_discover_tests(IRBuilderTest TEST_PREFIX [IRBuilder])