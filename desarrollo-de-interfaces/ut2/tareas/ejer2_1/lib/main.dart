import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Control de volumen',
      home: ChangeNotifierProvider(child: VolumeBar()),
    );
  }
}

class VolumenProvider extends ChangeNotifier {
  double _volumen = 50;

  double get getVolume => _volumen;
  set setVolume(double value) => _volumen = value; 
}

// 🔹 Widget con estado
class VolumeBar extends StatefulWidget {
  @override
  _MiWidgetConEstadoState createState() => _MiWidgetConEstadoState();
  // También válido: State<MiWidgetConEstado> createState() => _MiWidgetConEstadoState();
}

// 🔹 Clase de estado asociada al widget
class _MiWidgetConEstadoState extends State<VolumeBar> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Ejemplo StatefulWidget')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 20,
          children: [
            Text(
              "Volumen: 50%",
              style: TextStyle(fontSize: 18),
            ),
            Icon(Icons.volume_up),
            ElevatedButton(onPressed: _toggleFavourite, child: Text("Cambiar estado"))
          ],
        ),
      ),
    );
  }
}