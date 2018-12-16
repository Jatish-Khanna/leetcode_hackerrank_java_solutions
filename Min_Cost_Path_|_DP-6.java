
	private static int minCostToDestinationInMatrix(int[][] costMatrix, int rows, int cols) {

		if (costMatrix == null)
			return 0;

		int[][] solutionMatrix = new int[rows][cols];
		solutionMatrix[0][0] = costMatrix[0][0];

		for (int rowNum = 1; rowNum < rows; rowNum++) {
			solutionMatrix[rowNum][0] = solutionMatrix[rowNum - 1][0] + costMatrix[rowNum][0];

		}

		for (int colNum = 1; colNum < cols; colNum++) {
			solutionMatrix[0][colNum] = solutionMatrix[0][colNum - 1] + costMatrix[0][colNum];
		}

		for (int rowNum = 1; rowNum < rows; rowNum++) {
			for (int colNum = 1; colNum < cols; colNum++) {

				solutionMatrix[rowNum][colNum] = Math.min(solutionMatrix[rowNum - 1][colNum],
						Math.min(solutionMatrix[rowNum][colNum - 1], solutionMatrix[rowNum - 1][colNum - 1]))
						+ costMatrix[rowNum][colNum];
			}
		}
		return solutionMatrix[rows - 1][cols - 1];
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println("Minimum cost to reach end of matrix: "+minCostToDestinationInMatrix(cost, cost.length, cost[0].length));
	}
