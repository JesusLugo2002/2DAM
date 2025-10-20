import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return (MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Combinando widgets personalizados"),
          centerTitle: true,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            HeaderWidget("Panel principal", "Ejemplo con widgets propios"),
            SizedBox(height: 20),
            InfoCard("Información útil", Icons.info),
            InfoCard("Ajustes del sistema", Icons.settings),
            InfoCard("Usuario activo", Icons.person),
          ],
        ),
      ),
    ));
  }
}

class HeaderWidget extends StatelessWidget {
  final String title;
  final String subtitle;

  const HeaderWidget(this.title, this.subtitle, {super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          title,
          style: TextStyle(
            fontSize: 26,
            fontWeight: FontWeight.bold,
            color: Colors.blue,
          ),
        ),
        SizedBox(height: 10),
        Text(subtitle, style: TextStyle(fontSize: 18, color: Colors.grey[700])),
      ],
    );
  }
}

class InfoCard extends StatelessWidget {
  final String title;
  final IconData icon;

  const InfoCard(this.title, this.icon, {super.key});

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 4,
      margin: EdgeInsets.all(16),
      child: Padding(
        padding: EdgeInsetsGeometry.all(12),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(icon, color: Colors.blue, size: 40),
            SizedBox(width: 10),
            Text(
              title,
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
            ),
          ],
        ),
      ),
    );
  }
}
