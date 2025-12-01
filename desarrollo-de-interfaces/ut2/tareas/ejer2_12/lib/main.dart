import 'dart:async';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Flutter Demo', home: ReactorOverloadPage());
  }
}

class ReactorOverloadPage extends StatefulWidget {
  const ReactorOverloadPage({super.key});

  @override
  State<ReactorOverloadPage> createState() => _ReactorOverloadPageState();
}

class _ReactorOverloadPageState extends State<ReactorOverloadPage> {
  double energy = 0;
  int seconds = 0;
  late Timer timer;

  @override
  void initState() {
    super.initState();
    timer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        energy += 10;
        seconds++;
        if (energy == 100) {
          dispose();
        }
      });
    });
  }

  void freeEnergy() {
    if (energy <= 0) return;
    setState(() => energy -= 10);
  }

  @override
  void dispose() {
    timer.cancel();
    super.dispose();
  }

  Text getStatus() {
    Text status = Text("");
    if (energy == 100) {
      status = Text("Reactor exploded! :C", style: TextStyle(color: Colors.redAccent, fontWeight: FontWeight.bold, fontSize: 24),);
    }
    return status;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Reactor Overload')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 10,
          children: [
            Text(
              'Level: ${energy.toInt()}%',
              style: const TextStyle(fontSize: 22),
            ),
            LinearProgressIndicator(value: energy / 100, minHeight: 20),
            Text('Time: $seconds s'),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: freeEnergy,
              child: const Text('Reduce energy'),
            ),
            const SizedBox(height: 30),
            getStatus()
          ],
        ),
      ),
    );
  }
}
