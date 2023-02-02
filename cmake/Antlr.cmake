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

add_definitions(-DANTLR4CPP_STATIC)

include_directories(${ANTLR4_INCLUDE_DIRS})