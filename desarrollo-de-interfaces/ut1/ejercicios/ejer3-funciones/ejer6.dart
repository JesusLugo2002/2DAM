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
