package tree.minValue;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

//time complexity is O(n)
public class FindMinValue {


    public static int findMinIterative(Node root){

        //In BST all the values in cuurent node left subtree are smaller than
        //than current nodes value
        Node temp = root;
        //keep traversing towards left until we reach leaf node , and return leafs node value
        while(temp.getLeftChild() != null){
            temp = temp.getLeftChild();
        }
        return temp.getData();
    }

    public static int findMinRecursive(Node root){

        if(root == null){
            return -1;
        }
        //keep traversing towards left till we reach leaf node,
        //and return leaf's node value
        else if(root.getLeftChild() == null){
            return root.getData();
        }

        else
          return  findMinRecursive(root.getLeftChild());
    }

    public static void main(String[] args) {
        BinarySearchTreeIterative bsT = new BinarySearchTreeIterative();


        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println("Minimum Value is " + findMinIterative(bsT.getRoot()));

        System.out.println("Minimum Value is " + findMinRecursive(bsT.getRoot()));
    }
}
