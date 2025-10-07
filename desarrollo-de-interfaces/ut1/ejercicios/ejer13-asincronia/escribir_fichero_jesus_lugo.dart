import 'dart:io';

Future<void> main() async {
  final file = File('registro.txt');
  final fecha = DateTime.now();

  file.writeAsString(fecha.toString() + "\n", mode: FileMode.append).then((v) {
    print("Registro guardado correctamente.");
  });
}
