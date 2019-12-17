package hashtable.hashtableImpl;

import java.util.ArrayList;

public class HashTable {

    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;
        for(int i = 0;i< slots;i++){
            bucket.add(null);
        }

    }

    public int getIndex(String key){
        int hashCode = key.hashCode();
        return hashCode % slots;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void insert(String key , int value){

        int index = getIndex(key);
        HashEntry head = bucket.get(index);

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashEntry new_node = new HashEntry(key,value);
        size++;
        head = bucket.get(index);
        new_node.next = head;
        bucket.set(index,new_node);

        if((1 * size)/slots >= 0.6){
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<HashEntry>();
            slots = slots * 2;
            size = 0;
            for(int i = 0; i< slots ; i++){
                bucket.add(null);
            }

            for(HashEntry head_node : temp ){
                while(head_node != null){
                    insert(head_node.key,head_node.value);
                    head_node = head_node.next;

                }
            }

        }
    }

    public int get(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return 0;
    }

    public int delete(String key){
        int index = getIndex(key);
        HashEntry head = bucket.get(index);
        HashEntry prev = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null){
            return -1;
        }
        size--;
        if(prev == null){
            bucket.set(index, head.next);
        }
        else{
            prev.next = head.next;
        }
        return head.value;

    }

    public static void main(String[] args) {
        HashTable table = new HashTable();

        System.out.println("Table Size = " + table.size());
        table.insert("This",1 ); //Key-Value Pair
        table.insert("is",2 );
        table.insert("a",3 );
        table.insert("Test",4 );
        table.insert("Driver",5 );
        System.out.println("Table Size = " + table.size());

        // first search the key then delete it in the table
        // see the implementation first
        System.out.println(table.delete("is")+ " : This key is deleted from table");
        System.out.println("Now Size of the table = " + table.size() );
        if(table.isEmpty())
            System.out.println("Table is Empty");
        else
            System.out.println("Table is not Empty");

    }
}
