package arrays;

public class HappyNumber {

    public static int sqaureNumber(int n){
        int sqNum = 0;
        while(n!=0){
            sqNum += (n%10) * (n%10);
            n = n /10;
        }
        return sqNum;
    }

    public static boolean happyNumber(int n){
        int slow = n;
        int fast = n;
        do{
            slow = sqaureNumber(slow);
            fast = sqaureNumber(sqaureNumber(fast));
        }
        while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        System.out.println(happyNumber(19));

    }
}
