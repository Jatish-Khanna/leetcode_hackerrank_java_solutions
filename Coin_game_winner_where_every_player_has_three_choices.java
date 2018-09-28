class Solution {

	public static void main(String[] args) {
		int x = 3, y = 4, n = 5;
		if (findWinner(x, y, n) == true)
			System.out.println('A');
		else
			System.out.println('B');
	}

	private static boolean findWinner(int x, int y, int n) {
		boolean[] dpSol = new boolean[n + 1];
		dpSol[0] = false;
		dpSol[1] = true;

		for (int i = 2; i <= n; i++) {
			if (dpSol[i - 1] == false) {
				dpSol[i] = true;
			} else if (i - x >= 0 && dpSol[i - x] == false) {
				dpSol[i] = true;
			} else if (i - y >= 0 && dpSol[i - y] == false) {
				dpSol[i] = true;
			} else {
				dpSol[i] = false;
			}
		}

		return dpSol[n];
	}
}
