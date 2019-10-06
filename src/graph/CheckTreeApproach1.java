package graph;

import linkedList.DoublyLinkedList;

import java.util.Stack;

//Time Complexity : O(V+E)
public class CheckTreeApproach1 {

    public static boolean isTree(Graph g ){
        if(checkOneParent(g)){
            return false;
        }
        if(checkCycle(g)){
            return false;
        }
        if(!checkConnected(g,0)){
            return false;
        }
        return true;
    }


    public static boolean checkConnected(Graph g,int source){
        //Boolean array to hold history of visited nodes
        //make a node visited once pushed to stack
        boolean[] visited = new boolean[g.vertices];

        //Create stack for depthFirstTraversal
        Stack<Integer> stack = new Stack<Integer>();
        int numberNodeVisited = 0;

        stack.push(source);
        visited[source] = true;

        //Traverse while stack is not empty
        while(!stack.isEmpty()){
            //pop from stack to traverse
            int currentNode = stack.pop();

            //check the adjacent vertices from current node in array
            //push unvisted nodes into stack
            //increment vertices_reached
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[currentNode] != null){
                temp = g.adjacencyList[currentNode].headNode;
            }

            while(temp != null){
                if(!visited[temp.data]){
                    stack.push(temp.data);
                    visited[temp.data] = true;
                    numberNodeVisited++;
                }
                temp = temp.nextNode;
            }

        }
        //+1 for  source , and if the number of vertices reacheable from source are equal
        //to the total number of vertices in graph then return true
        return numberNodeVisited+1 == g.vertices;

    }


    public static boolean checkCycle(Graph g){

        boolean[] stackFlag = new boolean[g.vertices];
        boolean[] isVisited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {

            if(isCycle(g,i,stackFlag,isVisited)){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(Graph g,int v,boolean[] stackFlag,boolean[] isVisited){
        if(stackFlag[v]){
            return true;
        }

        if(isVisited[v]){
            return false;
        }

        stackFlag[v] = true;
        isVisited[v] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[v] != null){
            temp = g.adjacencyList[v].headNode;
        }
        while(temp!=null){
            if(isCycle(g, temp.data, stackFlag, isVisited)){
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
    }

    public static boolean checkOneParent(Graph g){

        boolean[] hasOneParent = new boolean[g.vertices];

        DoublyLinkedList<Integer>.Node temp = null;
        for (int i = 0; i <g.vertices ; i++) {
            if(g.adjacencyList[i] != null){
                temp = g.adjacencyList[i].headNode;
            }

            while(temp != null){
                //check if node has parent node already
                if(hasOneParent[temp.data]){
                    return false;
                }
                // set the has parent node to true
                hasOneParent[temp.data] = true;
                temp = temp.nextNode;
            }
        }

        //traverse the graph to check
        //if source 0 has parent node
        //if other node has no parent
        for (int i = 0; i <g.vertices ; i++) {

            if(i==0 && hasOneParent[i] == true){
                return false;
            }
            if(i!=0 && hasOneParent[i] == false){
                return false;
            }

        }
        return false;



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
