import 'dart:io';

void main() async {
  Future<String> readFile(String filepath) {
    final file = File(filepath);

    try {
      return file.readAsString();
    } catch (e) {
      return Future.error(e);
    }
  }

  print(await readFile("datos.txt"));
}
