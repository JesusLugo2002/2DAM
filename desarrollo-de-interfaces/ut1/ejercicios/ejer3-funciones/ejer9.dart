void main() {
  Function multiplicador(int value) {
    return (otherValue) => value * otherValue;
  }

  Function multiplicarPorCinco = multiplicador(5);
  print(multiplicarPorCinco(2));
}
