package tree;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrder(Node root){

        if(root== null)return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            System.out.println(root.getData() + " ");
            if(root.getLeftChild() != null){
                queue.add(root.getLeftChild());
            }
             if(root.getRightChild() != null){
                queue.add(root.getRightChild());
            }
        }


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

        levelOrder(bsT.getRoot());
    }
}
