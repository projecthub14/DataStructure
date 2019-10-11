package arrays;

public class MedianSortedArrays {


    public static double findMedianSortedArrays(int[] input1, int[] input2){

        //if input 1 is greater than switch them so that input1[] is smaller than input2
        if(input1.length > input2.length){
            return findMedianSortedArrays(input2,input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while(low<=high){

            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //partitionX = 0  means nothing there on left side , use -INF for maxLeftX
            //partitionX = x  means nothing there on right side , use +INF for minRightX
            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : input1[partitionX-1];
            int minRightX = (partitionX == x)? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                //We have partitioned at correct place
                //Now we get max of left elements and min of right elements to get median in case of even array size
                //or get max of left in case of odd length combine array size
                if((x + y) % 2 ==0){
                    return ((double)(Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2);
                }
                else{

                    return ((double)Math.max(maxLeftX,maxLeftY));
                }
            }
            else if(maxLeftX > minRightY){ // we are too far on right side for partitioX , go to left side
                high = partitionX -1;
            }
            else{
                // we are too far on left side for partitionX , go to right side
                low = partitionX +1;
            }

        }
        //only we can come here if input arrays are not sorted , throw in that scenario
        throw new IllegalArgumentException();


    }

    public static void main(String[] args) {
        int[] x = {3,4};
        int[] y = {1,2};

        System.out.println("Median is " + findMedianSortedArrays(x,y));
    }
}
