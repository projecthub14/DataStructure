package arrays;

public class SumAddOne {

    public static void main(String[] args) {
        int[] arr = {2,5,7,8,3,5};
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
            sum +=arr[i];
        }
        System.out.println("result " + sum);
    }
}
