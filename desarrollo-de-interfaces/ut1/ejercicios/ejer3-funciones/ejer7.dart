void main() {
  void showUpperCaseNames(List<String> names) {
    names.forEach((name) => print(name.toUpperCase()));
  }

  List<String> names = ["cindy", "nero", "santiago", "norrea"];
  print("Tras pasar los nombres ${names} por la función, da como resultado:");
  showUpperCaseNames(names);
}
