void main() async {
  // Ejercicio 1
  print("\nEjercicio 1");
  Future<String> holaFuture() async {
    await Future.delayed(new Duration(seconds: 2));
    return "Hola desde el futuro";
  }

  print(await holaFuture());

  // Ejercicio 2
  print("\nEjercicio 2");
  Future<int> getFiveNumber() {
    return Future.value(5);
  }

  await getFiveNumber()
      .then((value) => value * 2)
      .then((value) => value + 10)
      .then((value) => print(value));

  // Ejercicio 3
  print("\nEjercicio 3");
  Future<void> loadData() {
    String token = "xyz";
    if (token != "abc") {
      return Future.error(Exception("Error en la carga"));
    }
    return Future.delayed(
      new Duration(seconds: 1),
      () => print("Carga exitosa"),
    );
  }

  await loadData().catchError((err) {
    print("❌ Error atrapado: $err");
  });

  // Ejercicio 4
  print("\nEjercicio 4");
  Future<int> divide(int a, int b) {
    if (b == 0) {
      return Future.error(Exception("No puedes dividir entre cero"));
    }
    int result = (a / b).round();
    return Future.value(result);
  }

  try {
    print(await divide(10, 0));
  } catch (e) {
    print(e);
  }

  // Ejercicio 5
  print("\nEjercicio 5");
  Future<String> tarea1() async {
    await Future.delayed(new Duration(seconds: 1));
    return "Tarea 1";
  }

  Future<String> tarea2() async {
    await Future.delayed(new Duration(seconds: 2));
    return "Tarea 2";
  }

  Future<String> tarea3() async {
    await Future.delayed(new Duration(seconds: 3));
    return "Tarea 3";
  }

  List<Future<String>> tareas = [tarea1(), tarea2(), tarea3()];
  await Future.wait(tareas).then((results) {
    results.forEach((result) => print(result));
  });

  // Ejercicio 6
  print("\nEjercicio 6");
  Future<String> slowGet() async {
    await Future.delayed(new Duration(seconds: 2));
    return "Lenta";
  }

  Future<String> fastGet() async {
    await Future.delayed(new Duration(seconds: 1));
    return "Rápida";
  }

  await Future.any([slowGet(), fastGet()]).then((result) => print(result));

  // Ejercicio 7
  print("\nEjercicio 7");
  Future<void> cargarArchivo() async {
    bool errorWillHappen = true;
    await Future.delayed(new Duration(seconds: 1));
    if (errorWillHappen) {
      return Future.error("Archivo no encontrado");
    }
    print("Archivo cargado");
  }

  try {
    await cargarArchivo();
  } catch (e) {
    print(e);
  } finally {
    print("Proceso terminado");
  }

  // Ejercicio 8
  print("\nEjercicio 8");
  List<String> urls = ["url1", "url2", "url3"];
  for (var url in urls) {
    await Future.delayed(new Duration(seconds: 1));
    print("Descargada $url");
  }
}
