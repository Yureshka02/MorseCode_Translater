public class MorseCodeApp {
    public static void main(String[] args) {
        MorseCodeTree tree = new MorseCodeTree();

        // Insert Morse code and characters into the tree
        String[] codes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        char[] characters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        // Insert the Morse code and characters into the tree
        for (int i = 0; i < codes.length; i++) {
            tree.insert(codes[i], characters[i]);
        }

        // Print the Morse code dictionary using in-order traversal
        System.out.println("Morse Code Dictionary (In-order Traversal):");
        tree.inorderPrint(tree.getRoot(), "");
        System.out.println();

        // Decode the Morse code message
        String morseCode = "/ -- . ..-. ...- --- .-. .--./ . .... -/ . -... ..-. --- .../ - ... .-. .. .-..";
        String decodedMessage = tree.decode(morseCode);
        System.out.println("Decoded Message: " + decodedMessage);

        // Reverse the message
        String reversedMessage = tree.reverseMessage(decodedMessage);
        System.out.println("Reversed Message: " + reversedMessage);
    }
}
