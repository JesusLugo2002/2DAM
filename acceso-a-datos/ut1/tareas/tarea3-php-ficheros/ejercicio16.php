<?php
function guessWord(String $filename): void {
    if (!$words = file($filename)) {
        echo "Cannot open $filename";
        return;
    }

    $target = trim($words[array_rand($words)]);
    $countChars = strlen($target);
    $displayWord = str_repeat("-", $countChars);
    $firstIndex = rand(0, $countChars - 1);
    do {
        $secondIndex = rand(0, $countChars - 1);
    } while ($secondIndex == $firstIndex);
    $displayWord = substr_replace($displayWord, substr($target, $firstIndex, 1), $firstIndex, 1);
    $displayWord = substr_replace($displayWord, substr($target, $secondIndex, 1), $secondIndex, 1);

    echo "Adivina la palabra";
    do {
        echo "\n$displayWord\n";
        $userWord = strtolower(trim(readline("-> ")));
    } while ($target != $userWord);
    echo "¡Lo adivinaste!";
}

$filename = "files/palabras.txt";
guessWord($filename);
?>