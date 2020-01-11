package GraphAlgorithms;

import DisjointSets.DisJointSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    public class EdgeComparator implements Comparator<Edge<Integer>> {

        @Override
        public int compare(Edge<Integer> o1, Edge<Integer> o2) {
            if (o1.getWeight() <= o2.getWeight()) {
                return -1;
            } else {
                return 1;
            }

        }
    }

    public List<Edge<Integer>> kruskalMst(GenericGraph<Integer> graph) throws Exception {

        List<Edge<Integer>> edgeList = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();
        //Sort the list in dec ordr
        edgeList.sort(edgeComparator);

        DisJointSets disJointSets = new DisJointSets();

        // Make the all vertices as unique sets
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            disJointSets.makeSet(vertex.getId());
        }

        List<Edge<Integer>> result = new ArrayList<>();

        for (Edge<Integer> edge : edgeList) {

            //union of the edge vertices
            boolean isNeededEdge = disJointSets.quickUnion(edge.getV1().getId(), edge.getV2().getId());
            if (isNeededEdge) {
                result.add(edge);
            }

        }


        return result;

    }

    public static void main(String args[]) throws Exception {

        GenericGraph<Integer> graph = new GenericGraph<>(false);

        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 3);
        ;

        KruskalMST kruskalMST = new KruskalMST();
        List<Edge<Integer>> result = kruskalMST.kruskalMst(graph);

        for (Edge<Integer> edge : result) {

            System.out.println(edge.toString());
        }

    }
}
