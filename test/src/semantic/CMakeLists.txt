add_executable(SymbolTableComputerTest)

add_dependencies(SymbolTableComputerTest MoveResources)

set_target_properties(
	SymbolTableComputerTest
		PROPERTIES CXX_STANDARD 17
)

target_link_libraries(SymbolTableComputerTest ${NEM_SEM} ${NEM_ANTLR} ${NEM_O})

target_sources(SymbolTableComputerTest PRIVATE symbol/SymbolTableComputerTests.cpp)

catch_discover_tests(SymbolTableComputerTest TEST_PREFIX [SymbolTableComputer])