<?php
const SOURCE_FILENAME = "files/ops.csv";
const TARGET_FILENAME = "files/resultado.csv";


function getFileData(): array|bool {
    if (!$file = file(SOURCE_FILENAME)) {
        echo "Cannot open " . SOURCE_FILENAME;
        return false;
    }
    return array_slice($file, 1);
}

function getOperationResult(String $line): int|String {
    $parts = explode(",", trim($line));
    switch ($parts[2]) {
        case 'suma':
            return (int)$parts[0] + (int)$parts[1];
        case 'resta':
            return (int)$parts[0] - (int)$parts[1];
        case 'producto':
            return (int)$parts[0] * (int)$parts[1];
        case 'division':
            if ($parts[1] == 0) {
                return "ERROR";
            }
            return (int)$parts[0] / (int)$parts[1];
        default:
            return "ERROR_NOT_VALID_OPERATION";
    }
}

function generateResults() {
    if (!$fp = fopen(TARGET_FILENAME, "w")) {
        echo "Cannot open " . TARGET_FILENAME;
        return;
    }
    fwrite($fp, "z1,z2,op,resultado\n");
    $data = getFileData();
    foreach ($data as $line) {
        $result = getOperationResult($line);
        $output = trim($line) . ",$result\n";
        fwrite($fp, $output);
    }
    fclose($fp);
}

generateResults();
?>