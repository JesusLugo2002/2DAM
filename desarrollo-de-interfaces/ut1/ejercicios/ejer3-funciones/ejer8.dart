import 'dart:math';

void main() {
  List<num> getSquares(List<num> values) {
    List<num> result = [];
    values.forEach((value) => result.add(pow(value, 2)));
    return result;
  }

  List<num> values = [2, 4, 7];
  print(
    "Para una lista con valores ${values}, sus cuadrados son: ${getSquares(values)}",
  );
}
