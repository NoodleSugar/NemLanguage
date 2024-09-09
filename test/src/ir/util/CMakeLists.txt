add_executable(IRUtilTest)

target_sources(IRUtilTest
	PRIVATE
		LiteralParser.cpp
)

set_target_properties(IRUtilTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(IRUtilTest ${NEM_IR})

catch_discover_tests(IRUtilTest TEST_PREFIX [IRUtil])