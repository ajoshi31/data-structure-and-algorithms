package GraphAlgorithms.ListRepresentation;

import java.util.LinkedList;
import java.util.ListIterator;

public class AdjacencyList {

    public static void main(String args[]) {

        int n = 5;
        Graph graph = new Graph(n);
        AdjacencyList adl = new AdjacencyList();
        adl.addEdges(graph, 0, 1);
        adl.addEdges(graph, 0, 4);
        adl.addEdges(graph, 1, 2);
        adl.addEdges(graph, 1, 3);
        adl.addEdges(graph, 1, 4);
        adl.addEdges(graph, 2, 3);
        adl.addEdges(graph, 3, 4);

        adl.traverseGraphList(graph);


    }


    private void addEdges(Graph G, int src, int dest) {

        G.vertexList[src].add(dest);
        //For undirected we need to reverse as well
        G.vertexList[dest].add(src);

    }

    private void traverseGraphList(Graph G) {

        int i = 0;
        for (LinkedList list : G.vertexList) {

            ListIterator itr = list.listIterator();

            System.out.print("Source: " + i++ + " ");
            while (itr.hasNext()) {
                System.out.print(" -> " + itr.next());
            }

            System.out.println();

        }

    }

}
