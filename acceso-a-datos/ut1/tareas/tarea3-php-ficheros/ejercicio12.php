<?php
function createSongList(String $filename, array $songs): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open $filename";
        return false;
    }
    foreach ($songs as $song) {
        fwrite($fp, "$song\n");
    }
    return fclose($fp);
}

function getRandomLine(String $filename): String {
    $songs = file($filename);
    $randIndex = array_rand($songs);
    return $songs[$randIndex];
}

$filename = "files/canciones.txt";
$songs = ["RAWFEAR", "My Man on Willpower", "Altars of Apostasy"];
createSongList($filename, $songs);
echo getRandomLine($filename);
?>