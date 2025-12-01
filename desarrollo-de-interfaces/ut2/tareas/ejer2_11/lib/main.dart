import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: "Stabilizer", home: Stabilizer());
  }
}

class Stabilizer extends StatefulWidget {
  const Stabilizer({super.key});

  @override
  State<Stabilizer> createState() => _StabilizerState();
}

class _StabilizerState extends State<Stabilizer> {
  double energy = 50;

  void increaseEnergy() {
    if (energy >= 100) return;
    setState(() => energy += 10);
  }

  void reduceEnergy() {
    if (energy <= 0) return;
    setState(() => energy -= 10);
  }

  @override
  Widget build(BuildContext context) {
    Text status = Text("");
    if (energy == 0) {
      status = Text(
        "System collapsed D:",
        style: TextStyle(
          color: Colors.deepOrange,
          fontWeight: FontWeight.bold,
          fontSize: 24,
        ),
      );
    } else if (energy == 100) {
      status = Text(
        "Energy stabilized :D",
        style: TextStyle(
          color: Colors.green,
          fontWeight: FontWeight.bold,
          fontSize: 24,
        ),
      );
    }

    return Scaffold(
      appBar: AppBar(title: const Text('Stabilizer')),

      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          spacing: 25,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Energy: ${energy.toInt()}%',
              style: const TextStyle(fontSize: 22),
            ),
            LinearProgressIndicator(value: energy / 100, minHeight: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ElevatedButton(
                  onPressed: reduceEnergy,
                  child: const Text('-10'),
                ),

                ElevatedButton(
                  onPressed: increaseEnergy,
                  child: const Text('+10'),
                ),
              ],
            ),
            status,
          ],
        ),
      ),
    );
  }
}
