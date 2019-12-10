package heap;

import java.util.Arrays;

public class MinHeap {

    //Time complexity : O(n)
    public static void minHeapify(int[] heapArray, int index , int heapSize){

        int smallest = index;
        while(smallest < heapSize/2){ // check parent node only
            int left = 2 * index + 1; // left child
            int right = 2 * index + 2; // right child
            if(left < heapSize && heapArray[left] < heapArray[index]){
                smallest = left;
            }
            if(right < heapSize && heapArray[right] < heapArray[smallest]){
                smallest = right;
            }
            if(smallest!=index){ // swap parent with largest child
                int temp = heapArray[smallest];
                heapArray[smallest] = heapArray[index];
                heapArray[index] = temp;
                index = smallest;
            }
            else{
                break; //if heap is satisfied
            }
        }//end of while
    }


    public static void  buildMinHeap(int[] heapArray , int heapSize){
        for (int i = (heapSize -1)/2; i >= 0 ; i--) {
            //swap smallest child to parent node
            minHeapify(heapArray,i , heapSize );
        }
    }


    public static void main(String[] args) {

        int[] heapArray = {31, 11, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println("Before heapify " + Arrays.toString(heapArray));
        buildMinHeap(heapArray, heapArray.length);
        System.out.println("after heapify " + Arrays.toString(heapArray));
    }
}
