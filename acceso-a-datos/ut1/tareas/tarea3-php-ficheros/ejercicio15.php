<?php
// TODO
function getNextLine(String $filename): String|bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename";
        return false;
    }
    $line = fgets($fp);
    return $line;
}
?>