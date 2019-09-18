package arrays;

public class FirstUniqueNumber {

    public static int findDuplicate(int[] nums) {
        boolean isRepeated = false;
        for(int i =0 ;i<nums.length ;i++)
        {
            for(int j=0;j<nums.length ; j++)
            {
                if(nums[i] == nums[j] && i != j) {
                    isRepeated = true;
                    break;
                }


            }
            if(isRepeated == false)
            {
                return nums[i];
            }
            else {
                isRepeated = false;
            }

        }
        return -1;

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
        int[] num = {4,4,4,3};
        System.out.println("Array: " + arrayToString(num));
        int result = findDuplicate(num);
        System.out.println("First Unique chracter " + result);

    }
}
