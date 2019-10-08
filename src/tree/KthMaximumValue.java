package tree;

public class KthMaximumValue {

    public static int maximumKthValue(Node root , int k){
        StringBuilder result = new StringBuilder();
        result = inorderTraversal(root,result);
        String[] array = result.toString().split(",");
        if(array.length - k >= 0){
           return Integer.parseInt(array[array.length - k]);
        }
        return -1;
    }

    public static StringBuilder inorderTraversal(Node root , StringBuilder result){
        if(root.getLeftChild() != null){
            inorderTraversal(root.getLeftChild(),result);
        }
        result = result.append(root.getData() + ",");

        if(root.getRightChild() != null){
            inorderTraversal(root.getRightChild(),result);
        }
        return result;
    }
    public static void main(String[] args) {

        BinarySearchTreeIterative bst = new BinarySearchTreeIterative();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(2);
        bst.add(8);
        System.out.println(maximumKthValue(bst.getRoot(),3));

    }
}
