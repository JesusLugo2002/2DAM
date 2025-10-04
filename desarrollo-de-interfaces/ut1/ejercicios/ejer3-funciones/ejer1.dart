void main() {
  num getRectArea(num base, num height) {
    return base * height;
  }

  num base = 5;
  num altura = 10;
  num resultado = getRectArea(base, altura);

  print(
    "El área para un rectángulo con base ${base} y altura ${altura} es ${resultado}",
  );
}
