package GraphAlgorithms;

public class Edge<T> {
    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDirected() {
        return isDirected;
    }

    private Vertex v1;
    private Vertex v2;
    private int weight;
    private boolean isDirected;

    Edge(Vertex v1, Vertex v2, int weight, boolean isDirected) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        this.isDirected = isDirected;
    }


    @Override
    public String toString() {
        return "Edge [isDirected= " + isDirected + ", v1 = " + v1.id
                + ", v2 = " + v2.id + ", weight = " + weight + "]";
    }
}
