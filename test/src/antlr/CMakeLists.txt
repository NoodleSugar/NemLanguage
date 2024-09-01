add_executable(ParseTreeVisitorTest)

target_sources(ParseTreeVisitorTest
	PRIVATE
		ParseTreeVisitor/Files.cpp
		ParseTreeVisitor/Functions.cpp
		ParseTreeVisitor/Instructions.cpp
		ParseTreeVisitor/Expressions.cpp
		ParseTreeVisitor/Types.cpp
)

set_target_properties(ParseTreeVisitorTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(ParseTreeVisitorTest ${NEM_ANTLR})

catch_discover_tests(ParseTreeVisitorTest TEST_PREFIX [ParseTreeVisitor])