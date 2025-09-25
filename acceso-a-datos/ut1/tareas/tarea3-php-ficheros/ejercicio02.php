<?php
function generateRange(string $filename, int $limit): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open file";
        return false;
    }
    for ($i = 1; $i <= $limit; $i++) {
        fwrite($fp, "$i\n");
    }   
    return fclose($fp);
}

$filename = "files/numeros.txt";
generateRange($filename, 10);
echo file_get_contents($filename);
?>