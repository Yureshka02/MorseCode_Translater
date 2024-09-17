public class MorseCodeTree {
    private MorseNode root;

    //constructor that initializes the root node
    public MorseCodeTree() {
        root = new MorseNode(' ');
    }

    //method to insert a character and its morse code into the tree
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
        current.character = character; //assign the character to the node
    }


    //Inorder traversal of the tree to print the morse code and the character
    public void inorderPrint(MorseNode node, String morseCode) {

        if (node == null) return;

        // Traverse the left subtree (dot -> '.')
        inorderPrint(node.left, morseCode + ".");

        // Print the character and its morse code if the node holds a character
        if (node.character != '\0') {
            System.out.println(node.character + " : " + morseCode);
        }

        // Traverse the right subtree (dash -> '-')
        inorderPrint(node.right, morseCode + "-");
    }

    //method to decode a provided morse code string
    public String decode(String morseCode) {
        StringBuilder decodedString = new StringBuilder();
        String[] Message = morseCode.split(" ");

        for (String code : Message) {
            MorseNode current = root;
            for (char c : code.toCharArray()) {
                if (c == '.') {
                    current = current.left;
                } else if (c == '-') {
                    current = current.right;
                }
            }
            decodedString.append(current.character); // Append decoded character
        }
        decodedString.append(" "); // Add

        return decodedString.toString().trim();
    }
        // Method to reverse the message for transmission security
        public String reverseMessage(String Message) {
            return new StringBuilder(Message).reverse().toString();
        }

        // Getter for the root node
        public MorseNode getRoot() {
            return root;
        }
    }
