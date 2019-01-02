class Solution {


	private static void modifyMatrix(int[][] matrix) {

		if (matrix == null)
			return;

		boolean isOnePresentForRow = false;
		boolean isOnePresentForCol = false;

		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				if (rowIndex == 0 && matrix[rowIndex][colIndex] == 1) {
					isOnePresentForCol = true;
				}
				if (colIndex == 0 && matrix[rowIndex][colIndex] == 1) {
					isOnePresentForRow = true;
				}
				if (matrix[rowIndex][colIndex] == 1) {
					matrix[0][colIndex] = 1;
					matrix[rowIndex][0] = 1;
				}
			}
		}

		for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
			for (int colIndex = 1; colIndex < matrix[0].length; colIndex++) {
				if (matrix[0][colIndex] == 1 || matrix[rowIndex][0] == 1) {
					matrix[rowIndex][colIndex] = 1;
				}
			}
		}

		if (isOnePresentForRow) {
			for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
				matrix[rowIndex][0] = 1;
			}
		}
		if (isOnePresentForCol) {
			for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				matrix[0][colIndex] = 1;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				System.out.print(matrix[rowIndex][colIndex] + " ");
			}
			System.out.println();
		}
	}

	// Driver function to test the above function
	public static void main(String args[]) {

		int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

		System.out.println("Input Matrix :");
		printMatrix(mat);

		modifyMatrix(mat);

		System.out.println("Matrix After Modification :");
		printMatrix(mat);

	}
}
