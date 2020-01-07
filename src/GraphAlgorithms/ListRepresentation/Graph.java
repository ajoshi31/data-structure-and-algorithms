package GraphAlgorithms.ListRepresentation;

import java.util.LinkedList;

public class Graph {
    public int V;
    public LinkedList[] vertexList;

    public Graph(int v) {
        this.V = v;
        vertexList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            vertexList[i] = new LinkedList<>();
        }
    }

}
