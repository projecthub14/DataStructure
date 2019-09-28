package graph;

import linkedList.DoublyLinkedList;
import stackQueue.Stack;

//Time complexity is O(V+E)
//we use Last In First Out (LIFO) approach
// as it keeps popping new adjacent nodes ( gives node at new level)
//instead of returning previous node we pushed in

public class DepthFirstSearch {

    public static String dfsTraversal(Graph g , int source) {
        String result = "";
        int num_of_vertices = g.vertices;

        //To implement DFS by pushing source in to it
        Stack<Integer> stack = new Stack<>(num_of_vertices);

        //boolean array to hold history of visited nodes
        //make node visited when you push to stack
        boolean[] visited = new boolean[num_of_vertices];

        stack.push(source);
        visited[source] = true;

        //Traverse while stack is not empty
        while(!stack.isEmpty()){

            //pop a vertex from stack and add it to result
            int current_node = stack.pop();
            result += String.valueOf(current_node); // convert int to String

            //Get the adjacent vertices to current node from  array
            //and if they are not visited then push to stack

            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null){
                temp = g.adjacencyList[current_node].headNode;
            }

            while(temp!=null) {
                if(!visited[temp.data]){
                    stack.push(temp.data);
                    //Visit the node
                    visited[temp.data] = true;
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);

        System.out.println(dfsTraversal(g,0));
    }
}
