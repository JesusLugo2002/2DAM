<?php
$json = file_get_contents("files/datos.json");
$data = json_decode($json);
foreach ($data as $person) {
    echo "$person->name tiene $person->age años.\n";
}
?>