package tree;

public class BinarySearchTreeIterative {

    private Node root;

    //iterative function to insert a value to BST
    //Time Complexity : o(log(n))
    public boolean add(int value){

        //check if tree is empty if empty insert root
        //with given value inside tree
        if(isEmpty()){
            root = new Node(value);
            return true;
        }
        //starting root node
        Node currentNode = root;


        //traverse until valid position to insert value
        while(currentNode != null){

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();
            //if value to be inserted is less than root value then move to
            //left subtree

            if(value < currentNode.getData()){
                if(leftChild == null){
                    currentNode.setLeftChild(new Node(value));
                    return true;
                }
                currentNode = leftChild;

            }

            //if value to be inserted is greated than current value
            // then move to right subtree
            else if(value > currentNode.getData()){
                if(rightChild == null){
                    currentNode.setRightChild(new Node(value));
                    return true;
                }
                currentNode = rightChild;
            }
            //end of else
        }//end of while
        return false;

    }

    //to check if tree is empty or not
    public boolean isEmpty(){
        return root == null; //if root is null then tree is empty
    }

    //searches the value in BST
    //either returns the value or returns null
    // time complexity is O(log(n)) -> at each iteration
    //we choose either left or right subtree to traverse
    //hence dividing number of search elements by half
    public Node search(int value){
        if(isEmpty()){
            return null; //if tree is empty return null
        }
        Node currentNode = this.root;
        while(currentNode != null) {
            if(value == currentNode.getData()){
                return currentNode;
            }
            else if (value < currentNode.getData()) {
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }

        }
        System.out.println(value + " Not found in the Tree");
        return null;
    }

    //3 condition for delete
    //1. if leaf node to be deleted
    //2. node has 1 child -> left child or right child
    //3. node has 2 children

    public boolean delete(Node currentNode ,int value){

        //to store parent of current node
        Node parentNode = null;

        if(isEmpty()){
            return false;
        }

        //to get the node to be deleted and set the parentNode of node to be deleted
        while(currentNode != null && currentNode.getData() !=value){
            parentNode = currentNode;

            if(value < currentNode.getData() ){
                currentNode = currentNode.getLeftChild();
            }
            else{
                currentNode = currentNode.getRightChild();
            }
        }

        //if node to be deleted is leaf
        if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            //if node to be deleted is root node
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            //if node to be deleted is less than parent node
            else if(currentNode.getData() < parentNode.getData()){
                parentNode.setLeftChild(null); //set left child of parent
                return true;
            }
            else{
                parentNode.setRightChild(null);//set right child of parent
                return true;
            }
        }
        //if node to be deleted has 1 child with left child null
        else if(currentNode.getLeftChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parentNode.getData()){
                parentNode.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parentNode.setRightChild(currentNode.getRightChild());
                return true;
            }
        }

        //if node to be deleted has 1 child with right child null
        else if(currentNode.getRightChild() == null){
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parentNode.getData()){
                parentNode.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{
                parentNode.setRightChild(currentNode.getLeftChild());
                return true;
            }
        }
        else{
            //Find the least value Node in right subtree of current node
            Node leastNode = findLeastValue(currentNode.getRightChild());
            //get data value
            int temp = leastNode.getData();
            //delete the least value in right subtree of current node
            delete(root,temp);
            //set the currentnode with least value
            currentNode.setData(temp);
            return true;

        }
    }

    //Helper function to find least value in right subtree
    public Node findLeastValue(Node currentNode){
        Node temp = currentNode;
        //traverse left child untill null
        while(temp.getLeftChild() != null){
            temp = temp.getLeftChild();
        }
        //this is leaf most value in tree which is smallest value in right subtree
        return temp;
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

        System.out.println("Binary Search Tree Iterative ");
        BinarySearchTreeIterative bsT = new BinarySearchTreeIterative();
        bsT.add(6);
        bsT.add(7);
        bsT.add(8);
        bsT.add(12);
        bsT.add(1);
        bsT.add(15);
        bsT.printTree(bsT.getRoot());


//        Node temp = bsT.search(5);
//        if (temp != null) {
//            System.out.println("\n" + temp.getData() + " found in Tree !");
//        }
//        temp = bsT.search(51);
//        if (temp != null) {
//            System.out.println("\n" + temp.getData() + " found in Tree !");
//        }


        System.out.print("\nDeleting Node 6: ");
        bsT.delete(bsT.getRoot(),6);
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 15: ");
        bsT.delete( bsT.getRoot(),15);
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 1: ");
        bsT.delete( bsT.getRoot(),1);
        bsT.printTree(bsT.getRoot());

    }


}
