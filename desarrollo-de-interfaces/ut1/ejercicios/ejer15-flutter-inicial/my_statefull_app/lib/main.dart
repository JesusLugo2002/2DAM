import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State {
  String mensaje = '¡Hola, Flutter con estado!';

  void cambiarMensaje() {
    setState(() {
      mensaje = '¡Has pulsado el botón!';
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Mi app Stateful')),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                mensaje,
                style: TextStyle(fontSize: 24),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: cambiarMensaje,
                child: Text('Cambiar texto'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}