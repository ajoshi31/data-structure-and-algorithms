package GraphAlgorithms;

import java.util.*;

public class ShortestPathUnweighted {

    class Node {
        int minDistance = -1;
        Vertex<Integer> parentVertex = null;
    }

    private Map<Vertex<Integer>, Node> shortestPathUnweighted(GenericGraph<Integer> graph, int fromVertex) {
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        Map<Vertex<Integer>, Node> vertexDistanceMap = new HashMap<>();
        Vertex<Integer> vStart = null;
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            if (vertex.id == fromVertex) {
                vStart = vertex;
            }
            vertexDistanceMap.put(vertex, new Node());
        }

        queue.add(vStart);
        vertexDistanceMap.get(vStart).minDistance = 0;
        vertexDistanceMap.get(vStart).parentVertex = vStart;

        while (!queue.isEmpty()) {
            Vertex<Integer> v1 = queue.poll();
            for (Vertex<Integer> adjVertex : v1.getAdjacentVertex()) {
                // If not visited till yet
                if (vertexDistanceMap.get(adjVertex).minDistance == -1) {
                    vertexDistanceMap.get(adjVertex).minDistance = vertexDistanceMap.get(v1).minDistance + 1;
                    vertexDistanceMap.get(adjVertex).parentVertex = v1;
                    queue.add(adjVertex);
                }
            }
        }
        return vertexDistanceMap;
    }

    public static void main(String args[]) {
        GenericGraph<Integer> genericGraph = new GenericGraph<>(true);

        int from = 1;
        genericGraph.addEdge(1, 2);
        genericGraph.addEdge(2, 3);
        genericGraph.addEdge(1, 3);
        genericGraph.addEdge(2, 4);
        genericGraph.addEdge(3, 4);
        ShortestPathUnweighted sp = new ShortestPathUnweighted();
        Map<Vertex<Integer>, Node> map = sp.shortestPathUnweighted(genericGraph, from);

        System.out.println("Distance of nodes from " + from);
        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();
            Node b = (Node) mapElement.getValue();

            System.out.println("Min distance to " + a.getId() + " is " + b.minDistance + " via " + b.parentVertex.id);
        }

        //Min distance from Src to Dest and its path


    }
}

