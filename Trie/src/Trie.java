import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 12/22/13
 * Time: 3:37 AM
 * To change this template use File | Settings | File Templates.
 */

class TrieNode{

    private TrieNode parent;                //parent of curr node
    private boolean isLeaf;                 // Quick way to find terminal
    private boolean isWord;                 // A complete word or not
    private TrieNode[] children;            //children of curr node
    private char character;                 //current node value


    public TrieNode(){

        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }

    public TrieNode(char character){

        this();
        this.character = character;
    }

    protected void addWord(String word){

        isLeaf = false;

        // Find position in the children map
        int charPos = word.charAt(0) - 'a';

        //CHild doesn't exist add it. By default, isLeaf = true
        if(children[charPos] == null){

            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this;
        }

        //Child added(new node character) or not added(branching) in the previous statement, if length>1 then this  child is not leaf on recursion
        if(word.length() > 1){

            addWord(word.substring(1));
        }

        //Last node, isLeaf = true and isWord = true
        else children[charPos].isWord = true;


    }

    public String toString(){

        if (parent == null){

            return "";

        }

        else{

            return parent.toString() + new String(new char[] {character});

        }

    }

    protected List getWords() {
        //Create a list to return
        List list = new ArrayList();

        //If this node represents a word, add it
        if (isWord){

           
            list.add(toString());
        }

        //If any children
        if (!isLeaf){
            //Add any words belonging to any children
            for (int i=0; i<children.length; i++){

                if (children[i] != null){

                     List allWords = children[i].getWords();
                     list.addAll(allWords);

                }

            }

        }
        return list;
    }

    protected TrieNode getNode(char c){
        return children[c - 'a'];
    }
}



public class Trie{
    private TrieNode root;

    /**
     * Constructor
     */
    public Trie(){
        root = new TrieNode();
    }

    /**
     * Adds a word to the Trie
     * @param word
     */
    public void addWord(String word) {
        root.addWord(word.toLowerCase());
    }

    /**
     * Get the words in the Trie with the given
     * prefix
     * @param prefix
     * @return a List containing String objects containing the words in
     *         the Trie with the given prefix.
     */
    public List getWords(String prefix)  {
        //Find the node which represents the last letter of the prefix
        TrieNode lastNode = root;
        for (int i=0; i<prefix.length(); i++)
        {
            lastNode = lastNode.getNode(prefix.charAt(i));

            //If no node matches, then no words exist, return empty list
            if (lastNode == null) return new ArrayList();
        }

        //Return the words which eminate from the last node
        return lastNode.getWords();
    }
}