class Solution {
	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.println(binarySubstringsWithKAdjacent1s(n, k));
	}

	private static int binarySubstringsWithKAdjacent1s(int n, int k) {
		/*
		 * The dynamic solution matrix- - n: length binary string - k: number of
		 * adjacent strings - 0|1: appending 0 or 1 at end of string
		 */

		int[][][] dpSol = new int[n + 1][k + 1][2];

		// Base case when length = 1, k = 0
		dpSol[1][0][0] = 1;
		dpSol[1][0][1] = 1;

		// From length 2...n
		for (int length = 2; length <= n; length++) {
			// Adjacent set bit's
			for (int adjacentK = 0; adjacentK <= k && adjacentK < length; adjacentK++) {
				/*
				 * Adding 0 at the end of sequence - Last calculated binary
				 * string with K adjacent set bits ending with 0 - Last
				 * calculated binary string with K adjacent set bits ending with
				 * 1
				 */
				dpSol[length][adjacentK][0] = dpSol[length - 1][adjacentK][0] + dpSol[length - 1][adjacentK][1];

				/*
				 * Adding 0 at the end of sequence - Last calculated binary
				 * string with K adjacent set bits ending with 0
				 * 
				 */

				dpSol[length][adjacentK][1] = dpSol[length - 1][adjacentK][0];
				if (adjacentK - 1 >= 0)
					// Last calculated binary string with K adjacent set bits
					// ending with 1
					dpSol[length][adjacentK][1] += dpSol[length - 1][adjacentK - 1][1];
			}
		}

		// return
		// Number of string with K adjacent set bits ending with 0
		// Number of string with K adjacent set bits ending with 1
		return dpSol[n][k][0] + dpSol[n][k][1];

	}
}
