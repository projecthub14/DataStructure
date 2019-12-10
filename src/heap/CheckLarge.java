package heap;

public class CheckLarge {

    public static int[] findKLargest(int[] arr , int k){

        int arrSize = arr.length;

        if(arrSize > k){
            int[] result = new int[k];
            for (int i = 0; i <k ; i++) {
                result[i] = removeMax(arr, arr.length);
            }
            return result;
        }
        else{
            System.out.println("Value of k " + k + " is out of bound");
        }

        return arr;

    }

    public static int removeMax(int[] heapArray , int heapSize){

        MaxHeap.buildMaxHeap(heapArray,heapSize);
        int max = heapArray[0];
        heapArray[0]= heapArray[--heapSize];
        return max;

    }

    public static void main(String[] args) {

        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKLargest(input, 2);

        for(int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }
    }


