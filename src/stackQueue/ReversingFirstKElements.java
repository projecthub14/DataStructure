package stackQueue;

public class ReversingFirstKElements<V> {

    //1. Push first k elements in queue to stack
    //2. Pop stack elements and enqueu them to end of queue
    //3. Dequeue queue till "k" elements and append them at end of queue

    public static<V> void reverseKElements(Queue<V> queue,int k){

        if(queue.isEmpty() || k <= 0) {
            return;
        }
        Stack<V> stack = new Stack<>(k);

        while(!stack.isFull()) {
            stack.push(queue.dequeue());
        }
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        int size = queue.getCurrentSize();
        for(int i =0;i < size - k ;i++) {
            queue.enqueue(queue.dequeue());
        }

    }

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        reverseKElements(queue,5);

        System.out.println("Queue is :");
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue() + " ");
        }


    }

}
