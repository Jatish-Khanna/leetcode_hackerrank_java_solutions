import java.util.ArrayDeque;
import java.util.LinkedList;

class Solution {
	int V;
	LinkedList<Integer>[] adj;

	Solution(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private void topologicalSort() {
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
		boolean[] visited = new boolean[V];

		// Iterate over each un-visited vertex
		for (int index = 0; index < V; index++) {
			if (!visited[index]) {
				// Sort
				topologicalSort(arrayDeque, visited, index);
			}
		}

		// Print nodes in topological order
		while (!arrayDeque.isEmpty()) {
			System.out.println(arrayDeque.pop());
		}
	}

	private void topologicalSort(ArrayDeque<Integer> arrayDeque, boolean[] visited, int currentIndex) {
		// Vertex is visited
		visited[currentIndex] = true;

		// Iterate over each Adjacent vertex
		for (Integer adjNode : adj[currentIndex]) {
			// Vertex is not visited - recursive call to adjacent node
			if (!visited[adjNode]) {
				topologicalSort(arrayDeque, visited, adjNode);
			}
		}
		// Push node to stack
		arrayDeque.push(currentIndex);

	}

	// Driver method
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Solution g = new Solution(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}
}
