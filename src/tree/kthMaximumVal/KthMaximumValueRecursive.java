package tree.kthMaximumVal;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

//time complexity is : O(n) but its better
// if k =1 then complexity is O(h) -> height
// so solution is more efficient then previous
public class KthMaximumValueRecursive {

    static int counter = 0; //global count variable


    public static int findKthMax(Node root,int k){
        Node node = findKthMaximumRecursive(root,k);
        if(node != null){
            return node.getData();
        }
        return -1;
    }
    public static Node findKthMaximumRecursive(Node root,int k){
        if(root == null){
            return null;
        }
        //recursively reach rightmost node which  has highest value
        Node node = findKthMaximumRecursive(root.getRightChild(),k);
        if(counter != k){
            //increment the counter is kth element is not found
            counter++;
            node = root;
        }

        //base condition is reached as kth largest is found
        if(counter==k){
            return node;
        }
        else{
            //traverse left child if kth largest is not reached
           return findKthMaximumRecursive(node.getLeftChild(),k);
        }


    }


    public static void main(String[] args) {

        BinarySearchTreeIterative bst = new BinarySearchTreeIterative();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(2);
        bst.add(8);
        System.out.println(findKthMax(bst.getRoot(),2));


    }
}
