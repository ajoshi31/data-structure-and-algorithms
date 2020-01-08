package GraphAlgorithms.Traversal;

import java.util.Stack;

class DepthFirstSearch {


    void DFSRecursive(Graph graph, int vertex) {
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

    void dfsIterative(Graph graph, int vertex) {

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


}
