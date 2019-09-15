package arrays;

public class CheckMinimum {


    public static int findMinimum(int[] arr) {

        // Write your code here
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i])
            {
                min = arr[i];
            }

        }
        return min;
    }

    public static void main(String[] args) {
       int[] arr = {34,12,54,8,2};
        System.out.println("Minimum value is " + findMinimum(arr));
    }
}
