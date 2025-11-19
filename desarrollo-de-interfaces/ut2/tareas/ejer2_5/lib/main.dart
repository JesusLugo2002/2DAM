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
  @override
  Widget build(BuildContext context) {
    bool _isDark = false;

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tema claro/oscuro',
      theme: ThemeData(colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFF0455BF), brightness: Brightness.light)),
      darkTheme: ThemeData(colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFF0455BF), brightness: Brightness.dark)),
      home: Scaffold(
        appBar: AppBar(title: const Text('Home Page')),
        body: Center(
          child: ElevatedButton(onPressed: () {}, child: Text('Botón')),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {setState(() {
            _isDark = true;
          });},
          child: Icon(Icons.light_mode),
        ),
      ),
    );
  }
}
   