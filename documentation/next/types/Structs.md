# Struct

## Examples

    struct MyStruct
    {
        a : Int;
        b : Int;
    }

    var a = MyStruct{1, 2}
    var b = MyStruct{.b = 2, .a = 1}
    var c = MyStruct{.a{1}, .b{2}}