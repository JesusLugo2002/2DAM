<?php
$values = explode(",", file_get_contents("files/datos_numericos.txt"));
$sum = array_sum($values);
echo "La suma de " . implode(" + ", $values) . " es igual a $sum"; 
?>