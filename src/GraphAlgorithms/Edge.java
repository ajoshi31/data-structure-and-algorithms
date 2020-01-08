package GraphAlgorithms;

public class Edge<T> {
    private Vertex v1;
    private Vertex v2;
    private boolean isDirected = false;
    private int weight;

    Edge(Vertex v1, Vertex v2, boolean isDirected, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
}
