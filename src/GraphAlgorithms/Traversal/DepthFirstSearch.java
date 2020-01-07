package GraphAlgorithms.Traversal;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class DepthFirstSearch {

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

    private void DFSRecursive(Graph graph, int vertex) {
        if (vertex > graph.V) {
            throw new IllegalArgumentException("Value not defined");
        }
        boolean visited[] = new boolean[graph.V];
        DFSRecursiveUtil(graph, vertex, visited);

    }

    private void DFSRecursiveUtil(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Object o : graph.vertexList[vertex]) {
            int n = (int) o;
            if (!visited[n]) {
                DFSRecursiveUtil(graph, n, visited);
            }
        }
    }

    private void dfsIterative(Graph graph, int vertex) {

        if (vertex > graph.V) {
            throw new IllegalArgumentException("Value not defined");
        }

        boolean visited[] = new boolean[graph.V];
        Stack<Integer> stack = new Stack<>();


        stack.push(vertex);
        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (!visited[a]) {
                System.out.print(a + " ");
                visited[a] = true;
            }
            for (Object o : graph.vertexList[a]) {
                int n = (int) o;
                if (!visited[n]) {
                    stack.push(n);
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
                System.out.print("  -> " + itr.next());
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        DepthFirstSearch g = new DepthFirstSearch();

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

        System.out.println("DFS starting from node 2");

        g.DFSRecursive(graph, 2);
        System.out.println();
        g.dfsIterative(graph, 2);
        System.out.println();
        g.traverseGraphList(graph);

    }
}
