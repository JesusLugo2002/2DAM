import 'dart:async';
import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Jumper Game",
      home: GameView(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class GameController {
  final double canvasWidth;
  final double canvasHeight;
  final Random random = Random();

  GameController({required this.canvasWidth, required this.canvasHeight});

  int points = 0;
  int time = 15;

  late double xPos = random.nextDouble() * canvasWidth;
  late double yPos = random.nextDouble() * canvasHeight;

  bool get timeFinished => time == 0;
  bool get youWon => points >= 10;

  void moveButton() {
    points++;
    xPos = random.nextDouble() * canvasWidth;
    yPos = random.nextDouble() * canvasHeight;
  }

  void reduceTime() {
    if (time > 0) {
      time--;
    }
  }
}

class GameView extends StatefulWidget {
  const GameView({super.key});

  @override
  State<GameView> createState() => _GameViewState();
}

class _GameViewState extends State<GameView> {
  final GameController controller = GameController(
    canvasWidth: 900,
    canvasHeight: 500,
  );
  late Timer timer;

  @override
  void initState() {
    super.initState();
    timer = Timer.periodic(
      Duration(seconds: 1),
      (timer) => setState(() => controller.reduceTime()),
    );
  }

  @override
  void dispose() {
    timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    String endMessage = "";
    if (controller.youWon) {
      endMessage = "You won! :D";
      dispose();
    } else if (controller.timeFinished) {
      endMessage = "You lost! :(";
      dispose();
    }

    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          spacing: 10,
          children: [
            Text("Push the button 10 times until the timer stop!", style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              spacing: 20,
              children: [
                Text("Time: ${controller.time}"),
                Text("Score: ${controller.points}"),
              ],
            ),
            Container(
              width: controller.canvasWidth,
              height: controller.canvasHeight,
              decoration: BoxDecoration(
                border: BoxBorder.all(),
                borderRadius: BorderRadius.circular(20),
              ),
              child: Stack(
                clipBehavior: Clip.none,
                children: [
                  Positioned(
                    left: controller.xPos,
                    top: controller.yPos,
                    child: ElevatedButton(
                      onPressed: () => setState(() => controller.moveButton()),
                      child: Text("Push me!"),
                    ),
                  ),

                  Positioned(
                    left: controller.canvasWidth / 2,
                    top: controller.canvasHeight / 2,
                    child: Text(endMessage, style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),))
  
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
