public class MorseCodeApp {
    public static void main(String[] args) {
        MorseCodeTree tree = new MorseCodeTree();

        String[] codes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        char[] characters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        for (int i = 0; i < codes.length; i++) {
            tree.insert(codes[i], characters[i]);
        }

        System.out.println("Morse Code Dictionary :");
        tree.inorderPrint(tree.getRoot(), "");
        System.out.println();

        //FIRST SOLVE THE PROBLEM =>
        //String morseCode="/ -- . ..-. ...- --- .-. .--./ . .... -/ . -... ..-. --- .../ - ... .-. .. .-..";

        //MEET ME AT NOON =>
        //String morseCode = ".- --- --- .-/ - -./ . --/ - . . --";

        //HELLO WORLD =>
        String morseCode = "/ ..- ..-. .-. --- --./ --- ..-. ..-. . ....";

        String decodedMessage = tree.decode(morseCode);
        System.out.println("Decoded Message: " + decodedMessage);

//        String reversedMessage = tree.reverseMessage(decodedMessage);
//        System.out.println("Reversed Message: " + reversedMessage);
    }
}