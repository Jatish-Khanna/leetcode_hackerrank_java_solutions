import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Graph {


	int vertexCount;
	ArrayList<Integer> adjList[];

	Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjList = new ArrayList[vertexCount];
		for (int index = 0; index < vertexCount; index++) {
			adjList[index] = new ArrayList<>();
		}
	}

	private void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	private void printStronglyConnectedComponents() {
		if (vertexCount == 0)
			return;

		boolean[] visited = new boolean[vertexCount];
		Deque<Integer> dfsOrder = new ArrayDeque<>();

		for (int currentVertex = 0; currentVertex < vertexCount; currentVertex++) {
			if (!visited[currentVertex])
				depthFirstSearchUtil(currentVertex, visited, dfsOrder);
		}

		Graph transposeGraph = generateTransposeGraph();
		Arrays.fill(visited, false);

		for (int popedVertex : dfsOrder) {
			if (!visited[popedVertex])
				transposeGraph.depthFirstSearchConnectedComponents(popedVertex, visited);
			System.out.println();
		}

	}

	private void depthFirstSearchConnectedComponents(int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;

		System.out.print(currentVertex + " ");

		for (int adjNode : adjList[currentVertex]) {
			if (!visited[adjNode])
				depthFirstSearchConnectedComponents(adjNode, visited);
		}
	}

	private Graph generateTransposeGraph() {
		Graph transposeGraph = new Graph(vertexCount);
		for (int currentVertex = 0; currentVertex < vertexCount; currentVertex++) {
			for (int adjNode : adjList[currentVertex]) {
				transposeGraph.adjList[adjNode].add(currentVertex);
			}
		}
		return transposeGraph;
	}

	private void depthFirstSearchUtil(int currentVertex, boolean[] visited, Deque<Integer> dfsOrder) {

		visited[currentVertex] = true;
		for (Integer adjNode : adjList[currentVertex]) {
			if (!visited[adjNode])
				depthFirstSearchUtil(adjNode, visited, dfsOrder);
		}
		dfsOrder.push(currentVertex);
	}

	// Driver method
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components " + "in given graph ");
		g.printStronglyConnectedComponents();
	}
}
