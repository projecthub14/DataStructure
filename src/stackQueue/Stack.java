package stackQueue;

//Constructor
//getMaxSize()
//isFull()
//isEmpty()
//top()

public class Stack<V> {

    private int maxSize;
    private int top;
    private V[] arr;

    //Java doenot allow generic type arrays. So we have used Object type
    // and type casted it to generic type V
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        top = -1; // initially when the stack is empty
        arr = (V[]) new Object[maxSize]; // type case Object[] to V[]
    }

    public int getMaxSize() {
        return maxSize;
    }

    //returns true if Stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //returns true if stack is full
    public boolean isFull() {
        return top == maxSize-1;
    }

    //returns value at top of list
    public V top() {
        if(isEmpty()){
            return null;
        }
        return arr[top];
    }

    //inserts value at top of stack
    public void push(V value) {
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        // increments top and adds  value to updated top
        arr[++top] = value;
    }

    //removes value from top of stack and returns value
    public V pop(){
        if(isEmpty()) {
            System.out.println("Stack is Empty ");
            return null;
        }
        return arr[top--]; // return value of top and then decrements top

    }

    public void printStack(Stack<V> stack) {

        System.out.println("Stack is ");
        for (int i = stack.top; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(6);

        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.printStack(stack);
        stack.pop();

        System.out.println("Stack after pop : ");
        stack.printStack(stack);



    }




}
