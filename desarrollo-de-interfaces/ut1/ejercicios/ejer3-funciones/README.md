<div align=justify>

# Ejercicios de Dart - Uso de funciones

## Listado

1. Crea una función que calcule el área de un rectángulo a partir de su base y altura, y la muestre en consola.

```dart
void main() {
  num getRectArea(num base, num height) {
    return base * height;
  }

  num base = 5;
  num altura = 10;
  num resultado = getRectArea(base, altura);

  print(
    "El área para un rectángulo con base ${base} y altura ${altura} es ${resultado}",
  );
}
```

2. Haz una función que muestre un saludo en consola. El saludo debe poder llevar opcionalmente un apellido.

```dart
void main() {
  void greet([String? lastName]) {
    print("Hola ${lastName ?? ""}.");
  }

  greet();
  greet("Lugo");
}
```

3. Define una función que devuelva el mayor de tres números enteros.

```dart
void main() {
  num getMax(List values) {
    num maxValue = values[0];
    for (var value in values) {
      if (value > maxValue) {
        maxValue = value;
      }
    }
    return maxValue;
  }

  List<num> values = [3, 5, 2];
  num resultado = getMax(values);
  print("El número más grande de ${values} es ${resultado}.");
}
```

4. Crea una función que reciba una lista de números y devuelva la suma de todos ellos.

```dart
void main() {
  num getSum(List values) {
    num sum = 0;
    for (var value in values) {
      sum += value;
    }
    return sum;
  }

  List<num> values = [3, 5, 2];
  num resultado = getSum(values);
  print("La suma de los números ${values} es ${resultado}.");
}
```

5. Escribe una función que muestre en consola un mensaje de presentación con un nombre obligatorio y una edad opcional (si no se da edad, usa 0 por defecto).

```dart
void main() {
  void presentation(String name, [int? age]) {
    print("Hola, soy ${name} y mi edad es ${age ?? "0"}");
  }

  presentation("Jesús");
  presentation("Jesús", 23);
}
```

6. Implementa una función operar que reciba dos números y otra función que defina la operación. Haz que se pueda usar con suma, resta, multiplicación y división.

```dart
import 'dart:io';

void main() {
  String? getOperationType() {
    print("Elija el tipo de operación");
    print("1. Suma");
    print("2. Resta");
    print("3. Multiplicación");
    print("4. División");
    return stdin.readLineSync();
  }

  void operate() {
    print("Inserte el primer valor");
    num value1 = num.parse(stdin.readLineSync() ?? "0");
    print("Inserte el segundo valor");
    num value2 = num.parse(stdin.readLineSync() ?? "0");

    switch (getOperationType()) {
      case "1":
        print("La suma de $value1 + $value2 es ${value1 + value2}");
        break;
      case "2":
        print("La resta de $value1 - $value2 es ${value1 - value2}");
        break;
      case "3":
        print("La multiplicación de $value1 x $value2 es ${value1 * value2}");
        break;
      case "4":
        print("La división de $value1 / $value2 es ${value1 / value2}");
        break;
      default:
        break;
    }
  }

  operate();
}
```

7. Dada una lista de nombres, usa una función anónima dentro de forEach para mostrar cada nombre en mayúsculas.

```dart
void main() {
  List<String> getUppercaseNames(List<String> names) {
    List<String> result = [];
    for (String name in names) {
      result.add(name.toUpperCase());
    }
    return result;
  }

  List<String> names = ["cindy", "nero", "santiago", "norrea"];
  print(
    "Tras pasar los nombres ${names} por la función, da como resultado ${getUppercaseNames(names)}",
  );
}
```

8. Escribe una función que genere una lista con los cuadrados de los primeros n números enteros. Usa una función flecha (=>).

9.  Crea una función que devuelva otra función (closure). La función devuelta debe multiplicar por un factor fijo el número que reciba.
Ejemplo:

```dart
var porTres = multiplicador(3);
print(porTres(5)); // 15
```

10. Simula el comportamiento de un botón:
Declara una función onPressed que recibe un callback sin parámetros y lo ejecuta.
Llama a esa función pasándole una función anónima que imprima en consola "Botón pulsado".


</div>