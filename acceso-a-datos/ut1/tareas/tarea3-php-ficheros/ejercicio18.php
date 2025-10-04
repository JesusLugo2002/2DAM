<?php
const FILENAME = "files/tweets.txt";

function addTweet(): bool {
    if (!$fp = fopen(FILENAME, "a")) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    $content = readline("Twittea! -> ");
    $datetime = date_format(date_create(), "Y-m-d H:i");
    fwrite($fp, "[$datetime] $content\n");
    return fclose($fp);
}

function getLastTweets(int $limit = 5): array|bool {
    if (!$tweets = file(FILENAME)) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    return array_slice($tweets, -$limit);
}

addTweet();
foreach (getLastTweets() as $tweet) {
    echo $tweet;
}
?>