import java.util.LinkedList;
import java.util.Queue;

class Solution {


	private final static int[] ROW_DIRECTION = { -1, 0, 0, 1 };
	private final static int[] COL_DIRECTION = { 0, -1, 1, 0 };
	static int ROWS;
	static int COLS;

	static class Point {
		public int rowNum;
		public int colNum;
		int distance;

		Point(int rowNum, int colNum, int distance) {
			this.rowNum = rowNum;
			this.colNum = colNum;
			this.distance = distance;
		}
	}

	private static int breadthFirstSearchFindShortestPath(int[][] matrix, Point source, Point destination) {
		if (!(matrix[source.rowNum][source.colNum] == 1) || !(matrix[destination.rowNum][destination.colNum] == 1))
			return Integer.MAX_VALUE;
		boolean[][] visited = new boolean[ROWS][COLS];
		Queue<Point> queue = new LinkedList<>();

		queue.offer(source);
		visited[source.rowNum][source.colNum] = true;
		Point current;

		int newRow;
		int newCol;

		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.rowNum == destination.rowNum && current.colNum == destination.colNum)
				return current.distance;

			for (int index = 0; index < ROW_DIRECTION.length; index++) {
				newRow = current.rowNum + ROW_DIRECTION[index];
				newCol = current.colNum + COL_DIRECTION[index];

				if (isValidMove(matrix, newRow, newCol) && !visited[newRow][newCol]) {
					queue.offer(new Point(newRow, newCol, current.distance + 1));
					visited[newRow][newCol] = true;
				}

			}
		}
		return destination.distance;
	}

	private static boolean isValidMove(int[][] matrix, int newRow, int newCol) {
		return newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS && matrix[newRow][newCol] == 1;
	}

	public static void main(String[] args) {
		int matrix[][] = { 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
		        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
		        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 0 }, 
		        { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 }, 
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
		        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
		    };

		ROWS = matrix.length;
		COLS = matrix[0].length;
		Point source = new Point(0, 0, 0);
		Point destination = new Point(ROWS - 1, COLS - 1, Integer.MAX_VALUE);

		int dist = breadthFirstSearchFindShortestPath(matrix, source, destination);

		if (dist != Integer.MAX_VALUE)
			System.out.println("Shortest Path is " + dist);
		else
			System.out.println("Shortest Path doesn't exist");
	}
}
