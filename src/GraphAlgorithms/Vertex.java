package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex<T> {


    long id;
    private T data;
    private Map<Vertex<T>, Integer> edgeMap = new HashMap<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    void addAdjacentVertex(int weight, Vertex v) {
        edgeMap.put(v, weight);
        adjacentVertex.add(v);
    }

    int getWeigth(Vertex<T> dest) {
        return edgeMap.get(dest);
    }

    public List<Vertex<T>> getAdjacentVertex() {
        return adjacentVertex;
    }

}
