package GraphAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class Dijkstras {

    class Node<T> {
        int minDistance = -1;
        Vertex<T> parentVertex = null;
    }

    public Map<Vertex<Integer>, Node<Integer>> dijkstraShortestPath(GenericGraph<Integer> graph, Vertex<Integer> sourcePoint) {

        BinaryMinHeapMap<Vertex<Integer>> heapMap = new BinaryMinHeapMap<>();
        Map<Vertex<Integer>, Node<Integer>> distancePathMap = new HashMap<>();

        heapMap.addToHeap(0, sourcePoint);
        //Initialise all the vertex with the -1 in the distancePathMap
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            distancePathMap.put(vertex, new Node<>());
        }

        // Add the source to heap


        // Update the distance and path in the map
        distancePathMap.get(sourcePoint).minDistance = 0;
        distancePathMap.get(sourcePoint).parentVertex = sourcePoint;

        while (!heapMap.empty()) {

            GraphAlgorithms.Node<Vertex<Integer>> node = heapMap.extractMin();
            Vertex<Integer> currentNode = node.getKey();
            for (Vertex<Integer> v : currentNode.getAdjacentVertex()) {
                int distance = distancePathMap.get(currentNode).minDistance + currentNode.getWeigth(v);

                // If unvisited add it to the heap and update the distance map
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

        GenericGraph<Integer> graph = new GenericGraph<>(true);

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        Vertex<Integer> sourceVertex = graph.getVertex(1);
        Dijkstras dijkstras = new Dijkstras();


        Map<Vertex<Integer>, Node<Integer>> map = dijkstras.dijkstraShortestPath(graph, sourceVertex);

        System.out.println("Distance of nodes from " + 1);
        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();
            Node b = (Node) mapElement.getValue();

            System.out.println("Min distance to " + a.getId() + " is " + b.minDistance + " via " + b.parentVertex.id);
        }


    }

}
