package tree;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelByLevelOrder {

    public static void reverseLevelBylevelOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            stack.push(root);
            if(root.getRightChild() != null){
                queue.offer(root.getRightChild());
            }
            if(root.getLeftChild()!=null){
                queue.offer(root.getLeftChild());
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop().getData() + " ");
        }
    }


    public static void main(String[] args) {
        BinarySearchTreeIterative bt = new BinarySearchTreeIterative();
        bt.add(10);
        bt.add(20);
        bt.add(30);
        bt.add(15);
        bt.add(-10);
        bt.add(0);
        bt.add(5);
        bt.add(-5);
        bt.add(-15);
        bt.add(27);
        bt.add(35);

        reverseLevelBylevelOrder(bt.getRoot());
    }
}
