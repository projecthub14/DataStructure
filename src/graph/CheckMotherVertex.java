package graph;

import linkedList.DoublyLinkedList;

import java.util.Arrays;

public class CheckMotherVertex {

    public static int checkMotherVertex(Graph g){
        //array to store  visited flag
        boolean[] visited = new boolean[g.vertices];

        //variable to hold last value
        int lValue = 0;

        //mark all visited array to false
        Arrays.fill(visited,false);

        //do DFS to get last visited vertex
        for (int i = 0; i <g.vertices ; i++) {
          if(visited[i] == false) {
              visited = DFS(g, i, visited);
              lValue = i;
          }
        }

        // If there exist mother vertex (or vetices) in given
        // graph, then lastV must be one (or one of them)

        // Now check if lastV is actually a mother vertex (or graph
        // has a mother vertex). We basically check if every vertex
        // is reachable from lastV or not.

        // Reset all values in visited[] as false and do
        // DFS beginning from lastV to check if all vertices are
        // reachable from it or not.

        Arrays.fill(visited,false);
        visited = DFS(g,lValue,visited);

        for (int i = 0; i <g.vertices ; i++) {
            if(!visited[i]){
                return -1;
            }
        }

        return lValue;
    }

    // A recursive function to print DFS starting from v
    public static  boolean[] DFS(Graph g,int i,boolean[] visited){
        visited[i] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[i] != null){
            temp = g.adjacencyList[i].headNode;
        }

        while(temp!= null){
            if(visited[temp.data]){
                temp = temp.nextNode;
            }
            else{
                visited[temp.data] = true;
                visited = DFS(g,temp.data,visited);
                temp = temp.nextNode;
            }
        }
        return visited;
    }



    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        int motherVertex = checkMotherVertex(g);
        System.out.println("Mother Vertex is " + motherVertex);
    }
}
