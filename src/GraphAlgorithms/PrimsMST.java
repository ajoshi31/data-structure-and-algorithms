package GraphAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class PrimsMST {

    public static void main(String args[]) {
        GenericGraph<Integer> genericGraph = new GenericGraph<>(false);

        genericGraph.addEdge(1, 2, 10);
        genericGraph.addEdge(2, 3, 5);
        PrimsMST primMST = new PrimsMST();
        Map<Vertex<Integer>, Vertex<Integer>> map = primMST.primsMST(genericGraph);

        for (Object o : map.entrySet()) {
            Map.Entry mapElement = (Map.Entry) o;
            Vertex<Integer> a = (Vertex<Integer>) mapElement.getKey();
            Vertex<Integer> b = (Vertex<Integer>) mapElement.getValue();
            System.out.println("Source: " + b.id + " -> Dest: " + a.id);
        }
    }

    private Map<Vertex<Integer>, Vertex<Integer>> primsMST(GenericGraph<Integer> graph) {

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
                        edgeMap.put(v1, currentVertex);
                    }
                }
            }
        }
        return result;
    }
}
