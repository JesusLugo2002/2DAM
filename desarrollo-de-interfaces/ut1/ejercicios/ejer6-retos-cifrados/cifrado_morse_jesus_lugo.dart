void main() {
  final Map<String, String> morseCodeMap = {
    'A': '.-',
    'B': '-...',
    'C': '-.-.',
    'D': '-..',
    'E': '.',
    'F': '..-.',
    'G': '--.',
    'H': '....',
    'I': '..',
    'J': '.---',
    'K': '-.-',
    'L': '.-..',
    'M': '--',
    'N': '-.',
    'O': '---',
    'P': '.--.',
    'Q': '--.-',
    'R': '.-.',
    'S': '...',
    'T': '-',
    'U': '..-',
    'V': '...-',
    'W': '.--',
    'X': '-..-',
    'Y': '-.--',
    'Z': '--..',
    '0': '-----',
    '1': '.----',
    '2': '..---',
    '3': '...--',
    '4': '....-',
    '5': '.....',
    '6': '-....',
    '7': '--...',
    '8': '---..',
    '9': '----.',
    '.': '.-.-.-',
    ',': '--..--',
    '?': '..--..',
    '/': '-..-.',
    ' ': '/',
  };

  String decodeWord(String word) {
    List<String> decodedLetters = [];
    List<String> morseLetters = word.split(" ");

    for (var letter in morseLetters) {
      String decodedLetter = morseCodeMap.keys.firstWhere(
        (k) => morseCodeMap[k] == letter,
      );
      decodedLetters.add(decodedLetter);
    }
    return decodedLetters.join();
  }

  String decodeMorse(String morse) {
    List<String> words = morse.split("/");
    List<String> decodedWords = [];
    for (var word in words) {
      decodedWords.add(decodeWord(word.trim()));
    }
    return decodedWords.join(" ");
  }

  String secretMessage =
      "- --- -.-. / - --- -.-. / - --- -.-. --..-- / .--. . -. -. -.--";
  print("Resultado: " + decodeMorse(secretMessage));
}
