class Solution {
	public static void main(String[] args) {
		String stringOne = "OldSite:Google.org";
		String stringTwo = "NewSite:Google.plus.com";

		int m = stringOne.length();
		int n = stringTwo.length();

		System.out.println("Length of Longest Common Substring is "
				+ legthOfLCS(stringOne.toCharArray(), stringTwo.toCharArray(), m, n));
	}

	private static int legthOfLCS(char[] charArray, char[] charArray2, int m, int n) {
		int longest = 0;
		int[][] dpSol = new int[m + 1][n + 1];

		for (int first = 1; first <= m; first++) {
			for (int second = 1; second <= n; second++) {
				if (charArray[first-1] == charArray2[second-1])
					dpSol[first][second] = dpSol[first - 1][second - 1] + 1;
				else {
					dpSol[first][second] = 0;
				}
				longest = Math.max(longest, dpSol[first][second]);
			}
		}

		return longest;
	}
}
