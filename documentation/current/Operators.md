# Operators

## List

### Arithmetic

    + - * / %

### Comparison

    == < > <= >= <>

### Logical

    not and or xor

### Assignment

    =

### Call

    ()

## Precedence

## Associated method

Some nem operators has an associated method name, that can be defined in classes, in order to allow objects from these classes to use the operator.

| Operator  | Method |
|-----------|--------|
| ```+```   | ```__add(T, T) : T``` |
| ```-```   | ```__sub(T, T) : T``` |
| ```*```   | ```__mul(T, U) : V``` |
| ```/```   | ```__div(T, U) : V``` |
| ```%```   | ```__mod(T, T) : T``` |
| ```==```  | ```__equal(T, T) : Bool ``` |
| ```<```  | ```__lower(T, T) : Bool ``` |
| ```>```  | ```__greater(T, T) : Bool ``` |
| ```<=```  | ```__lowerEqual(T, T) : Bool ``` |
| ```>=```  | ```__greaterEqual(T, T) : Bool ``` |
| ```<>```  | ```__diff(T, T) : Bool ``` |
| ```not``` | ```__not(T)    : T``` |
| ```and``` | ```__and(T, T) : T``` |
| ```or```  | ```__or(T, T)  : T``` |
| ```xor``` | ```__xor(T, T) : T``` |
| ```=```   | ```__assign(* mut T, T)``` |
| ```()```  | ```__call()``` |

## Special case of comparators

It is possible to define only on comparator method that allows an object to use all the comparators.

    __compare(T, T) : Int

This function returns :
  - __zero__ if it is equal
  - __positive__ integer if it is greater
  - __negative__ integer if it is lower