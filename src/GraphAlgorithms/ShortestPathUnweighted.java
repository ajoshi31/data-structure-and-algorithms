package GraphAlgorithms;

import java.util.*;

public class ShortestPathUnweighted {

    private Map<Vertex<Integer>, Integer> shortestPathUnweighted(GenericGraph<Integer> graph, int fromVertex) {
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        Map<Vertex<Integer>, Integer> vertexDistanceMap = new HashMap<>();
        Vertex<Integer> vStart = null;
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            if (vertex.id == fromVertex) {
                vStart = vertex;
            }
            vertexDistanceMap.put(vertex, -1);
        }

        queue.add(vStart);

        vertexDistanceMap.put(vStart, 0);
        while (!queue.isEmpty()) {
            Vertex<Integer> v1 = queue.poll();
            for (Vertex<Integer> adjVertex : v1.getAdjacentVertex()) {
                if (vertexDistanceMap.get(adjVertex) == -1) {
                    int distance = vertexDistanceMap.get(v1) + 1;
                    vertexDistanceMap.put(adjVertex, distance);
                    queue.add(adjVertex);
                }
            }
        }
        return vertexDistanceMap;
    }

    public static void main(String args[]) {
        GenericGraph<Integer> genericGraph = new GenericGraph<>(true);
        genericGraph.addEdge(1, 2);
        genericGraph.addEdge(2, 3);
        genericGraph.addEdge(1, 3);
        genericGraph.addEdge(2, 4);
        genericGraph.addEdge(3, 4);
        ShortestPathUnweighted sp = new ShortestPathUnweighted();
        Map<Vertex<Integer>, Integer> map = sp.shortestPathUnweighted(genericGraph, 1);

        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();

            System.out.println(a.getId() + " - " + mapElement.getValue());
        }
    }
}

