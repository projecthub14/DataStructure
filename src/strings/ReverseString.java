package strings;

public class ReverseString {

    public static String reverseIterative(String str){
        char[] tempArray = str.toCharArray();
        for (int i = 0,j= tempArray.length -1 ; i < j; i++,j--) {
           char temp = tempArray[i];
           tempArray[i] = tempArray[j];
           tempArray[j] = temp;
        }
        return String.valueOf(tempArray);
    }

    public static void reverseRecursive(String str){
       if(str.length() == 1){
           System.out.println(str);
       }
       else{
           System.out.println(str.charAt(str.length()-1));
           reverseRecursive(str.substring(0,str.length()-1));
       }
    }

    public static void reverseRecursive2(char[] str,int i){
       int n = str.length;
       if(i == n/2){
           return;
       }
       swap(str,i, n-i-1);
       reverseRecursive2(str,i+1);
    }

    public static char[] swap(char[] str1, int i , int j){
          char temp = str1[i];
          str1[i] = str1[j];
          str1[j] = temp;
          return str1;

    }

    public static void main(String[] args) {
        char[] str = "sowmya sowmya".toCharArray();
        reverseRecursive2(str,0);
        System.out.println(String.valueOf(str));
        System.out.println(reverseIterative("sowmya"));
    }
}
