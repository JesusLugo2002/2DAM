import 'package:flutter/material.dart';

void main() {
  runApp(const RutasApp());
}

class RutasApp extends StatelessWidget {
  const RutasApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      initialRoute: "/",
      routes: {
        '/': (context) => InicioPage(),
        '/perfil': (context) => PerfilPage(),
        '/ajustes': (context) => AjustesPage(),
      },
    );
  }
}

class InicioPage extends StatelessWidget {
  const InicioPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Inicio')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          spacing: 10,
          children: [
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, "/perfil"),
              child: Text("Ir a Perfil"),
            ),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, "/ajustes"),
              child: Text("Ir a Ajustes"),
            ),
          ],
        ),
      ),
    );
  }
}

class PerfilPage extends StatelessWidget {
  const PerfilPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Perfil")),
      body: Center(
        child: Column(
          spacing: 10,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Pantalla de perfil"),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Volver"),
            ),
          ],
        ),
      ),
    );
  }
}

class AjustesPage extends StatelessWidget {
  const AjustesPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Ajustes")),
      body: Center(
        child: Column(
          spacing: 10,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Pantalla de ajustes"),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Volver"),
            ),
          ],
        ),
      ),
    );
  }
}
