package stackQueue;

public class QueueUsingStack<V> {

    private Stack<V>  stack1;
    private Stack<V> stack2;

    public QueueUsingStack(int maxSize) {
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    // takes constant time O(1)
    public void enqueue(V value) {
        stack1.push(value);
    }

    //time complexity of dequeue operation is O(n)
    public V dequeue(){
        //Traverse stack1 and pop all elements to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //pop from stack2 (which is end of stack1)
        V result = stack2.pop();

        //traverse stack2 and put all elements back to stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {

        QueueUsingStack<Integer> queueStack = new QueueUsingStack<>(6);

        queueStack.enqueue(5);
        queueStack.enqueue(7);
        queueStack.enqueue(8);
        queueStack.enqueue(10);
        queueStack.enqueue(17);
        queueStack.enqueue(24);

        System.out.println("Queue using stack is : ");

        while (!queueStack.isEmpty()) {
            System.out.println(queueStack.dequeue() + " ");
        }

    }
}
