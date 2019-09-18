package arrays;

public class SecondMaximum {

    public static int findSecondMaximum(int[] arr)
    {
        // Write - Your - Code
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
           if(arr[i] > max ) {
               secondMax = max;
               max = arr[i];

           }
           else if(secondMax < arr[i] && arr[i] != max) {
               secondMax = arr[i];
           }

        }
        return secondMax;
    }

    public static int thirdMax(int[] nums) {

        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for(Integer n : nums) {
            if(n.equals(max) || n.equals(secondMax) || n.equals(thirdMax)) continue;
            if(max == null || n > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            }

            else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            }
            else if(thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }

        return  thirdMax == null ? max : thirdMax;

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

        int[] arr = {1,2};
        System.out.println(arrayToString(arr));
        System.out.println("Second Maximum value is "  + findSecondMaximum(arr));
        System.out.println("Third Maximum value is "  + thirdMax(arr));

    }
}
