import 'dart:io';

Future<void> main() async {
  print('Comprobando conexión a Internet...');

  try {
    InternetAddress.lookup("google.com").then((value) {
      print("✅ Conectado a Internet");
    });
  } on SocketException catch (_) {
    print('❌ Sin conexión a Internet');
  }
}
