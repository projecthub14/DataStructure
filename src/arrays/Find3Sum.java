package arrays;

import java.util.HashSet;

public class Find3Sum {


    public static boolean find3Numbers(int[] A , int arr_size, int sum){

        for(int i =0;i< A.length-2 ;i++){
            int curr_sum = sum - A[i];
            HashSet<Integer> set = new HashSet<>();
            for(int j = i+1 ;j<A.length ;j++){
                if(set.contains(curr_sum - A[j]) && curr_sum - A[j] != (int) set.toArray()[set.size()-1]){
                    System.out.println(A[i] + ", " + A[j] + ", " + (curr_sum - A[j]));
                    return true;
                }
                else{
                    set.add(A[j]);
                }
            }
        }
        return false;

    }

    public static boolean findTripletZero(int[] arr,int n){

        for (int i = 0; i <arr.length-2 ; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i+1; j <arr.length ; j++) {
                int x = -(arr[i] + arr[j]);
                if (set.contains(x)) {
                    System.out.println(arr[i] + "," + arr[j] + "," + x );
                     return true;
                }
                else{
                    set.add(arr[j]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int arr[] ={-1,0,1,2,-1,-4};
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
        findTripletZero(arr,arr.length);
    }
}
