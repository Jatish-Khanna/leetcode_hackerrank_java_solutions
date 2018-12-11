import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	private void breadthFirstSearch() {
		boolean[] visited = new boolean[vertexCount];

		for (int vertex = 0; vertex < vertexCount; vertex++) {
			if (!visited[vertex]) {
				breadthFirstSearchUtil(vertex, visited);
			}
		}
	}

	private void breadthFirstSearchUtil(int vertex, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		visited[queue.peek()] = true;

		while (!queue.isEmpty()) {

			System.out.println(queue.poll());
			for (Integer adjNode : adjList[vertex]) {
				if (!visited[adjNode]) {
					queue.offer(adjNode);
					visited[adjNode] = true;

				}
			}
		}
	}

	private void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	// Driver method to
	public static void main(String args[]) {
		Solution g = new Solution(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.breadthFirstSearch();
	}
}
