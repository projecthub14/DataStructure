package tree;

import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderSum {

    public static List<Integer> levelOrderSum(Node root){
        Queue<Node> queue = new LinkedList<>();
        int currentCount =0;
        int levelCount = 1;
        queue.offer(root);
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        while(!queue.isEmpty()){
            while(levelCount > 0){
                root = queue.poll();
                sum +=root.getData();

                if(root.getLeftChild() != null){
                    queue.offer(root.getLeftChild());
                    currentCount++;
                }
                 if(root.getRightChild() != null){
                    queue.offer(root.getRightChild());
                    currentCount++;
                }
                levelCount--;

            }
            levelCount = currentCount;
            currentCount = 0;
            sumList.add(sum);
            sum =0;
        }
        return sumList;
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

        System.out.println(levelOrderSum(bsT.getRoot()));
    }
}
