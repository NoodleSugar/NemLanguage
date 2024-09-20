find_package(LLVM REQUIRED CONFIG)

list(APPEND CMAKE_MODULE_PATH "${LLVM_CMAKE_DIR}")

include(TableGen)
include(AddLLVM)
include(HandleLLVMOptions)

separate_arguments(LLVM_DEFINITIONS_LIST NATIVE_COMMAND ${LLVM_DEFINITIONS})
add_definitions(${LLVM_DEFINITIONS_LIST})

execute_process(COMMAND llvm-config --components OUTPUT_VARIABLE llvm_components)
separate_arguments(llvm_components_list NATIVE_COMMAND ${llvm_components})
llvm_map_components_to_libnames(llvm_libs ${llvm_components_list})

message(STATUS "Found LLVM ${LLVM_PACKAGE_VERSION}")
message(STATUS "Using LLVMConfig.cmake in: ${LLVM_DIR}")

message(STATUS "LLVM components: ${llvm_components_list}")
message(STATUS "LLVM includes dir: ${LLVM_INCLUDE_DIRS}")
message(STATUS "LLVM definitions: ${LLVM_DEFINITIONS_LIST}")
message(STATUS "LLVM tools dir: ${LLVM_TOOLS_BINARY_DIR}")

set_target_properties(LLVM PROPERTIES CXX_STANDARD 17)

target_include_directories(LLVM INTERFACE ${LLVM_INCLUDE_DIRS})
target_compile_definitions(LLVM INTERFACE ${LLVM_DEFINITIONS_LIST})
target_link_libraries(LLVM INTERFACE ${LLVM_AVAILABLE_LIBS})