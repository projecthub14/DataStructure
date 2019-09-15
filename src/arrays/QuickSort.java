package arrays;

public class QuickSort {

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
