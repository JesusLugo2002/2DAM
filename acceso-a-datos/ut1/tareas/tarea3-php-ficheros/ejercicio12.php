<?php
const FILENAME = "files/ranking.txt";

function getTopRankings(): array {
    if (!$rankings = file(FILENAME)) {
        echo "Cannot open " . FILENAME;
        return [];
    }
    echo var_dump($rankings);
    return $rankings;
}

getTopRankings();
?>