<div align=justify>

# Ejercicios

1. Declara una variable `edad` como `int` y otra `altura` como `double`. Imprime ambos valores en una sola frase.

```dart
void main() {
  int age = 22;
  double height = 1.70;
  
  print('I\'m ${age} years old and my height is ${height} meters.');
}
```

2. Sabiendo que el área de un círculo es `A=πr2`, escribe en la web DartPad un programa que calcule el área de un círculo. Como no podemos pedir un input al usuario, inicializa `r` a un valor cualquiera. 

```dart
void main() {
  const PI = 3.14;
  int radius = 5;
  double result = PI * radius * radius;

  print("The area for a circle with radius ${radius} is ${result}");
}
```

3. Declara una variable `String? apellido = null;`. Imprime `apellido` usando `??` para que muestre `"Sin apellido"` si es `null`. Ahora usa `!` y comprueba qué ocurre.

```dart
void main() {
  String? lastName = null;

  print(lastName ?? "Without last name");
}
// Output: Without last name

void main() {
  String? lastName = null;

  print(lastName! ?? "Without last name");
}
// Output: Error: Unexpected null value.
```

4. Declara `String? saludo = "hola";`. Convierte saludo a mayúsculas de tres formas distintas:
    - Con !
    - Con ?? y un valor alternativo
    - Con un if (saludo != null)

```dart
void main() {
  String? greet = "hello";

  print(greet!.toUpperCase());

  greet = null;
  print(greet ?? "HELLO");

  greet = "hello";
  if (greet != null) {
    print(greet.toUpperCase());
  }
}
```

5. Crea una `List<String>` con tres frutas. Añade una fruta repetida y muestra la lista. Convierte esa lista a un `Set` y muestra el resultado.

```dart
void main() {
  List<String> fruits = ["banana", "apple", "grapes"];

  fruits.add("banana");
  print(fruits);

  Set<String> uniqueFruits = fruits.toSet();
  print(uniqueFruits);
}
```

6. Crea un `Map<String, int>` con `nombres` como claves y `edades` como valores.
    - Muestra todas las claves.
    - Muestra todos los valores.
    - Accede a la `edad` de un `nombre` concreto y muéstrala.

```dart
void main() {
  Map<String, int> ages = {"Jesus": 22, "Miguel": 20, "Kai": 28};

  print("Names: ${ages.keys}");
  print("Ages: ${ages.values}");
  print("Jesus is ${ages["Jesus"]} years old.");
}
```

7. Declara un enum llamado `Estado` con valores: `pendiente`, `enProceso`, `completado`.
    - Crea una variable `tarea` con el valor `Estado.enProceso`.
    - Imprime el `nombre` y el índice de tarea.
    - Cambia el estado a `completado` y muéstralo.

```dart
enum Status { pending, inProgress, completed }

void main() {
  var task = Status.inProgress;
  print("Task name: ${task.name}");
  print("Task index: ${task.index}");
  task = Status.completed;
  print("Task is ${task.name}.");
}
```

8. Convierte un número entero en cadena (`int → String`) y luego vuelve a entero (`String → int`). Convierte una cadena `"3.14"` a `double` y suma 1. Convierte una lista `[1,2,3,2]` en un `Set` y después vuelve a lista.

```dart
void main() {
  dynamic num = 4;
  if (num is int) {
    print("num ${num} is a int type.");
  }

  num = num.toString();
  if (num is String) {
    print("num ${num} now is a String type.");
  }

  num = int.parse(num);
  if (num is int) {
    print("num ${num} is, again, a int type.");
  }

  String piInStr = "3.14";
  double piInDouble = double.parse(piInStr);
  piInDouble += 1;
  print(piInDouble);

  List<int> values = [1, 2, 3, 2];
  if (values is List) {
    print("values ${values} is a List type.");
  }

  Set<int> uniqueValues = values.toSet();
  if (uniqueValues is Set) {
    print("uniqueValues ${uniqueValues} is a Set type.");
  }

  List<int> reducedValues = uniqueValues.toList();
  if (reducedValues is List) {
    print("reducedValues ${reducedValues} is now a List type.");
  }
}
```

</div>