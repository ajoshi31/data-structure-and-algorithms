package GraphAlgorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericGraph<T> {

    private boolean isDirected;
    private Map<Long, Vertex<T>> allVertices;

    public GenericGraph(boolean isDirected) {
        allVertices = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public Collection<Vertex<T>> getAllVertices() {
        return allVertices.values();
    }

    public void setDataForVertex(long id, T data) {
        // Check if the vertex exisit

        if (allVertices.containsKey(id)) {
            Vertex<T> v = allVertices.get(id);
            v.setData(data);
        }
    }

    public void addEdge(long src, long dest) {

        Vertex<T> v1 = null;
        //Check the vertices in the graph if exist then get vertex to create edge else create the vertex
        if (allVertices.containsKey(src)) {
            v1 = allVertices.get(src);
        } else {
            v1 = new Vertex<>(src);
            allVertices.put(src, v1);
        }

        Vertex<T> v2 = null;
        if (allVertices.containsKey(dest)) {
            v2 = allVertices.get(dest);
        } else {
            v2 = new Vertex<>(dest);
            allVertices.put(dest, v2);
        }

        v1.addAdjacentVertex(v2);
        if (!isDirected) {
            v2.addAdjacentVertex(v1);
        }
    }
}