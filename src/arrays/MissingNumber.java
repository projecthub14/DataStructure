package arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2,7,8,9};

        int sum = 0;
        for (int i = 0; i <arr.length-1 ; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        int n = arr.length;
        int total = (n * (n+1)) / 2;
        System.out.println(total);
        System.out.println(total - sum);
    }
}
