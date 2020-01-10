package GraphAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class Dijkstras {

    class Node<T> {
        int minDistance = -1;
        Vertex<T> parentVertex = null;
    }

    private Map<Vertex<Integer>, Node<Integer>> dijkstraShortestPath(GenericGraph<Integer> graph, Vertex<Integer> sourcePoint) {

        BinaryMinHeapMap<Vertex<Integer>> heapMap = new BinaryMinHeapMap<>();
        Map<Vertex<Integer>, Node<Integer>> distancePathMap = new HashMap<>();

        heapMap.addToHeap(0, sourcePoint);

        //Initialise all the vertex with the -1 in the distancePathMap
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            distancePathMap.put(vertex, new Node<>());
        }

        // Update the distance and path in the map
        distancePathMap.get(sourcePoint).minDistance = 0;
        distancePathMap.get(sourcePoint).parentVertex = sourcePoint;

        while (!heapMap.empty()) {

            GraphAlgorithms.Node<Vertex<Integer>> node = heapMap.extractMin();
            Vertex<Integer> currentNode = node.getKey();
            for (Vertex<Integer> v : currentNode.getAdjacentVertex()) {
                int distance = distancePathMap.get(currentNode).minDistance + currentNode.getWeigth(v);
                // If unvisited add it to the heap and update the distsance map
                if (distancePathMap.get(v).minDistance == -1) {
                    distancePathMap.get(v).minDistance = distance;
                    distancePathMap.get(v).parentVertex = currentNode;
                    heapMap.addToHeap(distance, v);
                }
                if (distancePathMap.get(v).minDistance > distance) {
                    distancePathMap.get(v).minDistance = distance;
                    distancePathMap.get(v).parentVertex = currentNode;
                    heapMap.decreaseVal(v, distance);
                }
            }
        }
        return distancePathMap;
    }


    public static void main(String args[]) {

        GenericGraph<Integer> graph = new GenericGraph<>(false);

        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);

        Vertex<Integer> sourceVertex = graph.getVertex(2);
        Dijkstras dijkstras = new Dijkstras();

        Map<Vertex<Integer>, Node<Integer>> map = dijkstras.dijkstraShortestPath(graph, sourceVertex);

        System.out.println("Distance of nodes from " + 2);
        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();
            Node b = (Node) mapElement.getValue();

            System.out.println("Min distance to " + a.getId() + " is " + b.minDistance + " via " + b.parentVertex.id);
        }
    }
}
