import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: Scaffold(
        appBar: AppBar(title: Text("Campos de texto")),
        body: TextInput(),
      ),
    );
  }
}

class TextInput extends StatefulWidget {
  const TextInput({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TextInputState();
  }
}

class _TextInputState extends State<TextInput> {
  String text = "";

  @override
  Widget build(BuildContext context) {
    final TextEditingController controller = TextEditingController();
    return Padding(
      padding: EdgeInsetsGeometry.all(100),
      child: Column(
        spacing: 20,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          TextField(
            controller: controller,
            decoration: InputDecoration(labelText: "Escribe algo"),
          ),
          ElevatedButton(
            onPressed: () => {
              setState(() {
                text = controller.text;
              }),
            },
            child: Text("Mostrar texto", style: TextStyle(fontSize: 20)),
          ),
          Text(text, style: TextStyle(fontSize: 20)),
        ],
      ),
    );
  }
}
