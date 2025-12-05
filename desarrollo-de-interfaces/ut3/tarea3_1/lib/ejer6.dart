import 'package:flutter/material.dart';

void main() {
  runApp(const ComboDemo());
}

class ComboDemo extends StatefulWidget {
  const ComboDemo({super.key});

  @override
  State<ComboDemo> createState() => _ComboDemoState();
}

class _ComboDemoState extends State<ComboDemo> {
  bool active = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Animaciones Implícitas Combinadas")),
        body: Center(
          child: AnimatedAlign(
            alignment: active ? Alignment.centerRight : Alignment.centerLeft,
            duration: Duration(milliseconds: 600),
            child: AnimatedOpacity(
              opacity: active ? 1.0 : 0.3,
              duration: Duration(milliseconds: 600),
              child: AnimatedContainer(
                duration: Duration(milliseconds: 600),
                width: active ? 200 : 100,
                height: active ? 200 : 100,
                color: Colors.blue,
              ),
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () => setState(() => active = !active),
        ),
      ),
    );
  }
}
