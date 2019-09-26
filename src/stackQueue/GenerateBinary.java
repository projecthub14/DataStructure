package stackQueue;

public class GenerateBinary {


    //Time Complexity is O(n)
    public static  String[] generateBinary(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<>(number + 1);
        queue.enqueue("1"); // First enqueue "1"


        for (int i = 0; i < number ; i++) {
            result[i] = queue.dequeue(); // dequeue value from queue
            String s1 = result[i] + "0"; // append 0 to it
            String s2 = result[i] + "1"; // append 1 to it

            queue.enqueue(s1); // enqueue it to back of queue
            queue.enqueue(s2); //enqueue it to back of queue
        }


        return result;
    }


    public static void main(String[] args) {

        String[] result = generateBinary(4);
        for(String i : result){
            System.out.print(i + " ");
        }
    }
}
