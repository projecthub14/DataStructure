package graph;

import linkedList.DoublyLinkedList;


//We simply traverse through the complete adjacency list and count the size of each linked list.
// In an undirected graph, the number of edges is always even because the edges are bidirectional.
// Hence, to get the number of unique edges, we halve the total sum.
//Time Complexity : O(V+E)
public class CheckNumEdges {

    public static int numberOfEdges(Graph g){
        int sum = 0;

        for (int i = 0; i < g.vertices; i++) {

            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[i] != null){
                temp = g.adjacencyList[i].headNode;
            }

            while(temp != null){
                sum++;
                temp = temp.nextNode;
            }
        }
        return sum ;
    }


    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(6,4);
        g.addEdge(7,8);

        g.printGraph();

        System.out.println("Total number of edges is " + numberOfEdges(g));


    }
}
