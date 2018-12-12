import java.util.List;
import java.util.ArrayList;

class Solution {

	private int vertexCount;
	private List<Integer> adjList[];

	Solution(int vertexCount) {
		this.vertexCount = vertexCount;
		adjList = new ArrayList[vertexCount];
		for (int index = 0; index < vertexCount; index++) {
			adjList[index] = new ArrayList<>();
		}
	}

	private boolean isCyclic() {

		boolean[] visited = new boolean[vertexCount];
		boolean[] recursionPath = new boolean[vertexCount];

		for (int vertex = 0; vertex < vertexCount; vertex++) {

			if (isCyclicUtil(vertex, visited, recursionPath))
				return true;

		}
		return false;
	}

	private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionPath) {
		if (recursionPath[vertex])
			return true;

		if (visited[vertex])
			return false;
		visited[vertex] = true;
		recursionPath[vertex] = true;

		for (Integer adjNode : adjList[vertex]) {
			if (isCyclicUtil(adjNode, visited, recursionPath))
				return true;
		}
		recursionPath[vertex] = false;
		return false;
	}

	private void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	// Driver code
	public static void main(String[] args) {
		Solution graph = new Solution(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
//		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}
}
