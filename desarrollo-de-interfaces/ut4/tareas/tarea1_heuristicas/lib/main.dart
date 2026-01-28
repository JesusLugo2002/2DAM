import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MainPage(),
    );
  }
}

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  final String email = "profe@centro.com";
  final String password = "123456";
  int minPasswordLength = 6;

  final TextEditingController _emailController = TextEditingController();
  String emailErrorText = "";

  final TextEditingController _passwordController = TextEditingController();
  String passwordErrorText = "";

  bool submitted = false;
  FeedbackAlert alert = FeedbackAlert(
    icon: Icons.check_circle,
    text: '¡Sesión iniciada correctamente!',
  );

  void cleanFields() {
    _emailController.clear();
    _passwordController.clear();
  }

  void submit() {
    RegExp emailRegex = RegExp(r'^[^@\s]+@[^@\s]+\.[^@\s]+$');
    String emailInput = _emailController.text;
    String passwordInput = _passwordController.text;
    if (emailRegex.hasMatch(emailInput) == false) {
      setState(
        () => emailErrorText =
            "Formato de email inválido. Revisa el '@' y el dominio",
      );
      return;
    }

    if (passwordInput == "") {
      setState(() => passwordErrorText = "La contraseña es obligatoria");
      return;
    }

    if (_passwordController.text.length < minPasswordLength) {
      setState(
        () => passwordErrorText =
            "Demasiado corta: mínimo $minPasswordLength caracteres",
      );
      return;
    }
    setState(() {
      submitted = true;
      if (emailInput == email && passwordInput == password) {
        alert = FeedbackAlert(
          icon: Icons.check_circle,
          text: '¡Sesión iniciada correctamente!',
        );
      } else {
        alert = FeedbackAlert(
          icon: Icons.error,
          text: "Credenciales inválidas",
        );
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Heurística 9 - Ayuda con errores")),
      body: Container(
        padding: EdgeInsets.all(20),
        child: Column(
          spacing: 10,
          children: [
            if (submitted) alert,
            TextField(
              decoration: InputDecoration(
                labelText: "Email",
                hintText: "ejemplo@ejemplo.com",
              ),
              controller: _emailController,
            ),
            TextField(
              decoration: InputDecoration(labelText: "Contraseña"),
              controller: _passwordController,
            ),
            Row(
              children: [
                Expanded(
                  child: ElevatedButton(
                    onPressed: submit,
                    child: Text("Entrar"),
                  ),
                ),
                ElevatedButton(onPressed: cleanFields, child: Text("Limpiar")),
              ],
            ),
            Text(
              "Credenciales de prueba:\n$email / $password",
              textAlign: TextAlign.center,
            ),
          ],
        ),
      ),
    );
  }
}

class FeedbackAlert extends StatelessWidget {
  final IconData icon;
  final String text;

  const FeedbackAlert({super.key, required this.icon, required this.text});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        border: BoxBorder.all(),
        borderRadius: BorderRadius.circular(20),
      ),
      child: Row(children: [Icon(icon), Text(text)]),
    );
  }
}
