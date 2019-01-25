class Solution {

	private static void spiralPrint(int rowSize, int colSize, int[][] matrix) {

		int rowIndex = 0;
		int colIndex = 0;
		while (rowIndex < rowSize && colIndex < colSize) {
			for (int index = colIndex; index < colSize; index++) {
				System.out.print(matrix[rowIndex][index] + " ");
			}
			rowIndex++;
			for (int index = rowIndex; index < rowSize; index++) {
				System.out.print(matrix[index][colSize - 1] + " ");
			}
			colSize--;
			if (rowIndex < rowSize) {
				for (int index = colSize - 1; index >= colIndex; index--) {
					System.out.print(matrix[rowSize - 1][index] + " ");
				}
				rowSize--;
			}

			if (colIndex < colSize) {
				for (int index = rowSize - 1; index >= rowIndex; index--) {
					System.out.print(matrix[index][colIndex] + " ");
				}
				colIndex++;
			}
		}
	}

	// driver program
	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiralPrint(R, C, a);
	}
}
