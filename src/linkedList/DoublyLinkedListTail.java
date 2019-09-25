package linkedList;


//Consructor
//isEmpty
//printList()
//insertAtHead()
//insertAtTail()
//deleteAtHead()
//deleteAtTail()

public class DoublyLinkedListTail<T> {

    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedListTail() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if(headNode == null && tailNode == null) { //checking tailNode to make sure
            return true;
        }
        return false;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node list = headNode;
        System.out.println("List : null <-");
        while (list.nextNode != null) {
            System.out.print( list.data.toString() + " <-> ");
            list = list.nextNode;
        }
        System.out.print(list.data.toString() + " -> null");
    }

    public void insertAtHead(T data) {

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        newNode.prevNode = null;
        if(isEmpty()){
            tailNode = newNode;

        }
        else {
            headNode.prevNode = newNode;
        }
        headNode = newNode;
        size++;
    }

    public void insertAtTail(T data) {
        if(isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.prevNode = tailNode;

        newNode.nextNode = null;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;


    }

    public void deleteAtHead() {
        if(isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        if(headNode == null) {
            tailNode = null;
        }
        else {
            headNode.prevNode = null;
        }
        size--;

    }

    public void deleteAtTail() {
        if(isEmpty()) {
            return;
        }
        tailNode = tailNode.prevNode;
        if(tailNode == null) {
            headNode = null;
        }
        else {
            tailNode.nextNode = null;
        }
        size--;

    }

    public static void main(String[] args) {
        DoublyLinkedListTail<Integer> list = new DoublyLinkedListTail<>();
        for (int i = 1; i <= 6; i++) {
            list.insertAtHead(i);
        }
        list.printList();

        list.deleteAtHead();
        list.printList();

        list.deleteAtTail();
        list.printList();

        list.insertAtTail(10);
        list.printList();


//        System.out.println("\nInserting 8 after 2\n");
//        list.insertAfter(8,2);
//        list.printList();
//
//        System.out.println("\nInserting 10 after 3\n");
//        list.insertAfter(10,3);
//        list.printList();

       // System.out.println("\nSearch 6");
      //  boolean found = list.searchNode(6);
//        if(found) {
//            System.out.println("Item 6  found"  );
//        }
//        else {
//            System.out.println("Item 6 not found"  );
//        }
//
//        System.out.println("Delete at head\n");
//        list.deleteAtHead();
//        System.out.println("After : Delete at head");
//        list.printList();
//        System.out.println("Delete by value\n");
//        list.deleteByValue(4);
//        list.printList();
//        System.out.println("After : Delete by value\n");


    }

}
