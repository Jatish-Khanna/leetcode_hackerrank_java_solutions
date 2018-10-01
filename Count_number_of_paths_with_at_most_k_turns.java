import java.util.Arrays;

public class Solution {
	static int[][][][] dpSol;

	public static void main(String[] args) {

		int m = 3, n = 3, k = 2;
		dpSol = new int[m][n][k + 1][2];
		for (int[][][] a1 : dpSol) {
			for (int[][] a2 : a1) {
				for (int[] a3 : a2) {
					Arrays.fill(a3, -1);
				}
			}
		}
		System.out.println("Number of paths is " + countPaths(m - 1, n - 1, k));
	}

	private static int countPaths(int i, int j, int k) {

		return countWithDirection(i - 1, j, k, 1) + countWithDirection(i, j - 1, k, 0);
	}

	private static int countWithDirection(int i, int j, int k, int l) {

		if (i < 0 || j < 0) {
			return 0;
		}

		if (i == 0 && j == 0) {
			return 1;
		}
		if (k == 0) {
			if (i == 0 && l == 0)
				return 1;
			if (j == 0 && l == 1)
				return 1;
			return 0;
		}

		if (dpSol[i][j][k][l] != -1) {
			return dpSol[i][j][k][l];
		}

		if (l == 0) {
			return dpSol[i][j][k][l] = countWithDirection(i, j - 1, k, l) + countWithDirection(i - 1, j, k - 1, 1 - l);
		} else {
			return dpSol[i][j][k][l] = countWithDirection(i, j - 1, k - 1, 1 - l) + countWithDirection(i - 1, j, k, l);
		}
	}
}
