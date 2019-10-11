package arrays;

import java.util.LinkedList;
import java.util.Queue;

public class FindDuplicates {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        int m = arr2.length;
        int n = arr1.length;
        int i=0;
        int j =0;

        Queue<Integer> duplicates = new LinkedList<>();

        while(i<n && j< m){
            if(arr1[i] < arr2[j]){
                i++;

            }
            else if(arr1[i] > arr2[j]){
                j++;

            }
            else if(arr1[i] == arr2[j]){
                duplicates.add(arr1[i]);

                i++;
                j++;
            }

        }


        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] findDuplicateBinarySearch(int[] arr1 , int[] arr2){

        LinkedList<Integer> duplicate = new LinkedList<>();
        for (int num1:arr1) {
            if (binarySearchDuplicate(arr2, num1) != -1) {
                duplicate.add(num1);
            }
        }

        return duplicate.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int binarySearchDuplicate(int[] arr , int num){
        int begin = 0;
        int end = arr.length -1;


        while(begin <= end){
            int mid = begin + ((end-begin)/2);
            if(arr[mid] < num){
                begin = mid + 1;
            }
            else if(arr[mid] > num){
                end = mid -1;
            }
            else{
                return mid; // return array index
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,5,6,7};
        int[] arr2 = {3,6,7,8,20};

        int[] result = findDuplicateBinarySearch(arr1,arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}