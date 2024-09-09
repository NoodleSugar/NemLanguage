link_libraries(Catch2::Catch2WithMain)
include_directories(include)

add_custom_target(MoveResources ALL)
add_custom_command(TARGET MoveResources POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_directory  ${CMAKE_SOURCE_DIR}/test/resources ${CMAKE_BINARY_DIR}/test/src
	COMMENT "Resource files moved to ${CMAKE_SOURCE_DIR}/test/src"
)

add_subdirectory(src/parser/)
add_subdirectory(src/ir/util)
add_subdirectory(src/ir/IRBuilder)