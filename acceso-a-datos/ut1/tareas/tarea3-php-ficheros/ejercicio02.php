<?php
function generateRange(string $filename, int $limit): void {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open file";
        return;
    }
    for ($i = 1; $i <= $limit; $i++) {
        fwrite($fp, "$i\n");
    }   
    fclose($fp);
}

$filename = "numeros.txt";
generateRange($filename, 10);
echo file_get_contents($filename);
?>