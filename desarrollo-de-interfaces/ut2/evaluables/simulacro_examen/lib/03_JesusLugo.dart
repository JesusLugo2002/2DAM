import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    final base = ColorScheme.fromSeed(seedColor: Colors.teal);
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      theme: ThemeData(
        colorScheme: base,
        iconTheme: IconThemeData(size: 40, color: base.primary),
      ),
      home: MyMainWidget(),
    );
  }
}

// 🔹 Clase principal
class MyMainWidget extends StatelessWidget {
  const MyMainWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Tema dependiente de ColorScheme')),
      body: Center(child: Icon(Icons.school)),
    );
  }
}
