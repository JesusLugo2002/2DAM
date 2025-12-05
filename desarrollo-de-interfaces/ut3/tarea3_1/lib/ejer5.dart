import 'package:flutter/material.dart';

void main() {
  runApp(const AlignDemo());
}

class AlignDemo extends StatefulWidget {
  const AlignDemo({super.key});

  @override
  State<AlignDemo> createState() => _AlignDemoState();
}

class _AlignDemoState extends State<AlignDemo> {
  Alignment pos = Alignment.topLeft;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Implicit animation: AnimatedAlign")),
        body: Center(
          child: Container(
            width: 250,
            height: 250,
            color: Colors.grey.shade300,
            child: AnimatedAlign(
              alignment: pos,
              duration: Duration(seconds: 1),
              child: Container(width: 50, height: 50, color: Colors.orange),
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () => setState(() => pos = Alignment.bottomRight),
        ),
      ),
    );
  }
}
