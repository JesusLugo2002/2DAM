import 'package:flutter/material.dart';

void main() {
  runApp(const MarcadorApp());
}

class MarcadorApp extends StatelessWidget {
  const MarcadorApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MarcadorPage(),
    );
  }
}

class MarcadorPage extends StatefulWidget {
  const MarcadorPage({super.key});

  @override
  State<MarcadorPage> createState() => _MarcadorPageState();
}

class _MarcadorPageState extends State<MarcadorPage> {
  int scoreA = 0;
  int scoreB = 0;
  String status = "Empate";

  void addPointToTeamA() {
    setState(() => scoreA++);
    setStatus();
  }

  void addPointToTeamB() {
    setState(() => scoreB++);
    setStatus();
  }

  void setStatus() {
    setState(() {
      if (scoreA > scoreB) {
        status = "Va ganando A";
      } else if (scoreA < scoreB) {
        status = "Va ganando B";
      } else {
        status = "Empate";
      }
    });
  }

  void restart() {
    setState(() {
      scoreA = 0;
      scoreB = 0;
    });
    setStatus();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Marcador dinámico')),
      body: Center(
        child: Column(
          children: [
            Text('Equipo A: $scoreA'),
            Text('Equipo B: $scoreB'),
            Text(status),
            ElevatedButton(onPressed: addPointToTeamA, child: Text("+1 A")),
            ElevatedButton(onPressed: addPointToTeamB, child: Text("+1 B")),
            ElevatedButton(onPressed: restart, child: Text("Reiniciar")),

          ],
        ),
      ),
    );
  }
}
