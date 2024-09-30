public class Node {
    // Instance variables
    boolean isWord;
    Node[] next;
    public Node(boolean isWord, Node[] next){
        this.isWord = isWord;
        this.next = next;
    }
    boolean isWord(){
        return isWord;
    }
    void setWord(){
        isWord = true;
    }
    Node[] getNext(){
        return next;
    }
}
