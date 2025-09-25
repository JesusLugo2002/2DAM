<?php
function getRandomLine(String $filename): String {
    $results = file($filename);
    $randIndex = array_rand($results);
    return $results[$randIndex];
}
$filename = "files/excusas.txt";
echo getRandomLine($filename);
?>