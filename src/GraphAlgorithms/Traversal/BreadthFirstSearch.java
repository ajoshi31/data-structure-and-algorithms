package GraphAlgorithms.Traversal;

import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearch {

    void bfs(Graph graph, int vertex) {
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
}


