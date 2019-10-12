package linkedList;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class MergeTwoSortedList {

    public static ListNode mergeTwoSortedLists(ListNode l1 , ListNode l2){
        ListNode curr = new ListNode(0);
        ListNode result = curr;

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else if(l2.val < l1.val){
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l1.next.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l4.next.next = l6;

        ListNode result = mergeTwoSortedLists(l1,l4);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
