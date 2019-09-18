package arrays;

public class RotateArray {

    public static int[] rotateArray(int[] arr){

        // Write - Your - Code
        int len = arr.length;
        int last = arr[len-1];

        for (int i = len-1; i >=1 ; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] =last;
        return arr;
    }

    public static int[] rotate(int[] nums, int k) {
        k %=nums.length;
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        return nums;

    }

    public static void  reverse(int[] nums,int start , int end)
    {
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static String arrayToString(int[] arr) {
        String arrStr = " ";
        if(arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                arrStr += arr[i] + " ";
            }
            return arrStr;
        }
        else {
            return "Empty String";
        }


    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {1,2,3,4,5};
        System.out.println(arrayToString(arr));
        System.out.println( arrayToString(rotateArray(arr)));
        System.out.println( arrayToString((rotate(arr1,1))));
    }
}
