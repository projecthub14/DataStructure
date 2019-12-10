package heap;

public class CheckSmall {


    public static int[] findKSmallest(int[] arr , int k){

        if(k <=arr.length){
            int[] result = new int[k];
            for (int i = 0; i <k ; i++) {
                result[i] = removeMin(arr,arr.length);
            }
            return result;
        }

        System.out.println("Value of k out of bounds" + k);
        return arr;

    }

    public static int removeMin(int[] heapArray, int heapSize){
        MinHeap.buildMinHeap(heapArray,heapSize);
        int min = heapArray[0];
        heapArray[0] = heapArray[--heapSize];
        return min;
    }

    public static void main(String[] args) {

        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKSmallest(input, 2);

        for(int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }
}
