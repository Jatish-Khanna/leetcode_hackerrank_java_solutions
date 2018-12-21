class Solution {

	static int ROWS;
	static int COLS;

	private static int findLongestPathOverAll(int[][] matrix) {

		int maxPathLength = 0;
		if (matrix == null)
			return maxPathLength;

		int[][] visited = new int[ROWS][COLS];

		for (int rowIndex = 0; rowIndex < ROWS; rowIndex++) {
			for (int colIndex = 0; colIndex < COLS; colIndex++) {
				if (visited[rowIndex][colIndex] == 0) {
					maxPathLength = Math.max(maxPathLength, depthFirstSearch(matrix, visited, rowIndex, colIndex));
				}
			}
		}
		return maxPathLength;
	}

	private static int depthFirstSearch(int[][] matrix, int[][] visited, int rowIndex, int colIndex) {

		// Out of bounds
		if (rowIndex < 0 || rowIndex >= ROWS || colIndex < 0 || colIndex >= COLS)
			return 0;
	  // Already visited the position
    if (visited[rowIndex][colIndex] != 0)
			return visited[rowIndex][colIndex];

  // Iterate over other four directions
		if (rowIndex < ROWS - 1 && matrix[rowIndex][colIndex] == matrix[rowIndex + 1][colIndex] + 1)
			return visited[rowIndex][colIndex] = depthFirstSearch(matrix, visited, rowIndex + 1, colIndex) + 1;
		if (rowIndex > 0 && matrix[rowIndex][colIndex] == matrix[rowIndex - 1][colIndex] + 1)
			return visited[rowIndex][colIndex] = depthFirstSearch(matrix, visited, rowIndex - 1, colIndex) + 1;
		if (colIndex < COLS - 1 && matrix[rowIndex][colIndex] == matrix[rowIndex][colIndex + 1] + 1)
			return visited[rowIndex][colIndex] = depthFirstSearch(matrix, visited, rowIndex, colIndex + 1) + 1;
		if (colIndex > 0 && matrix[rowIndex][colIndex] == matrix[rowIndex][colIndex - 1] + 1)
			return visited[rowIndex][colIndex] = depthFirstSearch(matrix, visited, rowIndex, colIndex - 1) + 1;
		return visited[rowIndex][colIndex] = 1;

	}

	// driver program
	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 7 }, 
							{ 5, 15, 8 }, 
							{ 13, 14, 9 }, 
							{ 12, 11, 10 } };

		ROWS = matrix.length;
		COLS = matrix[0].length;
		System.out.println("Length of the longest path is " + findLongestPathOverAll(matrix));
	}
}
