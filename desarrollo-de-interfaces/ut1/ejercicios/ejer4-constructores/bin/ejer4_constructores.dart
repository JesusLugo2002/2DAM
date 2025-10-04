// Ejercicio 1
class Movie {
  String title;
  int year;

  Movie(this.title, this.year);

  void showData() => print('$title from year $year');
}

// Ejercicio 2
class Task {
  String description;
  bool status;

  Task(this.description, this.status);
  Task.uncompleted(this.description) : status = false;

  void showStatus() => print("Task: $description - Completed: $status");
}

// Ejercicio 3
class Circle {
  num area;
  num radius;

  Circle(this.radius) : area = 3.14 * radius * radius;

  void getArea() => print("The area is $area");
}

// Ejercicio 4
class Message {
  String text;
  String priority;

  Message({required this.text, this.priority = "Normal"});

  void showPriority() => print("This message have $priority priority");
}

// Ejercicio 5
class Coin {
  final String code, symbol;
  const Coin(this.code, this.symbol);

  void showInfo() => print("$code - $symbol");
}

// Ejercicio 6
class Student {
  String name;
  int mark;

  Student(this.name, this.mark);
  Student.aproved(String name) : this(name, 5);

  void showData() => print("The student $name have a mark of $mark");
}

// Ejercicio 7
class Session {
  static final Session _sessionInstance = Session._internal();

  factory Session() {
    return _sessionInstance;
  }

  Session._internal();
}

void main(List<String> arguments) {
  // Ejercicio 1
  print("\nEjercicio 1");
  final movie = Movie("El Faro", 2019);
  movie.showData();

  // Ejercicio 2
  print("\nEjercicio 2");
  final completedTask = Task("Hacer la tarea de PHP", true);
  final pendingTask = Task.uncompleted("Hacer la tarea de Dart");
  completedTask.showStatus();
  pendingTask.showStatus();

  // Ejercicio 3
  print("\nEjercicio 3");
  final circle = Circle(3);
  circle.getArea();

  // Ejercicio 4
  print("\nEjercicio 4");
  final normalMessage = Message(text: "Quiero una pizza");
  final highMessage = Message(
    text: "Ayuda, necesito comprar unas pastillas urgente",
    priority: "High",
  );
  normalMessage.showPriority();
  highMessage.showPriority();

  // Ejercicio 5
  print("\nEjercicio 5");
  final firstCoin = const Coin("USD", "\$");
  final secondCoin = const Coin("USD", "\$");
  print(identical(firstCoin, secondCoin));

  // Ejercicio 6
  print("\nEjercicio 6");
  final firstStudent = Student("Jesús", 7);
  final aprovedStudent = Student.aproved("Susan");
  firstStudent.showData();
  aprovedStudent.showData();

  // Ejercicio 7
  print("\nEjercicio 7");
  final session = Session();
  final newSession = Session();
  print(identical(session, newSession));
}
