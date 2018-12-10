class Solution {

	private static boolean possibleSameCharFreqByOneRemoval(String string) {
		int[] frequency = new int[26];

		for (int index = 0; index < string.length(); index++) {
			frequency[string.charAt(index) - 'a']++;
		}

		if (checkAllSameFrequencies(frequency)) {
			return true;
		} else {
			for (int charSet = 0; charSet < 26; charSet++) {

				if (frequency[charSet] > 0) {
					frequency[charSet]--;
					if (checkAllSameFrequencies(frequency))
						return true;
					frequency[charSet]++;
				}
			}
		}
		return false;
	}

	private static boolean checkAllSameFrequencies(int[] frequency) {
		int same = -1;

		for (int index = 0; index < frequency.length; index++) {
			if (frequency[index] > 0) {
				if (same == -1) {
					same = frequency[index];
				} else if (frequency[index] != same) {
					return false;
				}
			}
		}
		return true;
	}

	// Driver code to test above methods
	public static void main(String[] args) {
		String str = "xxyyyzzzz";
		if (possibleSameCharFreqByOneRemoval(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
