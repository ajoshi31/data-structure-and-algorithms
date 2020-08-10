package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex<T> {

    long id;
    private final Map<Vertex<T>, Integer> edgeMap = new HashMap<>();
    private final List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    public void setData(T data) {
    }

    public long getId() {
        return id;
    }

    void addAdjacentVertex(int weight, Vertex v) {
        edgeMap.put(v, weight);
        adjacentVertex.add(v);
    }

    int getWeight(Vertex<T> dest) {
        return edgeMap.get(dest);
    }

    public List<Vertex<T>> getAdjacentVertex() {
        return adjacentVertex;
    }

}
