<div align=justify>

# Ejercicios

1) Declara variables de tipo `int`, `double` y `num`. Convierte un `int` a `String` y parsea `'3.14'` a `double`.

```dart
void main() {
  int x = 3;
  double y = 1.5;
  num value = x;

  String text_value = x.toString();
  double pi = double.parse('3.14');
}
```

2) Crea un `String` multilínea con tus lenguajes favoritos y muestra su longitud. Usa interpolación para imprimirlos en una sola línea.

```dart
void main() {
  String sequence = '''
    My favourite programming languages are:
    - Python.
    - GDScript.
    - Typescript.
    ''';

  print("The length of the sequence is ${sequence.length} characters.");
  print(sequence.replaceAll("\n", " ").trim());
}
```

3) Dada la lista `[1, 2, 3, 4, 5, 6]`, obtén una nueva lista con los números pares multiplicados por 10.

```dart
void main() {
  List<int> values = [1, 2, 3, 4, 5, 6];
  List<int> multipliedValues = values.map((value) => value * 10).toList();

  print("Initial values: ${values}");
  print("Multiplied values: ${multipliedValues}");
}
```

4) Con un `Set<String>` de tecnologías `{'dart', 'flutter', 'dart', 'firebase'}`, imprime el conjunto resultante y calcula su tamaño. Une con otro set `{'dart', 'grpc'}` y muestra intersección y diferencia.

```dart
void main() {
  Set<String> technologies = {'dart', 'flutter', 'dart', 'firebase'};
  print("The set is ${technologies}");
  print("The length of the set: ${technologies.length}");

  Set<String> anotherTechnologies = {'dart', 'grpc'};

  var union = technologies.union(anotherTechnologies);
  print("The union: ${union}");

  var intersection = technologies.intersection(anotherTechnologies);
  print("The intersection: ${intersection}");

  var difference = technologies.difference(anotherTechnologies);
  print("The difference: ${difference}");
}
```

5) Define un `Map<String, Object>` para un usuario con `id`, `nombre` y `activo`. Agrega la clave `email`, cambia `activo` a `false` y recorre el mapa imprimiendo `clave => valor`.

```dart
void main() {
  Map<String, Object> user = {'id': 1, 'name': 'Duran Duran', 'active': true};

  user['email'] = 'duranalcuadrado@yahoo.com';
  user['active'] = false;

  user.forEach((key, value) => print("${key} => ${value}"));
}
```

6) Crea una función que reciba un `String?` nombre y devuelva `'Hola, anónimo'` si es `null` o vacío; en caso contrario, `'Hola, <nombre>'`. Usa `??` y `trim()`.

```dart
void main() {
  String greet([String? name = null]) {
    String result = name ?? "anonymus";
    return "Hello, ${result}";
  }

  print(greet());
  print(greet('Duran Duran'));
}
```

7) Define `const double iva = 0.21` y una lista de precios. Calcula una nueva lista con el precio final aplicando IVA y redondea a 2 decimales.

```dart
void main() {
  const double iva = 0.21;
  List<double> prices = [1.2, 2.0, 2.5, 3.2];

  double applyIVA(double price) {
    return price + (price * iva);
  }

  List<double> fixedPrices = prices.map((price) => double.parse(applyIVA(price).toStringAsFixed(2))).toList();
  print(fixedPrices);
}
```

8) Declara un `enum Prioridad { baja, media, alta }` y una función que reciba una prioridad y devuelva el tiempo estimado en horas: `baja=8`, `media=4`, `alta=1`.

```dart
enum Priority { low, mid, high }

void main() {
  int getPriorityHours(Priority level) {
    switch (level) {
      case Priority.low:
        return 8;
      case Priority.mid:
        return 4;
      case Priority.high:
        return 1;
    }
  };

  print("Hours for low priority: ${getPriorityHours(Priority.low)}");
  print("Hours for mid priority: ${getPriorityHours(Priority.mid)}");
  print("Hours for high priority: ${getPriorityHours(Priority.high)}");
}
```

</div>