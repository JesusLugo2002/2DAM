import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: NumberCheckerPage(),
    );
  }
}

class NumberCheckerPage extends StatefulWidget {
  const NumberCheckerPage({super.key});

  @override
  State createState() => _NumberCheckerPageState();
}

class _NumberCheckerPageState extends State {
  TextEditingController controller = TextEditingController();
  String input = '';
  String result = '';
  String? error;

  @override
  void initState() {
    super.initState();
    controller.addListener(_validate);
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  void checkNumber() {
    setState(() {
      result = 'Result: ${controller.text}';
    });
  }

  bool isInvalid() {
    return controller.text.contains(RegExp(r'[a-z]|[A-Z]|\s+'));
  }

  void _validate() {
    setState(() {
      error = isInvalid() ? 'Only numbers, no letters and blank spaces' : null;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Comprobar número')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: controller,
              decoration: InputDecoration(
                labelText: 'Introduce un número',
                errorText: error,
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: error == null ? checkNumber : null,
              child: const Text('Comprobar'),
            ),
            const SizedBox(height: 20),
            Text(result),
          ],
        ),
      ),
    );
  }
}
