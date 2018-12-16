class Solution {


	private static final int INF = 99999;

	private static void floydWarshall(int[][] graph) {
		if (graph == null)
			return;
		int vertexCount = graph.length;

		int[][] solution = new int[vertexCount][vertexCount];
		for (int i = 0; i < vertexCount; i++)
			for (int j = 0; j < vertexCount; j++)
				solution[i][j] = graph[i][j];

		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < vertexCount; j++) {
				for (int k = 0; k < vertexCount; k++) {
					if (solution[i][k] + solution[k][j] < solution[i][j]) {
						solution[i][j] = solution[i][k] + solution[k][j];
					}
				}
			}
		}

		printSolution(solution, vertexCount);
	}

	private static void printSolution(int[][] solution, int vertexCount) {

		for (int i = 0; i < vertexCount; i++) {
			for (int j = 0; j < vertexCount; j++) {
				if(solution[i][j]!= INF)
					System.out.print(solution[i][j] + "\t");
				else
					System.out.print("INF\t");
				
			}
			System.out.println();
		}

	}

	// Driver program to test above function 
    public static void main (String[] args) 
    { 
        /* Let us create the following weighted graph 
           10 
        (0)------->(3) 
        |         /|\ 
        5 |          | 
        |          | 1 
        \|/         | 
        (1)------->(2) 
           3           */
        int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 

        // Print the solution 
        floydWarshall(graph); 
    }

}
