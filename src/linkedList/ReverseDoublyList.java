package linkedList;

public class ReverseDoublyList {

    public static DoublyLinkedList.Node reverseDoublyLinkedList(DoublyLinkedList.Node head){
        DoublyLinkedList.Node curr = head;
        DoublyLinkedList.Node temp = null;
        while(curr != null){
            temp = curr.prevNode;
            curr.prevNode = curr.nextNode;
            curr.nextNode = temp;
            curr = curr.prevNode;
        }
        if(temp != null){
            head = temp.prevNode;
        }
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            list.insertAtEnd(i);
        }
        list.printList();
        DoublyLinkedList<Integer>.Node res = reverseDoublyLinkedList(list.headNode);
        while(res != null){
            System.out.println(res.data);
            res = res.nextNode;
        }
    }
}
