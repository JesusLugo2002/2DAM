void main() {
  void onPressed(Function callback) {
    return callback();
  }

  onPressed(() => print("Botón pulsado"));
}
