package tree;

public class BinarySearchTreeRecursive {

    private Node root;



    //recursive function to insert value to BST
    //Time Complexity : o(log(n))
    public Node add_recursive(Node currentNode ,int value){

        //Base case
        if(currentNode == null){
            return new Node(value);
        }
        if(value < currentNode.getData()){
            //Iterate to left sub tree
            currentNode.setLeftChild(add_recursive(currentNode.getLeftChild(),value));
        }

        else if(value > currentNode.getData()){
            //iterate to right sub tree
            currentNode.setRightChild(add_recursive(currentNode.getRightChild(),value));
        }
        else{
            //value already exists
            return currentNode;
        }
        return currentNode;
    }

    //function to call recursive add
    public boolean insert_recursive(int value){
        root = add_recursive(this.root,value);
        return true;
    }

    //to check if tree is empty or not
    public boolean isEmpty(){
        return root == null; //if root is null then tree is empty
    }

    //for testing purpose
    public void printTree(Node currentNode ){
        if(currentNode == null){
            return;
        }
        System.out.print(currentNode.getData() + ",");
        printTree(currentNode.getLeftChild());
        printTree(currentNode.getRightChild());
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {


        System.out.println("Binary Search Tree Recursive ");
        BinarySearchTreeRecursive bsT1 = new BinarySearchTreeRecursive();
        bsT1.insert_recursive(6);
        bsT1.insert_recursive(4);
        bsT1.insert_recursive(9);
        bsT1.insert_recursive(5);
        bsT1.insert_recursive(2);
        bsT1.insert_recursive(8);
        bsT1.insert_recursive(12);
        bsT1.insert_recursive(10);
        bsT1.insert_recursive(14);
        bsT1.printTree(bsT1.getRoot());
    }
}
