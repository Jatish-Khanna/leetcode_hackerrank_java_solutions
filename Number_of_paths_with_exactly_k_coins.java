import java.io.IOException;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		int k = 12;
		int mat[][] = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
		System.out.println(pathCountDP(mat, k));
	}

	private static int pathCountDP(int[][] mat, int k) {
		int dpSol[][][] = new int[mat.length][mat[0].length][k + 1];
		for (int arr[][] : dpSol) {
			for (int arrSub[] : arr) {
				Arrays.fill(arrSub, -1);
			}
		}

		return pathCountDPRec(mat, dpSol, mat.length - 1, mat[0].length - 1, k);
	}

	private static int pathCountDPRec(int[][] mat, int[][][] dpSol, int i, int j, int k) {

		if (i < 0 || j < 0)
			return 0;
		if (i == 0 && j == 0) {
			if (k == mat[0][0])
				return 1;
			else
				return 0;
		}

		if (dpSol[i][j][k] != -1) {
			return dpSol[i][j][k];
		}
		dpSol[i][j][k] = pathCountDPRec(mat, dpSol, i - 1, j, k - mat[i][j])
				+ pathCountDPRec(mat, dpSol, i, j - 1, k - mat[i][j]);

		return dpSol[i][j][k];
	}
}
