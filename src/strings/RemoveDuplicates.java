package strings;

import java.util.HashSet;

public class RemoveDuplicates {


    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        String str = "aabbtrerkejnnweweee";
        for (char ch:str.toCharArray()) {
            set.add(ch);
        }
        for (char ch : set) {
            System.out.print(ch);
        }
    }
}
