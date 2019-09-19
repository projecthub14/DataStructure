package linkedList;

//Constructor
//isEmpty()
//insertAtHead();
//insertAtEnd()
//insertAfter(T data)
//searchByValue(T data)
//deleteHead()
//deleteByValue(T data)
//printList()

public class SinglyLinkedList<T> {

    class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //headNode of linkedList
    public int size; // size of linked list

    //Constructor initializes headNode and size.
    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    //helper function that checks if list is empty
    public boolean isEmpty() {
        if(headNode == null) return true;
        else
            return false;
    }

//    Create a new node with the given value
//    Make nextElement of newNode points to the head node
//    Make head to point to this newly created node

    //Inserts new node at start of linked list
    public void insertHead(T data) {
        //creating new node and assigning it data value
        Node newNode = new Node();
        newNode.data = data;

        //linking head to newnodes next node
        newNode.nextNode = headNode;
        //assigning head to new node
        headNode = newNode;
        size++;
    }
    // If the list is empty, the situation is exactly like insertion at the head.
    // Otherwise, we can use a loop to reach the tail of the list
    // and set our new node as the nextNode of the last node.

    //Inserts new node at end of linked list
    public void insertEnd(T data) {
        //if list is empty then call insertHead()
        if(isEmpty()) {
            insertHead(data);
            return;
        }

        //Creating new node with value data
        Node newNode = new Node();
        newNode.data = data;

        Node last = headNode;
        //iterate to last element
        while(last.nextNode != null) {
            last = last.nextNode;
        }

        //make new node the nextElement of last nodex`x
        last.nextNode = newNode;
        newNode.nextNode = null;
        size++;
    }

    public void insertAfter(T data,T previous) {
        //Creating new node with value data
        Node newNode = new Node();
        newNode.data = data;

        //Start from head node
        Node curr = headNode;

        //traverse the list until node having data is equal to previous is found
        while(curr!=null && curr.data != previous) {
            curr = curr.nextNode;
        }

        //if such a node is found
        //then point newnode to curr node nextElement
        if(curr != null) {
            newNode.nextNode = curr.nextNode;
            curr.nextNode = newNode;
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

    //Time Complexity : O(1)
    public void deleteAtHead() {

        //if list is empty simply return
        if(isEmpty()) {
            return;
        }
        //make headNode point to heads nextnode
        headNode = headNode.nextNode;
        size--;

    }


    public void deleteByValue(T data) {
        if(isEmpty()){
            return;
        }
        //Start from head node
        Node cur = this.headNode;
        Node prev = null;

        if(data.equals(cur.data)){
            deleteAtHead();
            return;
        }
        //Traverse the list searching for data to delete
        while(cur != null){
            //node to delete is found
            if(cur.data.equals(data)){
                prev.nextNode = cur.nextNode;
                size--;
                return;
            }
            prev = cur;
            cur = cur.nextNode;
        }

    }

    //Helper function to printList
    public void printList() {
        if(isEmpty()) {
            System.out.println("list is Empty ");
            return;
        }

        Node temp = headNode;
        System.out.println("List : ");
        while(temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null ");
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            list.insertEnd(i);
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
        System.out.println("Delete by value\n");
        list.deleteByValue(4);
        list.printList();
        System.out.println("After : Delete by value\n");


    }
}
