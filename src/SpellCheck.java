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
        for(int i = 0; i < dictionary.length; i++){
            if(dictionary[i].equals("k")){
                System.out.println("***************************");
            }
            //System.out.println(dictionary[i]);
        }
        // Arraylist to keep track of all words not present in dictionary
        ArrayList<String> misspelledWords = new ArrayList<String>();
        // Array of nodes where the index is the ASCII value of the current letter
        Node[] next = new Node[260];
        Node root = new Node(false, next);
        Trie trie = new Trie(root);
        // Crete trie that consists of all dictionary Strings
        for (int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }
        for (int i = 0; i < text.length; i++) {
            if (!trie.lookup(text[i])) {
                misspelledWords.add(text[i]);
            }
        }
        for(int i = 0 ; i < misspelledWords.size(); i++){
            System.out.println(misspelledWords.get(i) + ", " + i);
        }
        //System.out.println("_____________________");
        // Removes duplicates
        String word = "";
        for (int i = 0; i < misspelledWords.size() - 1; i++) {
            word = misspelledWords.get(i);
            for (int j = i + 1; j < misspelledWords.size(); j++) {
                if (word.equals(misspelledWords.get(j))) {
                    misspelledWords.remove(j);
                    j--;
                }
            }
        }
        // Convert ArrayList to array
        String[] words = new String[misspelledWords.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = misspelledWords.get(i);
            System.out.println(words[i]);
        }
        return words;
        /*
        String currentWord = "";
        System.out.println(dictionary.length);
        for(int i = 0; i < dictionary.length; i++){
            System.out.println(dictionary[i]);
        }
        int firstChar = 0;
        int low = 0;
        int high = text.length - 1;
        int mid = 0;
        // Go through each word in the text
        for(int i = 0; i < text.length; i++){
            currentWord = text[i];
            // Perform binary search on current word
            if(!binarySearch(dictionary, text, currentWord)){
                misspelledWords.add(currentWord);
            }
        }
        // Removes duplicates
        String word = "";
        for(int i = 0; i < misspelledWords.size() - 1; i++){
            word = misspelledWords.get(i);
            for(int j = i + 1; j < misspelledWords.size(); j++){
                if(word.equals(misspelledWords.get(j))){
                    misspelledWords.remove(j);
                    j--;
                }
            }
        }
        // Convert ArrayList to array
        String[] words = new String[misspelledWords.size()];
        for(int i = 0; i < words.length; i++){
            words[i] = misspelledWords.get(i);
            System.out.println(words[i]);
        }
        return words;
    }
    public boolean binarySearch(String[] dictionary, String[] text, String currentWord){
        // Calculate midpoint
        int low = 0;
        int high = dictionary.length - 1;
        int currentLetter = 0;
        System.out.println(currentWord);
        while(low <= high){
            System.out.println("low: " + low);
            System.out.println("high: " + high);
            int mid = (high - low) / 2 + low;
            System.out.println("mid: " + mid);
            System.out.println(dictionary[mid]);
            // Check if word is in dictionary
            if(dictionary[mid].equals(currentWord)){
                return true;
            }
            // Check if they have the same letter so you can search based on the other letters
            if(currentWord.charAt(currentLetter) == dictionary[mid].charAt(currentLetter)){
                currentLetter++;
            }
            // Check if first letter of current word is less than first character of midpoint word
            if(currentWord.charAt(currentLetter) < dictionary[mid].charAt(currentLetter)){
                high = mid - 1;
            }
            else if(currentWord.charAt(currentLetter) > dictionary[mid].charAt(currentLetter)){
                low = mid + 1;
            }
            // If letters are equal case
            else{

            }
        }
        return false;
    }

         */
    }
}
