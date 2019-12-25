package GraphAlgorithms;

import java.util.Stack;

class Graph {

    private final int maxVertices = 20;
    private int adjMatrix[][];
    private int vertexCount;
    private Vertex vertexList[];
    private Stack stack;

    public Graph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int i = 0; i < maxVertices; i++)
            for (int j = 0; j < maxVertices; j++)
                adjMatrix[i][i] = 0;
        stack = new Stack();

    }

    public void addVertex(char label) {
        vertexList[vertexCount++].label = label;
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }
}
