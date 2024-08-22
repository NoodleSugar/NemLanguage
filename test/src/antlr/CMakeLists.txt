add_executable(ParseTreeVisitorTest)

target_sources(ParseTreeVisitorTest
	PRIVATE
		ParseTreeVisitor/Expressions.cpp
)

set_target_properties(ParseTreeVisitorTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(ParseTreeVisitorTest ${NEM_ANTLR})

catch_discover_tests(ParseTreeVisitorTest TEST_PREFIX [ParseTreeVisitor])