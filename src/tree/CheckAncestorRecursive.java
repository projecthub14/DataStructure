package tree;

public class CheckAncestorRecursive {

    public static boolean checkAncestor(Node root, int target){
        if(root == null){
            return false;
        }
        if(root.getData() == target){
            return true;
        }

        if(checkAncestor(root.getLeftChild(),target) || checkAncestor(root.getRightChild(),target)){
            System.out.println(root.getData());
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        BinarySearchTreeIterative bst = new BinarySearchTreeIterative();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        bst.add(8);
        bst.add(12);
        bst.add(10);
        bst.add(14);

        checkAncestor(bst.getRoot(),10);


    }
}
