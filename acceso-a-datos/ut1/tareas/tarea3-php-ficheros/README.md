# Ejercicios de ficheros - PHP

### 1) Hola fichero (crear y leer)

**Enunciado:** Crea un fichero `datos.txt` con el texto *"Hola Mundo desde PHP"* y, a continuación, léelo y muestra su contenido por pantalla.  
**Funciones/Comandos sugeridos:** `file_put_contents`, `file_get_contents`  

**Ejemplo de fichero generado:**

```code
datos.txt
Hola Mundo desde PHP
```

**Solución**

```php
<?php
$filename = "files/datos.txt";
file_put_contents($filename, "Hola Mundo desde PHP");
echo file_get_contents($filename);
?>
```

---

### 2) Guardar números en un fichero

**Enunciado:** Almacena en `numeros.txt` los números del 1 al 10 (cada número en una línea). Luego léelo y muestra todos los números.  
**Funciones sugeridas:** `fopen`, `fwrite`, `fclose`, `file`  

**Ejemplo de fichero generado:**

```code
numeros.txt
1
2
3
...
10
```

**Solución**

```php
<?php
function generateRange(string $filename, int $limit): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open file";
        return false;
    }
    for ($i = 1; $i <= $limit; $i++) {
        fwrite($fp, "$i\n");
    }   
    return fclose($fp);
}

$filename = "files/numeros.txt";
generateRange($filename, 10);
echo file_get_contents($filename);
?>
```

---

### 3) Contar palabras en un fichero

**Enunciado:** Escribe un texto en `texto.txt`, luego haz que tu programa cuente cuántas palabras contiene ese archivo.  
**Funciones sugeridas:** `file_get_contents`, `str_word_count`  

**Ejemplo de fichero generado:**

```code
texto.txt
PHP es muy divertido y potente.
```

**Solución**

```php
<?php
function countWords(String $filename): int {
    return str_word_count(file_get_contents($filename));
}

$filename = "files/texto.txt";
file_put_contents($filename, "PHP es muy divertido y potente");
echo "El archivo $filename tiene " . countWords($filename) . " palabras.";
?>
```

---

### 4) Escribir y leer array en fichero

**Enunciado:** Guarda un array de nombres en `nombres.txt` (uno por línea). Después, léelo y muéstralos en lista numerada.  
**Funciones sugeridas:** `fopen`, `fwrite`, `fgets`  

**Ejemplo de fichero generado:**

```code
nombres.txt
Ana
Luis
Marta
Carlos
Julia
```

**Solución**

```php
<?php
function createNameList(String $filename, array $names): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open $filename";
        return false;
    }
    foreach ($names as $name) {
        fwrite($fp, $name . "\n");
    }
    return fclose($fp);
}

function showNameList(String $filename): bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename";
        return false;
    }
    while ($line = fgets($fp)) {
        echo $line;
    }
    return fclose($fp);
}

$names = ["Ana", "Luis", "Marta", "Carlos", "Julia"];
$filename = "files/nombres.txt";
createNameList($filename, $names);
showNameList($filename);
?>
```

---

### 5) Copiar contenido de un fichero a otro

**Enunciado:** Copia el contenido de `origen.txt` en un archivo `copia.txt`.  
**Funciones sugeridas:** `copy`, `file_get_contents`, `file_put_contents`  

**Ejemplo de fichero inicial:**

```code
origen.txt
Este es el archivo original.
```

**Ejemplo de fichero resultante:**

```code
copia.txt
Este es el archivo original.
```

**Solución**:

```php
<?php
$sourceFilename = "files/origen.txt";
$targetFilename = "files/copia.txt";

file_put_contents($sourceFilename, "Este es el archivo original.");
echo "$sourceFilename\n";
echo file_get_contents($sourceFilename) . "\n";
copy($sourceFilename, $targetFilename);
echo "$targetFilename\n";
echo file_get_contents($targetFilename) . "\n";
?>
```

