import 'package:flutter/material.dart';

void main() {
  runApp(const EscapeRoomApp());
}

class EscapeRoomApp extends StatelessWidget {
  const EscapeRoomApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Darkest Dungeon Escape Room",
      theme: ThemeData(
        textTheme: TextTheme(
          headlineMedium: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        ),
      ),
      routes: {
        "/": (_) => DungeonStart(),
        "/ending": (_) => DungeonEnd(),
        "/victory": (_) => VictoryScreen(),
        "/lose": (_) => LoseScreen(),
      },
      initialRoute: "/",
    );
  }
}

class DungeonStart extends StatelessWidget {
  const DungeonStart({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Darkest Dungeon - Inicio")),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Center(
          child: Column(
            spacing: 20,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Estás junto a tus compañeros de guerra en las puertas de la mazmorra oscura, aquella donde se encuentran los cuerpos de antiguos cazatesoros a la espera de que alguien cumpla el sueño que ellos no pudieron alcanzar",
              ),
              Text(
                "Uno de ellos avista con el rabillo del ojo un veloz conejo, sale de una caja y se pierde en la oscuridad",
              ),
              Column(
                spacing: 15,
                children: [
                  ElevatedButton(
                    child: Text("Lo persiguen rápidamente"),
                    onPressed: () => Navigator.pushNamed(context, "/lose"),
                  ),
                  ElevatedButton(
                    child: Text("Lo siguen con cautela"),
                    onPressed: () => Navigator.pushNamed(context, "/ending"),
                  ),
                  ElevatedButton(
                    child: Text("Lo ignoran y toman otro camino"),
                    onPressed: () => Navigator.pushNamed(context, "/lose"),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class DungeonEnd extends StatelessWidget {
  const DungeonEnd({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Darkest Dungeon - Final")),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Center(
          child: Column(
            spacing: 20,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Entran en la habitación y el conejo se posa sobre un objeto brillante... ¡Una llave!",
              ),
              Text(
                "Uno de los heroes está tentado a agarrar la llave y abrir la puerta dorada a la distancia...",
              ),
              Column(
                spacing: 15,
                children: [
                  ElevatedButton(
                    child: Text("'Toma la llave y abre la puerta'"),
                    onPressed: () => Navigator.pushNamed(context, "/victory"),
                  ),
                  ElevatedButton(
                    child: Text("'Es una trampa, mejor vayamos por este otro camino'"),
                    onPressed: () => Navigator.pushNamed(context, "/lose"),
                  ),
                  ElevatedButton(
                    child: Text("'¿Qué es ese ruido?'"),
                    onPressed: () => Navigator.pushNamed(context, "/lose"),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class VictoryScreen extends StatelessWidget {
  const VictoryScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Darkest Dungeon - Victoria")),
      body: Container(
        color: const Color.fromARGB(255, 182, 219, 139),
        child: Center(
          child: Column(
            spacing: 20,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "¡Has vencido las mazmorras y te has hecho con sus tesoros!",
                style: Theme.of(context).textTheme.headlineMedium,
              ),
              ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: Text("Volver a jugar"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class LoseScreen extends StatelessWidget {
  const LoseScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Darkest Dungeon - Derrota")),
      body: Container(
        color: const Color.fromARGB(255, 255, 115, 115),
        child: Center(
          child: Column(
            spacing: 20,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "¡Has caído en una trampa!",
                style: Theme.of(context).textTheme.headlineMedium,
              ),
              ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: Text("Volver a jugar"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
