package arrays;

public class SortZerosOnes {



    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,0,0,1,0};
        int zeroCount = 0;
        for (int i : arr) {
            if(i == 0){
                zeroCount++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
           if(zeroCount > 0){
               arr[i] = 0;
               zeroCount--;
           }
           else{
               arr[i] = 1;
           }
        }

        for (int i:arr) {
            System.out.println(i);
        }
    }
}
