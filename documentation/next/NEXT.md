
# Future additions
Nem should be suitable to program both for embedded hardware and huge applications.

# Discussions

## String
Native “string” type? How do we implement it? Zero-terminated string OR size + char sequence?

Noel: After discussing with my brother, I think we should just keep byte and not char. Initially, char was not meant to represent a “character”, but rather a memory word (= a byte). We should also keep arith and bitwise op on it. For the “textual” part of the langage(char, strings …), let’s see it later (in a specific module), because it seems a bit complex (in this world, we speak about  “encodage” and “collation”. Wtf). Maybe make a separate module to deal with strings.

# Ideas
- sizeof, alignof
- define math operators’ behavior on overflow (I’d suggest going with “unspecified result”)
- add math operators with different overflow behavior : +% (wrapping add.), +| (saturating add.)

## Modules

### 1st possibility: like in C++20
import A;        // imports everything from A 
import A.B;      // imports everything from the submodule(?) B from A?
export import A; // imports and exports everything from A
module C;        // this module is module C
// downsides:
// - definitions in A can collide with definitions in C
// - it’s not clear in the code after what comes from A
//   (since A is not brought as a namespace = there’s no A::thing)

### 2nd possibility: modules are brought in namespaces
import A;          // imports everything from A in a namespace “A”
using A::thing;    // now “thing” can be directly accessed
using namespace A; // same as C++, but not recommended

### 3rd possibility: mix of Zig/C++/Rust
const mod_A = import("A"); // namespace-import of module A
using mod_A::thing;        // now “thing” can be directly used
using mod_A::*;            // like in Rust, but not recommended

## Statements
if (cond) { … } else if (cond) { … } else { … }

while (cond) { … break; … continue; … }

switch (expr) { case val: … case val, val: … else: … }

ideas:
- for loop? with which syntax?
- switch: allow “ranges” in cases, such as “case 1…10:”
- switch: no fallthrough possible (implicit break), and no explicit break to leave the switch
- how to exit (break) out of the outer loop from within an inner nested loop?
  Zig uses optional statement names like “name: while (cond) { … }” to allow “break :name;”

## Functions

fn name(parameters) !return_type { /* code which can throw */ }

ideas:
1. overloading allowed or not?
2. default values? ex: “fn f(a=0, b=1, c=2) void;”
3. possiblity to “skip” parameters which have default values in calls? ex: “f(,4,)”
4. possiblity to “name” parameters (for clarity for instance) in calls? ex: “f(b=1,a=0,2)”

Noel:
1. Yes
2. Yes
3. Yes, maybe with a “default” keyword : “f(default, 4, default)” ???
4. I do not really like this syntax. If there is a benefit, maybe I’d say ok to this.

Nathan: I have no opinion yet on any of those four points.

benefit of named parameters:
open(“/file”, false, true) is less clear than open(“/file”, readonly=false, lock=true)
if the function open is redesigned and the order of some of its parameters are changed, open(“/file”, lock=true, readonly=false) won’t miscompile, unlike open(“...”, false, true)
however:
if we have great enum support, we won’t need named parameters and can have instead:
	fn open(path: string, access: ModeEnum, exclusive: LockEnum) called like below:
	open(“”, .ReadWrite, .ExclusiveAccess); // looks even better than readonly=false, …

benefit of named parameters if we allow “skipping” parameters (as defined above):
f(fourth_parameter=x) looks better than f(default, default, default, x)

## Aliases
fn f(a : int, b : char, c : int) { … } // regular function
alias fn aliasFn(x : int, y : int) = f(y, 'a', x); // alias

Nathan: What about removing the keyword alias? to allow directly the following:
fn aliasFn(x : int, y : int) = f(y, 'a', x); // alias

Error handling

fn f() !int; // f can throw

ideas:

try f(); // if f returns with an error, return with the same error
         // otherwise, this expression has the return value of f()

f() catch (err) { … } // evaluates to … if f returned with an error
                      // otherwise, evaluates to the result of f()

throw error_value; // “return” with an error

## Pointers

var ptr : *int; // can’t be set to null
var ptr_to_const : *const int; // can’t be set to null

## Compile-time

comptime expr // “expr” will be evaluated at compile-time and
              // its result value will be used here in the code

ideas:

f(comptime n: int, k: int); // n must be a compile-time known
                            // C++ equivalent: f<int n>(int k)

compile time constant data
TypeList, TypeSet, TypeMap
for(Type t in myTypeList)
for(Type t in myTypeSet)
for(Entry t in myTypeMap)

## Genericity

class MyClass<type T>
interface MyInterface<type T>
fn myFunction<type T, int n>

Reflexivity

// compile time methods for types:
MyType.name()
MyType.hasFuntion("maFunc")
MyType.hasFuntion("maFunc", fn (int) void)

Nathan: What about having a symbol to identify built-in (*) functions/attributes, like in Zig?
(*) things that can’t be written in the language itself, but that are understood by the compiler
For instance, “@”: “@sizeof(type)”, “type.@name”, “type.@hasFunction(“myFunc”).

## Classes
class C
{
public:
  fn f() void { … this … }
  fn const f() void { … this … }
  static fn f() void { … }
  virtual fn f() void { … this … }
  override fn f() void { … this … }
protected: …
private: …
  // (static) attributes like in C++
}

interface I
{
  fn f(int) int;
}

class A implements I
{
  fn f(int) int { … }
}

class B {}

adapt B to I
{
  fn f(int) int { … }
}

ideas:
- are attributes allowed in interfaces?
- “property” keyword and “property get/set” like in C# (to avoid getter/setter standard methods)
- constructors? destructors? invariants? pre/post-conditions?
- (multiple?) (diamond?) inheritance?
- single/multi dispatch?

## Self and self
- Self représente le type actuel dans un trait, classe (interface ?)
- self représente l'objet actuel dans une méthode (remplace this)
- Les méthodes d'instance de classe prennent self en premier paramètre (peut être const)    

Avantages :
- Représente réellement le type de la méthode, donc plus facile à faire des pointeurs dessus
- Plus facile pour faire du fonction binding

## Alias
class A<type T, type U> { … } // normal class
alias class B<type Z> = A<SomeClass, Z>; // alias

Nathan: What about removing the keyword alias? to allow directly the following:
class B<type Z> = A<SomeClass, Z>;



# BAZAR
- Volonté d'avoir un typage "fort" et sûr
- Analyse de l'usage des variables
	- Si une variable n'est pas déclarée const, mais n'est pas modifiée dans son scope : warning
	- Si une variable n'est pas utilisées : warning
- Union type (polymorphisme statique)
	Possibilité de switch su& le type
- Enum type
- Séparer le parser de l'analyse sémantique ? (faire deux programmes)