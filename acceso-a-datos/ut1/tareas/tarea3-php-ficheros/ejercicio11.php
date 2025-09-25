<?php
const FILENAME = "files/diario.txt";
function addLog(String $content): bool {
    if (!$fp = fopen(FILENAME, "a")) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    $datetime = date_format(date_create(), "Y-m-d H:i");
    fwrite($fp, "[$datetime] $content \n");
    return fclose($fp);
}

function printLogs(): bool {
    if (!$fp = fopen(FILENAME, "r")) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    while ($line = fgets($fp)) {
        echo $line;
    }
    return fclose($fp);
}

addLog("Probando, probando, 1, 2, 3");
printLogs();
?>