package linkedList;

public class ReverseLinkedList {


    //The algorithm runs in O(n) since the list is traversed once.
    public static void reverse(SinglyLinkedList list) {

        //To keep track of previous used in swapping links
        SinglyLinkedList.Node previous = null;

        SinglyLinkedList.Node curr = list.headNode; // firstElement
        SinglyLinkedList.Node next = null;

        //while traversing swap the links
         while(curr != null ) {
             next = curr.nextNode;
             curr.nextNode = previous;
             previous = curr;
             curr = next;

         }

         //linking headNode to new first element
         list.headNode = previous;

    }


    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 15; i >= 0 ; i-=3) {
            list.insertHead(i);
        }
        list.printList();

        reverse(list);
        System.out.println("Reversed List is " );

        list.printList();
    }
}
