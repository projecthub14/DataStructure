package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramVariation {


    public static void anangramOccurence(String str){
        String[] s = str.split("\\s+");
        HashMap<String, List<String>> map = new HashMap<>();

        for(String input : s){
            String temp = input.toLowerCase();
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<String>());
            }
            map.get(temp).add(input);

        }




        int count = 0;
        for(Map.Entry<String,List<String>> mapEntry : map.entrySet()){
            if(map.get(mapEntry.getKey()) != null){
                if(mapEntry.getKey().equals("eclipse")){
                    System.out.println(mapEntry.getValue().size());
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {

        String str = "This sia eclipse random Eclipse ecliPse not a valid ECLIPSE sdfdsf sdfd";
        anangramOccurence(str);
    }
}
