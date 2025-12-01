import 'dart:async';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: MainPage());
  }
}

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() {
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  int time = 10;
  late Timer timer;

  @override
  void initState() {
    super.initState();
    timer = Timer.periodic(
      Duration(seconds: 1),
      (timer) => setState(() => time -= 1),
    );
  }

  @override
  void dispose() {
    timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    if (time == 0) {
      dispose();
    }

    return Scaffold(
      appBar: AppBar(title: Text("Cuenta atrás con Timer")),
      body: Center(
        child: Text(
          time.toString(),
          style: TextStyle(fontSize: 64, fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
