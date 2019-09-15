package arrays;

public class CheckRemoveEven {
    public static int[] removeEven(int[] arr) {

        // Write - Your - Code- Here
        int oddCount = 0;
        //Find the number of Odd elements in arr
        for(int i=0;i< arr.length ;i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        //create result array with size equal to number of odd elements
        int[] oddArr = new int[oddCount];
        int resultIndex = 0;
        //Put the odd values to result array
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] % 2 != 0) {
                oddArr[resultIndex++] = arr[i];
            }
        } // end of loop

        return oddArr; //  return the correct result array
    }

    public static void main(String[] args)  {

        int size = 10;
        int[] arr = new int[size]; //declaration and instantiation

        for (int i = 0; i < size; i++) {
            arr[i] = i; // assigning values
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int[] result = removeEven(arr);


        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " "); // printing array
        }
    }
}
