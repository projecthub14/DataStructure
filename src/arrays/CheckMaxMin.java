package arrays;

public class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int maxIdx  = arr.length - 1;
        int minIdx = 0;

        int maxElement = arr[maxIdx] +1;

        for (int i = 0; i < arr.length ; i++) {
            if(i%2 == 0) {
                arr[i] += (arr[maxIdx] % maxElement) * maxElement;
                maxIdx--;
            }
            else {
                arr[i] += (arr[minIdx] % maxElement) * maxElement;
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arr[i] / maxElement;
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void maxMin2(int[] arr) {
          int maxId = arr.length -1;
          int minId = 0;
          boolean switchPointer = true;
          int[] result = new int[arr.length];

        for (int i = 0; i <  arr.length ; i++) {
             if(switchPointer) {
                 result[i] = arr[maxId--];
             }
             else {
                result[i] = arr[minId++];
             }
             switchPointer = !switchPointer;
        }

        for (int i = 0; i < arr.length ; i++) {
            arr[i] =result[i];
        }

        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Array before rearrange : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Array after rearrange : ");
        maxMin(arr);
        System.out.println(" ");
        System.out.println("Array after rearrange : ");
        maxMin2(arr1);
    }
}
