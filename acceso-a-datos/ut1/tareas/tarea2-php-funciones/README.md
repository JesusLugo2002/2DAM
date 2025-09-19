<div align=justify>

# Ejercicios - Introducción a Php, uso de funciones

- [Número capicúa (palíndromo numérico)](#número-capicúa-palíndromo-numérico)
- [Escalera de asteriscos](#escalera-de-asteriscos)
- [Suma de dígitos](#suma-de-dígitos)
- [Número secreto (múltiplos de 3 o 5)](#número-secreto-múltiplos-de-3-o-5)
- [Secuencia de Collatz](#secuencia-de-collatz)

## Número capicúa (palíndromo numérico)

Implementa una función __esCapicua(int $n): bool__ que determine si un número entero positivo es capicúa.

- Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

> Ejemplo: `12321` → `true`

**Respuesta**

```php
<?php
$value = (int)readline("Inserte el número para comprobar si es capicua -> ");
function isCapicua(int $num): bool {
    $reversedNum = strrev(strval($num));
    return $reversedNum == $num;
}

echo "$value → " . (isCapicua($value) ? "true" : "false");
?>
```

**Output**

```
Inserte el número para comprobar si es capicua -> 12321
12321 → true
```

## Escalera de asteriscos

Implementa una función __montañaAsteriscos(int $n, $m): void__ que imprima una escalera de asteriscos de altura `N`y el tamaño M.

- La primera fila contiene 1 asterisco, la segunda 2, y así hasta `N`, `M` veces.

> Ejemplo con entrada `4,2`:

```text
*.     *
**.   **
***  ***
********
```

**Respuesta**

```php
<?php

?>
```

## Suma de dígitos

Implementa una función __sumaDigitos(int $n): int__ que calcule la suma de los dígitos de un número entero positivo.

- Descompón el número en dígitos y súmalos.

> Ejemplo: `2025` → `9` (2+0+2+5)

**Respuesta**

```php
<?php
$value = (int)readline("Inserte el número para sumar sus dígitos -> ");
function sumDigits(int $num): int {
    $result = 0;
    $digits = str_split(strval($num));
    foreach($digits as $value) {
        $result += (int)$value;
    }
    return $result;
}

echo "$value → " . sumDigits($value);
?>
```

**Output**

```
Inserte el número para sumar sus dígitos -> 2025
2025 → 9
```

## Número secreto (múltiplos de 3 o 5)

Implementa una función __multiplosTresOCinco(int $n): array__ que devuelva todos los múltiplos de 3 o 5 menores que `N`.

- Además, calcula la suma de dichos múltiplos.

> Ejemplo con entrada `10`:

```code
3, 5, 6, 9
Suma = 23
```

**Respuesta**

```php
<?php
$limit = (int)readline("Inserte el número limite para obtener los múltiplos -> ");
function getMultiples(int $limit, array $multipliers = [3, 5]) {
    $multiplies = [];
    for ($num = 1; $num < $limit; $num++) {
        foreach($multipliers as $multiplier) {
            if ($num % $multiplier == 0) {
                array_push($multiplies, $num);
                break;
            }
        }
    }
    return $multiplies;
}

$multiplies = getMultiples($limit);
echo implode(", ", $multiplies) . "\n";
echo "Suma = " . array_sum($multiplies);
?>
```

**Output**

```
Inserte el número limite para obtener los múltiplos -> 25
3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24
Suma = 143
```

## Secuencia de Collatz

Implementa una función __secuenciaCollatz(int $n): array__ que genere la secuencia de Collatz a partir de un entero positivo.

- Si el número es par → dividir entre 2.  
- Si es impar → multiplicar por 3 y sumar 1.  
- Repetir hasta llegar a 1.

> Ejemplo con entrada `6`:

```code
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

**Respuesta**

```php
<?php
$num = (int)readline("Inserte el número para la secuencia de Collatz -> ");
function collatzSequence(int $num): array {
    $sequence = [];
    while($num != 1) {
        $sequence[] = $num;
        if ($num % 2 == 0) {
            $num /= 2;
        } else {
            $num = $num * 3 + 1;
        }
    }
    $sequence[] = 1;
    return $sequence;
}

echo implode(" → ", collatzSequence($num));
?>
```

**Output**

```
Inserte el número para la secuencia de Collatz -> 6
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

</div>