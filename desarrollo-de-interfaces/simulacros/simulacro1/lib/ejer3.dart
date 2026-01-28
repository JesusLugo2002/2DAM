import 'package:flutter/material.dart';

void main() {
  runApp(const BombillaApp());
}

class BombillaApp extends StatelessWidget {
  const BombillaApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: BombillaPage(),
    );
  }
}

class BombillaPage extends StatefulWidget {
  const BombillaPage({super.key});

  @override
  State createState() => _BombillaPageState();
}

class _BombillaPageState extends State {
  bool encendida = false;

  void toggle() {
    setState(() {
      encendida = !encendida;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Animación implícita: Bombilla')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            AnimatedOpacity(
              duration: Duration(milliseconds: 300),
              opacity: encendida ? 1.0 : 0.25,
              child: AnimatedScale(
                scale: encendida ? 2.0 : 1.0,
                duration: Duration(milliseconds: 300),
                child: Text("💡"),
              ),
            ),

            const SizedBox(height: 18),

            Text(encendida ? "ENCENDIDA" : "APAGADA"),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: toggle,
        child: const Icon(Icons.power_settings_new),
      ),
    );
  }
}
