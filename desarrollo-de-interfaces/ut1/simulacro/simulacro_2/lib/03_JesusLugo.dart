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
        appBar: AppBar(title: Text("Widget principal")),
        body: MainWidget(),
      ),
    );
  }
}

class MainWidget extends StatelessWidget {
  const MainWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      alignment: Alignment.center,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          IconCard("Work and job", Icons.work),
          IconCard("Health and Safety", Icons.health_and_safety),
          IconCard("Home", Icons.home),
        ],
      ),
    );
  }
}

class IconCard extends StatelessWidget {
  final IconData icon;
  final String text;

  const IconCard(this.text, this.icon, {super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 120,
      child: Card(
        margin: EdgeInsets.all(10),
        elevation: 5,
        child: Padding(
          padding: const EdgeInsets.all(10),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            spacing: 10,
            children: [
              SizedBox(child: ElevatedButton(onPressed: () => {}, child: Icon(icon, size: 20))),
              Text(text)
            ],
          ),
        ),
      ),
    );
  }

}