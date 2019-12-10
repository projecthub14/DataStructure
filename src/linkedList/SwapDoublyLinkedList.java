package linkedList;

public class SwapDoublyLinkedList {

    public static DoublyLinkedList.Node middleSwapList(DoublyLinkedList<Integer>.Node head){
        DoublyLinkedList<Integer>.Node prev = null;
        DoublyLinkedList<Integer>.Node slow = head;
        DoublyLinkedList<Integer>.Node fast = head;
        while(fast.nextNode != null && fast != null){
            prev = slow;
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        prev.nextNode = null;
        slow.prevNode = null;
        fast.nextNode = head;
        head.prevNode = fast.nextNode;
        head = slow;
        return head;

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 7; i++) {
            list.insertAtEnd(i);
        }
        list.printList();
        DoublyLinkedList<Integer>.Node head = middleSwapList(list.headNode);
        while (head != null){
            System.out.println(head.data);
            head = head.nextNode;
        }
    }
}
