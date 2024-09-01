# Optionals

## Examples

    var opt = ?int{none};
    var value : int = optional ?? 0;

    var value 2 = match(opt)
        | None     -> 0
        | Value(v) -> v