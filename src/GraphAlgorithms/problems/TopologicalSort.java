package GraphAlgorithms.problems;

import GraphAlgorithms.GenericGraph;
import GraphAlgorithms.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a directed acyclic graph, do a topological sort on this graph.
 * Space and time complexity is O(n).
 */

public class TopologicalSort<T> {

    public static void main(String args[]) {

        GenericGraph graph = new GenericGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(3, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);

        TopologicalSort<Integer> topologicalSort = new TopologicalSort<Integer>();
        Stack<Vertex<Integer>> result = topologicalSort.topologicalSort(graph);

        while (!result.isEmpty()) {
            Vertex<Integer> ans = result.pop();
            System.out.print(ans.getId() + " ");
        }
    }

    private Stack<Vertex<T>> topologicalSort(GenericGraph graph) {
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visitedVertexSet = new HashSet<>();
        for (Object vertex : graph.getAllVertices()) {
            if (visitedVertexSet.contains(vertex)) {
                continue;
            }
            topologicalSortUtil((Vertex<T>) vertex, stack, visitedVertexSet);
        }
        return stack;
    }

    private void topologicalSortUtil(Vertex<T> vertex, Stack<Vertex<T>> stack, Set<Vertex<T>> visitedVertexSet) {

        visitedVertexSet.add(vertex);
        for (Vertex<T> adjVertex : vertex.getAdjacentVertex()) {
            if (visitedVertexSet.contains(adjVertex)) {
                continue;
            }
            topologicalSortUtil(adjVertex, stack, visitedVertexSet);
        }
        stack.push(vertex);
    }
}

