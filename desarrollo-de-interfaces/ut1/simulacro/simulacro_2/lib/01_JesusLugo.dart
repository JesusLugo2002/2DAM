import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: Scaffold(
        appBar: AppBar(title: Text("Widget principal")),
        body: MainPage(),
      ),
    );
  }
}

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    const title = Text(
      "Misión Apolo 8 - 1968",
      style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold),
      textAlign: TextAlign.center,
    );
    const subtitle = Text(
      "Earthrise: la Tierra vista desde la Luna",
      style: TextStyle(fontSize: 18),
      textAlign: TextAlign.center,
    );
    const body = Text(
      "El 24 de diciembre de 1968, mientras orbitaban la Luna, los astronautas del Apolo 8 presenciaron algo que nadie había visto jamás: la Tierra elevándose sobre el horizonte lunar. En ese instante capturaron la icónica fotografía Earthrise, que transformó para siempre la forma en que la humanidad se veía a sí misma en el cosmos.",
      style: TextStyle(fontSize: 16),
      textAlign: TextAlign.justify,
    );
    Image image = Image.asset("assets/earthrise.webp", width: 350);

    return Container(
      padding: EdgeInsets.all(20),
      child: Column(spacing: 15, children: [title, subtitle, body, image]),
    );
  }
}
