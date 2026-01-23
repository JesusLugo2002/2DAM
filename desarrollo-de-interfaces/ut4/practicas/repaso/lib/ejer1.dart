import 'package:flutter/material.dart';

void main() {
  runApp(const SemaforoApp());
}

class SemaforoApp extends StatelessWidget {
  const SemaforoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: SemaforoPage(),
    );
  }
}

class SemaforoPage extends StatefulWidget {
  const SemaforoPage({super.key});

  @override
  State<SemaforoPage> createState() => _SemaforoPageState();
}

class _SemaforoPageState extends State<SemaforoPage> {
  String turn = 'red';
  Text subtitle = Text(
    "STOP",
    style: TextStyle(
      color: Colors.red,
      fontWeight: FontWeight.bold,
      fontSize: 24,
    ),
  );

  void nextColor() {
    setState(() {
      switch (turn) {
        case 'red':
          turn = 'yellow';
          subtitle = Text(
            "PRECAUCIÓN",
            style: TextStyle(
              color: Colors.yellow,
              fontWeight: FontWeight.bold,
              fontSize: 24,
            ),
          );
          break;
        case 'yellow':
          turn = 'green';
          subtitle = Text(
            "AVANZA",
            style: TextStyle(
              color: Colors.green,
              fontWeight: FontWeight.bold,
              fontSize: 24,
            ),
          );
          break;
        case 'green':
          turn = 'red';
          subtitle = Text(
            "STOP",
            style: TextStyle(
              color: Colors.red,
              fontWeight: FontWeight.bold,
              fontSize: 24,
            ),
          );
          break;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Semáforo interactivo'), centerTitle: true),
      body: Center(
        child: Column(
          spacing: 20,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.black,
                borderRadius: BorderRadius.circular(18),
              ),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Luz(color: turn == 'red' ? Colors.red : Colors.grey),
                  SizedBox(height: 12),
                  Luz(color: turn == 'yellow' ? Colors.yellow : Colors.grey),
                  SizedBox(height: 12),
                  Luz(color: turn == 'green' ? Colors.green : Colors.grey),
                ],
              ),
            ),
            subtitle,
            ElevatedButton(onPressed: nextColor, child: Text("Cambiar luz")),
          ],
        ),
      ),
    );
  }
}

class Luz extends StatelessWidget {
  final Color color;

  const Luz({super.key, required this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 90,
      height: 90,
      decoration: BoxDecoration(shape: BoxShape.circle, color: color),
    );
  }
}
