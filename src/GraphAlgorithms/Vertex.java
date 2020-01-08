package GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {


    long id;
    private T data;


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

    void addAdjacentVertex(Vertex v) {
        adjacentVertex.add(v);
    }

    public List<Vertex<T>> getAdjacentVertex() {
        return adjacentVertex;
    }


}
