import java.util.Arrays;

class Solution {
	private static int[][] dpSol;

	public static void main(String[] args) {
		String digits = "123";
		int dLength = digits.length();
		dpSol = new int[dLength][dLength * 9 + 1];

		for (int[] list : dpSol) {
			Arrays.fill(list, -1);
		}
		System.out.println(countGroups(0, 0, dLength, digits));
	}

	private static int countGroups(int position, int prevSum, int dLength, String digits) {
		if (position == dLength)
			return 1;
		if (dpSol[position][prevSum] != -1)
			return dpSol[position][prevSum];

		dpSol[position][prevSum] = 0;
		int sum = 0;
		for (int index = position; index < dLength; index++) {
			sum += digits.charAt(index) - '0';
			if (sum >= prevSum) {
				dpSol[position][prevSum] += countGroups(index + 1, sum, dLength, digits);
			}
		}

		return dpSol[position][prevSum];
	}
}
