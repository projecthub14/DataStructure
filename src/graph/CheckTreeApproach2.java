package graph;


import linkedList.DoublyLinkedList;
import stackQueue.Queue;

//Time complexity is O(V+E)
public class CheckTreeApproach2 {

    public static boolean isTree(Graph g){

        //boolean array to hold the history of visited nodes
        //make the node visited when we enqueue it into queue
        boolean[] isVisited = new boolean[g.vertices];

        //create queue for Breadth First Traversal and
        // enqueu root it
        Queue<Integer> queue = new Queue<>(g.vertices);
        //stor the number of nodes visited to check if all nodes
        // are visited
        int num_vertices_visited= 1;

        int root = 0;

        queue.enqueue(root);
        isVisited[root] = true;

        //check is queue is not empty
        while(!queue.isEmpty()){

            //dequeue the node from queue
            int currentNode = queue.dequeue();

            //get the adjacency vertices to current_node from array
            //if not visited then enqueu to queue
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[currentNode] != null){
                temp = g.adjacencyList[currentNode].headNode;
            }
            while(temp != null){
                if(!isVisited[temp.data]){
                    queue.enqueue(temp.data);
                    isVisited[temp.data] = true; //visit the current node
                    num_vertices_visited++;

                }
                else{
                    return false;
                }
                temp = temp.nextNode;
            }
        }

        //if all nodes visited then return true
        if(g.vertices == num_vertices_visited){
            return true;
        }
        else{
            return false;
        }

    }



    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

    }

}
