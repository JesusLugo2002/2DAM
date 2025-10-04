<?php
function removeDuplicates(int $n): int {
    $digits = str_split(strval($n));
    $uniqueNumbers = array_unique($digits);
    return (int)implode("", $uniqueNumbers);
}

echo removeDuplicates(12021203);
?>