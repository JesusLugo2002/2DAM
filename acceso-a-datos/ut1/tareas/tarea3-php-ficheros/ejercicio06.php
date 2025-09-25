<?php
$phrase = file_get_contents("files/frase.txt");
echo "$phrase\n";
$invertedPhrase = strrev($phrase);
file_put_contents("files/frase_invertida.txt", $invertedPhrase);
echo file_get_contents("files/frase_invertida.txt") . "\n";
?>