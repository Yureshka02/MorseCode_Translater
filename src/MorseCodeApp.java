public class MorseCodeApp {
    public static void main(String[] args) {
        MorseCodeTree tree = new MorseCodeTree();

        //inserting the morse code and the character into the tree
        String[] codes = {
                ".-",
                "-...",
                "-.-.",
                "-..",
                ".",
                "..-.",
                "--.",
                "....",
                "..",
                ".---",
                "-.-",
                ".-..",
                "--",
                "-.",
                "---",
                ".--.",
                "--.-",
                ".-.",
                "...",
                "-",
                "..-",
                "...-",
                ".--",
                "-..-",
                "-.--",
                "--.."
        };

        char[] characters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z' };

        //inserting the morse code and the character into the tree
        for (int i = 0; i < codes.length; i++) {
            tree.insert(codes[i], characters[i]);
        }
        //printing the morse code and the character
        // Print the Morse code dictionary using in-order traversal
        System.out.println("Morse Code Dictionary (In-order Traversal):");
        tree.inorderPrint(tree.getRoot(), "");
        System.out.println();
    }
}
