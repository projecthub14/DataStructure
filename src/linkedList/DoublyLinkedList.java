package linkedList;

public class DoublyLinkedList<T> {

    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;

    }

    public Node headNode;
    public int size;

    public DoublyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        if(headNode == null) {
            return true;
        }
        return false;
    }

    public void printList() {
        if(isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node curr = headNode;
        System.out.print("List : null <- ");
        while(curr.nextNode != null) {
            System.out.print(curr.data.toString() + " <->");
            curr = curr.nextNode;
        }
        System.out.print(curr.data.toString() + " -> null");
    }

    public void deleteAtHead() {
        if(isEmpty()){
            return;
        }
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data) {
        if(isEmpty()) {
            return;
        }
        Node curr = headNode;

        if(data.equals(curr.data)) {
            deleteAtHead();
            return;
        }

        while(curr != null) {
            if(curr.data.equals(data)) {
                curr.prevNode.nextNode = curr.nextNode;
                if(curr.nextNode != null) {
                    curr.nextNode.prevNode = curr.prevNode;
                }
                size--;
            }
            curr = curr.nextNode;
        }
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;

        newNode.nextNode = headNode;
        newNode.prevNode = null;

        headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        if(isEmpty()){
            insertAtHead(data);
            return;
        }
        Node last = headNode;
        Node newNode = new Node();
        newNode.data = data;

        while(last.nextNode != null) {
            last=last.nextNode;
        }
        last.nextNode = newNode;
        newNode.prevNode = last;
        newNode.nextNode = null;
        size++;
    }

    public void insertAfter(T data,T previous) {

        Node newNode = new Node();
        newNode.data = data;
        Node curr = headNode;

        while(curr!=null && curr.data != previous){
            curr = curr.nextNode;
        }

        if(curr != null) {
            curr.nextNode.prevNode = newNode;
            newNode.nextNode = curr.nextNode;
            curr.nextNode =newNode;
            newNode.prevNode = curr;
            size++;

        }
    }

    public boolean searchNode(T data) {
        if(isEmpty()) {
            return false;
        }
        //Start from first element
        Node cur = headNode;

        //Traverse the list till you reach end
        while(cur != null){
            if(cur.data.equals(data)){
                return true; // value found
            }
            cur = cur.nextNode;
        }
        return false; // value not found

    }
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            list.insertAtEnd(i);
        }
        list.printList();

        System.out.println("\nInserting 8 after 2\n");
        list.insertAfter(8,2);
        list.printList();

        System.out.println("\nInserting 10 after 3\n");
        list.insertAfter(10,3);
        list.printList();

        System.out.println("\nSearch 6");
        boolean found = list.searchNode(6);
        if(found) {
            System.out.println("Item 6  found"  );
        }
        else {
            System.out.println("Item 6 not found"  );
        }

        System.out.println("Delete at head\n");
        list.deleteAtHead();
        System.out.println("After : Delete at head");
        list.printList();
        System.out.println("\nDelete by value 4\n");
        list.deleteByValue(4);
        list.printList();
        System.out.println("\nAfter : Delete by value\n");


    }




}
