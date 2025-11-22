import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Homepage(),
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFF2C3E50)),
        textTheme: TextTheme(
          headlineMedium: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          bodyLarge: TextStyle(fontSize: 18)
        ),
        iconTheme: IconThemeData(size: 50)
      ),
    );
  }
}

class Homepage extends StatelessWidget {
  const Homepage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Perfil minimalista"),),
      body: Column(
        spacing: 10,
        children: [
          Icon(Icons.person),
          Text("PERFIL DE USUARIO", style: Theme.of(context).textTheme.headlineMedium,),
          TextField(
            decoration: InputDecoration(label: Text("Nombre completo")),
          ),
          Text("Indica tu nivel de experiencia", style: Theme.of(context).textTheme.bodyLarge,),
          Slider(value: 0.5, onChanged: (double value) {}),
          ElevatedButton(onPressed: () {}, child: Text("Guardar perfil")),
        ],
      ),
    );
  }
}
