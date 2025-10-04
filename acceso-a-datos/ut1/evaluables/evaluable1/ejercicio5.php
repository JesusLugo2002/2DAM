<?php
function countLetters(String $word): array {
    $vowelsCount = preg_match_all("/[aeiouáéíóú]/i", $word);
    $lettersCount = preg_match_all("/\w/i", $word) - $vowelsCount;
    return ["letras" => $lettersCount, "vocales" => $vowelsCount];
}

print_r(countLetters("Hola, mundo!"));
print_r(countLetters("¡Qué fácil es PHP 8!"));
?>