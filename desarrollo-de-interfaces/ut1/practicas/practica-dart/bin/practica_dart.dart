import "dart:io";

void main() {
  print("Hello world!");
  String? name = stdin.readLineSync();
  print("$name, how are you?");
}
