import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Color Sequence',
      home: const Homepage(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class Homepage extends StatefulWidget {
  const Homepage({super.key});

  @override
  State<Homepage> createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  final List<MaterialColor> possibleColors = [
    Colors.yellow,
    Colors.red,
    Colors.green,
    Colors.blue,
  ];
  late List<MaterialColor> correctSequence;
  late List<MaterialColor> userSequence;

  bool gameFinished = false;
  bool youWon = true;

  @override
  void initState() {
    super.initState();
    correctSequence = generateColors();
    userSequence = [];
  }

  List<MaterialColor> generateColors({int size = 4}) {
    return List.generate(size, (_) => possibleColors.elementAt(Random().nextInt(possibleColors.length)));
  }

  void addColorToSelection(MaterialColor color) {
    if (userSequence.length == correctSequence.length) return;
    setState(() {
      userSequence.add(color);
    });
  }

  void checkWinner() {
    if (userSequence.length != correctSequence.length) return;
    setState(() => gameFinished = true);
    for (var i = 0; i < userSequence.length; i++) {
      if (userSequence.elementAt(i) != correctSequence.elementAt(i)) {
        setState(() => youWon = false);
        break;
      }
    }
  }

  void resetGame() {
    setState(() {
      correctSequence = generateColors();
      userSequence = [];
      gameFinished = false;
      youWon = true;
    });
  }

  @override
  Widget build(BuildContext context) {
    checkWinner();

    String status = gameFinished
        ? (youWon ? "🎉 Correct sequence!" : "You failed 💀")
        : "Repeat the sequence";

    return Scaffold(
      appBar: AppBar(title: Text("Color Sequence")),
      body: Center(
        child: Column(
          spacing: 25,
          children: <Widget>[
            Text("Remember the sequence"),
            Row(
              spacing: 10,
              mainAxisAlignment: MainAxisAlignment.center,
              children: correctSequence
                  .map((color) => ColorBox(color: color, size: 32))
                  .toList(),
            ),
            Text("Push the colors in order"),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              spacing: 20,
              children: possibleColors
                  .map(
                    (color) => ColorButton(
                      color: color,
                      size: 64,
                      onPressed: () => addColorToSelection(color),
                    ),
                  )
                  .toList(),
            ),

            Text(
              status,
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            ElevatedButton(onPressed: resetGame, child: Text("New sequence")),
          ],
        ),
      ),
    );
  }
}

class ColorBox extends StatelessWidget {
  final MaterialColor color;
  final double size;

  const ColorBox({required this.color, required this.size, super.key});

  @override
  Widget build(BuildContext context) {
    return Container(width: size, height: size, color: color);
  }
}

class ColorButton extends StatelessWidget {
  final MaterialColor color;
  final double size;
  final VoidCallback onPressed;

  const ColorButton({
    required this.color,
    required this.size,
    required this.onPressed,
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTapDown: (_) => onPressed(),
      child: ColorBox(color: color, size: size),
    );
  }
}
