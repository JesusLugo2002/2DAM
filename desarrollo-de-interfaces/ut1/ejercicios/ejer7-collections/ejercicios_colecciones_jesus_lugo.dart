import 'dart:collection';

void main() {
  // Ejercicio 1 - List
  print("\nEjercicio 1");
  List<num> marks = [5, 5.6, 7, 9, 3.9];
  marks.add(10);
  print("Primera nota: ${marks.first}");
  print("Última nota: ${marks.last}");
  num sumMarks = marks.reduce((total, mark) => total + mark);
  num avgMark = sumMarks / marks.length;
  print("Nota promedio: $avgMark");

  // Ejercicio 2 - Set
  print("\nEjercicio 2");
  Set<String> emails = {
    "ana@mail.com",
    "luis@mail.com",
    "ana@mail.com",
    "pedro@mail.com",
  };
  print(emails);
  emails.add("salazardemocratico@yahoo.com");
  print(emails.contains("luis@mail.com"));

  // Ejercicio 3 - Map
  print("\nEjercicio 3");
  Map<String, num> prices = {"pan": 1.0, "leche": 1.5, "huevos": 2.0};
  print(prices["leche"]);
  prices["café"] = 3.0;
  prices.forEach((product, price) => print("$product → $price"));

  // Ejercicio 4 - Queue
  print("\nEjercicio 4");
  final queue = Queue();
  queue.addAll(["Lavar platos", "Hacer compra", "Estudiar"]);
  print(queue.removeFirst());
  queue.addLast("Pasear perro");
  print(queue);

  // Ejercicio 5 - SplayTreeSet
  print("\nEjercicio 5");
  final nums = SplayTreeSet<int>();
  nums.addAll([5, 3, 9, 1, 4]);
  print(nums);
  nums.remove(3);
  print(nums);
}
