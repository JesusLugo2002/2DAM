import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const LoginBase(),
    );
  }
}

class LoginBase extends StatefulWidget {
  const LoginBase({super.key});

  @override
  State<LoginBase> createState() => _LoginBaseState();
}

class _LoginBaseState extends State<LoginBase> {
  final _emailCtrl = TextEditingController();
  final _passCtrl = TextEditingController();
  Alert? alert;
  bool passIsInvisible = true;

  void setError(msg) {
    setState(
      () => alert = msg != null
          ? Alert(icon: Icons.dangerous, msg: msg, color: Colors.red.shade100)
          : null,
    );
  }

  void togglePasswordVisible() {
    setState(() => passIsInvisible = !passIsInvisible);
  }

  void submit() {
    if (_emailCtrl.text.isEmpty) {
      setError("Escribe tu correo electrónico");
      return;
    }

    if (_passCtrl.text.length < 8) {
      setError("La contraseña debe tener al menos 8 caracteres");
      return;
    }

    setError(null);
    setState(
      () => alert = Alert(
        icon: Icons.check,
        msg: "Bienvenido al sistema!",
        color: Colors.green.shade100,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Acceso')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          spacing: 15,
          children: [
            if (alert != null) alert!,
            TextField(
              controller: _emailCtrl,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                labelText: 'Correo electrónico',
                hintText: 'nombre@dominio.com',
                helperText: "Usa un correo válido para iniciar sesión.",
              ),
            ),
            Stack(
              children: [
                TextField(
                  controller: _passCtrl,
                  decoration: const InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Contraseña',
                    hintText: "Mínimo 8 caracteres.",
                    helperText: "No compartas tu contraseña con nadie.",
                  ),
                  obscureText: passIsInvisible,
                ),

                Positioned(
                  right: 1,
                  top: 3.5,
                  child: IconButton(
                    onPressed: togglePasswordVisible,
                    icon: Icon(
                      passIsInvisible ? Icons.visibility_off : Icons.visibility,
                    ),
                  ),
                ),
              ],
            ),
            ElevatedButton(onPressed: submit, child: const Text('Entrar')),
          ],
        ),
      ),
    );
  }
}

class Alert extends StatelessWidget {
  final IconData icon;
  final String msg;
  final Color color;

  const Alert({
    super.key,
    required this.icon,
    required this.msg,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      color: color,
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Row(
          spacing: 5,
          children: [
            Icon(icon),
            Text(msg, style: TextStyle(fontWeight: FontWeight.bold)),
          ],
        ),
      ),
    );
  }
}
