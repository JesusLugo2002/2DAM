<?php
const ADJECTIVES_FILENAME = "files/adjetivos.txt";
const ANIMALS_FILENAME = "files/animales.txt";

function getRandomWord(String $filename): String|bool {
    if (!$words = file($filename)) {
        echo "Cannot open $filename";
        return false;
    }
    $index = array_rand($words);
    return trim($words[$index]);

}
function generateSuperHeroName(): String|bool {
    $adjective = getRandomWord(ADJECTIVES_FILENAME);
    $animal = getRandomWord(ANIMALS_FILENAME);
    if (!$adjective || !$animal) {
        echo "Error getting the words!";
        return false;
    }
    return "$adjective $animal";
}

echo generateSuperHeroName();
?>