<?php
function askFood(String $filename): bool {
    if (!$fp = fopen($filename, "a")) {
        echo "Cannot open $filename";
        return false;
    }
    $food = strtolower(readline("¿Qué comida te gusta? -> "));
    fwrite($fp, "$food\n");
    showFoodRanking($filename);
    return fclose($fp);
}

function showFoodRanking(String $filename): void {
    if (!$foods = file($filename)) {
        echo "Cannot open $filename";
        return;
    }
    $frequencies = array_count_values($foods);
    arsort($frequencies);
    echo "Ranking de comida\n";
    foreach ($frequencies as $food => $quantity) {
        echo trim($food) . ": " . trim($quantity) . "\n";
    }
}

$filename = "files/comidas.txt";
askFood($filename);
?>