package arrays;

public class ProductArray {

    public static int[] prodArray(int[] arr) {
        int[] result = new int[arr.length];
        int temp =1;
        for (int i = 0; i < arr.length; i++) {
            result[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for (int i = arr.length-1; i >=0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,3,4};
        int[] results =  prodArray(arr);

        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }

    }
}
