void main() {
  void greet([String? lastName]) {
    print("Hola ${lastName ?? ""}.");
  }

  greet();
  greet("Lugo");
}
