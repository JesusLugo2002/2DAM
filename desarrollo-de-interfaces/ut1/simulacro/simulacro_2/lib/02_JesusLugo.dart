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
    const profileRow = IconRow(
      Icon(Icons.person, size: 40),
      Text("Perfil de usuario"),
    );
    const starRow = IconRow(Icon(Icons.star), Text("Puntos: 120"));
    const notificationsRow = IconRow(
      Icon(Icons.notifications),
      Text("Notificaciones: 5"),
    );
    ElevatedButton editButton = ElevatedButton(
      onPressed: () {
        print("Editando perfil");
      },
      child: Text("Editar perfil"),
    );
    const folderColumn = IconColumn(Icon(Icons.folder), Text("Archivos"));
    const settingsColumn = IconColumn(Icon(Icons.settings), Text("Ajustes"));
    const helpColumn = IconColumn(Icon(Icons.help_outline), Text("Ayuda"));

    return Center(
      child: SizedBox(
        width: 350,
        height: 380,
        child: Card(
          elevation: 10,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              profileRow,
              Separator(),
              SizedBox(height: 8),
              starRow,
              SizedBox(height: 8),
              notificationsRow,
              Separator(),
              SizedBox(height: 24),
              editButton,
              Separator(),
              SizedBox(height: 8),
              Text("Opciones rápidas"),
              SizedBox(height: 16),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                spacing: 24,
                children: [folderColumn, settingsColumn, helpColumn],
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class IconRow extends StatelessWidget {
  final Icon icon;
  final Text text;

  const IconRow(this.icon, this.text, {super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [icon, text],
    );
  }
}

class IconColumn extends StatelessWidget {
  final Icon icon;
  final Text text;

  const IconColumn(this.icon, this.text, {super.key});

  @override
  Widget build(BuildContext context) {
    return Column(children: [icon, text]);
  }
}

class Separator extends StatelessWidget {
  const Separator({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 24,
      margin: EdgeInsets.fromLTRB(20, 0, 20, 0),
      decoration: BoxDecoration(
        border: BoxBorder.fromLTRB(bottom: BorderSide(color: Colors.grey)),
      ),
    );
  }
}
