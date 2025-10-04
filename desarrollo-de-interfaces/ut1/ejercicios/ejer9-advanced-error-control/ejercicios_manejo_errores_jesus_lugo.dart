// Clase necesaria para el ejercicio 2
import 'dart:math';

class ElementoNoEnteroException implements Exception {
  final String message;

  const ElementoNoEnteroException(this.message);

  @override
  String toString() {
    return message;
  }
}

void main() async {
  // Ejercicio 1
  print("\nEjercicio 1");
  int toIntSeguro(String valor) {
    try {
      int result = int.parse(valor);
      return result;
    } catch (e) {
      throw FormatException("Valor inválido: $valor");
    }
  }

  List<String> values = ["123", "abc", "45"];
  values.forEach((value) {
    try {
      print(toIntSeguro(value));
    } catch (e) {
      print(e);
    }
  });

  // Ejercicio 2
  print("\nEjercicio 2");
  int sumarLista(List<dynamic> datos) {
    int result = 0;
    for (var dato in datos) {
      if (dato is! int) {
        throw ElementoNoEnteroException("ERROR: Elemento no entero -> $dato");
      }
      result += dato;
    }
    return result;
  }

  List<dynamic> datos = [10, 20, "hola", 5];
  try {
    print(sumarLista(datos));
  } catch (e) {
    print(e);
  }

  // Ejercicio 3
  print("\nEjercicio 3");
  int multiplicar(int? a, int? b) {
    if (a == null || b == null) {
      throw ArgumentError();
    }
    if (a < 0 || b < 0) {
      throw Exception("Elemento negativo");
    }
    return a * b;
  }

  try {
    print(multiplicar(2, -3));
  } catch (e) {
    print(e);
  }

  // Ejercicio 4
  print("\nEjercicio 4");
  void conectar() {
    int connectionTries = 3;
    int failedTries = 0;
    for (var i = 0; i < connectionTries; i++) {
      try {
        if (Random().nextInt(10) > 5) {
          throw Exception("Fallo de red");
        }
      } catch (e) {
        failedTries++;
        if (failedTries == 3) {
          throw Exception("Conexión fallida tras 3 intentos");
        }
      }
    }
    print("Conexión exitosa!");
  }

  try {
    conectar();
  } catch (e) {
    print(e);
  }

  // Ejercicio 5
  print("\nEjercicio 5");
  Future<String> cargarArchivo(String nombre) async {
    if (nombre == "config.txt") {
      return "Archivo cargado";
    }
    throw Exception("Archivo no encontrado");
  }

  print(await cargarArchivo("datos.txt").catchError((e) {
    print(e);
    return "";
  }));
}
