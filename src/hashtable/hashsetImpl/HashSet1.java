package hashtable.hashsetImpl;

import java.util.ArrayList;

public class HashSet1 {

        /** Initialize your data structure here. */
        int value;
        private ArrayList<HashNode> bucket;
        int slots;
        int size;

        public HashSet1() {

            bucket = new ArrayList<HashNode>();
            slots = 10;
            size = 0;
            for(int i = 0 ; i < slots ;i++){
                bucket.add(null);
            }

        }

        public int getIndex(int key){
            return key % slots;
        }

        public int size(){
            return size;
        }

        public void add(int key) {
            if(!contains(key)){
                HashNode new_node = new HashNode(key);
                size++;
                int index = getIndex(key);
                HashNode head = bucket.get(index);
                new_node.next = head;
                bucket.set(index,new_node);
            }

            if(size / slots > 0.7){
                ArrayList<HashNode> temp = bucket;
                size = 0;
                slots = 2 * slots;
                for(int i = 0 ;i < slots; i++){
                    bucket.add(null);
                }
                for(HashNode node : temp){
                    while(node != null){
                        add(node.val);
                        node = node.next;
                    }
                }
            }

        }

        public void remove(int key) {
            if(contains(key)){
                int index = getIndex(key);
                HashNode head = bucket.get(index);
                HashNode prev = null;

                while(head != null){
                    if(head.val == key){
                        break;
                    }
                    prev = head;
                    head = head.next;
                }

                size--;
                if(prev == null){
                    bucket.set(index,head.next);
                }
                else{
                    prev.next = head.next;
                }

            }



        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = getIndex(key);
            HashNode head = bucket.get(index);
            while(head != null && head.val != key){

                head = head.next;
            }
            return head != null;
        }

    public static void main(String[] args) {
        HashSet1 hashSet = new HashSet1();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)

    }

}
