import 'package:flutter/material.dart';

void main() {
  runApp(const EmojiApp());
}

class EmojiApp extends StatelessWidget {
  const EmojiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: EmojiPage(),
    );
  }
}

class EmojiPage extends StatefulWidget {
  const EmojiPage({super.key});

  @override
  State<EmojiPage> createState() => _EmojiPageState();
}

class _EmojiPageState extends State<EmojiPage> {
  bool zoomActive = false;

  void toggleZoom() {
    setState(() => zoomActive = !zoomActive);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Animación implícita: Emoji')),
      floatingActionButton: FloatingActionButton(onPressed: toggleZoom, child: Icon(Icons.play_arrow),),
      body: Center(
        child: AnimatedScale(
          scale: zoomActive ? 2.5 : 1.5,
          duration: Duration(milliseconds: 400),
          curve: Curves.easeInOut,
          child: Center(child: Text("😄", style: TextStyle(fontSize: 48))),
        ),
      ),
    );
  }
}
