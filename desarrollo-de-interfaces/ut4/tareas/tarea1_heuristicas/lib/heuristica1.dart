import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(home: LoadingExample());
  }
}

class LoadingExample extends StatefulWidget {
  const LoadingExample({super.key});

  @override
  State createState() => _LoadingExampleState();
}

class _LoadingExampleState extends State<LoadingExample> {
  bool isLoading = false;
  String message = "";

  Future loadData() async {
    setState(() {
      isLoading = true;
      message = "";
    });

    await Future.delayed(const Duration(seconds: 3));

    setState(() {
      isLoading = false;
      message = "Datos cargados correctamente";
    });
  }

  @override
  Widget build(BuildContext context) {
return Scaffold(
      appBar: AppBar(title: const Text('Heurística 1 – Estado del sistema')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ElevatedButton(
              onPressed: () => loadData(),
              child: const Text('Cargar datos'),
            ),
            const SizedBox(height: 20),

            // Indicador de estado
            if (isLoading) const CircularProgressIndicator(),

            const SizedBox(height: 20),

            // Mensaje final
            Text(message, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}
