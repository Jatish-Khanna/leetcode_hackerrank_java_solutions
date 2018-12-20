class Solution {


	private static boolean isSubsetSum(int[] set, int length, int sum) {
		if (set == null)
			return false;

		boolean[][] dpSol = new boolean[length + 1][sum + 1];

		for (int index = 0; index <= length; index++) {
			dpSol[index][0] = true;
		}

		for (int element = 1; element <= length; element++) {
			for (int index = 1; index <= sum; index++) {
				// Excluding
				dpSol[element][index] = dpSol[element - 1][index];
				// Sum lower than current element
				if (index >= set[element - 1]) {
					// Include current element in set
					dpSol[element][index] = dpSol[element][index] || dpSol[element - 1][index - set[element - 1]];
				}
			}
		}

		return dpSol[length][sum];
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}
}
