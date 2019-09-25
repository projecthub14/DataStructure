package linkedList;

import java.util.HashSet;

public class RemoveDuplicatesLinkedList {

    //brute force solution
    public static<T> void removeDuplicates(SinglyLinkedList<Integer> list) {
        SinglyLinkedList.Node current = list.headNode; // will be used for outer loop
        SinglyLinkedList.Node compare = null; //will be used for inner loop

        while(current.nextNode != null && current != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }

    //using hashing o(n)
    public static<T> void removeDuplicatesHashing(SinglyLinkedList<Integer> list) {
        SinglyLinkedList.Node current = list.headNode;
        SinglyLinkedList.Node previous = list.headNode;
        //visit all the nodes we observe once
        HashSet<Integer>  visitedNodes = new HashSet<Integer>();

        if(!list.isEmpty() && current.nextNode != null) {
          while(current != null) {

              //check if already visited node otherwise delete the node
              if (visitedNodes.contains(current.data)) {
                  //deleting the node by updating previous node
                  previous.nextNode = current.nextNode;
                  current = current.nextNode;
              }
              else{
                  //if node was not visited then add it to visited set
                  visitedNodes.add((Integer)current.data);


                  //moving on to next element in list
                  previous = current;
                  current = current.nextNode;
              }
          }

        }



    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertHead(7);
        list.insertHead(22);
        list.insertHead(14);
        list.insertHead(21);
        list.insertHead(14);
        list.insertHead(7);

        System.out.println("Linked list before removing duplicates : ");
        list.printList();

        removeDuplicates(list);

        System.out.println("Linked list after removing duplicates : ");
        list.printList();


        removeDuplicatesHashing(list);
        System.out.println("Linked list after removing duplicates Hashing : ");
        list.printList();




    }
}
