import 'package:flutter/material.dart';

void main() {
  runApp(const FadeDemo());
}

class FadeDemo extends StatefulWidget {
  const FadeDemo({super.key});

  @override
  State<FadeDemo> createState() => _FadeDemoState();
}

class _FadeDemoState extends State<FadeDemo> {
  double opacity = 0.0;

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback(
      (_) => setState(() => opacity = 1.0),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: AnimatedOpacity(
            duration: Duration(seconds: 1),
            opacity: opacity,
            child: Container(width: 150, height: 150, color: Colors.blue),
          ),
        ),
      ),
    );
  }
}