---

### 6) Invertir el contenido de un fichero

**Enunciado:** Lee `frase.txt`, invierte el texto y guarda el resultado en `frase_invertida.txt`.  
**Funciones sugeridas:** `file_get_contents`, `strrev`, `file_put_contents`  

**Ejemplo de fichero inicial:**

```code
frase.txt
Hola PHP
```

**Ejemplo de fichero resultante:**

```code
frase_invertida.txt
PHP aloH
```

**Solución**

```php
<?php
$phrase = file_get_contents("files/frase.txt");
echo "$phrase\n";
$invertedPhrase = strrev($phrase);
file_put_contents("files/frase_invertida.txt", $invertedPhrase);
echo file_get_contents("files/frase_invertida.txt") . "\n";
?>
```

---

### 7) Calcular suma desde fichero

**Enunciado:** Guarda números separados por comas en `datos_numericos.txt`. Léelos y calcula su suma.  
**Funciones sugeridas:** `file_get_contents`, `explode`, `array_sum`  

**Ejemplo de fichero:**

```code
datos_numericos.txt
10,20,30,40
```

**Solución**

```php
<?php
$values = explode(",", file_get_contents("files/datos_numericos.txt"));
$sum = array_sum($values);
echo "La suma de " . implode(" + ", $values) . " es igual a $sum"; 
?>
```

---

### 8) Crear fichero de multiplicaciones

**Enunciado:** Genera la tabla del 5 y guárdala en `tabla5.txt`. Luego muéstrala.  
**Funciones sugeridas:** `fopen`, `fwrite`, `file`  

**Ejemplo de fichero:**

```code
tabla5.txt
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
```

**Solución**

```php
<?php
function generateMultiplicationTable(String $filename, int $multiplier): bool {
    if (!$fp = fopen($filename, "w")) {
        echo "Cannot open $filename.";
        return false;
    }
    for ($i = 1; $i <= $multiplier; $i++) {
        fwrite($fp, "$multiplier x $i = " . $multiplier * $i . "\n");
    }
    return fclose($fp);
}

function showMultiplicationTable(String $filename): bool {
    if (!$fp = fopen($filename, "r")) {
        echo "Cannot open $filename.";
        return false;
    }
    foreach (file($filename) as $row) {
        echo $row;
    }
    return fclose($fp);
}

$filename = "files/tabla5.txt";
generateMultiplicationTable($filename, 5);
showMultiplicationTable($filename);
?>
```

---

### 9) Registrar entradas de usuario

**Enunciado:** Guarda los nombres recibidos en un formulario dentro de `usuarios.txt` (cada nombre en una línea). Luego muéstralos.  
**Funciones sugeridas:** `fopen`, `fwrite`, `file`  

**Ejemplo de fichero:**

```code
usuarios.txt
Ana
Pedro
Lucía
```

---

### 10) Leer JSON desde fichero

**Enunciado:** Crea `datos.json` con información de personas (nombre y edad). Haz que el programa lo lea y muestre los datos.  
**Funciones sugeridas:** `file_get_contents`, `json_decode`  

**Ejemplo de fichero:**

```code
datos.json
[
  {"nombre": "Ana", "edad": 25},
  {"nombre": "Luis", "edad": 30}
]
```

**Solución**

```php
<?php
$json = file_get_contents("files/datos.json");
$data = json_decode($json);
foreach ($data as $person) {
    echo "$person->name tiene $person->age años.\n";
}
?>
```

---

### 11) Diario personal secreto

**Enunciado:** Guarda entradas con fecha y hora en `diario.txt`. Luego muéstralas todas.  

**Ejemplo de fichero:**

```code
diario.txt
[2025-09-24 10:00] Hoy aprendí PHP con ficheros 😄
[2025-09-24 12:00] Almorcé pizza mientras programaba.
```

**Solución**

