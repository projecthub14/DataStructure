package tree.printAncestors;


import tree.bstImpl.BinarySearchTreeIterative;
import tree.bstImpl.Node;

import java.util.Stack;

class CheckAncestorIterative
{
    // Iterative Function to print all ancestors of a given key
    static void printAncestors(Node root, int key)
    {
        if (root == null)
            return;

        Stack<Node> myStack = new Stack<Node>();  // stack to hold ancestors

        while (1 == 1)  // Traversing the tree in postorder
        {
            // Traverse the left side. While traversing, push the nodes into the stack so that their right subtrees can be traversed later
            while (root != null && root.getData() != key)
            {
                myStack.push(root); // push current node
                root = root.getLeftChild();
            }

            // If the node whose ancestors are to be printed is found, then break the while loop.
            if (root != null && root.getData() == key)
                break;

            // Check if right sub-tree exists  for the node at top If not then pop that node because we don't need this node any more.
            if (myStack.peek().getRightChild() == null)
            {
                root = myStack.peek();
                myStack.pop();

                // If the popped node is right child of top, then remove the top as well. Left child of the top must have processed before.
                while (!myStack.isEmpty() && myStack.peek().getRightChild() == root)
                {
                    root = myStack.peek();
                    myStack.pop();
                }
            }

            // if stack is not empty then simply set the root as right child of top and start traversing right sub-tree.
            root = myStack.isEmpty() ? null : myStack.peek().getRightChild();
        }

        // If stack is not empty, print contents of stack, assuming the key is there in tree
        while (!myStack.isEmpty())
        {
            System.out.print(myStack.peek().getData() + " ");
            myStack.pop();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        BinarySearchTreeIterative tree = new BinarySearchTreeIterative();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        printAncestors(tree.getRoot(), key);

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        printAncestors(tree.getRoot(), key);
    }
}
