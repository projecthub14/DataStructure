package graph;

import linkedList.DoublyLinkedList;

import java.util.Stack;

public class CheckPathExists {

    public static boolean checkPathExists(Graph g, int source , int destination){

        boolean[] visited = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()){
            int node = stack.pop();

            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[node] != null){
                temp = g.adjacencyList[node].headNode;
            }
            while (temp!=null){
                if(temp.data == destination)
                    return true;
                if(!visited[temp.data]){
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
        }
        return false;

    }

    public static void main(String[] args) {

        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();

        System.out.println("Path exists: " + checkPathExists(g1, 0, 7));

    }
}
