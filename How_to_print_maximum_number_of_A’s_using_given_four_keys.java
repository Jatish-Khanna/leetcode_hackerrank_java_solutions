
class Solution {

	private static int countMaxTimesCharacterToRepeat(int numberOfKeyStroke) {
		int[] ways = new int[numberOfKeyStroke + 1];

		if (numberOfKeyStroke <= 6)
			return numberOfKeyStroke;

		for (int index = 0; index <= 6; index++) {
			ways[index] = index;
		}

		for (int index = 7; index <= numberOfKeyStroke; index++) {
			for (int copyIndex = index - 3; copyIndex >= 1; copyIndex--) {
				// Ways before last three keystrokes as (^A, ^C, ^V ) * (numberOfkeystrokes -
				// start position to copy)
				ways[index] = Math.max(ways[index], ways[copyIndex - 1] * (index - copyIndex));
			}
		}

		return ways[numberOfKeyStroke];

	}

	// Driver program
	public static void main(String[] args) {
		int N;

		// for the rest of the array we will rely on the previous
		// entries to compute new ones
		for (N = 1; N <= 20; N++)
			System.out.println(
					"Maximum Number of A's with keystrokes: " + N + " is: " + countMaxTimesCharacterToRepeat(N));
	}
}
