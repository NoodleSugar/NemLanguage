add_executable(JitTest)

target_sources(JitTest
	PRIVATE
		return_int.cpp
)

set_target_properties(JitTest PROPERTIES CXX_STANDARD 17)
target_link_libraries(JitTest ${NEM_IR} ${NEM_PARSER})

catch_discover_tests(JitTest TEST_PREFIX [JitTest])