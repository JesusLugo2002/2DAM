<?php
function generateMultiplicationTable(String $filename, int $multiplier): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open $filename.";
        return false;
    }
    for ($i = 1; $i <= $multiplier; $i++) {
        fwrite($fp, "$multiplier x $i = " . $multiplier * $i . "\n");
    }
    return fclose($fp);
}

function showMultiplicationTable(String $filename): bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename.";
        return false;
    }
    foreach (file($filename) as $row) {
        echo $row;
    }
    return fclose($fp);
}

$filename = "files/tabla5.txt";
generateMultiplicationTable($filename, 5);
showMultiplicationTable($filename);
?>