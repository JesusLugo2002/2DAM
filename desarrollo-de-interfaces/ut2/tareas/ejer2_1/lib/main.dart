import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Control de volumen',
      home: ChangeNotifierProvider(create: (_) => VolumenProvider(), child: VolumeBar()),
    );
  }
}

class VolumenProvider extends ChangeNotifier {
  double _volumen = 50;

  double get volumen => _volumen;
  set volumen(double value) {
    _volumen = value;
    notifyListeners();
  } 
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
    final volumenProvider = context.watch<VolumenProvider>();
    final volumen = volumenProvider.volumen;

    IconData icon;
    if (volumen >= 50) {
      icon = Icons.volume_up; 
    } else if (volumen > 0) {
      icon = Icons.volume_down;
    } else {
      icon = Icons.volume_off;
    }

    return Scaffold(
      appBar: AppBar(title: Text('Control del volumen')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 20,
          children: [
            Text(
              "Volumen: ${volumen.toStringAsFixed(0)}%",
              style: TextStyle(fontSize: 32),
            ),
            Icon(icon, size: 80,),
            Slider(value: volumen, min: 0, max: 100, onChanged: (newVolumen) {
              context.read<VolumenProvider>().volumen = newVolumen;
            })
          ],
        ),
      ),
    );
  }
}