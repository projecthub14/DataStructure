package linkedList;

public class EvenOddList {

    private static SinglyLinkedList.Node evenOddList(SinglyLinkedList.Node head){
        SinglyLinkedList.Node evenStart = null;
        SinglyLinkedList.Node evenEnd = null;
        SinglyLinkedList.Node oddStart = null;
        SinglyLinkedList.Node oddEnd = null;
        SinglyLinkedList.Node currentNode = head;

        while (currentNode != null){
            if((int)currentNode.data %2 == 0){
                if(evenStart == null){
                    evenStart = currentNode;
                    evenEnd = currentNode;
                }
                else{
                    evenEnd.nextNode = currentNode;
                    evenEnd = evenEnd.nextNode;
                }
            }
           else{
                if(oddStart == null){
                    oddStart = currentNode;
                    oddEnd = currentNode;
                }
                else{
                    oddEnd.nextNode = currentNode;
                    oddEnd = oddEnd.nextNode;
                }
            }
            currentNode = currentNode.nextNode;
        }
        if(oddStart == null || evenStart == null){
            return head;
        }

        evenEnd.nextNode = oddStart;
        oddEnd.nextNode = null;
        head = evenStart;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 15; i >= 0 ; i--) {
            list.insertHead(i);
        }
        list.printList();

        SinglyLinkedList.Node head = evenOddList(list.headNode);
        System.out.println("Result :");
        while (head != null){
            System.out.println(head.data + " -> ");
            head = head.nextNode;
        }
        System.out.println("null");

    }
}
