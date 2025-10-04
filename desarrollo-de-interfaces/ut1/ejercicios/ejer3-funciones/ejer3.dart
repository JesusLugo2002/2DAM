void main() {
  num getMax(List values) {
    num maxValue = values[0];
    for (var value in values) {
      if (value > maxValue) {
        maxValue = value;
      }
    }
    return maxValue;
  }

  List<num> values = [3, 5, 2];
  num resultado = getMax(values);
  print("El número más grande de ${values} es ${resultado}.");
}
