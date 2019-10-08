package tree.traversal;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

public class PreOrderTraversal {

    //level by level order where it print left child before right child
    public static  void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());


    }

    public static void main(String[] args) {

        BinarySearchTreeIterative BST = new BinarySearchTreeIterative();

        BST.add(6);
        BST.add(4);
        BST.add(2);
        BST.add(5);
        BST.add(9);
        BST.add(8);
        BST.add(12);

        preOrder(BST.getRoot());


    }
}
