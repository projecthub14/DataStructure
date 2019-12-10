package arrays;

import java.util.LinkedHashMap;

public class FirstRepeatNonRepeat {

    public static void firstRepeatNonRepeat(String str){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i <str.length()-1 ; i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i) , map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i),1);
            }
        }
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                System.out.println("Non repeated character " + c);
                break;
            }


        }
        for(char c : map.keySet()){
            if(map.get(c) > 1){
                System.out.println("Repeated character " + c);
                break;
            }
        }
    }

    public static void main(String[] args) {
        String str = "JavaConceptOfDay";
        firstRepeatNonRepeat(str);
    }
}
