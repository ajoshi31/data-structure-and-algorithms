package GraphAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordShortestPath {


    private class NegativeWeightCycleException extends RuntimeException {

    }

    private Map<Vertex<Integer>, Integer> bellmanFordShortestPath(GenericGraph<Integer> graph, Vertex<Integer> sourceVertex) {

        Map<Vertex<Integer>, Integer> vertexDistanceMap = new HashMap<>();
        Map<Vertex<Integer>, Vertex<Integer>> parentPathMap = new HashMap<>();

        /*Initialise*/
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            vertexDistanceMap.put(vertex, Integer.MAX_VALUE);
            parentPathMap.put(vertex, null);
        }

        vertexDistanceMap.put(sourceVertex, 0);
        for (int i = 1; i < vertexDistanceMap.size() - 1; i++) {

            for (Edge<Integer> edge : graph.getAllEdges()) {

                Vertex u = edge.getV1();
                Vertex v = edge.getV2();

                if (vertexDistanceMap.get(v) > vertexDistanceMap.get(u) + edge.getWeight()) {
                    vertexDistanceMap.put(v, vertexDistanceMap.get(u) + edge.getWeight());
                    parentPathMap.put(v, u);

                }
            }
        }

        for (Edge<Integer> edge : graph.getAllEdges()) {
            Vertex u = edge.getV1();
            Vertex v = edge.getV2();
            if (vertexDistanceMap.get(v) > vertexDistanceMap.get(u) + edge.getWeight()) {
                throw new NegativeWeightCycleException();
            }
        }
        return vertexDistanceMap;
    }

    public static void main(String args[]) {

        GenericGraph<Integer> graph = new GenericGraph<>(false);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);

        BellmanFordShortestPath blf = new BellmanFordShortestPath();
        Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();
        Map<Vertex<Integer>, Integer> distance = blf.bellmanFordShortestPath(graph, startVertex);

        System.out.println("Distance of nodes from " + startVertex.id);
        System.out.println(distance);
    }
}
