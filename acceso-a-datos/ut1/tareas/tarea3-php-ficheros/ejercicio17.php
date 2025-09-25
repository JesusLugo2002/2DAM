<?php
function askFood(String $filename): bool {
    if (!$fp = fopen($filename, "a")) {
        echo "Cannot open $filename";
        return false;
    }
    $food = strtolower(readline("¿Qué comida te gusta? -> "));
    fwrite($fp, "$food\n");
    return fclose($fp);
}

function showFoodRanking(String $filename): void {
    if (!$foods = file($filename)) {
        echo "Cannot open $filename";
        return;
    }
    $rankings = [];
    foreach (array_unique($foods) as $food) {
        array_push($food);
    }
}
?>