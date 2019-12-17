package trie;

import java.util.Arrays;

public class DictWord {

    public static boolean  isFormationPosssible(String[] dict , String word,Trie trie){
        if(word.length() < 2 || dict.length < 2){
            return false;
        }



        for(int i = 0 ;i<word.length();i++){
            String first = word.substring(0,i);
            String second = word.substring(i,word.length());

            if(trie.search(first) && trie.search(second)){
                return true;
            }
        }
        return false;
    }


        public static void main(String args[]){
            // Input dict (use only 'a' through 'z' and lower case)
            String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};

            Trie t = new Trie();

            System.out.println("Keys: "+ Arrays.toString(dict));

            // Construct trie

            int i;
            for (i = 0; i < dict.length ; i++)
                t.insert(dict[i]);

            if(isFormationPosssible(dict, "helloworld",t))
                System.out.println("true");
            else
                System.out.println("false");

        }

}
