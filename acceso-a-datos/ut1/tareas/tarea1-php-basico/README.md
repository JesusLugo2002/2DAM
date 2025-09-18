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
Insert first value -> 5
Insert second value -> 2
5 is greater than 2
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
Insert your age -> 20
You are of legal age
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
The value -2 is negative!
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
function factorial(int $value) {
    
}
?>
```

---

## Combinando Condicionales y Bucles

11. **Números primos**  
    Escribe un algoritmo que muestre los números primos entre 1 y 50.  

```php
<?php

?>
```

12. **Fibonacci**  
    Genera los primeros 20 términos de la secuencia de Fibonacci. 

```php
<?php

?>
``` 

13. **Múltiplos de un número**  
    Pide un número `n` y muestra sus múltiplos hasta 100.  

```php
<?php

?>
```

14. **Suma de pares e impares**  
    Calcula la suma de los números pares e impares entre 1 y 100 por separado.  

```php
<?php

?>
```

15. **Adivinar número**  
    Genera un número aleatorio entre 1 y 20.  
    Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: `"Mayor"` o `"Menor"`.  

```php
<?php

?>
```

---

## Construcción de Algorítmicos

16. **Número perfecto**  
    Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).  

```php
<?php

?>
```

17. **Invertir número**  
    Escribe un algoritmo que invierta los dígitos de un número (ejemplo: `123 → 321`).  

```php
<?php

?>
```

18. **Palíndromo**  
    Comprueba si una palabra almacenada en una variable es palíndroma.  

```php
<?php

?>
```

19. **Máximo común divisor (MCD)**  
    Escribe un algoritmo que calcule el MCD de dos números.  

```php
<?php

?>
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

?>
```
</div>