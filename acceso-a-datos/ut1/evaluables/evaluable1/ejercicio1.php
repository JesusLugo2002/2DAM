<?php
function fizzBuzz(int $n, int $a, int $b): void {
    $result = [];
    for ($i = 1; $i <= $n; $i++) {
        if ($i % $a == 0 && $i % $b == 0) {
            $result[] = "FizzBuzz";
        } else if ($i % $a == 0) {
            $result[] = "Fizz";
        } else if ($i % $b == 0) {
            $result[] = "Buzz";
        } else {
            $result[] = $i;
        }
    }

    echo implode(", ", $result);
}

fizzBuzz(15, 3, 5);
?>