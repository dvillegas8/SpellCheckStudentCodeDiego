import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        // Array of nodes where the index is the ASCII value of the current letter
        Node[] next = new Node[253];
        // The top node of the trie
        Node root = new Node(false, next);
        // Trie to keep track of all the misspelled words in text
        Trie misspelledWords = new Trie(root);
        Trie trie = new Trie(root);
        // ArrayList to keep track of order misspelled words appear in text
        ArrayList<String> order = new ArrayList<String>();
        // Create trie that consists of all dictionary Strings
        for (int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }
        // For every word in text
        for (int i = 0; i < text.length; i++) {
            // Check if it is in misspelled words
            if(!misspelledWords.lookup(text[i])){
                // Check if it is in the dictionary
                if(!trie.lookup(text[i])) {
                    // Add current word (text[i]) to misspelledWords trie
                    misspelledWords.insert(text[i]);
                    // Add current word to order
                    order.add(text[i]);
                }
            }
        }
        // Convert ArrayList to array
        String[] words = order.toArray(new String[0]);
        return words;
    }
    public String[] checkWordsTST(String[] text, String[] dictionary) {
        //for(int i = 0; i < dictionary.length; i++){
            //System.out.println(dictionary[i]);
        //}
        // Create a top node for the dictionary trie
        TSTNode top = new TSTNode(false,null, null, null, dictionary[0].charAt(0));
        TSTTrie misspelledWords = new TSTTrie(null);
        TSTTrie trie = new TSTTrie(top);
        // ArrayList to keep track of order misspelled words appear in text
        ArrayList<String> order = new ArrayList<String>();
        // Create trie dictionary
        for(int i = 0; i < dictionary.length; i++){
            trie.insert(dictionary[i]);
        }
        // For each word in text
        for(int i = 0; i < text.length; i++){
            // Check if it is in misspelled words
            if(!misspelledWords.lookup(text[i])){
                // Check if it is in the dictionary
                if(!trie.lookup(text[i])) {
                    // Add current word (text[i]) to misspelledWords trie
                    misspelledWords.insert(text[i]);
                    // Add current word to order
                    order.add(text[i]);
                }
            }
        }
        // Convert ArrayList to array
        String[] words = order.toArray(new String[0]);
        return words;
    }
}
