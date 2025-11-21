import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      home: Homepage(),
    );
  }
}

class Homepage extends StatelessWidget {
  const Homepage({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Widget principal")),
      body: Center(
        child: Column(
          spacing: 20,
          children: [
            Text("Alaska"),
            Text("El Sol se ha ido oficialmente en Alaska, y no volverá a salir hasta el 22 de enero de 2026"),
            Image.asset("assets/alaska.jpg", width: 350,),
            Image.asset("assets/alaska2.jpg", width: 350,),
          ],
        ),
      ),
    );
  }
}
