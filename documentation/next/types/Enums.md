# Enums

## Examples

    enum Color
    {
        Red,
        Green,
        Blue
    }

    var v = Color.Red;
    var n =
        match(v)
        | Red   -> 1
        | Green -> 2
        | Blue  -> 3