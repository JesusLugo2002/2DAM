<?php
const ANIMALS_FILENAME = "files/animales.txt";
const PLACES_FILENAME = "files/lugares.txt";
const FOOD_FILENAME = "files/comidas.txt";

function getRandomWord(String $filename): String|bool {
    if (!$words = file($filename)) {
        echo "Cannot open $filename";
        return false;
    }
    $index = array_rand($words);
    return $words[$index];
}

function useTemplate(String $filename): String {
    $phrase = file_get_contents($filename);
    $animal = trim(getRandomWord(ANIMALS_FILENAME));
    $place = trim(getRandomWord(PLACES_FILENAME));
    $food = trim(getRandomWord(FOOD_FILENAME));
    $phrase = preg_replace("/\[animal\]/", $animal, $phrase);
    $phrase = preg_replace("/\[lugar\]/", $place, $phrase);
    $phrase = preg_replace("/\[comida\]/", $food, $phrase);
    return $phrase;
}

$filename = "files/plantilla.txt";
echo useTemplate($filename);
?>