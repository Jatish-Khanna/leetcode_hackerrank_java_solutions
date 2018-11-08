class Solution {

	public static void main(String[] args) {

		String str = "aaabaaaa";
		System.out.println("Length is: " + lengthOfLongestPalindromeString(str));
	}

	private static int lengthOfLongestPalindromeString(String str) {
		int sizeOfString = str.length();
		int max = 1;
		boolean[][] dpSol = new boolean[sizeOfString][sizeOfString];
		for (int index = 0; index < sizeOfString; index++) {
			dpSol[index][index] = true;
		}
		for (int index = 0; index < sizeOfString - 1; index++) {
			if (str.charAt(index) == str.charAt(index + 1)) {
				dpSol[index][index + 1] = true;
				max = 2;
			}
		}
		for (int subLength = 3; subLength <= sizeOfString; subLength++) {
			for (int index = 0; index <= sizeOfString - subLength; index++) {
				int end = index + subLength - 1;
				if (dpSol[index + 1][end - 1] && str.charAt(index) == str.charAt(end)) {
					dpSol[index][end] = true;
					max = Math.max(max, subLength);
				}
			}
		}

		return max;
	}
}
