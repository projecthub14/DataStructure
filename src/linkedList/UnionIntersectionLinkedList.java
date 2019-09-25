package linkedList;

public class UnionIntersectionLinkedList {

    //Time Complexity O(m+n)
    public static SinglyLinkedList<Integer> unionList(SinglyLinkedList<Integer> list1 , SinglyLinkedList<Integer> list2) {

        //if one list is empty return other one
        if(list1.isEmpty()){
            return list2;
        }
        if(list2.isEmpty()) {
            return list1;
        }

        // take the head of first list
        SinglyLinkedList.Node last = list1.headNode;
        SinglyLinkedList.Node current2 = list2.headNode;

        //Time Complexity O(n)
        //traverse till last element
        while(last.nextNode != null ) {
            last = last.nextNode;
        }

        //Time Complexity O(m+n)
        //attach last element of list1 to head of list2
        last.nextNode = current2; // new list with length m+ n

        //Time Complexity O(n)
        //remove the duplicates that have been added now
        RemoveDuplicatesLinkedList.removeDuplicatesHashing(list1);
        return list1;

    }

    public static<T> boolean contains(SinglyLinkedList<T> list,T data) {

        SinglyLinkedList<T>.Node current = list.headNode;
        //Time Complexity O(n)
        while(current != null) {
            if(current.data.equals(data)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;

    }

    //Time Complexity o(mn)
    public static<T> SinglyLinkedList<T> intersectionList(SinglyLinkedList<T> list1,SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        if(list1.isEmpty()){
            return result;
        }
        if(list2.isEmpty()){
            return result;
        }



        SinglyLinkedList<T>.Node current = list1.headNode;

        //TimeComplexity O(n)
        while(current != null) {
            //TimeComplexity 0(m)
            if(contains(list2,current.data)) {
                result.insertHead(current.data);
            }
            current = current.nextNode;
        }
        return result;


    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

        list1.insertEnd(15);
        list1.insertEnd(22);
        list1.insertEnd(8);

        System.out.println("First List : ");
        list1.printList();

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();

        list2.insertEnd(7);
        list2.insertEnd(14);
        list2.insertEnd(22);

        System.out.println("Second List : ");
        list2.printList();

        System.out.println("Union : " );
        unionList(list1,list2).printList();

        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();

        list3.insertEnd(15);
        list3.insertEnd(22);
        list3.insertEnd(8);

        System.out.println("-------------------------");

        System.out.println("Third List : ");
        list3.printList();

        SinglyLinkedList<Integer> list4 = new SinglyLinkedList<>();

        list4.insertEnd(7);
        list4.insertEnd(14);
        list4.insertEnd(22);

        System.out.println("Fourth List : ");
        list4.printList();

        System.out.println("Intersection : ");
        intersectionList(list3,list4).printList();






    }
}
