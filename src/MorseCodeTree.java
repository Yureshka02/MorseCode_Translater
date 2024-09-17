public class MorseCodeTree {
    private MorseNode root;

    //constructor that initializes the root node
    public MorseCodeTree() {
        root = new MorseNode(' ');
    }

        //method to insert a character and its morse code into the tree
        public void insert(String code, char character){
        MorseNode current = root;
        for ( char c : code.toCharArray() ){
            if ( c == '.' ){
                if ( current.left == null ){
                    current.left = new MorseNode(' ');
                }
                current = current.left;
            } else if ( c == '-' ){
                if ( current.right == null ){
                    current.right = new MorseNode(' ');
                }
                current = current.right;
            }
        }
        current.character = character; //assign the character to the node
    }


    //Inorder traversal of the tree to print the morse code and the character
    public void inorder(MorseNode node){
        if ( node != null ){
            inorder(node.left);
            if ( node.character != ' ' ){
                System.out.println(node.character + " ");
            }
            inorder(node.right);
        }
    }
}
