package GraphAlgorithms;

public class Edge<T> {
    private Vertex v;
    private int weight;

    Edge(Vertex v1, int weight) {
        this.v = v1;
        this.weight = weight;
    }
}
