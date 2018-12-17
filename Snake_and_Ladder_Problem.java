import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static class Block {
		int blockNumber;
		int distance;

		Block(int blockNumber, int distance) {
			this.blockNumber = blockNumber;
			this.distance = distance;
		}
	}

	private static int getMinDiceThrows(int[] moves, int blocks) {
		if (moves == null || blocks == 0)
			return -1;

		boolean[] visited = new boolean[blocks];
		Queue<Block> queue = new LinkedList<>();
		queue.offer(new Block(0, 0));
		Block current;

		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.blockNumber == blocks - 1)
				return current.distance;
			
			visited[current.blockNumber] = true;

			for (int index = current.blockNumber + 1; index < blocks 
									&& index <= (current.blockNumber + 6); index++) {
				if (!visited[index]) {
					if (moves[index] == -1)
						queue.offer(new Block(index, current.distance + 1));
					else
						queue.offer(new Block(moves[index], current.distance + 1));
					visited[index] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;
		moves[3] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

}
