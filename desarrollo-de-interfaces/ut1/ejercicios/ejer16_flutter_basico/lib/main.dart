import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Center(
        child: Text(
          "Hello world!",
          style: TextStyle(
            fontWeight: FontWeight.normal,
            fontStyle: FontStyle.italic,
            fontSize: 64,
            fontFamily: "Comic Sans",
            color: Colors.deepOrangeAccent,
          ),
        ),
      ),
    ),
  );
}
