import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: ErrorHelpExample(),
    );
  }
}

class ErrorHelpExample extends StatefulWidget {
  const ErrorHelpExample({super.key});

  @override
  State createState() => _ErrorHelpExampleState();
}

class _ErrorHelpExampleState extends State {
  String inputText = "";
  String ?errorText;

  void updateText(text) {
    setState(() {
      inputText = text;
    });
  }

  void checkText() {
    setState(() {
      errorText = int.tryParse(inputText) == null
          ? "Error: introduce un numero"
          : null;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Heurística 9 – Ayuda con errores')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              onChanged: (text) => updateText(text),
              decoration: InputDecoration(
                labelText: "Introduce un número entero",
                errorText: errorText,
              ),
            ),
            ElevatedButton(onPressed: checkText, child: Text("Comprobar")),
          ],
        ),
      ),
    );
  }
}
