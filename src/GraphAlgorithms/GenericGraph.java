package GraphAlgorithms;

import java.util.*;

public class GenericGraph<T> {

    private boolean isDirected;
    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertices;

    public GenericGraph(boolean isDirected) {
        allVertices = new HashMap<>();
        allEdges = new ArrayList<>();
        this.isDirected = isDirected;
    }

    public Collection<Vertex<T>> getAllVertices() {
        return allVertices.values();
    }

    public Vertex<T> getVertex(long id) {
        return allVertices.get(id);
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public void setDataForVertex(long id, T data) {
        // Check if the vertex exist
        if (allVertices.containsKey(id)) {
            Vertex<T> v = allVertices.get(id);
            v.setData(data);
        }
    }

    public void addEdge(long src, long dest) {
        addEdge(src, dest, 0);
    }

    void addEdge(long src, long dest, int weight) {
        Vertex<T> v1 = avoidDuplicateVertex(src);
        Vertex<T> v2 = avoidDuplicateVertex(dest);
        allEdges.add(new Edge<T>(v1, v2, weight, isDirected));
        v1.addAdjacentVertex(weight, v2);
        if (!isDirected) {
            v2.addAdjacentVertex(weight, v1);
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