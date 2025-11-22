import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: Homepage());
  }
}

class Homepage extends StatelessWidget {
  const Homepage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Widget personalizado"),),
      body: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          spacing: 10,
          children: [
            MyCard(Icons.work, "Trabajo", "Gestiona tus tareas y proyectos diarios"),
            MyCard(Icons.health_and_safety, "Salud", "Consulta información relacionada con tu bienestar"),
            MyCard(Icons.home, "Hogar", "Organiza todos los aspectos de tu vivienda"),
          ],
        ),
      ),
    );
  }
}

class MyCard extends StatelessWidget {
  final IconData icon;
  final String title;
  final String description;
  
  const MyCard(this.icon, this.title, this.description, {super.key});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Row(
        children: [
          Icon(icon),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(title),
              Text(description),
            ],
          ),
        ],
      ),
    );
  }
}
