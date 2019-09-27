package stackQueue;

import java.util.Arrays;

//Time complexity os O(n) better than brute force o(n2)
public class NextGreaterElement {


    public static int[] nextGreaterElement(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);
        //1. begin by iterating array in reverse order

        for(int i=arr.length-1;i>=0;i--){

            if(!stack.isEmpty()){
                //if top element is smaller then pop untill we find next
                //greater element
                while(!stack.isEmpty() && stack.top() < arr[i]){
                    stack.pop();
                }
            }

            //if no next greater elemnt then assign -1
            if(stack.isEmpty()){
                result[i] = -1;
            }

            //assign next greater elment in stack to result array
            else {
                result[i] = stack.top();
            }
            //to find next greater element in stack
            stack.push(arr[i]);

        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4,6,3,2,8,1,11};

        System.out.println("Input is " + Arrays.toString(arr));
        int[] result = nextGreaterElement(arr);

        System.out.println("Result is " + Arrays.toString(result));

    }
}
