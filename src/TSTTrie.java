public class TSTTrie {
    private TSTNode top;

    public TSTTrie(TSTNode top) {
        this.top = top;
    }
    public void put(String word){
        put(top, word, 0);
    }
    private void put(TSTNode currentNode, String word, int index){
        if(index == word.length() - 1){
            currentNode.setWord();
            return;
        }
        else if(currentNode.getMiddle() == null && index < word.length()){
            currentNode.setMiddle(new TSTNode(false, null,null,null, word.charAt(index + 1)));
        }
        // If letter of word and node are the same
        if(word.charAt(index) == currentNode.getLetter()){
            put(currentNode.getMiddle(), word, index + 1);
        }
        // Word letter is less than node letter
        else if(word.charAt(index) < currentNode.getLetter()){
            put(currentNode.getLeft(), word, index);
        }
        // Word letter is greater than node letter
        else{
            if(currentNode.getRight() == null){
                currentNode.setRight(new TSTNode(false, null, null, null, word.charAt(index)));
            }
            put(currentNode.getRight(), word, index);
        }
    }
    public void insert(String s) {
        TSTNode currentNode = top;
        // For each letter in s
        for(int i = 0; i < s.length() - 1; i++) {
            if (currentNode.getLetter() == s.charAt(i)) {
                if (currentNode.getMiddle() == null) {
                    currentNode.setMiddle(new TSTNode(false, null, null, null, s.charAt(i + 1)));
                }
                currentNode = currentNode.getMiddle();
            }
            // S letter is less than node letter
            else if (currentNode.getLetter() > s.charAt(i)) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new TSTNode(false, null, null, null, s.charAt(i)));
                }
                currentNode = currentNode.getLeft();
                i--;
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new TSTNode(false, null, null, null, s.charAt(i)));
                }
                currentNode = currentNode.getRight();
                i--;
            }
        }
        if(currentNode.getLetter() != s.charAt(s.length() - 1)){
            if(s.charAt(s.length() - 1) > currentNode.getLetter()){
                currentNode.setRight(new TSTNode(true, null, null, null, s.charAt(s.length() -1)));
            }
            else{
                currentNode.setLeft(new TSTNode(true, null, null,null, s.charAt(s.length() - 1)));
            }
        }
        else{
            currentNode.setWord();
        }
            /*
            // Check if the next node is null
            if(currentNode.getNext()[s.charAt(i)] == null) {
                // Create new node for "s" letter
                currentNode.getNext()[s.charAt(i)] = new Node(false, new Node[253]);
            }
            currentNode = currentNode.getNext()[s.charAt(i)];
        }
        // CurrentNode = last letter in s, so set isWord to true
        currentNode.setWord();
        TSTNode currentNode = top;
        int i = 0;
        // For each letter in s
        while (i < s.length()) {
            // If letters match, go down the middle and move onto the next letter
            if (currentNode.getLetter() == s.charAt(i)) {
                if(currentNode.getMiddle() == null){
                    if(i == s.length() - 1){
                        currentNode.setMiddle(new TSTNode(true, null,null,null, s.charAt(i)));
                    }
                    else{
                        currentNode.setMiddle(new TSTNode(false, null,null,null, s.charAt(i)));
                    }
                }
                currentNode = currentNode.getMiddle();
            }
            // If s letter is less than node letter go to the left
            else if (s.charAt(i) < currentNode.getLetter()) {
                if(currentNode.getLeft() == null){
                    if(i == s.length() - 1){
                        currentNode.setLeft(new TSTNode(true, null, null, null, s.charAt(i)));
                    }
                    else{
                        currentNode.setLeft(new TSTNode(false, null, null, null, s.charAt(i)));
                    }
                }
                currentNode = currentNode.getLeft();
            }
            // If s letter is greater than node letter go to the right
            else {
                if(currentNode.getRight() == null){
                    if(i == s.length() - 1){
                        currentNode.setRight(new TSTNode(true, null, null, null, s.charAt(i)));
                    }
                    else{
                        currentNode.setRight(new TSTNode(false, null, null, null, s.charAt(i)));
                    }
                }
                currentNode = currentNode.getRight();
            }
        }
        // Create node for last letter in s
        currentNode.setWord();

             */
    }
    public boolean lookup(String s){
        TSTNode currentNode = top;
        int i = 0;
        while(i < s.length() - 1){
            if(currentNode == null){
                return false;
            }
            // If letters match, go down the middle and move onto the next letter
            if(currentNode.getLetter() == s.charAt(i)){
                currentNode = currentNode.getMiddle();
                i++;
            }
            // If s letter is less than node letter go to the left
            else if(s.charAt(i) < currentNode.getLetter()){
                currentNode = currentNode.getLeft();
            }
            // If s letter is greater than node letter go to the right
            else{
                currentNode = currentNode.getRight();
            }
        }
        // Check if it is even a word in the dictionary
        if(!currentNode.isWord()){
            return false;
        }
        return true;
    }
    public TSTNode getTop(){
        return top;
    }
}
