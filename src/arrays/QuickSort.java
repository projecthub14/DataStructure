package arrays;

public class QuickSort {

    //Pivot , Partitioning

    //a. job of partition sub routine is to find pivot
    //b. pivot is the value within the partititon space that I want to find a position for
    //c. return index of pivot

    //we randomly choose pivot

    //a. i -> remember last position that element was placed in , that was less than pivot
    //b. j -> scan from L to R-1 and see if they are greater than or less than pivot

    public static int partition(int[] arr,int low,int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot)  // current element smaller than pivot
            {
                i++;
                //swap arr[i](index of smaller element) and arr[j](current element)
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void sort(int[] arr , int low,int high) {
        //a. splits the input
        //b. calls the partition at first and we get pivot from partition step
        //c. run our trees going left and right
        if(low < high)
        {
            int partition = partition(arr,low,high);
            sort(arr,low,partition-1);
            sort(arr,partition + 1 , high);
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        sort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}
