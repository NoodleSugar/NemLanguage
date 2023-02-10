package org.nem.llvm;

import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;

import static org.bytedeco.llvm.global.LLVM.*;

public class App {
	public static void main(String[] args) {
		LLVMInitializeCore(LLVMGetGlobalPassRegistry());
		LLVMLinkInMCJIT();
		LLVMInitializeNativeAsmPrinter();
		LLVMInitializeNativeAsmParser();
		LLVMInitializeNativeTarget();

		LLVMContextRef context = LLVMContextCreate();
		LLVMModuleRef module = LLVMModuleCreateWithNameInContext("factorial", context);
		LLVMBuilderRef builder = LLVMCreateBuilderInContext(context);
		LLVMTypeRef i32Type = LLVMInt32TypeInContext(context);
		LLVMTypeRef factorialType = LLVMFunctionType(i32Type, i32Type, /* argumentCount */ 1, /* isVariadic */ 0);
	}
}
