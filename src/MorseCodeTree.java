public class MorseCodeTree {
    private MorseNode root;

    // Constructor to initialize MorseCodeTree
    public MorseCodeTree() {
        root = new MorseNode(' ');  // Root node represents the start of the Morse code tree
    }

    // Insert a character with its Morse code into the tree
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
        current.character = character;
    }

    // Perform in-order traversal to print the Morse code dictionary
    public void inorderPrint(MorseNode node, String morseCode) {
        if (node == null) return;

        inorderPrint(node.left, morseCode + ".");
        if (node.character != ' ') {
            System.out.println(node.character + " : " + morseCode);
        }
        inorderPrint(node.right, morseCode + "-");
    }

    // Decode a message from Morse code into English
    public String decode(String morseCode) {
        StringBuilder decodedString = new StringBuilder();

        // Split by Morse code word separator (slash '/')
        String[] words = morseCode.split("/");

        // Process each word in the Morse code
        for (String word : words) {
            word = word.trim(); // Remove leading/trailing spaces

            if (word.isEmpty()) {
                decodedString.append(" ");
                continue;
            }

            // Split by Morse code letter separator (space between letters)
            String[] letters = word.split(" ");

            // Process each letter in the word
            for (String letter : letters) {
                MorseNode current = root;

                // Reverse the letter's Morse code sequence
                String reversedLetter = new StringBuilder(letter).reverse().toString();

                // Process the individual Morse code characters (dots and dashes) in reversed order
                for (char c : reversedLetter.toCharArray()) {
                    // Traverse left for '.', traverse right for '-'
                    if (c == '.') {
                        current = current.left;
                    } else if (c == '-') {
                        current = current.right;
                    }

                    // Handle invalid Morse code
                    if (current == null) {
                        decodedString.append('?');
                        break;
                    }
                }

                // Append the decoded character if it's valid
                if (current != null) {
                    decodedString.append(current.character);
                }
            }

            // Add space after each word
            decodedString.append(" ");
        }

        // Return the fully decoded string, trimming any trailing spaces
        return decodedString.toString().trim();
    }

    // Use custom stack to reverse the message
    public String reverseMessage(String message) {
        Stack stack = new Stack(message.length());  // Create a new stack with message length
        return stack.reverseUsingStack(message); // Reverse the message using the stack
    }

    // Getter for root node
    public MorseNode getRoot() {
        return root;
    }
}
