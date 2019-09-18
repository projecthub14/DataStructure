package arrays;

/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
*/

public class DuplicateNumInclusive {

    public static int findDuplicateInclusive(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
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
        int[] num = {1,3,4,2,2};
        System.out.println("Array: " + arrayToString(num));
        int result = findDuplicateInclusive(num);
        System.out.println("First Unique chracter " + result);

    }
}
