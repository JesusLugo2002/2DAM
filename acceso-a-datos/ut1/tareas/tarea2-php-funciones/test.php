<?php
function asteriskMountain(int $height, int $mountains): void {
    $mountain = [];
    $horizontalSize = $height * $mountains - 1;
    for ($i = 1; $i <= $height; $i++) {
        $row = array_fill(0, $horizontalSize, "*");
        $mountain[] = $row;
    }

    foreach ($mountain as $row) {
        echo implode(" ", $row) . "\n";
    }
}

asteriskMountain(4, 2);
?>