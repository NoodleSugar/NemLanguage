list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)
set(ANTLR_EXECUTABLE ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/antlr/antlr-4.13.0-complete.jar)
set(ANTLR4_ZIP_REPOSITORY ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/antlr/antlr4-4.13.0.zip)

include(ExternalAntlr4Cpp)
find_package(ANTLR REQUIRED)

antlr_target(NEMLexer NEMLexer.g4 LEXER
		PACKAGE nem::antlr
)
antlr_target(NEMParser NEMParser.g4 PARSER VISITOR
		PACKAGE nem::antlr
		DEPENDS_ANTLR NEMLexer
		COMPILE_FLAGS -lib ${ANTLR_NEMLexer_OUTPUT_DIR}
)

add_library(ANTLR STATIC)
set_target_properties(ANTLR PROPERTIES CXX_STANDARD 17)

target_include_directories(ANTLR
	PUBLIC
		${ANTLR4_INCLUDE_DIRS}
		${ANTLR_NEMLexer_OUTPUT_DIR}
		${ANTLR_NEMParser_OUTPUT_DIR}
)

target_sources(ANTLR
PRIVATE
	${ANTLR_NEMLexer_CXX_OUTPUTS}
	${ANTLR_NEMParser_CXX_OUTPUTS}
)

target_compile_definitions(ANTLR PUBLIC -DANTLR4CPP_STATIC)
target_link_libraries(ANTLR PUBLIC antlr4_static)