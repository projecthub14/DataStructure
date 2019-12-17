package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllWords {

    public static void getAllWords(TrieNode currentNode, ArrayList<String> result, char[] str, int level){


        if(currentNode.isEndWord){
            String temp = "";
            for(int i = 0; i< level;i++){
                temp += Character.toString(str[i]);
            }
           result.add(temp);
        }
        for(int i = 0 ; i< 26 ; i++){
            if(currentNode.children[i] != null){
                str[level] = (char)(i + 'a');
                getAllWords(currentNode.children[i],result,str,level+1);
            }
        }
    }

    public static ArrayList<String> findWords(TrieNode root){
        ArrayList<String> result = new ArrayList<>();
        char[] charArr = new char[20];
        getAllWords(root,result,charArr,0);
        return result;
    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.root);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
