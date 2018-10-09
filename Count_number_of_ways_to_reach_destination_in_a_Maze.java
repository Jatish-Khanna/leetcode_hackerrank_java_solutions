class Solution {
	public static void main(String[] args) {
		
		/*
		 * Give NxM size maze 
		 * Start with 0,0 
		 * End at N-1 M-1
		 * Calculate the number of ways where
		 * 0 is valid position
		 * -1 is invalid position
		 */
		int maze[][] = { { 0, -1, 0, 0 }, 
						 { 0, 0, -1, 0 }, 
						 { -1, 0, 0, -1 }, 
						 { 0, -1, 0, 0 } };
		System.out.println(countPaths(maze));

	}

	private static int countPaths(int[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		
		// Intialize the matrix to store number of ways at each postion
		int[][] dpSol = new int[rows][cols];

		// Check if first position is valid
		dpSol[0][0] = maze[0][0] == 0 ? 1 :  0;
		
		// return 0 ways on invalid first postion
		if(dpSol[0][0] == 0)
			return 0;
		
		/*
		 *  Fill the first row of result matrix with 1
		 *  Number of ways to reach x position till move is valid is 1
		 *  continue until -1 or end of row  
		 */
		for (int i = 0; i < rows; i++) {
			if (maze[0][i] == -1)
				break;
			dpSol[0][i] = 1;
		}
		
		/*
		 *  Fill the first column of result matrix with 1
		 *  Number of ways to reach x position till move is valid is 1
		 *  continue until -1 or end of column
		 */
		for (int i = 0; i < cols; i++) {
			if (maze[i][0] == -1)
				break;
			dpSol[i][0] = 1;
		}

		/*
		 * Loop over each position of maze
		 */
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				// if position is invalid - keep value == 0
				if (maze[i][j] == -1)
					continue;
				// Sum the value of upper immediate position and left immediate position
				dpSol[i][j] = dpSol[i - 1][j] + dpSol[i][j - 1];
			}
		}

		// return the number of ways stored by last element [N-1] [M-1]
		return dpSol[rows - 1][cols - 1];
	}
}
