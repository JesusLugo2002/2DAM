import 'package:flutter/material.dart';

void main() => runApp(const ComidaApp());

class ComidaApp extends StatelessWidget {
  const ComidaApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Rutas sencillas',
      initialRoute: '/',
      routes: {
        '/': (_) => const InicioPage(),
        '/pizza': (_) => const PizzaPage(),
        '/brocoli': (_) => const BrocoliPage(),
      },
    );
  }
}

class InicioPage extends StatelessWidget {
  const InicioPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('¿Qué prefieres?')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              'Practica navegación por rutas',
              style: TextStyle(fontSize: 18),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, "/pizza"),
              child: const Text('🍕 Pizza'),
            ),
            const SizedBox(height: 12),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, "/brocoli"),
              child: const Text('🥦 Brócoli'),
            ),
          ],
        ),
      ),
    );
  }
}

class PizzaPage extends StatelessWidget {
  const PizzaPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pizza')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('🍕', style: TextStyle(fontSize: 80)),
            const SizedBox(height: 10),
            const Text('La pizza nunca falla', style: TextStyle(fontSize: 20)),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: const Text('Volver'),
            ),
          ],
        ),
      ),
    );
  }
}

class BrocoliPage extends StatelessWidget {
  const BrocoliPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Brócoli')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('🥦', style: TextStyle(fontSize: 80)),
            const SizedBox(height: 10),
            const Text('Modo vida sana ON', style: TextStyle(fontSize: 20)),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: const Text('Volver'),
            ),
          ],
        ),
      ),
    );
  }
}
