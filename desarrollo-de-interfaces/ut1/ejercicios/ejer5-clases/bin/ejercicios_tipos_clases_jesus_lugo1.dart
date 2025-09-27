// Ejercicio 1
class Temperature {
  num celsius;

  Temperature(this.celsius);

  num get fahrenheit => celsius * 9 / 5 + 32;

  void showData() {
    print("Temperature in celsius -> $celsius | in fahrenheit -> $fahrenheit");
  }
}

// Ejercicio 2
class Password {
  String? _value;

  set value(String newPassword) {
    if (newPassword.length < 8) {
      throw ArgumentError(
        "Password not have valid length. Minimun 8 characters.",
      );
    }
    _value = newPassword;
  }

  bool authenticate(String password) {
    return password == _value;
  }
}

// Ejercicio 3
class Employee {
  String name;

  Employee(this.name);

  void work() {}
}

class Programmer extends Employee {
  Programmer(super.name);

  @override
  void work() {
    print("I'm programming in Dart");
  }
}

// Ejercicio 4
abstract class MusicalInstrument {
  void play();
}

class Guitar extends MusicalInstrument {
  @override
  void play() => print("Chraam chram chraaam");
}

class Piano extends MusicalInstrument {
  @override
  void play() => print("Plin plin plon");
}

// Ejercicio 5
class Exportable {
  void export() => print("Exporting file...");
}

class PDFDocument implements Exportable {
  @override
  void export() => print("Exporting PDF document...");
}

class PNGImage implements Exportable {
  @override
  void export() => print("Exporting PNG image...");
}

// Ejercicio 6
mixin Rechargable {
  void recharge() => print("Recargando...");
}

class Phone with Rechargable {
  String brand;

  Phone(this.brand);

  void showBrand() => print("Phone brand $brand");
}

class Flashlight with Rechargable {
  String color;

  Flashlight(this.color);

  void printColor() => print("The flashlight color is $color");
}

// Ejercicio 7
class RGBColor {
  final int r;
  final int g;
  final int b;

  const RGBColor(this.r, this.g, this.b);

  void showColorCode() => print("Color: $r, $g, $b");
}

void main() {
  // Ejercicio 1
  print("\nEjercicio 1");
  final temperatureHot = Temperature(50);
  final temperatureNormal = Temperature(25);
  final temperatureFreeze = Temperature(-3);
  temperatureHot.showData();
  temperatureNormal.showData();
  temperatureFreeze.showData();

  // Ejercicio 2
  print("\nEjercicio 2");
  final myPassword = Password();
  try {
    myPassword.value = "1234";
  } catch (error) {
    print(error);
  }

  // Ejercicio 3
  print("\nEjercicio 3");
  final dartProgrammer = Programmer("Jesús");
  dartProgrammer.work();

  // Ejercicio 4
  print("\nEjercicio 4");
  final myGuitar = Guitar();
  final myPiano = Piano();
  myGuitar.play();
  myPiano.play();

  // Ejercicio 5
  print("\nEjercicio 5");
  final genericExportable = Exportable();
  final myImage = PNGImage();
  final myPDF = PDFDocument();
  List<Exportable> files = [genericExportable, myImage, myPDF];
  for (var file in files) {
    file.export();
  }

  // Ejercicio 6
  print("\nEjercicio 6");
  final samsungMobile = Phone("Samsung");
  final blueFlashlight = Flashlight("blue");
  samsungMobile.recharge();
  blueFlashlight.recharge();

  // Ejercicio 7
  print("\nEjercicio 7");
  final yellow = const RGBColor(211, 245, 39);
  final otherYellow = const RGBColor(211, 245, 39);
  print(identical(yellow, otherYellow));
}
