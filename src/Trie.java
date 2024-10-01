public class Trie {
    // Instance variables
    Node root;
    public Trie(Node root){
        this.root = root;
    }
    // Add String "s" into the Trie
    void insert(String s){
        Node currentNode;
        // Check if the first letter of s "Node" is null
        if(root.getNext()[s.charAt(0)] == null) {
            // Create new node for first letter of s
            root.getNext()[s.charAt(0)] = new Node(false, new Node[260]);
        }
        currentNode = root.getNext()[s.charAt(0)];
        // For each letter in s
        for(int i = 1; i < s.length(); i++){
            // Check if the node is null
            if(currentNode.getNext()[s.charAt(i)] == null) {
                currentNode.getNext()[s.charAt(i)] = new Node(false, new Node[260]);
            }
            currentNode = currentNode.getNext()[s.charAt(i)];
        }
        // CurrentNode = last letter in s, so set isWord to true
        currentNode.setWord();
    }
    // Return false if "s" is not in Trie/dictionary, return true otherwise
    boolean lookup(String s){
        Node currentNode;
        // Check if first letter of s "Node" is null
        if(root.getNext()[s.charAt(0)] == null){
            return false;
        }
        currentNode = root.getNext()[s.charAt(0)];
        // For each letter in s
        for(int i = 1; i < s.length(); i++){
            // Check if the node is null
            if(currentNode.getNext()[s.charAt(i)] == null) {
                return false;
            }
            currentNode = currentNode.getNext()[s.charAt(i)];
        }
        // Check if it is even a word in the dictionary
        if(!currentNode.isWord){
            return false;
        }
        return true;
    }
    // Debugging
    //void printTrie(){
    //}
}
