package linkedList;


import java.util.HashMap;

public class RemoveZeroSumSubLists {


    public  ListNode removeZeroSumLists(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);
        int sum = 0;
        for (ListNode i = dummy; i !=null ; i=i.next) {
            sum+= i.val;
            map.put(sum,i);
        }
        sum = 0;
        for (ListNode i = dummy; i !=null ; i=i.next) {
            sum+= i.val;
            i.next = map.get(sum).next;
        }

        return dummy.next;

    }
    public static void main(String[] args) {

        RemoveZeroSumSubLists rm = new RemoveZeroSumSubLists();
        linkedList.ListNode l1 = new linkedList.ListNode(3);
        linkedList.ListNode l2 = new linkedList.ListNode(4);
        linkedList.ListNode l3 = new linkedList.ListNode(2);
        linkedList.ListNode l4 = new linkedList.ListNode(-6);
        linkedList.ListNode l5 = new linkedList.ListNode(1);
        linkedList.ListNode l6 = new linkedList.ListNode(1);
        linkedList.ListNode l7 = new linkedList.ListNode(5);
        linkedList.ListNode l8 = new linkedList.ListNode(-6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = null;


        linkedList.ListNode result = rm.removeZeroSumLists(l1);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
