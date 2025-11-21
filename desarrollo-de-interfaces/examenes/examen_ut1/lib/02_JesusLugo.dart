import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: Homepage());
  }
}

class Homepage extends StatelessWidget {
  const Homepage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Widget principal")),
      body: Center(
        child: Card(
          child: Padding(
            padding: EdgeInsetsGeometry.fromLTRB(30, 30, 30, 45),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                IconButton.filledTonal(onPressed: () => {}, icon: Icon(Icons.person)),
                TextField(
                  decoration: InputDecoration(
                    label: Row(
                      spacing: 10,
                      children: [
                        Icon(Icons.person),
                        Text("Nombre completo"),
                      ],
                    ),
                    border: OutlineInputBorder(),
                  ),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Icon(Icons.email),
                    Icon(Icons.phone),
                    Icon(Icons.telegram),
                    Icon(Icons.language),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    ElevatedButton(onPressed: () => {}, child: Row(
                      children: [
                        Icon(Icons.save),
                        Text("Guardar perfil"),
                      ],
                    ),),
                  ],
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
