package trie;

public class TrieNode {

    TrieNode[] children;
    boolean isEndWord;

    public TrieNode(){
        children = new TrieNode[26];
        isEndWord = false;
    }

    public void markAsLeaf(){
        this.isEndWord = true;
    }

    public void unmarkAsLeaf(){
        this.isEndWord = false;
    }
}
