class Solution {

	private static void floodFill(int[][] screen, int xAxis, int yAxis, int filledColor, int newColor) {
		if (checkBounds(screen, xAxis, yAxis) && checkColor(screen, xAxis, yAxis, filledColor)) {
			screen[xAxis][yAxis] = newColor;
			floodFill(screen, xAxis + 1, yAxis, filledColor, newColor);
			floodFill(screen, xAxis - 1, yAxis, filledColor, newColor);
			floodFill(screen, xAxis, yAxis + 1, filledColor, newColor);
			floodFill(screen, xAxis, yAxis - 1, filledColor, newColor);
		}

	}

	private static boolean checkBounds(int[][] screen, int xAxis, int yAxis) {
		return xAxis >= 0 && xAxis < screen.length && yAxis >= 0 && yAxis < screen[0].length;
	}

	private static boolean checkColor(int[][] screen, int xAxis, int yAxis, int neighbourColor) {

		return screen[xAxis][yAxis] == neighbourColor;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, 
						   { 1, 1, 1, 1, 1, 1, 0, 0 }, 
						   { 1, 0, 0, 1, 1, 0, 1, 1 },
						   { 1, 2, 2, 2, 2, 0, 1, 0 }, 
						   { 1, 1, 1, 2, 2, 0, 1, 0 }, 
						   { 1, 1, 1, 2, 2, 2, 2, 0 },
						   { 1, 1, 1, 1, 1, 2, 1, 1 }, 
						   { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 4, y = 4, newC = 3;
		floodFill(screen, x, y, screen[x][y], newC);
		
		floodFill(screen, 0, 0, screen[0][0], 4);

		System.out.println("Updated screen after call to floodFill: n");
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++)
				System.out.print(screen[i][j] + " ");
			System.out.println();
		}
	}

}
