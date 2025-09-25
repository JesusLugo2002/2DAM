<?php
const FILENAME = "files/ranking.txt";

function sortRankings(array $rankings): array {
    $result = [];
    foreach ($rankings as $ranking) {
        $parts = explode(":", $ranking);
        array_push($result, array("name" => $parts[0], "rank" => (int)$parts[1]));
    }
    usort($result, function ($a, $b) {
        return $b["rank"] <=> $a["rank"];
    });
    return $result;
}

function getTopRankings(int $firstTerms = 3): array {
    if (!$rankings = file(FILENAME)) {
        echo "Cannot open " . FILENAME;
        return [];
    }
    $sortedRankings = sortRankings($rankings);
    return array_slice($sortedRankings, 0, $firstTerms);
}

foreach (getTopRankings() as $ranking) {
    echo $ranking["name"] . ": " . $ranking["rank"] . "\n";
}
?>