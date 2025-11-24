import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  bool isDark = false;

  void toggleTheme() => setState(() => isDark = !isDark);

  @override
  Widget build(BuildContext context) {
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
      home: Homepage(isDark, toggleTheme)
    );
  }
}

class Homepage extends StatelessWidget {
  final bool isDark;
  final VoidCallback toggleTheme;
  
  const Homepage(this.isDark, this.toggleTheme, {super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(appBar: AppBar(title: const Text('Home Page')),
        body: Center(
          child: ElevatedButton(
            onPressed: toggleTheme,
            child: Text(isDark ? "Cambiar a claro" : "Cambiar a oscuro"),
          ),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: toggleTheme,
          child: Icon(isDark ? Icons.dark_mode : Icons.light_mode),
        ),
      );
  }
}
