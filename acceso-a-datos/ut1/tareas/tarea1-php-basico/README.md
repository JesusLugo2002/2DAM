<div align=justify>

# Ejercicios - Conceptos básicos (introducción a PHP)

- [Variables y Condicionales](#variables-y-condicionales)
- [Bucles (for, while, foreach)](#bucles-for-while-foreach)
- [Combinando Condicionales y Bucles](#combinando-condicionales-y-bucles)
- [Construcción de Algorítmicos](#construcción-de-algorítmicos)


## Variables y Condicionales

1. **Mayor de dos números**  
   Pide dos números y muestra cuál es mayor o si son iguales.

```php
<?php
$value1 = readline("Inserte primer valor -> ");
$value2 = readline("Inserte segundo valor -> ");

function compare(int $value1, int $value2) {
    $result = "Ambos valores son los mismos";
    if ($value1 > $value2) {
        $result = "$value1 es mayor que $value2";
    } elseif ($value1 < $value2) {
        $result = "$value1 es menor que $value2";
    }
    echo $result;
}

compare($value1, $value2);
?>
```

**Output**

```
Inserte primer valor -> 5
Inserte segundo valor -> 2
5 es mayor que 2
```

2. **Edad permitida**  
   Pide la edad de una persona y muestra:  
   - `"Eres menor de edad"` si es < 18.  
   - `"Eres mayor de edad"` si es ≥ 18. 

```php
<?php
$age = readline("Inserte su edad -> ");

function checkAge(int $age) {
    $result = "Eres mayor de edad";
    if ($age < 18) {
        $result = "Eres menor de edad";
    }
    echo $result;
}

checkAge($age);
?>
``` 

**Output**
```
Inserte su edad -> 20
Eres mayor de edad
```


3. **Positivo, negativo o cero**  
   Comprueba si un número almacenado en una variable es positivo, negativo o cero.

```php
<?php
$value = rand(-10, 10);

function checkSign(int $value) {
    $result = "El valor es cero.";
    if ($value > 0) {
        $result = "El valor $value es positivo.";
    } elseif ($value < 0) {
        $result = "El valor $value es negativo.";
    }
    echo $result;
}

checkSign($value);
?>
```  

**Output**

```
El valor -2 es negativo.
```

4. **Nota final**  
   Pide la nota de un alumno y muestra:  
   - `"Suspenso"` (< 5), `"Aprobado"` (5–6), `"Notable"` (7–8), `"Sobresaliente"` (9–10).

```php
<?php
$mark = readline("Inserte la nota del estudiante -> ");

function getMarkCategory(int $mark) {
    if ($mark < 5) {
        return "Suspenso";
    }
    if ($mark == 5 || $mark == 6) {
        return "Aprobado";
    }
    if ($mark == 7 || $mark == 8) {
        return "Notable";
    }
    return "Sobresaliente";
}

echo getMarkCategory($mark);
?>
```

**Output**

```
Inserte la nota del estudiante -> 8
Notable
```

---

## Bucles (for, while, foreach)

5. **Contar del 1 al 100**  
   Muestra los números del 1 al 100 en pantalla.

```php
<?php
$maxValue = 100;
for ($i = 1; $i <= $maxValue; $i++) {
    echo "$i\n";
}
?>
```

**Output**

```
1
2
3
4
5
6
7
8
9
...
...
...
90
91
92
93
94
95
96
97
98
99
100
```

6. **Suma acumulada**  
   Calcula la suma de los números del 1 al 50 usando un bucle.  

```php
<?php
function summation(int $maxValue = 50) {
    $result = 0;
    for ($i = 1; $i <= $maxValue; $i++) {
        $result += $i;
    }
    return $result;
}

echo "El resultado de la sumatoria es " . summation();
?>
```

**Output**

```
El resultado de la sumatoria es 1275
```

7. **Tabla de multiplicar**  
   Pide un número y genera su tabla de multiplicar del 1 al 10.  

```php
<?php
$value = readline("Inserta un número para generar una tabla de multiplicar -> ");

function getMultiplicationTable(int $num, int $maxMultiplier = 10) {
    for ($i = 1; $i < $maxMultiplier; $i++) {
        $product = $num * $i;
        echo "$num x $i = $product\n";
    }
}

getMultiplicationTable($value);
?>
```

**Output**

```
Inserta un número para generar una tabla de multiplicar -> 7
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
```

8. **Números pares**  
   Muestra todos los números pares entre 1 y 50.  

```php
<?php
function getEvenNumbers(int $min = 1, int $max = 50) {
    for ($i = $min; $i <= $max; $i++) {
        if ($i % 2 == 0) {
            echo "$i\n";
        }
    }
}

getEvenNumbers();
?>
```

**Output**

```
2
4
6
8
10
...
...
...
40
42
44
46
48
50
```

9. **Cuenta atrás**  
   Haz un bucle que cuente de 10 a 1 y luego muestre `"¡Fin!"`.  

```php
<?php
$initialValue = 10;
for ($i = $initialValue; $i >= 1; $i--) {
    echo "$i\n";
}
echo "¡Fin!";
?>
```

**Output**

```
10
9
8
7
6
5
4
3
2
1
¡Fin!
```

10. **Factorial**  
    Calcula el factorial de un número introducido (ejemplo: `5! = 120`).  

```php
<?php
$value = readline("Inserte el número para calcular su factorial -> ");

function factorial(int $value) {
    $result = 1;
    for ($i = 1; $i <= $value; $i++) {
        $result *= $i;
    }
    return $result;
}

echo "$value! = " . factorial($value);
?>
```

**Output**

´´´
Inserte el número para calcular su factorial -> 5
5! = 120
´´´

---

## Combinando Condicionales y Bucles

11. **Números primos**  
    Escribe un algoritmo que muestre los números primos entre 1 y 50.  

```php
<?php
function isPrime(int $num) {
    if ($num == 0 || $num == 1) {
        return false;
    }
    for ($i = 2; $i < $num; $i++) {
        if ($num % $i == 0) {
            return false;
        }
    }
    return true;
}

function getPrimeNumbers(int $min = 1, int $max = 50) {
    for ($num = $min; $num <= $max; $num++) {
        if (isPrime($num)) {
            echo "$num\n";
        }
    }
}

getPrimeNumbers();
?>
```

12. **Fibonacci**  
    Genera los primeros 20 términos de la secuencia de Fibonacci. 

```php
<?php
$firstTerms = 20;

function fibonnaci(int $num) {
    if ($num <= 1) {
        return 1;
    }
    return fibonnaci($num-1) + fibonnaci($num-2);
}

for ($i = 0; $i < $firstTerms; $i++) {
    echo fibonnaci($i) . "\n";
}
?>
```

**Output**

```
1
1
2
3
5
8
13
21
34
55
89
144
233
377
610
987
1597
2584
4181
6765
```

13. **Múltiplos de un número**  
    Pide un número `n` y muestra sus múltiplos hasta 100.  

```php
<?php
$n = readline("Inserta un número para mostrar sus múltiplos -> ");

function printMultiples(int $value, int $limit = 100) {
    for ($i = 1; $i <= $limit; $i++) {
        $multiple = $value * $i;
        echo "$multiple\n";
    }
}

printMultiples($n);
?>
```

**Output**

```
5
10
15
20
25
...
...
...
480
485
490
495
500
```

14. **Suma de pares e impares**  
    Calcula la suma de los números pares e impares entre 1 y 100 por separado.  

```php
<?php
$limit = 100;
$evenSummation = 0;
$oddSummation = 0;
for ($i = 1; $i <= $limit; $i++) {
    if ($i % 2 == 0) {
        $evenSummation += $i;
    } else {
        $oddSummation += $i;
    }
}
echo "La suma de números pares: $evenSummation\n";
echo "La suma de números impares: $oddSummation\n";
?>
```

**Output**

```
La suma de números pares: 2550
La suma de números impares: 2500
```

15. **Adivinar número**  
    Genera un número aleatorio entre 1 y 20.  
    Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: `"Mayor"` o `"Menor"`.  

```php
<?php
$randomTarget = rand(1, 20);
do {
    $userNumber = readline("Adivina el número que estoy pensando -> ");
    if ($userNumber < $randomTarget) {
        echo "Es mayor\n";
    } else if ($userNumber > $randomTarget) {
        echo "Es menor\n";
    }
} while ($userNumber != $randomTarget);
echo "¡Bien! Es el número $randomTarget!"
?>
```

**Output**

```
Adivina el número que estoy pensando -> 16
Es mayor
Adivina el número que estoy pensando -> 17
¡Bien! Es el número 17!
```

---

## Construcción de Algorítmicos

16. **Número perfecto**  
    Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).  

```php
<?php
$value = readline("Inserta un número para comprobar si es perfecto -> ");
function isPerfectNumber(int $value): bool {
    $divisorsSum = 1;
    for ($i = 2; $i < $value; $i++) {
        if ($value % $i == 0) {
            $divisorsSum += $i;
        }
    }
    return $divisorsSum == $value;
}

if (isPerfectNumber($value)) {
    echo "El número $value ES perfecto.";
} else {
    echo "El número $value NO ES perfecto.";
}
?>
```

**Output**

```
Inserta un número para comprobar si es perfecto -> 24
El número 24 NO ES perfecto.
Inserta un número para comprobar si es perfecto -> 28
El número 28 ES perfecto.
```

17. **Invertir número**  
    Escribe un algoritmo que invierta los dígitos de un número (ejemplo: `123 → 321`).  

```php
<?php
$value = readline("Inserte el número a invertir -> ");
function reverseNumber(int $num): int {
    $reversedNum = strrev(strval($num));
    return (int)$reversedNum;
}
echo $value . " → " . reverseNumber($value);
?>
```

**Output**

```
Inserte el número a invertir -> 123
123 → 321
```

18. **Palíndromo**  
    Comprueba si una palabra almacenada en una variable es palíndroma.  

```php
<?php
function isPalindrome(string $word): bool {
    $loweredWord = strtolower($word);
    $invertedWord = strrev($loweredWord);
    return $loweredWord == $invertedWord;
}

$targetWord = "Anna";
if (isPalindrome($targetWord)) {
    echo "La palabra '$targetWord' ES un palíndromo.";
} else {
    echo "La palabra '$targetWord' NO ES un palíndromo.";
}
?>
```

**Output**

```
La palabra 'Anna' ES un palíndromo.
```

19. **Máximo común divisor (MCD)**  
    Escribe un algoritmo que calcule el MCD de dos números.  

```php
<?php
echo "Calculadora del máximo común divisor\n";
$firstValue = readline("Inserte el primer valor -> ");
$secondValue = readline("Inserte el segundo valor -> ");

function getMCD(int $a, int $b): int {
    $remainder = $a % $b;
    if ($remainder == 0) {
        return $b;
    }
    return getMCD($b, $remainder);
}

echo "El máximo común divisor de $firstValue y $secondValue es " . getMCD($firstValue, $secondValue);
?>
```

**Output**

```
Calculadora del máximo común divisor
Inserte el primer valor -> 18
Inserte el segundo valor -> 12
El máximo común divisor de 18 y 12 es 6
```

20. **Triángulo de asteriscos**  
    Muestra en pantalla un triángulo de altura `n` usando `*`.  
    Ejemplo con `n = 5`:  
    ```
    *
    **
    ***
    ****
    *****
    ```

```php
<?php
$n = readline("Inserte la altura del triángulo resultante -> ");
for ($i = 1; $i <= $n; $i++) {
    echo str_repeat("*", $i) . "\n";
}
?>
```

**Output**

```
Inserte la altura del triángulo resultante -> 10
*
**
***
****
*****
******
*******
********
*********
**********
```

</div>