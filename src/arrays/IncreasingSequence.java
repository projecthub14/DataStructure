package arrays;

import java.util.Arrays;

public class IncreasingSequence {

    public static int lengthLIS(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int len = 0;
        int i =0;
        for(int num : arr){
            i = Arrays.binarySearch(dp,0,len,num);
            if(i<0){
                i = -(i+1);
            }
            dp[i] = num;
           if(i==len){
               len++;
           }
        }
        return len;

    }

    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2};
        System.out.println(lengthLIS(arr));
    }
}
