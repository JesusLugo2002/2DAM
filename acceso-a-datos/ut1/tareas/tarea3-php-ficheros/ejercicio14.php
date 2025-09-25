<?php
// No sé cómo almacenar el pointer para usarlo en la siguiente iteración
function getNextLine(String $filename): String|bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename";
        return false;
    }
    $line = fgets($fp);
    return $line;
}
?>