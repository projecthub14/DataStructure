package graph;

import linkedList.DoublyLinkedList;
import stackQueue.Queue;

//Time complexity is O(V + E)
//First In First Out (FIFO) of graph ensures traversal of graph one level at time
public class BreadFirstSearch {

    public static String bfsTraversal(Graph g , int source) {

        String result = "";
        int numVertices = g.vertices;
        //Create Queue for Breadth First search and enqueue source in it
        Queue<Integer> queue = new Queue<>(numVertices);

        //boolean Array to hold the history of visited nodes by default false
        //Make a node whenever we enqueue it to queue
        boolean[] visited = new boolean[numVertices];

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while(!queue.isEmpty()) {

            //Dequeue a node from queue to result
            int current_node = queue.dequeue();
            result += String.valueOf(current_node);

            //1. get the adjacent vertices to current node from array
            //2,  if they are not already visited then enqueue them  in Queue
            DoublyLinkedList<Integer>.Node temp = null;

            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }

            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; // visit the current node
                }
                temp = temp.nextNode;

            }
        }// end of while loop
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        System.out.println(bfsTraversal(g,0));
    }

}
