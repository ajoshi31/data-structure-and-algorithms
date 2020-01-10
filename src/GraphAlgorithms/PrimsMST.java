package GraphAlgorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMST {

    public static void main(String args[]) {
        GenericGraph<Integer> genericGraph = new GenericGraph<>(false);

        genericGraph.addEdge(1, 2);
        genericGraph.addEdge(2, 3);
        genericGraph.addEdge(1, 3);
        genericGraph.addEdge(2, 4);
        genericGraph.addEdge(3, 4);
        PrimsMST primMST = new PrimsMST();
        Map<Vertex<Integer>, Vertex<Integer>> map = primMST.primsMST(genericGraph);

        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();
            ShortestPathUnweighted.Node b = (ShortestPathUnweighted.Node) mapElement.getValue();

            System.out.println("Min distance to " + a.getId() + " is " + b.minDistance + " via " + b.parentVertex.id);
        }

    }

    public Map<Vertex<Integer>, Vertex<Integer>> primsMST(GenericGraph<Integer> graph) {

        BinaryMinHeapMap<Vertex<Integer>> minHeap = new BinaryMinHeapMap<>();

        Map<Vertex<Integer>, Vertex<Integer>> edgeMap = new HashMap<>();

        Map<Vertex<Integer>, Vertex<Integer>> result = new HashMap<>();

        for (Vertex<Integer> v : graph.getAllVertices()) {
            minHeap.addToHeap(Integer.MAX_VALUE, v);
        }

        Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();

        minHeap.decreaseVal(startVertex, 0);

        while (!minHeap.empty()) {

            Vertex<Integer> currentVertex = minHeap.extractMin().getKey();

            Vertex<Integer> edgeVertex = edgeMap.get(currentVertex);
            if (edgeVertex != null) {
                result.put(currentVertex, edgeVertex);
            }

            for (Vertex<Integer> v1 : currentVertex.getAdjacentVertex()) {
                if (minHeap.containsKey(v1)) {
                    // if weight of the v1 < in map update
                    if (currentVertex.getWeigth(v1) < minHeap.getKeyWeight(v1)) {
                        minHeap.decreaseVal(v1, currentVertex.getWeigth(v1));
                        edgeMap.put(currentVertex, v1);
                    }
                }

            }


        }

        return result;

    }
}
