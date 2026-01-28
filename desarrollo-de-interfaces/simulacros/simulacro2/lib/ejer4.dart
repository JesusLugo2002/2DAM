import 'package:flutter/material.dart';

void main() {
  runApp(const IncidenciasApp());
}

class IncidenciasApp extends StatelessWidget {
  const IncidenciasApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: PrioridadPage(),
    );
  }
}

class PrioridadPage extends StatefulWidget {
  const PrioridadPage({super.key});

  @override
  State createState() => _PrioridadPageState();
}

class _PrioridadPageState extends State {
  String mensaje = '';
  String codigo = "";

  void guardar() {
    setState(() {
      if (codigo == '1')
        mensaje = 'Prioridad: Baja';
      else if (codigo == '2')
        mensaje = 'Prioridad: Media';
      else if (codigo == '3')
        mensaje = 'Prioridad: Alta';
      else
        mensaje = 'Código no válido (usa 1, 2 o 3)';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Heurística 6 – Reconocer')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('Introduce el código de prioridad (1, 2 o 3):'),
            const SizedBox(height: 10),

            DropdownButtonFormField(
              decoration: InputDecoration(border: OutlineInputBorder()),
              initialValue: "1",
              items: [
                DropdownMenuItem(value: "1", child: Text("Baja")),
                DropdownMenuItem(value: "2", child: Text("Media")),
                DropdownMenuItem(value: "3", child: Text("Alta")),
              ],
              onChanged: (value) => setState(() => codigo = value ?? ""),
            ),

            const SizedBox(height: 16),

            ElevatedButton(onPressed: guardar, child: const Text('Guardar')),

            const SizedBox(height: 16),

            Text(mensaje, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}
