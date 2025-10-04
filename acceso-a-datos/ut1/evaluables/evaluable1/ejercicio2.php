<?php
function asteriskPyramid(int $height): void {
    $horizontalSize = ($height % 2 == 0) ? $height * 2 - 1 : $height * 2;
    for ($i = 1; $i <= $horizontalSize; $i += 2) {
        $line = str_repeat(" ", ($horizontalSize - $i) / 2);
        $line .= str_repeat("*", $i);
        $line .= str_repeat(" ", ($horizontalSize - $i) / 2);
        echo $line . "\n";
    }
}

asteriskPyramid(6);
?>