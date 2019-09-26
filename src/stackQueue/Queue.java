package stackQueue;

public class Queue<V> {

    private int maxSize;
    private int currentSize;
    private int front;
    private int back;

    private V[] arr;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        front = 0;
        back = -1;
        currentSize = 0;

        arr = (V[])new Object[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public V top() {
        return arr[front];
    }

    public void enqueue(V value) {
        if(isFull()){
            System.out.println("Queue is full ");
            return;
        }
        back = (back + 1) % maxSize; // to keep the index in range
        arr[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if(isEmpty()) {
            System.out.println( " Queue is empty ");
            return null;
        }
        V temp = arr[front];
        front = (front + 1) % maxSize; // to keep the index in range
        currentSize--;

        return temp;
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>(5);

        //enqueue 2 4 6 8 10  at the end
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);

        //dequeue 2 elements from start

        queue.dequeue();
        queue.dequeue();

        //enqueue 12 and 14 at end
        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue is ");
        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " ");
        }



    }







}
