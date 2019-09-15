package arrays;

public class CheckSum {

    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        // write your code here

        QuickSort.sort(arr,0,arr.length-1);
        int i=0,j=arr.length-1;
        while (i<j) {
            if(arr[i]+arr[j] > n)
            {
                j--;
            }
            else if(arr[i]+arr[j] < n)
            {
                i++;
            }
            else {
                result[0] = arr[i];
                result[1] = arr[j];
                return result;
            }
        }

        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String[] args) {

        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int n = 63;
        int[] results = findSum(arr,n);
        int num1 = results[0];
        int num2 = results[1];
        if(num1 + num2 == n)
        {
            System.out.println("result is " + num1 + " " + num2 );
        }
        else
        {
            System.out.println("Result not found");
        }
    }
}
