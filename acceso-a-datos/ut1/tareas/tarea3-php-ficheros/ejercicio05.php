<?php
$sourceFilename = "files/origen.txt";
$targetFilename = "files/copia.txt";

file_put_contents($sourceFilename, "Este es el archivo original.");
echo "$sourceFilename\n";
echo file_get_contents($sourceFilename) . "\n";
copy($sourceFilename, $targetFilename);
echo "$targetFilename\n";
echo file_get_contents($targetFilename) . "\n";
?>