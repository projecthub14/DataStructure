package number;

public class NumberPalindrome {


    private static boolean isPalindromeNumber(int number){
        int reverse = 0;

        while(number > 0){
            reverse = reverse*10 + number %10;
            number = number /10;
        }
        return (reverse == number);

    }

    public static void main(String[] args) {

        System.out.println(isPalindromeNumber(343));

    }
}
