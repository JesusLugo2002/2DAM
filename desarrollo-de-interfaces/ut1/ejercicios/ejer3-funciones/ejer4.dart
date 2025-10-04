void main() {
  num getSum(List values) {
    num sum = 0;
    for (var value in values) {
      sum += value;
    }
    return sum;
  }

  List<num> values = [3, 5, 2];
  num resultado = getSum(values);
  print("La suma de los números ${values} es ${resultado}.");
}
