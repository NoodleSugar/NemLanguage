#include <fstream>

#include <llvm/ExecutionEngine/Orc/LLJIT.h>
#include <llvm/ExecutionEngine/Orc/ThreadSafeModule.h>
#include <llvm/IR/LegacyPassManager.h>
#include <llvm/MC/TargetRegistry.h>
#include <llvm/Support/CommandLine.h>
#include <llvm/Support/Error.h>
#include <llvm/Support/InitLLVM.h>
#include <llvm/Support/TargetSelect.h>
#include <llvm/Target/TargetOptions.h>
#include <llvm/TargetParser/Host.h>

#include <NEMLexer.h>
#include <NEMParser.h>

#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::antlr;
using namespace nem::ast;
using namespace nem::semantic;

enum Action
{
	Compile,
	DumpSemantic,
	DumpIr,
	Execute
};

static llvm::cl::opt<std::string> inputFileName(
 llvm::cl::Positional,
 llvm::cl::desc("<file>"),
 llvm::cl::Required);

static llvm::cl::opt<enum Action> action(
 "action",
 llvm::cl::desc("Select what to do"),
 llvm::cl::init(Compile),
 llvm::cl::values(clEnumValN(Compile, "compile", "Compile to object file. (Default)")),
 llvm::cl::values(clEnumValN(DumpSemantic, "semantic", "Output the semantic AST")),
 llvm::cl::values(clEnumValN(DumpIr, "ir", "Output the LLVM IR")),
 llvm::cl::values(clEnumValN(Execute, "exec", "Execute the script")));

static llvm::cl::opt<bool> isCompact(
 "compact",
 llvm::cl::desc("Enable compact printing"),
 llvm::cl::init(false));

int main(int argc, char* argv[])
{
	llvm::cl::ParseCommandLineOptions(argc, argv);

	std::fstream inStream(inputFileName);

	if(!inStream.is_open())
		return 1;

	antlr4::ANTLRInputStream  input(inStream);
	NEMLexer				  lexer(&input);
	antlr4::CommonTokenStream tokens(&lexer);
	NEMParser				  antlrAst(&tokens);

	ParseTreeVisitor ParseTreeVisitor;

	auto ast = std::any_cast<nem::ast::File>(ParseTreeVisitor.visitFile(antlrAst.file()));

	if(action == Action::DumpSemantic)
	{
		return 0;
	}

	ComputeIRVisitor computeIRVisitor;
	computeIRVisitor.visit(ast);
	if(action == Action::DumpIr)
		computeIRVisitor.getModule()->print(llvm::outs(), nullptr);

	if(action == Action::Execute)
	{
		llvm::InitLLVM X(argc, argv);

		llvm::InitializeNativeTarget();
		llvm::InitializeNativeTargetAsmPrinter();

		llvm::ExitOnError err;

		err.setBanner("TEST JIT : ");
		auto jit = err(llvm::orc::LLJITBuilder().create());

		err(jit->addIRModule(
		 llvm::orc::ThreadSafeModule(computeIRVisitor.getModule(),
									 computeIRVisitor.getContext())));

		auto mainAddr = err(jit->lookup("main"));
		auto mainFunc = mainAddr.toPtr<int()>();

		std::cout << "Result of script ["
				  << inputFileName
				  << " ] : "
				  << mainFunc()
				  << std::endl;

		return 0;
	}

	if(action == Action::Compile)
	{
		llvm::InitializeAllTargetInfos();
		llvm::InitializeAllTargets();
		llvm::InitializeAllTargetMCs();
		llvm::InitializeAllAsmParsers();
		llvm::InitializeAllAsmPrinters();

		std::string err;

		auto targetTriple = llvm::sys::getDefaultTargetTriple();
		auto target		  = llvm::TargetRegistry::lookupTarget(targetTriple, err);

		if(!target)
		{
			llvm::errs() << err;
			return 1;
		}

		auto cpu		   = "generic";
		auto features	   = "";
		auto targetOptions = llvm::TargetOptions{};
		auto relocModel	   = std::optional<llvm::Reloc::Model>();

		auto targetMachine =
		 target->createTargetMachine(targetTriple, cpu, features, targetOptions, relocModel);

		auto module = computeIRVisitor.getModule();
		module->setDataLayout(targetMachine->createDataLayout());
		module->setTargetTriple(targetTriple);

		auto outputFilename = inputFileName + ".nemo";

		std::error_code		 errorCode;
		llvm::raw_fd_ostream outStream(outputFilename, errorCode, llvm::sys::fs::OF_None);

		if(errorCode)
		{
			llvm::errs() << "Could not open file: " << errorCode.message();
			return 1;
		}

		llvm::legacy::PassManager pass;

		auto fileType = llvm::CGFT_ObjectFile;

		if(targetMachine->addPassesToEmitFile(pass, outStream, nullptr, fileType))
		{
			llvm::errs() << "TargetMachine can't emit a file of this type";
			return 1;
		}

		pass.run(*module);
		outStream.flush();

		return 0;
	}

	return 0;
}