void main() {
  String decodeAscii(String asciiSequence) {
    List<String> values = asciiSequence.split(" ");
    Iterable<int> nums = values.map((v) => int.parse(v) - 1);
    return String.fromCharCodes(nums);
  }

  String secretMessage =
      "82 118 102 33 109 98 33 103 118 102 115 123 98 33 117 102 33 98 100 112 110 113 98 242 102";
  print(decodeAscii(secretMessage));
}
