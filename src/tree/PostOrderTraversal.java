package tree;

public class PostOrderTraversal {

    //prints the children nodes first before parent node
    public static  void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.print(root.getData() + " ");
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

        postOrder(BST.getRoot());
    }
}
