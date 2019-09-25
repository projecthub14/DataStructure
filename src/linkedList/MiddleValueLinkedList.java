package linkedList;

public class MiddleValueLinkedList {

    //TimeComplexity is O(n)
    public static <T>Object middleValue(SinglyLinkedList<Integer> list) {

        if(list.isEmpty()) {
            return null;
        }


        //both the nodes start from the head
        SinglyLinkedList.Node mid = list.headNode;
        SinglyLinkedList.Node current = list.headNode;

        while(current != null && current.nextNode!=null && mid != null) {
            //current jumps 2 nodes on each iteration
            current = current.nextNode.nextNode;
            if(current!=null) {
                //then mid jumps 1 node
                //mid is halfway behind current
                mid = mid.nextNode;
            }
        }
        return mid.data;

    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 15; i >= 0 ; i-=4) {
            list.insertHead(i);
        }
        list.printList();

        System.out.println("Middle Value of List " + ((Integer)middleValue(list)).intValue());

    }
}
