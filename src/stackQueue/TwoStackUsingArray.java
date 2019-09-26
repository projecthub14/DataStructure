package stackQueue;

//logic is to start stacks at extreme ends
//Top of stack1 from extreme left of array ie: top1 = 0;
//Top of stack2 from extreme right of array ie: top2 = size -1 ;

//Operation take O91) as array is indexed and not resized
public class TwoStackUsingArray<V> {

    private int maxSize;
    private int top1;
    private int top2; // store top value indices of stack1 and stack2
    private V[] arr;

    public TwoStackUsingArray(int maxSize) {
        int top1 = -1;
        int top2 = maxSize -1;
        V[] arr = (V[]) new Object[maxSize]; // type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {
        if(top1 < top2 -1){
            arr[++top1] = value;
        }
        else {
            System.out.println("Stack is full");
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if(top1 < top2 -1) {
            arr[--top2] = value;
        }
        else {
            System.out.println("Stack is full");
        }
    }

    //removes and return value from top of first stack
    public V pop1() {
        if(top1 > -1) {
            return arr[top1--];
        }
        else {
            System.out.println("Stack is Empty");
        }
        return null;
    }

    //removes and return value from top of second stack
    public V pop2() {
         if(top2 < maxSize){
             return arr[top2++];
         }
         else {
             System.out.println("Stack is Empty");
         }
         return null;
    }
}
