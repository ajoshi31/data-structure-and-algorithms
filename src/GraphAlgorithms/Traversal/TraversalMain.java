package GraphAlgorithms.Traversal;

public class TraversalMain {

    public static void main(String args[]) {

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        DepthFirstSearch dfs = new DepthFirstSearch();

        int n = 8;
        Graph graph = new Graph(n);
        graph.addEdge(graph, 0, 1);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 1, 2);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 2, 3);
        graph.addEdge(graph, 3, 3);
        graph.addEdge(graph, 3, 4);
        graph.addEdge(graph, 5, 4);
        graph.addEdge(graph, 5, 6);
        graph.addEdge(graph, 7, 6);
        System.out.println("BFS starting from node 2");
        bfs.bfs(graph, 2);

        System.out.println();
        graph.traverseGraphList(graph);

        System.out.println("DFS starting from node 2");
        dfs.DFSRecursive(graph, 2);
        System.out.println();
        dfs.dfsIterative(graph, 2);
        System.out.println();
        graph.traverseGraphList(graph);

    }
}
