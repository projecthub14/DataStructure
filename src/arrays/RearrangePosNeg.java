package arrays;

public class RearrangePosNeg {

    public static void reArrange(int[] arr) {
        int count = 0;
        int j = 0;
       for (int i : arr) {
           if(i < 0) {
               count++;
           }
       }
        for (int i = 0; i <arr.length ; i++) {

            if(count > 0 && arr[i] <0) {
                if(i!=j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    count--;
                }
                j++;
            }


        }

        System.out.println(arrayToString(arr));
    }

    public static String arrayToString(int[] arr) {
        String arrStr = " ";
        if(arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                arrStr += arr[i] + " ";
            }
            return arrStr;
        }
        else {
            return "Empty String";
        }


    }

    public static void main(String[] args) {
        int[] arr1 = {10, -1, 20, 4, 5, -9, -6};
        System.out.println(arrayToString(arr1));
        reArrange(arr1);
    }
}
