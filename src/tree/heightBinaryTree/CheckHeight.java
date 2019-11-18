package tree.heightBinaryTree;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

public class CheckHeight {

    public static int findHeight(Node root){

        if(root == null){
            return -1;
        }

        int leftHeight = findHeight(root.getLeftChild());
        int rightHeight = findHeight(root.getRightChild());

        return (Math.max(leftHeight,rightHeight) + 1);
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

        System.out.println(findHeight(bsT.getRoot()));

    }
}
