package stackQueue;

public class MinStack<V> {

    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    //constructor
    public MinStack(int maxSize) {
        //1. Use two stacks
        //2. mainStack to hold original values
        //3. minStack to hold minimum values
        //4. top of minStack will always return minimum values of main stack

        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }


    //pushes value into stack
    public void push(Integer value) {

        //1. Push value into mainStack and check that value with
        // top value of minStack
        //2. If the value is greater than top
        // then push top value in minStack
        //else push value in minStack
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value) {
            minStack.push(minStack.top());
        }
        else{
            minStack.push(value);
        }
    }

    //removes and returns value from stack
    public int pop(){
        //1. Pop element from minStack to make it sync with mainStack
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }


    //returns min() value in O(1)
    public int min() {
        return minStack.top();
    }



    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>(6);

        minStack.push(5);
        minStack.push(12);
        minStack.push(4);
        minStack.push(10);
        minStack.push(9);
        minStack.push(1);


        System.out.println("Minimum value is " + minStack.min());

        minStack.pop();
        minStack.pop();

        System.out.println("Minimum value is " + minStack.min());


    }



}
