<?php
file_put_contents("datos.txt", "Hola Mundo desde PHP");
echo file_get_contents("datos.txt");
?>