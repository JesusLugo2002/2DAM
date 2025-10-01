import 'dart:io';

// Clase necesaria para el ejercicio 5
class DivisionByZero implements Exception {
  @override
  String toString() {
    return "🚫 División prohibida";
  }
}

// Clase necesaria para el ejercicio 6
Future<void> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  throw HttpException;
}

void main() async {
  // Ejercicio 1
  print("\nEjercicio 1");
  void divide(int a, int b) {
    if (b == 0) {
      throw Exception();
    }
    print(a / b);
  }

  try {
    divide(10, 0);
  } catch (e) {
    print("ERROR: División por cero.");
  }

  // Ejercicio 2
  print("\nEjercicio 2");
  List<int> values = [1, 2, 3];
  try {
    print(values[5]);
  } on RangeError {
    print("ERROR: Índice fuera de rango");
  }

  // Ejercicio 3
  print("\nEjercicio 3");
  try {
    var numero = int.parse("abc"); // ❌ Esto da FormatException
    print(numero);
  } on FormatException {
    print("ERROR: Formato inválido");
  }

  // Ejercicio 4
  print("\nEjercicio 4");
  void abrirArchivo() {
    print("📂 Archivo abierto");
    throw Exception("Error al leer archivo");
  }

  try {
    abrirArchivo();
  } catch (e) {
    print(e);
  } finally {
    print("📕 Archivo cerrado");
  }

  // Ejercicio 5
  print("\nEjercicio 5");
  void dividir(int a, int b) {
    if (b == 0) {
      throw DivisionByZero;
    }
    print(a / b);
  }

  try {
    dividir(8, 0);
  } catch (e) {
    print(e);
  }

  // Ejercicio 6
  print("\nEjercicio 6");
  try {
    await cargarDatos();
  } catch (e) {
    print("ERROR: No se pudieron cargar los datos");
  }
}
