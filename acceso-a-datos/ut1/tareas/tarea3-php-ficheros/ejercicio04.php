<?php
function createNameList(String $filename, array $names): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open $filename";
        return false;
    }
    foreach ($names as $name) {
        fwrite($fp, $name . "\n");
    }
    return fclose($fp);
}

function showNameList(String $filename): bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename";
        return false;
    }
    while ($line = fgets($fp)) {
        echo $line;
    }
    return fclose($fp);
}

$names = ["Ana", "Luis", "Marta", "Carlos", "Julia"];
$filename = "files/nombres.txt";
createNameList($filename, $names);
showNameList($filename);
?>