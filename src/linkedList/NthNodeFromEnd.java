package linkedList;

public class NthNodeFromEnd {


    //use the size cariable to get the node from start using formula
    public static<T> T nthNode(SinglyLinkedList<T> list, int n) {

        int size = list.size;
        int nthNode = size - n + 1; // we use size variable to get the node from start
        if(size == 0 || n > size ) { // return null if list is empty or n is greater than size
           return null;
        }

        SinglyLinkedList<T>.Node current = list.headNode;
        int count = 1;

        // traverse until count is not equal to n
        while(current != null) {
            if(count == nthNode) {
                return current.data;
            }
            current = current.nextNode;
            count++;
        }
        return null;
    }

    public static<T> T nthNodeApproach2(SinglyLinkedList<T> list, int n) {

        int size = list.size;
        if(size == 0 || n > size ) { // return null if list is empty or n is greater than size
            return null;
        }
        SinglyLinkedList<T>.Node nthNode = list.headNode;
        SinglyLinkedList<T>.Node traverseNode = list.headNode;
        int count =1;

        while(count != n) {
            traverseNode = traverseNode.nextNode;
            count++;
        }

        while(traverseNode.nextNode != null) {
            nthNode = nthNode.nextNode;
            traverseNode = traverseNode.nextNode;

        }




        return nthNode.data;
    }


    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        for (int i = 1; i <= 7 ; i++) {
            list.insertEnd(i);
        }

        list.printList();

        System.out.println("NthNode is : " + nthNode(list,6));

        System.out.println("NthNode Approach2 is : " + nthNodeApproach2(list,6));


    }
}
