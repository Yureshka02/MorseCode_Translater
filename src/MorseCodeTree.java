public class MorseCodeTree {
    private MorseNode root;

    // Constructor that initializes the root node
    public MorseCodeTree() {
        root = new MorseNode(' ');
    }

    // Method to insert a character and its Morse code into the tree
    public void insert(String code, char character) {
        MorseNode current = root;
        for (char c : code.toCharArray()) {
            if (c == '.') {
                if (current.left == null) {
                    current.left = new MorseNode(' ');
                }
                current = current.left;
            } else if (c == '-') {
                if (current.right == null) {
                    current.right = new MorseNode(' ');
                }
                current = current.right;
            }
        }
        current.character = character; // Assign the character to the node
    }

    // In-order traversal of the tree to print the Morse code and the character
    public void inorderPrint(MorseNode node, String morseCode) {
        if (node == null) return;

        // Traverse the left subtree (dot -> '.')
        inorderPrint(node.left, morseCode + ".");

        // Print the character and its Morse code if the node holds a character
        if (node.character != ' ') {
            System.out.println(node.character + " : " + morseCode);
        }

        // Traverse the right subtree (dash -> '-')
        inorderPrint(node.right, morseCode + "-");
    }

    // Method to decode a provided Morse code string
    public String decode(String morseCode) {
        StringBuilder decodedString = new StringBuilder();

        // Reverse the entire Morse code string
        morseCode = new StringBuilder(morseCode).reverse().toString();

        // Split by Morse code word separator
        String[] words = morseCode.split("/");

        for (String word : words) {
            word = word.trim(); // Remove leading/trailing spaces
            if (word.isEmpty()) {
                decodedString.append(" ");
                continue;
            }

            // Split by Morse code letter separator
            String[] letters = word.split(" ");

            for (String letter : letters) {
                MorseNode current = root;
                for (char c : letter.toCharArray()) {
                    if (c == '.') {
                        current = current.left;
                    } else if (c == '-') {
                        current = current.right;
                    }
                    if (current == null) {
                        decodedString.append('?'); // Handle invalid Morse code
                        break;
                    }
                }
                if (current != null) {
                    decodedString.append(current.character);
                }
            }
            decodedString.append(" "); // Add space after each word
        }

        return decodedString.toString().trim(); // Remove trailing space
    }

    // Method to reverse the message for transmission security
//    public String reverseMessage(String message) {
//        return new StringBuilder(message).reverse().toString();
//    }

    // Getter for the root node
    public MorseNode getRoot() {
        return root;
    }
}
