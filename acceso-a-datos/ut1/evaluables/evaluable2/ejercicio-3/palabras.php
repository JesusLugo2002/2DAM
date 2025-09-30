<?php
/**
 * Devuelve una lista con todas las palabras de un fichero.
 *
 * @param  string $filename
 * @return array
 */
function getWords(String $filename): array {
    $result = [];
    $words = file($filename);
    foreach ($words as $word) {
        $result[] = trim($word);
    }
    return $result;
}

/**
 * Devuelve la palabra más larga.
 *
 * @param  mixed $words
 * @return string
 */
function getLongestWord(array $words): string {
    $result = $words[0];
    foreach ($words as $word) {
        if (strlen($word) > strlen($result)) {
            $result = $word;
        }
    }
    return $result;
}

/**
 * Devuelve la palabra más corta.
 *
 * @param  array $words
 * @return string
 */
function getShortestWord(array $words): string {
    $result = $words[0];
    foreach ($words as $word) {
        if (strlen($word) < strlen($result)) {
            $result = $word;
        }
    }
    return $result;
}


/**
 * Genera los resultados y escribe en el fichero objetivo.
 *
 * @param  string $targetFilename
 * @param  array $words
 * @return bool
 */
function generateResults(String $targetFilename, array $words): bool {
    $stream = fopen($targetFilename, "w");
    fwrite($stream, "total " . count($words) . "\n");
    fwrite($stream, "únicas " . count(array_unique($words)) . "\n");
    fwrite($stream, "+larga " . getLongestWord($words) . "\n");
    fwrite($stream, "+corta: " . getShortestWord($words) . "\n\n");
    fwrite($stream, "orden:\n");
    sort($words);
    foreach ($words as $word) {
        fwrite($stream, "$word\n");
    }
    fwrite($stream, "\nnumero palabras:\n");
    foreach (array_count_values($words) as $word => $frequency) {
        fwrite($stream, "$word: $frequency\n");
    }

    return fclose($stream);
}

$sourceFilename = "./palabras.txt";
$targetFilename = "./resultados.txt";
$words = getWords($sourceFilename);
generateResults($targetFilename, $words);
?>