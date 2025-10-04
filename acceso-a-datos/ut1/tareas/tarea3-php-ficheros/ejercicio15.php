<?php
function setDisplayWord(String $word): String {
    $countChars = strlen($word);
    $displayWord = str_repeat("-", $countChars);
    $firstIndex = rand(0, $countChars - 1);
    do {
        $secondIndex = rand(0, $countChars - 1);
    } while ($secondIndex == $firstIndex);
    $displayWord = substr_replace($displayWord, substr($word, $firstIndex, 1), $firstIndex, 1);
    $displayWord = substr_replace($displayWord, substr($word, $secondIndex, 1), $secondIndex, 1);
    return $displayWord;
}

function guessWord(String $filename): void {
    if (!$words = file($filename)) {
        echo "Cannot open $filename";
        return;
    }

    $target = trim($words[array_rand($words)]);
    $displayWord = setDisplayWord($target);

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