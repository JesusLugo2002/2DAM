<?php
const SOURCE_FILENAME = "files/texto.txt";
const TARGET_FILENAME = "files/estadisticas.csv";

function getWords(): array {
    $text = strtolower(file_get_contents(SOURCE_FILENAME));
    preg_match_all("/\p{L}+/u", $text, $words);
    return $words[0];
}

function generateResults(): void {
    if (!$fp = fopen(TARGET_FILENAME, "w")) {
        echo "Cannot open " . TARGET_FILENAME;
        return;
    }

    $words = getWords();
    $ocurrencies = array_count_values($words);

    fwrite($fp, "palabra,frequencia\n");
    foreach ($ocurrencies as $word => $frequency) {
        fwrite($fp, "$word,$frequency\n");
    }
    fclose($fp);
}

generateResults();

?>