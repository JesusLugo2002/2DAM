import 'package:flutter/material.dart';

/// This exercise don't work for me. I tried and read about it but, in my pc, I don't see
/// any padding change. I don't know if I have an error or is just the magic of programming.
/// 
/// May God protect you.
/// 
/// - JesusLugo2002 (If you find the error, pls tell me).

void main() {
  runApp(const PaddingDemo());
}

class PaddingDemo extends StatefulWidget {
  const PaddingDemo({super.key});

  @override
  State<PaddingDemo> createState() => _PaddingDemoState();
}

class _PaddingDemoState extends State<PaddingDemo> {
  double pad = 10;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Implicit animation: AnimatedPadding")),
        body: Center(
          child: SizedBox(
            child: AnimatedPadding(
              padding: EdgeInsets.all(pad),
              duration: Duration(milliseconds: 500),
              child: Container(width: 120, height: 120, color: Colors.green),
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () => setState(() => pad = 50),
        ),
      ),
    );
  }
}
