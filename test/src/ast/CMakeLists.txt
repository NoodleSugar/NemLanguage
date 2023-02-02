add_executable(AstSerializationTest)

target_sources(AstSerializationTest
	PRIVATE
		serialization/TopLevels.cpp
		serialization/Instructions.cpp
		serialization/Expressions.cpp
		serialization/Types.cpp
		serialization/LValues.cpp
)

set_target_properties(AstSerializationTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(AstSerializationTest ${NEM_AST})

catch_discover_tests(AstSerializationTest TEST_PREFIX AstSerialization)