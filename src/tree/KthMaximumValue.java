package tree;

//Time complexity is O(n)
public class KthMaximumValue {

    public static int maximumKthValue(Node root , int k){
        //result to store the value seperated by ,
        StringBuilder result = new StringBuilder();

        //do inorderTraversal to get sorted elements
        result = inorderTraversal(root,result);

        //retrieve the result seperated by ,
        //splitting string into array of strings
        String[] array = result.toString().split(",");

        //if we are able to retrieve successfully
        //then retrieve value at index [length -k]
        if(array.length - k >= 0){
            //get integer value
           return Integer.parseInt(array[array.length - k]);
        }

        return -1;
    }

    //helper recursive function to traverse tree inorder
    //return result as StringBuilder
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
