public class MorseCodeApp {
    public static void main(String[] args) {
        MorseCodeTree tree = new MorseCodeTree();

        // Morse codes for each character
        String[] codes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        // Characters corresponding to the Morse codes
        char[] characters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        // Insert Morse codes and characters into the tree
        for (int i = 0; i < codes.length; i++) {
            tree.insert(codes[i], characters[i]);
        }

        // Print the Morse code dictionary
        System.out.println("Morse Code Dictionary :");
        tree.inorderPrint(tree.getRoot(), "");
        System.out.println();

        //  Decode and reverse the message
          String morseCode = "/ -- . ..-. ...- --- .-. .--./ . .... -/ . -... ..-. --- .../ - ... .-. .. .-.."; //FIRST SOLVE THE PROBLEM
  //      String morseCode = "/ ..- ..-. .-. --- --./ --- ..-. ..-. . ...."; // HELLO WORLD

        // First, decode the message from Morse code
        String decodedMessage = tree.decode(morseCode);
        System.out.println("Decoded Message: " + decodedMessage);

        //  reverse the decoded message
        String reversedMessage = tree.reverseMessage(decodedMessage);
        System.out.println("Reversed Message: " + reversedMessage);
    }
}
