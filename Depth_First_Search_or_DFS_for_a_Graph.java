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

	private void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	private void depthFirstSearch(int startNode) {
		boolean[] visited = new boolean[vertexCount];

		printAndMarkVisited(startNode, visited);

		for (Integer adjNode : adjList[startNode]) {
			if (!visited[adjNode]) {
				depthFirstSearchUtil(adjNode, visited);
			}
		}
	}

	private void depthFirstSearchUtil(int vertex, boolean[] visited) {
		printAndMarkVisited(vertex, visited);

		for (Integer adjNode : adjList[vertex]) {
			if (!visited[adjNode]) {
				depthFirstSearchUtil(adjNode, visited);
			}
		}
	}

	private void printAndMarkVisited(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.println(vertex + " ");
	}

	public static void main(String args[]) {
		Solution g = new Solution(4);

		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.depthFirstSearch(2);
	}
}
