void main() {
  void presentation(String name, [int? age]) {
    print("Hola, soy ${name} y mi edad es ${age ?? "0"}");
  }

  presentation("Jesús");
  presentation("Jesús", 23);
}
