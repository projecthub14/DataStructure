package linkedList;

public class LengthLinkedList {

    //Since this is a linear algorithm, the time complexity will be O(n).

    public static int length(SinglyLinkedList.Node headNode) {
        //Get reference to head of list
        SinglyLinkedList.Node curr = headNode;
        //initialize length to 0
        int length = 0;

        //traverse till end of list
        while(curr != null) {
            length++; //increment at each iteration
            curr = curr.nextNode;
        }
        return length;
    }

    public static void main(String[] args) {
        
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 5; i >= 0 ; i--) {
            list.insertHead(i);
        }
        list.printList();
        System.out.println("Length is " + length(list.headNode));
    }
}
