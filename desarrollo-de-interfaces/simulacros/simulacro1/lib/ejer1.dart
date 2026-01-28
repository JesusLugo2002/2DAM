import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => CarritoModel(),
      child: CafeteriaApp(),
    ),
  );
}

class CarritoModel extends ChangeNotifier {
  int items = 0;
  double total = 0.0;

  void add(double precio) {
    items++;
    total += precio;
    notifyListeners();
  }

  void clear() {
    items = 0;
    total = 0;
    notifyListeners();
  }
}

class CafeteriaApp extends StatelessWidget {
  const CafeteriaApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: CafeteriaPage(),
    );
  }
}

class CafeteriaPage extends StatefulWidget {
  const CafeteriaPage({super.key});

  @override
  State<CafeteriaPage> createState() => _CafeteriaPageState();
}

class _CafeteriaPageState extends State<CafeteriaPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Cafetería (provider)'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            // RESUMEN
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.black12),
                borderRadius: BorderRadius.circular(10),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    'Items: ${context.watch<CarritoModel>().items}',
                    style: TextStyle(fontSize: 18),
                  ),
                  Text(
                    'Total: ${context.watch<CarritoModel>().total} €',
                    style: TextStyle(fontSize: 18),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 16),

            // PRODUCTOS (estático)
            _Producto(nombre: 'Café', precio: 1.20),
            _Producto(nombre: 'Tostada', precio: 1.80),
            _Producto(nombre: 'Zumo', precio: 2.10),

            const Spacer(),

            // VACIAR (estático)
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: context.read<CarritoModel>().clear,
                child: Text('Vaciar carrito'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _Producto extends StatelessWidget {
  final String nombre;
  final double precio;

  const _Producto({required this.nombre, required this.precio});

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        title: Text(nombre),
        subtitle: Text('${precio.toStringAsFixed(2)} €'),
        trailing: ElevatedButton(
          onPressed: () => context.read<CarritoModel>().add(precio),
          child: const Text('Añadir'),
        ),
      ),
    );
  }
}
