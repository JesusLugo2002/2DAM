<?php
function getFrameData(String $filename): array {
    $data = file_get_contents($filename);
    $parts = explode(' ', $data);
    return ['height' => (int)$parts[0], 'width' => (int)$parts[1], 'grosor' => (int)$parts[2], "artist" => $parts[3]];
}

/**
 * Genera el array o espacio en blanco que va en las filas interiores.
 *
 * @param  array $meizures
 * @return array
 */
function getInnerSpace(array $meizures): array {
    $asterisks = array_fill(0, $meizures['grosor'], '*');
    $blankSpaces = array_fill(0, $meizures['width'] - ($meizures['grosor'] * 2), " ");
    return array_merge( $asterisks, $blankSpaces, $asterisks);
}

/**
 * Genera el canvas en forma de array con las medidas pasadas.
 *
 * @param  mixed $meizures
 * @return array
 */
function generateCanvas(array $meizures): array {
    $canvas = [];
    for ($row = 1; $row <= $meizures['height']; $row++) {
        $canvas[] = array_fill(0, $meizures['width'], '*');
    }

    $innerSpaceRow = getInnerSpace($meizures);
    $startInnerIndex = $meizures['grosor'] * 2 > $meizures['height'] ? 1 : $meizures['grosor'];
    $endInnerIndex = $startInnerIndex == 1 ? $meizures['height'] - $meizures['grosor'] : $meizures['height'] - $meizures['grosor'] - 1;
    for ($i = $startInnerIndex; $i <= $endInnerIndex; $i++) {
        $canvas[$i] = $innerSpaceRow;
    }

    return $canvas;
}

/**
 * Muestra en pantalla el canvas y lo escribe en un fichero de salida bajo el nombre del artista pasado.
 *
 * @param  string $sourceFilename
 * @return bool
 */
function paint(String $sourceFilename): void {
    foreach (file($sourceFilename) as $line) {
        $frameData = getFrameData($sourceFilename);
        $canvas = generateCanvas($frameData);
        $targetFilename = trim(strtolower($frameData['artist'])) . ".txt";
        $stream = fopen($targetFilename, "w");
        foreach ($canvas as $row) {
            $output = implode($row) . "\n";
            fwrite($stream, $output);
            echo $output;
        }
    fclose($stream);
    }
}

$sourceFilename = './pintores.txt';
paint($sourceFilename);
?>