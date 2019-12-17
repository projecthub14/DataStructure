package trie;

import java.util.Arrays;

public class Trie {

    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public int getIndex(char t){
        return t - 'a';
    }

    public void insert(String key){

        if(key == null){
            return;
        }
        TrieNode currentNode = this.root;
        int index = 0;
        key = key.toLowerCase();

        for(int level = 0; level < key.length() ; level++){
             index = this.getIndex(key.charAt(level));

            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }
        currentNode.markAsLeaf();
    }

    public boolean search(String key){
        if( key == null ){
            return false;
        }

        key = key.toLowerCase();
        int index =0;
        TrieNode currentNode = this.root;
        for(int level = 0; level < key.length() ; level++){
            index = this.getIndex(key.charAt(level));
            if(currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }

        if(currentNode.isEndWord){
            return true;
        }
        return false;
    }

    public boolean hasNoChildren(TrieNode currentNode){

        for(int i = 0; i< currentNode.children.length ;i++){
            if(currentNode.children[i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean deleteHelper(String key , TrieNode currentNode , int length , int level){

        boolean deleteSelf = false;
        if(currentNode == null){
            return deleteSelf;
        }

        if(level == length){
            if(hasNoChildren(currentNode)){
                currentNode = null;
                deleteSelf = true;
            }
            else {
                currentNode.unmarkAsLeaf();
                deleteSelf = false;
            }
        }
        else{
           TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
           boolean childDeleted = deleteHelper(key,childNode, length , level+1);

           if(childDeleted){
               currentNode.children[getIndex(key.charAt(level))] = null;

               if(currentNode.isEndWord){
                   deleteSelf = false;
               }
               else if(!hasNoChildren(currentNode)){
                   deleteSelf = false;
               }
               else{
                   currentNode = null;
                   deleteSelf =true;
               }
           }
           else{
               deleteSelf = false;
           }
        }
        return deleteSelf;
    }



    public void delete(String key){

        if(key == null || root == null){
            System.out.println("Null Key or Empty trie error");
            return;
        }

        deleteHelper(key , this.root, key.length() , 0);

    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        int i;
        for (i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        // Search for different keys and delete if found
        if(t.search("the") == true)
        {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        }
        else System.out.println("the --- " + output[0]);

        if(t.search("these") == true)
        {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        }
        else System.out.println("these --- " + output[0]);

        if(t.search("abc") == true)
        {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        }
        else System.out.println("abc --- " + output[0]);

        // check if the string has deleted correctly or still present
        if(t.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
     }
    }


