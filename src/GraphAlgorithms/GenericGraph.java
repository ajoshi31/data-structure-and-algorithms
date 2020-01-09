package GraphAlgorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericGraph<T> {

    private boolean isDirected;
    private Map<Long, Vertex<T>> allVertices;

    public GenericGraph(boolean isDirected) {
        allVertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Collection<Vertex<T>> getAllVertices() {
        return allVertices.values();
    }

    public void setDataForVertex(long id, T data) {
        // Check if the vertex exist
        if (allVertices.containsKey(id)) {
            Vertex<T> v = allVertices.get(id);
            v.setData(data);
        }
    }

    public void addEdge(long src, long dest) {

        Vertex<T> v1 = avoidDuplicateVertex(src);
        Vertex<T> v2 = avoidDuplicateVertex(dest);

        v1.addAdjacentVertex(v2);
        if (!isDirected) {
            v2.addAdjacentVertex(v1);
        }
    }

    private Vertex<T> avoidDuplicateVertex(long vertexId) {
        Vertex<T> v;
        if (allVertices.containsKey(vertexId)) {
            v = allVertices.get(vertexId);
        } else {
            v = new Vertex<>(vertexId);
            allVertices.put(vertexId, v);
        }
        return v;
    }
}