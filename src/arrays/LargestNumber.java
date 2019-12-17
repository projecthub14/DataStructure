package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private class LargestNumberComparator implements Comparator<String>{

        public int compare(String a , String b){
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }

    public  String largestNumber(int[] nums){
        String[] asStrs = new String[nums.length];
        for (int i = 0; i <nums.length ; i++) {
           asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, new LargestNumberComparator());

        if(asStrs[0].equals("0")){
            return "0";
        }
        String result = new String();
        for(String str : asStrs){
           result+=str;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        LargestNumber largeNum = new LargestNumber();
        System.out.println(largeNum.largestNumber(nums));
    }


}
