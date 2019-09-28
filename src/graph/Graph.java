package graph;

import linkedList.DoublyLinkedList;
//Applications of Graph :
//1. GPS navigation system,
// 2. shortest path finding,
// 3.peer to peer networks,
// 4. crawlers in the search engine,
// 5. garbage collection (java), and
// 6. even social networking websites.

public class Graph {

     int vertices;
     DoublyLinkedList<Integer> adjacencyList[];

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];

        for (int i = 0; i < vertices ; i++) {
            adjacencyList[i] = new DoublyLinkedList<>();
        }

    }

    public void addEdge(int source , int destination){
        this.adjacencyList[source].insertAtEnd(destination);

        //for unidirectoed graph uncomment below line
        //this.adjacencyList[destination].insertAtEnd(source);
    }

    public void printGraph() {
        System.out.println("Data -> ");
        for (int i = 0; i <vertices ; i++) {

            if (this.adjacencyList[i] != null) {
                DoublyLinkedList<Integer>.Node current = this.adjacencyList[i].headNode;
                System.out.print("|" + i + "|" + " => ");

                while (current != null) {
                    System.out.print("[" + current.data + "]" + "->");
                    current = current.nextNode;
                }
                System.out.println(" null  ");
            }
            else {
                System.out.print("|" + i + "|" + " => null ");
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,0);

        graph.printGraph();

    }


}
