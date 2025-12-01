import 'package:flutter/material.dart';

void main() {
  runApp(const MinigameState());
}

class MinigameState extends StatefulWidget {
  const MinigameState({super.key});

  @override
  State<MinigameState> createState() => _MinigameStateState();
}

class _MinigameStateState extends State<MinigameState> {
  int energy = 50;
  bool isDark = false;

  @override
  Widget build(BuildContext context) {

    String info = "";
    if (energy == 0) {
      info = "Has perdido toda la energía";
    } else if (energy == 50) {
      info = "Vas a mitad de camino";
    } else if (energy == 100) {
      info = "¡Has escapado!";
    } else {
      info = "Sigue ajustando la energía...";
    }

    Color color = Colors.yellow;
    if (energy < 30) {
      color = Colors.redAccent;
    } else if (30 <= energy && energy <= 70) {
      color = Colors.orange;
    } else if (energy > 70) {
      color = Colors.green;
    }

    void incrementar() => setState(() => energy += 10);
    void reducir() => setState(() => energy -= 10);
    void reiniciar() => setState(() => energy = 50);
    void cambiarTema() => setState(() => isDark = !isDark);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        brightness: isDark ? Brightness.dark : Brightness.light,
      ),
      home: Scaffold(
        floatingActionButton: ElevatedButton(onPressed: cambiarTema, child: Icon(isDark ? Icons.dark_mode : Icons.light_mode)),
        appBar: AppBar(
          title: const Text("Mini-juego: Gestión de estado"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            spacing: 20,
            children: [
              Text("Energía", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),),
              Text(energy.toString(), style: TextStyle(fontSize: 64, color: color),),
              Text(info),
              Row(
                spacing: 20,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ElevatedButton(onPressed: incrementar, child: Text("➕ Incrementar"),),
                  ElevatedButton(onPressed: reducir, child: Text("➖ Reducir"),),
                  ElevatedButton(onPressed: reiniciar, child: Text("🔄 Reiniciar"),),
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}