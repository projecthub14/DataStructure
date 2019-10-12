package arrays;

public class MaxContiguousSubArray {
//https://backtobackswe.com/videos/max-contiguous-subarray-sum

    public static int maxSubArray(int[] a){
        int maxPrevious = a[0];
        int maxSubArray = a[0];
        for (int i = 1; i < a.length ; i++) {
            maxPrevious = Math.max(maxPrevious+ a[i],a[i]);
            maxSubArray = Math.max(maxPrevious,maxSubArray);
        }
        return maxSubArray;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max Sub Array " + maxSubArray(a));
    }
}
