import java.util.ArrayList;
import java.util.ArrayDeque;

class Graph {


	int vertexCount;
	ArrayList<Integer>[] adjList;

	Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjList = new ArrayList[vertexCount];
		for (int index = 0; index < vertexCount; index++) {
			adjList[index] = new ArrayList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adjList[source].add(destination);
	}

	private static void printSortedOrderAlphabet(String[] words, int alphabetSize) {
		if (words == null || alphabetSize == 0)
			return;

		Graph graph = new Graph(alphabetSize);
		String firstWord = words[0];
		String secondWord;
		if (words.length == 1) {

			for (int charIndex = 0; charIndex < firstWord.length() - 1; charIndex++) {
				graph.addEdge(firstWord.charAt(charIndex) - 'a', firstWord.charAt(charIndex + 1) - 'a');
			}
		} else {

			for (int index = 1; index < words.length; index++) {
				secondWord = words[index];
				for (int charIndex = 0; charIndex < firstWord.length(); charIndex++) {
					if (firstWord.charAt(charIndex) != secondWord.charAt(charIndex)) {
						graph.addEdge(firstWord.charAt(charIndex) - 'a', secondWord.charAt(charIndex) - 'a');
						break;
					}
				}
				firstWord = secondWord;
			}
		}
		graph.topologicalSort();
	}

	private void topologicalSort() {
		boolean[] visited = new boolean[vertexCount];
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

		for (int currentVertex = 0; currentVertex < vertexCount; currentVertex++) {
			if (!visited[currentVertex]) {
				topologicalSortUtil(currentVertex, visited, arrayDeque);
			}
		}

		for (Integer element : arrayDeque) {
			System.out.print((char) (element + 'a') + " ");
		}
	}

	private void topologicalSortUtil(int currentVertex, boolean[] visited, ArrayDeque<Integer> arrayDeque) {
		visited[currentVertex] = true;
		for (int adjNode : adjList[currentVertex]) {
			if (!visited[adjNode]) {
				topologicalSortUtil(adjNode, visited, arrayDeque);
			}
		}
		arrayDeque.push(currentVertex);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		String[] words = { "caa", "aaa", "aab" };
		printSortedOrderAlphabet(words, 3);

		System.out.println();
		String[] words2 = { "baa", "abcd", "abca", "cab", "cad" };
		printSortedOrderAlphabet(words2, 4);
	}

}
