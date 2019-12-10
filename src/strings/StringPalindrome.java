package strings;

import java.util.stream.IntStream;

public class StringPalindrome {

    public static  boolean isPalindrome(String str){
         str = str.replaceAll("\\s+","").toLowerCase();

         int begin = 0;
         int end = str.length() -1;
         while(begin < end){
             if(str.charAt(begin) != str.charAt(end)){
                 return false;
             }

                 begin++;
                 end--;

         }
         return true;
    }

    public static boolean isPalindromeReverseString(String text){
        StringBuilder reverse = new StringBuilder();
        text = text.replaceAll("\\s+","").toLowerCase();
        char[] input = text.toCharArray();
        for (int i = input.length-1; i >=0 ; i--) {
            reverse.append(input[i]);
        }
        return reverse.toString().equals(text);


    }

    public boolean isPalindromeUsingStringBuilder(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    public boolean isPalindromeUsingStringBuffer(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuffer plain = new StringBuffer(clean);
        StringBuffer reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    public static  boolean isPalindromeStream(String str){
        String temp  = str.replaceAll("//s+", "").toLowerCase();
        return IntStream.range(0,temp.length()/2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

    public static boolean isPalindromeRecursion(String str){
        String temp  = str.replaceAll("//s+", "").toLowerCase();
        return recursivePalindrome(str,0,temp.length() -1);
    }

    public static boolean recursivePalindrome(String str,int begin , int end){

        if(begin == end){
            return true;
        }
        if(str.charAt(begin) != str.charAt(end)){
            return false;
        }
        if(begin < end ){
            recursivePalindrome(str,begin+1 , end-1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeRecursion("anaana"));

    }
}
