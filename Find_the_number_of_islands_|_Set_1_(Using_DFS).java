class Solution {


	final static int[] rowDirection = { -1, -1, -1, 0, 0, 1, 1, 1 };
	final static int[] colDirection = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int ROWS;
	static int COLS;

	private static int countIslands(int[][] islandsMatrix) {
		if (islandsMatrix == null)
			return 0;

		int islandCounter = 0;
		ROWS = islandsMatrix.length;
		COLS = islandsMatrix[0].length;

		boolean[][] visited = new boolean[ROWS][COLS];

		for (int rowIndex = 0; rowIndex < ROWS; rowIndex++) {
			for (int colIndex = 0; colIndex < COLS; colIndex++) {
      // Count only those -
      // If the current position is an island
      // If the current position has been viewed for the first time
				if (islandsMatrix[rowIndex][colIndex] == 1 && !visited[rowIndex][colIndex]) {
					countIslandsUtil(islandsMatrix, rowIndex, colIndex, visited);
					islandCounter++;
				}
			}
		}
		return islandCounter;
	}

	private static void countIslandsUtil(int[][] islandsMatrix, int rowIndex, int colIndex, boolean[][] visited) {
		visited[rowIndex][colIndex] = true;

		for (int directionIndex = 0; directionIndex < 8; directionIndex++) {
			if (isValidMove(islandsMatrix, rowIndex + rowDirection[directionIndex],
					colIndex + colDirection[directionIndex], visited)) {
				countIslandsUtil(islandsMatrix, rowIndex + rowDirection[directionIndex],
						colIndex + colDirection[directionIndex], visited);
			}
		}
	}

  /**
	 * check if the move is valid ?
	 *  - In bounds (row index, and col index)
	 *  - It should be an island - islandMatrix(rowIndex, colIndex) == 1
	 *  - It should be viewed first time
	 *  
	 * @param islandsMatrix - original matrix
	 * @param rowIndex - row number
	 * @param colIndex - col number
	 * @param visited - already viewed matrix
	 * @return - if the move suggested is valid
	 */
	private static boolean isValidMove(int[][] islandsMatrix, int rowIndex, int colIndex, boolean[][] visited) {
		return rowIndex >= 0 && rowIndex < ROWS 
				&& colIndex >= 0 && colIndex < COLS
				&& islandsMatrix[rowIndex][colIndex] == 1 
				&& !visited[rowIndex][colIndex];
	}

	// Driver method
	public static void main(String[] args) throws java.lang.Exception {
		int islandsMatrix[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
											{ 0, 1, 0, 0, 1 }, 
											{ 1, 0, 0, 1, 1 },
											{ 0, 0, 0, 0, 0 }, 
											{ 1, 0, 1, 0, 1 } };

		System.out.println("Number of islands is: " + countIslands(islandsMatrix));
	}

}
