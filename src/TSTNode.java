public class TSTNode{
    private boolean isWord;
    private TSTNode left;
    private TSTNode middle;
    private TSTNode right;
    char letter;
    public TSTNode(boolean isWord, TSTNode left, TSTNode middle, TSTNode right, char letter){
        this.isWord = isWord;
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.letter = letter;
    }
    boolean isWord(){
        return isWord;
    }
    void setWord(){
        isWord = true;
    }
    // Get functions for nodes
    public TSTNode getLeft(){
        return left;
    }
    public TSTNode getMiddle(){
        return middle;
    }
    public TSTNode getRight(){
        return right;
    }
    // Set functions for nodes
    public void setLeft(TSTNode left){
        this.left = left;
    }
    public void setMiddle(TSTNode middle){
        this.middle = middle;
    }
    public void setRight(TSTNode right){
        this.right = right;
    }
    public char getLetter(){
        return letter;
    }
    public void setLetter(char letter){
        this.letter = letter;
    }
}
