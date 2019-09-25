package linkedList;

public class DetectLoopLinkedList {


    //O(n) time complexity with auxilary space equals to O(1)
    public static boolean detectLoop(SinglyLinkedList<Integer> list) {
        SinglyLinkedList.Node slow = list.headNode;
        SinglyLinkedList.Node fast = list.headNode;

        while(slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode; // slow pointer jumps 1 step
            fast = fast.nextNode.nextNode; // fast pointer jumps 2 steps
            //when the pointer becomes equal then there will be loop
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(3);

        System.out.println("List before loop : " +detectLoop(list));


        list.headNode.nextNode.nextNode = list.headNode;
        System.out.println("List after loop : " +detectLoop(list));
    }
}

