<?php
function countWords(String $filename): int {
    return str_word_count(file_get_contents($filename));
}

file_put_contents("texto.txt", "PHP es muy divertido y potente");
echo "El archivo texto.txt tiene " . countWords("texto.txt") . " palabras.";
?>