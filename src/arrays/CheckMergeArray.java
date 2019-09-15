package arrays;

public class CheckMergeArray {

    // merge arr1 and arr2 into a new result array
    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        // write your code here

        int m = arr1.length;
        int n = arr2.length;

        //initialize result array
        int size = m + n;
        int[] mergeArray = new int[size];

        int resultIndex = 0;
        int mi =0;
        int ni = 0;
        while(mi < m && ni < n)
        {
            if(arr1[mi] < arr2[ni] )
            {
                mergeArray[resultIndex++] = arr1[mi++];


            }
            else {
                mergeArray[resultIndex++] = arr2[ni++];

            }
        }
        while(mi < m)
        {
            mergeArray[resultIndex++] = arr1[mi++];
        }
        while(ni < n)
        {
            mergeArray[resultIndex++] = arr2[ni++];
        }

        return mergeArray; // make a new resultant array and return your results in that
    }

    public static void main(String[] args) {

        int[] arr1 = {3,9,14,17,20};
        int[] arr2 = {6,11,16,19,21,33};

        int[] results = mergeArrays(arr1,arr2);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }


    }
}