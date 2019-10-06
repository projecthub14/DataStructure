package graph;


import linkedList.DoublyLinkedList;
import stackQueue.Queue;

//BreadthFirstTraversal
//main logic lies in distance -> indexed value in distance shows
//the node's distance from source interms of number of edges

//timeComplexity is O(V+E)
public class CheckShortestPath {


    public static int checkShortestPath(Graph g, int source , int destination){

        //Boolean Array to hold history of visited nodes
        // make node visited whenever we enqueue to queue
        boolean[] visited = new boolean[g.vertices];

        //integer array to hold distance of node from cuurent_node(root)
        int[] distance_node = new int[g.vertices];

        //Create Queue for Bread First Traversal and enqueue source
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(source);
        visited[source] = true;

        //Traverse while queue is not empty
        while (!queue.isEmpty()){

            //dequeue vertex from queue
            int currentNode = queue.dequeue();

            //Get the adjacent node to current node from array
            DoublyLinkedList<Integer>.Node temp = null;

            if(g.adjacencyList[currentNode] != null){
                temp = g.adjacencyList[currentNode].headNode;
            }

            while(temp != null){
                //if not visited then enqueue to queue
                //mark it has visited
                //update distance of node from source node(current_node) + 1
                if(!visited[temp.data]){
                    visited[temp.data] = true;
                    distance_node[temp.data] = distance_node[currentNode]+1;
                    queue.enqueue(temp.data);

                }
                if(temp.data == destination){
                    return distance_node[temp.data];
                }
                temp = temp.nextNode;
            }
        }//end of while
       return -1;
    }

    public static void main(String[] args) {

        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(checkShortestPath(g, 0, 4));

    }
}
