public class TSTTrie {
    private TSTNode top;

    public TSTTrie(TSTNode top) {
        this.top = top;
    }
    public void put(String word){
        top = put(top, word, 0);
    }
    // Creates a TST using recursion
    private TSTNode put(TSTNode currentNode, String word, int index){
        // Check if node is null, if true then create a new node
        if(currentNode == null){
            currentNode = new TSTNode(false,null,null,null, word.charAt(index));
        }
        // Check if we are at the last character of the word
        if(index == word.length() - 1 && currentNode.getLetter() == word.charAt(index)){
            currentNode.setWord();
            return currentNode;
        }
        // If letter of word and node are the same
        if(word.charAt(index) == currentNode.getLetter()){
            currentNode.setMiddle(put(currentNode.getMiddle(), word, index + 1));
        }
        // Word letter is less than node letter
        else if(word.charAt(index) < currentNode.getLetter()){
            currentNode.setLeft(put(currentNode.getLeft(), word, index));
        }
        // Word letter is greater than node letter
        else{
            currentNode.setRight(put(currentNode.getRight(), word, index));
        }
        return currentNode;
    }
    // Returns true if s is in trie, false if not
    public boolean search(String s){
        TSTNode currentNode = top;
        int i = 0;
        while(i < s.length()){
            // If we encounter a null link then s is not in dictionary
            if(currentNode == null){
                return false;
            }
            // Check if we are at the end of s
            if(i == s.length() - 1 && currentNode.getLetter() == s.charAt(i)){
                // Check if s is even a word
                if(!currentNode.isWord()){
                    return false;
                }
            }
            // If s character is less than node letter, take left link
            if(s.charAt(i) < currentNode.getLetter()){
                currentNode = currentNode.getLeft();
            }
            // If s character is greater than node letter, take right link
            else if(s.charAt(i) > currentNode.getLetter()){
                currentNode = currentNode.getRight();
            }
            // If both letters are the same, take middle link
            else{
                currentNode = currentNode.getMiddle();
                i++;
            }
        }
        return true;
    }
}
