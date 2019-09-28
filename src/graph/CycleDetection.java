package graph;

import linkedList.DoublyLinkedList;

//logic is in stackFlag rest is DFS implementation
//we recursively call cyclic function on outgoing path to check any node in stack
// if true that means we found a path from that node back to itself
//time complexity is O(V+E)
public class CycleDetection {

    public static boolean detectCycle(Graph g) {

        int num_vertices = g.vertices;

        //boolean array to hold history of visited nodes
        boolean[] stackFlag = new boolean[num_vertices];

        //hold a falg to check if node is currently in stack or not
        boolean[] visited = new boolean[num_vertices];

        for (int i = 0; i <g.vertices ; i++) {
            //check cyclic on each node
            if(cycle(g,i,stackFlag,visited))
                return true;
        }
        return false;
    }

    public static boolean cycle(Graph g , int v , boolean[] stackFlag , boolean[] visited){

        //if node is currenly in stack means we have found cycle
        if(stackFlag[v]){
            return true;
        }

        //if its already visited and not in stack then its not cycle
        if(visited[v]){
            return false;
        }

        stackFlag[v] = true;
        visited[v] = true;

        // check adjacency list of node
        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[v] != null) {
            temp = g.adjacencyList[v].headNode;
        }

        while(temp != null) {
            //run cyclic function recursive on each outgrowing path
            if(cycle(g,temp.data,stackFlag,visited)){
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,0);

        g.printGraph();

        System.out.println(detectCycle(g));
    }
}
