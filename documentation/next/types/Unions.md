# Unions

## Examples

    struct Cat{ Color catColor; }
    struct Dog{ Color dogColor; }

    union Animal
    {
        Cat,
        Dog
    }

    var v = Animal.Cat{};
    var color =
        match(v)
        | Cat(c) -> c.catColor
        | Dog(d) -> d.dogColor