link_libraries(Catch2::Catch2WithMain)
include_directories(include)

add_custom_target(MoveResources ALL)
add_custom_command(TARGET MoveResources POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_directory  ${CMAKE_SOURCE_DIR}/test/resources ${CMAKE_BINARY_DIR}/resources
	COMMENT "Resource files moved to ${CMAKE_SOURCE_DIR}/test/resources"
)

add_subdirectory(src/antlr/)
