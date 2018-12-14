class Solution {

	static int ROW;
	static int COL;

	private void dijkstra(int[][] graph, int source) {

		int[] shortestPath = new int[ROW];
		boolean[] visited = new boolean[ROW];

		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		shortestPath[source] = 0;

		for (int currentVertexCount = 0; currentVertexCount < ROW - 1; currentVertexCount++) {
			int vertexWithMinimumDistance = findUnvisitedVertexWithMinimumDistance(shortestPath, visited);

			if (vertexWithMinimumDistance == -1)
				break;

			visited[vertexWithMinimumDistance] = true;

			for (int adjNode = 0; adjNode < ROW; adjNode++) {
				if (!visited[adjNode] && graph[vertexWithMinimumDistance][adjNode] != 0) {
					shortestPath[adjNode] = Math.min(
							shortestPath[vertexWithMinimumDistance] + graph[vertexWithMinimumDistance][adjNode],
							shortestPath[adjNode]);
				}
			}
		}
		printSolution(shortestPath, source);
	}

	private int findUnvisitedVertexWithMinimumDistance(int[] shortestPath, boolean[] visited) {
		int minimum = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int index = 0; index < ROW; index++) {
			if (!visited[index] && shortestPath[index] < minimum) {
				minimum = shortestPath[index];
				minIndex = index;
			}
		}
		return minIndex;
	}
	
    void printSolution(int shortedPath[], int source) 
    { 
        System.out.println("Vertex\t\tDistance from Source"); 
        for (int index = 0; index < ROW; index++) 
            System.out.println("From source: "+ source+ " to " +index+"\t"+shortedPath[index]); 
    }

    // Driver method 
    public static void main (String[] args) 
    { 
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; 
        Solution t = new Solution(); 
		ROW = graph.length;
		COL = graph[0].length;
        t.dijkstra(graph, 0); 
    } 

}
