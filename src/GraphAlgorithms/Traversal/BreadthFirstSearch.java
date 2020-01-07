package GraphAlgorithms.Traversal;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BreadthFirstSearch {

    static class Graph {
        int V;
        LinkedList[] vertexList;

        Graph(int v) {
            this.V = v;
            vertexList = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                vertexList[i] = new LinkedList<>();
            }
        }
    }

    private void addEdge(Graph graph, int src, int dest) {
        graph.vertexList[src].add(dest); // Directed Graph Only
    }

    private void bfs(Graph graph, int vertex) {

        if (vertex > graph.V) {
            throw new IllegalArgumentException("Value not defined");
        }
        boolean visited[] = new boolean[graph.V];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (!visited[a]) {
                System.out.print(a + " ");
                visited[a] = true;

            }
            for (Object o : graph.vertexList[a]) {
                int n = (int) o;
                if (!visited[n]) {
                    queue.add(n);
                }
            }
        }
    }

    private void traverseGraphList(Graph G) {
        int i = 0;
        for (LinkedList list : G.vertexList) {
            ListIterator itr = list.listIterator();
            System.out.print("src: " + i++ + " ");
            while (itr.hasNext()) {
                System.out.print(" -> " + itr.next());
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        BreadthFirstSearch g = new BreadthFirstSearch();
        int n = 8;
        Graph graph = new Graph(n);
        g.addEdge(graph, 0, 1);
        g.addEdge(graph, 0, 2);
        g.addEdge(graph, 1, 2);
        g.addEdge(graph, 2, 0);
        g.addEdge(graph, 2, 3);
        g.addEdge(graph, 3, 3);
        g.addEdge(graph, 3, 4);
        g.addEdge(graph, 5, 4);
        g.addEdge(graph, 5, 6);
        g.addEdge(graph, 7, 6);
        System.out.println("BFS starting from node 2");
        g.bfs(graph, 2);

        System.out.println();
        g.traverseGraphList(graph);
        //2 0 3 1 4

    }
}