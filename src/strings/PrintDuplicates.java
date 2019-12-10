package strings;

import java.util.HashMap;

public class PrintDuplicates {

    public static void main(String[] args) {
        String str = "ssowMmya";
        HashMap<Character,Integer> map = new HashMap<>();
        str = str.toLowerCase();
        for(char ch : str.toCharArray()){
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            if(map.get(ch) > 1){
                System.out.println(ch);
            }
        }
    }
}
