<?php
$height = (int)readline("Inserte la altura de las montañas -> ");
function asteriskMountain(int $height, int $mountains): void {
    $mountain = [];
    $horizontalSize = $height * $mountains - 1;
    for ($i = 1; $i <= $height; $i++) {
        $row = array_fill(0, $horizontalSize, "*");
        for ($j = $i; $j < $horizontalSize - $i; $j++) {
            $row[$j] = " ";
        }
        $mountain[] = $row; 
    }

    foreach ($mountain as $row) {
        echo implode("", $row) . "\n";
    }
}

asteriskMountain($height, 2);
?>