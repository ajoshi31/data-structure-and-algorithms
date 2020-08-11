package GraphAlgorithms.problems;

import java.util.*;

class APGraph {

    int V;
    public LinkedList<Integer>[] adjVertexList;

    public APGraph(int v) {
        this.V = v;
        adjVertexList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjVertexList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjVertexList[u].add(v);
        adjVertexList[v].add(u);
    }
}

public class ArticulationPoints {
    public int TIME = 0;

    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        */

        // Initializing Graph
        APGraph g1 = new APGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        ArticulationPoints ap = new ArticulationPoints();
        Set<Integer> aps = ap.AP(g1);
        aps.forEach(System.out::println);
    }

    public Set<Integer> AP(APGraph graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> articulationPoints = new HashSet<>();
        HashMap<Integer, Integer> descTime = new HashMap<>();
        HashMap<Integer, Integer> low = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        // initial vertex
        int vertex = 4;
        DFSTree(vertex, graph, visited, articulationPoints, parent, descTime, low);
        return articulationPoints;
    }

    public void DFSTree(int vertex, APGraph graph,
                        Set<Integer> visited,
                        Set<Integer> articulationPoints,
                        HashMap<Integer, Integer> parent,
                        HashMap<Integer, Integer> desc,
                        HashMap<Integer, Integer> low) {

        // Once you reach the vertex set all the data for that particualr node and then find its adj values
        visited.add(vertex);
        desc.put(vertex, TIME);
        low.put(vertex, TIME);
        TIME++;
        boolean isArticulationPoint = false;

        // This is for the root node only
        int childCount = 0; // Once you reach a new node it will have its children as zero.

        // Get all adj of this vertex
        for (Integer adjVertex : graph.adjVertexList[vertex]) {
            if (adjVertex.equals(parent.get(vertex))) {
                continue;
            }
            if (!visited.contains(adjVertex)) {
                parent.put(adjVertex, vertex);
                childCount++;
                DFSTree(adjVertex, graph, visited, articulationPoints, parent, desc, low);
                if (desc.get(vertex) <= low.get(adjVertex)) {
                    if (!desc.get(vertex).equals(low.get(adjVertex))) {
                        System.out.println(vertex + " - " + adjVertex); // to find bridge
                    }
                    isArticulationPoint = true;
                } else {
                    low.put(vertex, Math.min(low.get(adjVertex), low.get(vertex)));
                }
            } else {
                low.put(vertex, Math.min(desc.get(adjVertex), low.get(vertex)));
            }
        }
        if ((parent.get(vertex) == null && childCount >= 2) ||
                (parent.get(vertex) != null && isArticulationPoint)) {
            articulationPoints.add(vertex);
        }
    }
}

class Bridge {
    private int u;
    private int v;

    public Bridge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}