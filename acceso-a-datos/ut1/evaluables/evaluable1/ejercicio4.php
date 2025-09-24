<?php
function getStats(array $values): array {
    $min = min($values);
    $max = max($values);
    $sum = array_sum($values);
    $avg = $sum / count($values);
    return [$min, $max, $sum, $avg];
}

print_r(getStats([10, -3, 7, 0]));
?>