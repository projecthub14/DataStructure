package strings;

public class IncrementLastDigit {

    public static void main(String[] args) {
        String str = "String09i";
        char[] charStr = str.toCharArray();
        char lastIndexValue = charStr[charStr.length-1];
        int lastDigit = 0;

        if(Character.isDigit(lastIndexValue)){
             lastDigit = Character.getNumericValue(lastIndexValue);
             lastDigit++;
             str = str.substring(0,str.length() -1) + lastDigit;
        }
        else{
            lastDigit = 1;
            str = str + lastDigit;
        }

        System.out.println(str);




    }
}
