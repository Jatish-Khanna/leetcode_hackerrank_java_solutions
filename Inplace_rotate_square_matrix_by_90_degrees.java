class Solution {

	private static void rotateMatrix(int dimension, int[][] matrix) {
		if (matrix == null || dimension <= 1) {
			return;
		}

		// Rotate anti-clockwise
		for (int rowLocation = 0; rowLocation < dimension / 2; rowLocation++) {
			int maxColLocation = dimension - 1 - rowLocation;
			for (int colLocation = rowLocation; colLocation < dimension - rowLocation - 1; colLocation++) {
				int topLeft = matrix[rowLocation][colLocation];

				// right to top
				matrix[rowLocation][colLocation] = matrix[colLocation][maxColLocation];

				// bottom to right
				matrix[colLocation][maxColLocation] = matrix[maxColLocation][dimension - 1 - colLocation];

				// left to bottom
				matrix[maxColLocation][dimension - 1 - colLocation] = matrix[dimension - 1 - colLocation][rowLocation];

				// top to left
				matrix[dimension - 1 - colLocation][rowLocation] = topLeft;
			}
		}
	}

	private static void displayMatrix(int dimension, int[][] matrix) {
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int N = 4;

		// Test Case 1
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// Tese Case 2
		/*
		 * int mat[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 */

		// Tese Case 3
		/*
		 * int mat[][] = { {1, 2}, {4, 5} };
		 */

		// displayMatrix(mat);

		rotateMatrix(N, mat);

		// Print rotated matrix
		displayMatrix(N, mat);
	}
}
