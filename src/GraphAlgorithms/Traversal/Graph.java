package GraphAlgorithms.Traversal;

import java.util.LinkedList;
import java.util.ListIterator;

class Graph {
    int V;
    LinkedList[] vertexList;

    Graph(int v) {
        this.V = v;
        vertexList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            vertexList[i] = new LinkedList<>();
        }
    }

    void traverseGraphList(Graph G) {
        int i = 0;
        for (LinkedList list : G.vertexList) {
            ListIterator itr = list.listIterator();
            System.out.print("src: " + i++ + " ");
            while (itr.hasNext()) {
                System.out.print("  -> " + itr.next());
            }
            System.out.println();
        }
    }

    void addEdge(Graph graph, int src, int dest) {
        // For Directed Graph Only
        graph.vertexList[src].add(dest);
    }
}
