package heap;

import java.util.Arrays;

public class MaxHeap {

    //Time complexity : O(n)
    public static void maxHeapify(int[] heapArray, int index , int heapSize){

        int largest = index;
        while(largest < heapSize/2){ // check parent node only
            int left = 2 * index + 1; // left child
            int right = 2 * index + 2; // right child
            if(left < heapSize && heapArray[index] < heapArray[left]){
                largest = left;
            }
            if(right < heapSize && heapArray[largest] < heapArray[right]){
                largest = right;
            }
            if(largest!=index){ // swap parent with largest child
                int temp = heapArray[largest];
                heapArray[largest] = heapArray[index];
                heapArray[index] = temp;
                index = largest;
            }
            else{
                break; //if heap is satisfied
            }
        }//end of while
    }


    public static void  buildMaxHeap(int[] heapArray , int heapSize){
        for (int i = (heapSize -1)/2; i >= 0 ; i--) {
            //swap largest child to parent node
            maxHeapify(heapArray,i , heapSize );
        }
    }


    public static void main(String[] args) {

        int[] heapArray = {1,4,7,12,15,14,9,2,3,16};
        System.out.println("Before heapify " + Arrays.toString(heapArray));
        buildMaxHeap(heapArray, heapArray.length);
        System.out.println("after heapify " + Arrays.toString(heapArray));
    }
}
