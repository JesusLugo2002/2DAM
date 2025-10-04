import 'dart:async';
import 'dart:isolate';

void main() async {
  // Ejercicio 1
  print("\nEjercicio 1");
  Stream<int> temperatureSensor() async* {
    List<int> values = [20, 21, 22, 23, 24];
    for (var value in values) {
      await Future.delayed(new Duration(milliseconds: 500));
      if (value > 22) {
        print("⚠️ ¡Temperatura alta!");
      }
      yield value;
    }
    print("✅ Sensor apagado");
  }

  await for (var temperature in temperatureSensor()) {
    print("Temperatura: $temperature");
  }

  // Ejercicio 2
  print("\nEjercicio 2");
  final chat = StreamController.broadcast();
  chat.stream.listen((msg) => print("Primer oyente: $msg"));
  chat.stream.listen((msg) => print("Segundo oyente: $msg"));
  chat.add("Hola");
  chat.add("¿Cómo estás?");
  chat.add("Adiós");
  await chat.close();

  // Ejercicio 3
  print("\nEjercicio 3");
  Stream<int> getRange([int min = 1, int max = 5]) async* {
    for (var i = min; i < max; i++) {
      yield i;
    }
  }

  Stream<int> nums = getRange().where((n) => n % 2 == 0).map((n) => n * 10);
  await for (var num in nums) {
    print(num);
  }

  // Ejercicio 4
  print("\nEjercicio 4");
  final controller = StreamController<String>();
  controller.stream.listen(
    (data) {
      print("Recibido $data");
    },
    onError: (error) {
      print("❌ Error detectado: $error");
    },
    onDone: () {
      print("Stream cerrado");
    },
  );
  controller.add("dato1");
  controller.add("dato2");
  controller.addError("fallo de red");
  controller.add("dato3");
  await controller.close();

  // Ejercicio 5
  print("\nEjercicio 5");
  final stream = Stream.periodic(
    new Duration(seconds: 1),
    (i) => "tick ${i + 1}",
  );

  final completer = Completer();
  int tickCounter = 0;
  late StreamSubscription subscription;
  subscription = stream.listen((data) {
    print(data);
    tickCounter++;
    if (tickCounter >= 3) {
      subscription.cancel().then((_) {
        completer.complete();
      });
    }
  });
  await completer.future;

  // Ejercicio 6
  print("\nEjercicio 6");
  void bigSum(SendPort sendPort) {
    int result = 0;
    for (var i = 0; i < 1000000; i++) {
      result += i;
    }
    sendPort.send(result);
  }

  final receiver = ReceivePort();

  // Ejercicio 7
  print("\nEjercicio 7");

  // Ejercicio 8
  print("\nEjercicio 8");

  // Ejercicio 9
  print("\nEjercicio 9");

  // Ejercicio 10
  print("\nEjercicio 10");
}
