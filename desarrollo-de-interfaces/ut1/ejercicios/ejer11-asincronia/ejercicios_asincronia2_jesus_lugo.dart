import 'dart:async';

void main() async {
  // Ejercicio 1
  print("\nEjercicio 1");
  Stream<int> temperatureSensor() async* {
    List<int> values = [20, 21, 22, 23, 24];
    for (var value in values) {
      await Future.delayed(new Duration(milliseconds: 500));
      if (value > 22) {
        print("⚠️ ¡Temperatura alta!");
      }
      yield value;
    }
    print("✅ Sensor apagado");
  }

  await for (var temperature in temperatureSensor()) {
    print("Temperatura: $temperature");
  }

  // Ejercicio 2
  print("\nEjercicio 2");

  // Ejercicio 3
  print("\nEjercicio 3");

  // Ejercicio 4
  print("\nEjercicio 4");

  // Ejercicio 5
  print("\nEjercicio 5");

  // Ejercicio 6
  print("\nEjercicio 6");

  // Ejercicio 7
  print("\nEjercicio 7");

  // Ejercicio 8
  print("\nEjercicio 8");

  // Ejercicio 9
  print("\nEjercicio 9");

  // Ejercicio 10
  print("\nEjercicio 10");
}
