import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (BuildContext context) => ThemeNotifier(),
      child: const MyApp(),
    ),
  );
}

class ThemeNotifier extends ChangeNotifier {
  bool _isDark = false;
  bool get isDark => _isDark;

  void toggleTheme() {
    _isDark = !_isDark;
    notifyListeners();
  }
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    bool isDark = context.watch<ThemeNotifier>().isDark;

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tema claro/oscuro',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Color(0xFF0455BF),
          brightness: Brightness.light,
        ),
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Color(0xFF0455BF),
          brightness: Brightness.dark,
        ),
      ),
      themeMode: isDark ? ThemeMode.dark : ThemeMode.light,
      initialRoute: "/",
      routes: {
        "/": (_) => const Homepage(),
        "/pantalla2": (_) => const Pantalla2(),
      },
    );
  }
}

class Homepage extends StatelessWidget {
  const Homepage({super.key});

  @override
  Widget build(BuildContext context) {
    bool isDark = context.watch<ThemeNotifier>().isDark;
    VoidCallback toggleTheme = context.read<ThemeNotifier>().toggleTheme;

    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla A')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 10,
          children: [
            ElevatedButton(
              onPressed: toggleTheme,
              child: Text(isDark ? "Cambiar a claro" : "Cambiar a oscuro"),
            ),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, "/pantalla2"),
              child: Text("Cambiar a Pantalla B"),
            ),
          ],
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: toggleTheme,
        child: Icon(isDark ? Icons.dark_mode : Icons.light_mode),
      ),
    );
  }
}

class Pantalla2 extends StatelessWidget {
  const Pantalla2({super.key});

  @override
  Widget build(BuildContext context) {
    bool isDark = context.watch<ThemeNotifier>().isDark;
    VoidCallback toggleTheme = context.read<ThemeNotifier>().toggleTheme;

    return Scaffold(
      appBar: AppBar(title: Text("Pantalla B")),
      body: Center(
        child: ElevatedButton(
          onPressed: toggleTheme,
          child: Text(isDark ? "Cambiar a claro" : "Cambiar a oscuro"),
        ),
      ),
    );
  }
}
