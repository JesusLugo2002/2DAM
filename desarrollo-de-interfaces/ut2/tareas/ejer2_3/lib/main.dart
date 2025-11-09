import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(ChangeNotifierProvider(create: (_) => ContadorProvider(), child: MiApp()));

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Navegacion',
      routes: {
        "/": (context) => PantallaA(),
        "/pantallaB": (context) => PantallaB(),
      },
      initialRoute: "/",
    );
  }
}

class ContadorProvider extends ChangeNotifier {
  int _counter = 0;
  int get counter => _counter;

  void increase() {
    _counter++;
    notifyListeners();
  }

  void decrease() {
    _counter--;
    notifyListeners();
  }

  void reset() {
    _counter = 0;
    notifyListeners();
  }
}

class PantallaA extends StatefulWidget {
  const PantallaA({super.key});

  @override
  State<StatefulWidget> createState() {
    return _PantallaAState();
  }

}

class _PantallaAState extends State<PantallaA> {
  @override
  Widget build(BuildContext context) {
    ContadorProvider count = context.watch<ContadorProvider>();
    ContadorProvider counter = context.read<ContadorProvider>();

    return Scaffold(
      appBar: AppBar(title: Text("Pantalla A")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Contador: ${count.counter}", style: TextStyle(fontSize: 20)),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                IconButton(onPressed: () {
                  counter.decrease();
                }, icon: Icon(Icons.remove)),
                IconButton(onPressed: () {
                  counter.increase();
                }, icon: Icon(Icons.add))
              ],
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, "/pantallaB");
              },
              child: Text("Ir a pantalla B"),
            ),
          ],
        ),
      ),
    );
  }
}

class PantallaB extends StatefulWidget {
  const PantallaB({super.key});

  @override
  State<StatefulWidget> createState() {
    return _PantallaBState();
  }

}

class _PantallaBState extends State<PantallaB> {

  @override
  Widget build(BuildContext context) {
    ContadorProvider count = context.watch<ContadorProvider>();
    ContadorProvider counter = context.read<ContadorProvider>();

    return Scaffold(
      appBar: AppBar(title: Text("Pantalla B")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 20,
          children: [
            Text("Valor del contador: ${count.counter}", style: TextStyle(fontSize: 20, color: Colors.blueAccent),),
            ElevatedButton(
              onPressed: () {
                counter.reset();
              },
              child: Text("Reiniciar contador"),
            ),
          ],
        ),
      ),
    );
  }
}
