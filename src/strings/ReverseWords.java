package strings;

public class ReverseWords {

    public static void main(String[] args) {
        String[] str = "I    love to write code".split(" ");
        String result = "";
        for(int i = str.length -1 ; i >= 0 ; i--){
            result += str[i] + " ";
        }
        System.out.println("Reversed String ");
        System.out.println(result.substring(0,result.length() -1 ));
    }
}
