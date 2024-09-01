# Grammar
- Suffix for literral type (b, u32, r64 ...)
- Boolean operators
- Pointer type
- Function type
- Conditionnal structure (if, else)
- Conditionnal expression (if b then e1 else e2)
- Loop (for(x in list), for(init;cond;assign), while)

# Antlr
- Handle parsing errors

# Semantic Analysis
- Before all : compute Symbol Table from AST
- Step 1 : Symbols
	- Undefined symbol
	- Symbol redefinition
- Step 2 : Types
	- Condition with boolean
	- Arithmetic for integers and reals
	- Comparisons
		- Equality for all type
		- Greater/Lower for integers and reals
- LLVM may do these (to be checked)
	- Repetitive "Minus" simplification
	- Boolean simplification (true OR b => true, false AND b => false)
	- Conditionnal structure simplification
- int = int32 or int64 depending on target machine register size (use TargetRegisterInfo)

# Tests
- More tests for antlr visitor
- Make tests for Ast/Serialization

# BAZAR
- Volonté d'avoir un typage "fort" et sûr
- Analyse de l'usage des variables
	- Si une variable n'est pas déclarée const, mais n'est pas modifiée dans son scope : warning
	- Si une variable n'est pas utilisées : warning
- Union type (polymorphisme statique)
	Possibilité de switch su& le type
- Enum type
- Séparer le parser de l'analyse sémantique ? (faire deux programmes)