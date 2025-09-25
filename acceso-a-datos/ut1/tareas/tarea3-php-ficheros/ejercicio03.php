<?php
function countWords(String $filename): int {
    return str_word_count(file_get_contents($filename));
}

$filename = "files/texto.txt";
file_put_contents($filename, "PHP es muy divertido y potente");
echo "El archivo $filename tiene " . countWords($filename) . " palabras.";
?>