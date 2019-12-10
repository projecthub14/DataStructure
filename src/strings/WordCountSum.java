package strings;

import java.util.*;

public class WordCountSum {

    private static void wordCountSum(String sentence,int target){

        String[] words = sentence.split("\\s+");
        HashMap<String , Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (String word:words) {
            map.put(word,map.getOrDefault(word,0)+1);
            maxFreq = Math.max(maxFreq,map.get(word));
        }

        List[] bucket = new List[maxFreq+1];

        for(String word : map.keySet()){
            int frequency = map.get(word);
            if(bucket[frequency] == null){
               bucket[frequency] = new ArrayList<String>();
            }
            bucket[frequency].add(word);
        }

        for (int i =bucket.length -1; i >=0 ; i--) {
            int sum = target - i;
            if(bucket[i] != null && bucket[sum] !=null){
               for(int outer = 0; outer < bucket[i].size();outer++){
                   for (int j = 0; j < bucket[sum].size() ; j++) {
                       System.out.println("(" + bucket[i].get(outer) +" ,  "+ bucket[sum].get(j) + ")");

                   }

               }
                return;

            }
        }


    }

    public static  String getKey(int count,HashMap<String,Integer> map){
        for(Map.Entry<String , Integer> entrySet : map.entrySet()){
            if(count == entrySet.getValue()){
                return entrySet.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String sentence = "i am this solving word count problem i this word i yes";
        wordCountSum(sentence,3);
    }
}
