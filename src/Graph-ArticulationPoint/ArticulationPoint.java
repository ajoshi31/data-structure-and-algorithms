import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ArticulationPoint {

	public int TIME;

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		ArticulationPoint ap = new ArticulationPoint();
		Set<Integer> artPoints = ap.AP(graph);
		artPoints.forEach(System.out::println);
	}

	public Set<Integer> AP(Graph graph) {
		Set<Integer> visitedVertex = new HashSet<>();
		HashMap<Integer, Integer> parent = new HashMap<>();
		HashMap<Integer, Integer> discTime = new HashMap<>();
		HashMap<Integer, Integer> lowTime = new HashMap<>();
		Set<Integer> articulationPoints = new HashSet<>();
		TIME = 0;
		int vertex = 3; // starting point as root
		DFS(vertex, graph, visitedVertex, parent, discTime, lowTime, articulationPoints);
		return articulationPoints;
	}

	public void DFS(Integer vertex, Graph graph, Set<Integer> visitedVertex, HashMap<Integer, Integer> parent,
			HashMap<Integer, Integer> discTime, HashMap<Integer, Integer> lowTime, Set<Integer> articulationPoints) {
		visitedVertex.add(vertex);
		discTime.put(vertex, TIME);
		lowTime.put(vertex, TIME);
		TIME++;
		int childCount = 0;
		boolean artPoint = false;
		for (Integer adjVertex : graph.adjVertexList[vertex]) {
			if (adjVertex.equals(parent.get(vertex))) {
				continue;
			}

			if (!visitedVertex.contains(adjVertex)) {
				parent.put(adjVertex, vertex);
				childCount++;
				DFS(adjVertex, graph, visitedVertex, parent, discTime, lowTime, articulationPoints);
				if (discTime.get(vertex) <= lowTime.get(adjVertex)) {
					artPoint = true;
				} else {
					// Update the low time as there might be soe backedge
					lowTime.put(vertex, Math.min(lowTime.get(adjVertex), lowTime.get(vertex)));
				}
			} else {
				// Backedge Found Update Low Time of vertex with the adjVertex
				lowTime.put(vertex, Math.min(discTime.get(adjVertex), lowTime.get(vertex)));
			}
			if ((parent.get(vertex) == null && childCount >= 2) || (parent.get(vertex) != null && artPoint)) {
				articulationPoints.add(vertex);
			}
		}
	}
}

class Graph {
	public int V;
	public LinkedList<Integer>[] adjVertexList;

	public Graph(int v) {
		this.V = v;
		adjVertexList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjVertexList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adjVertexList[v].add(u);
		adjVertexList[u].add(v);
	}
}