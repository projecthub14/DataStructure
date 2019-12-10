package strings;

public class PangramChecking {

    //Time Complexity: O(n)
    public static boolean checkPangram(String str){

        boolean[] checkPresent = new boolean[26];
        int index =0;
        for(char ch : str.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                index = ch - 'A';
            }
            else if(ch >= 'a' && ch <= 'z'){
                index = ch - 'a';
            }
            checkPresent[index] = true;
        }

        for(boolean val : checkPresent){
            if(!val){
               return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";

        if (checkPangram(str) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str+ " is not a pangram.");
    }
}
