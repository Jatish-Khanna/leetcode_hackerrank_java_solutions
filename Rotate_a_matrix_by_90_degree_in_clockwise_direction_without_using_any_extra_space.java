class Solution {

	private static void rotate90Clockwise(int[][] arr) {
		if (arr == null || arr.length < 1 || arr.length != arr[0].length) {
			return;
		}

		int rowSize = arr.length;
		int colSize = arr[0].length;
		for (int rowIndex = 0; rowIndex < rowSize / 2; rowIndex++) {
			int maxColLocation = rowSize - rowIndex - 1;
			for (int colIndex = rowIndex; colIndex < maxColLocation; colIndex++) {
				// Copy top left
				int topLeft = arr[rowIndex][colIndex];

				// copy left to top
				arr[rowIndex][colIndex] = arr[colSize - colIndex - 1][rowIndex];
				// Copy bottom to left
				arr[colSize - colIndex - 1][rowIndex] = arr[maxColLocation][colSize - colIndex - 1];
				// copy right to bottom
				arr[maxColLocation][colSize - colIndex - 1] = arr[colIndex][maxColLocation];
				// copy top to right
				arr[colIndex][maxColLocation] = topLeft;
			}
		}
	}

	private static void printMatrix(int[][] arr) {
		for (int rowIndex = 0; rowIndex < arr.length; rowIndex++) {
			for (int colIndex = 0; colIndex < arr[0].length; colIndex++) {
				System.out.print(arr[rowIndex][colIndex] + " ");
			}
			System.out.println();
		}
	}

	// Driver code

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate90Clockwise(arr);
		printMatrix(arr);
	}
}