```php
<?php
const FILENAME = "files/diario.txt";
function addLog(String $content): bool {
    if (!$fp = fopen(FILENAME, "a")) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    $datetime = date_format(date_create(), "Y-m-d H:i");
    fwrite($fp, "[$datetime] $content \n");
    return fclose($fp);
}

function printLogs(): bool {
    if (!$fp = fopen(FILENAME, "r")) {
        echo "Cannot open " . FILENAME;
        return false;
    }
    while ($line = fgets($fp)) {
        echo $line;
    }
    return fclose($fp);
}

addLog("Probando, probando, 1, 2, 3");
printLogs();
?>
```

---

### 12) Ranking de videojuegos

**Enunciado:** Guarda juegos con puntuaciones en `ranking.txt`, ordénalos y muestra el top 3.  

**Ejemplo de fichero:**

```code
ranking.txt
Zelda: 10
Mario: 9
Sonic: 8
```

**Solución**

```php
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
```

---

### 13) Canción aleatoria

**Enunciado:** Guarda títulos en `canciones.txt` y muestra uno al azar.  

**Ejemplo de fichero:**

```code
canciones.txt
Hysteria
Bohemian Rhapsody
Africa
```

**Solución**

```php
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
```

---

### 14) Generador de excusas divertidas

**Enunciado:** Lee excusas desde `excusas.txt` y muestra una aleatoria.  

**Ejemplo de fichero:**

```code
excusas.txt
Mi perro se comió la tarea.
El Wi-Fi decidió tomarse el día libre.
Me abdujeron los marcianos.
```

**Solución**

```php
<?php
function getRandomLine(String $filename): String {
    $results = file($filename);
    $randIndex = array_rand($results);
    return $results[$randIndex];
}
$filename = "files/excusas.txt";
echo getRandomLine($filename);
?>
```

---

### 15) Lista de chistes (rotativos)

**Enunciado:** Muestra un chiste distinto en cada ejecución desde `chistes.txt`.  

**Ejemplo de fichero:**

```code
chistes.txt
¿Sabes cuál es el colmo de un programador? Tener mala RAM-oria.
Ayer vi un bit triste… estaba des-bit-ido.
Yo no sudo, compilo.
```

**Solución**

```php

```

---

### 16) Adivina la palabra

**Enunciado:** Elige una palabra de `palabras.txt` y muestra solo 2 letras, el usuario debe adivinarla.  

**Ejemplo de fichero:**

```code
palabras.txt
manzana
platano
cereza
```

---

### 17) Generador de nombres para superhéroes

**Enunciado:** Combina palabras de `adjetivos.txt` y `animales.txt`.  

**Ejemplo de ficheros:**

```code
adjetivos.txt
Increíble
Rápido
Misterioso
```

```code
animales.txt
Tigre
Águila
Lobo
```

---

### 18) Encuesta de comidas favoritas

**Enunciado:** Guarda respuestas de usuarios en `comidas.txt` y genera ranking.  

**Ejemplo de fichero:**

```code
comidas.txt
pizza
sushi
pizza
pasta
```

---

### 19) Simulador de tweets

**Enunciado:** Guarda tweets en `tweets.txt` con fecha y hora, muestra los últimos 5.  

**Ejemplo de fichero:**

```code
tweets.txt
[2025-09-24 09:30] Aprendiendo PHP con ejercicios divertidos #php
[2025-09-24 10:00] Otro día más programando 🚀
```

---

### 20) Historias locas (Mad Libs)

**Enunciado:** Reemplaza placeholders en `plantilla.txt` con palabras aleatorias de otros ficheros.  

**Ejemplo de ficheros:**

```code
plantilla.txt
Un [animal] viajó a [lugar] para comer [comida].
```

```code
animales.txt
gato
dragón
perro
```

```code
lugares.txt
la Luna
Tokio
la playa
```

```code
comidas.txt
tacos
ramen
helado
```
