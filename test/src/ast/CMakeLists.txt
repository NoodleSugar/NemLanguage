add_executable(AstSerializationTest)
target_sources(AstSerializationTest
	PRIVATE
		serialization/File.cpp
)

set_target_properties(
	AstSerializationTest
		PROPERTIES CXX_STANDARD 17)

target_link_libraries(AstSerializationTest ${NEM_AST} ${NEM_ANTLR})

catch_discover_tests(AstSerializationTest TEST_PREFIX [AstSerialization])