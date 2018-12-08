class Solution {


	private static String findSubString(String original, String pattern) {

		int[] patternDictionary = new int[256];
		int[] stringDictionary = new int[256];

		// Hash pattern character frequency
		for (int index = 0; index < pattern.length(); index++) {
			patternDictionary[pattern.charAt(index)]++;
		}

		int start = 0;
		int startIndex = -1;
		int minWindow = Integer.MAX_VALUE;
		int foundCharsCount = 0;

		// For each character in the original string
		for (int index = 0; index < original.length(); index++) {

			// Hash the character frequency
			char current = original.charAt(index);
			stringDictionary[current]++;

			// Check if character is present in pattern with higher or equal frequency
			// Check if pattern character is present
			// Update total matched pattern character in original string
			if (patternDictionary[current] > 0 && patternDictionary[current] >= stringDictionary[current])
				foundCharsCount++;

			// If all the character of pattern are found
			if (foundCharsCount == pattern.length()) {
				// Started with the window index
				current = original.charAt(start);
				// Iterate until unwanted character at start of window
				// Character at start of window is not part of pattern
				// Character at start of window has higher frequency/repetitions than required
				while (stringDictionary[current] > patternDictionary[current] || patternDictionary[current] == 0) {
					start++;
					// If character has higher frequency, remove character for window
					// Also remove frequecy of hashed character
					if (stringDictionary[current] > patternDictionary[current])
						stringDictionary[current]--;

					// Check for next character in window
					current = original.charAt(start);
				}
				// Print the start and end index, where pattern is found
				System.out.println("Found at: start: " + start + " End: " + index);
				// Update the minimum window with the new length
				if (minWindow > index - start + 1) {
					minWindow = index - start + 1;
					startIndex = start;
				}
			}

		}
		// return substring
		return startIndex == -1 ? "" : original.substring(startIndex, startIndex + minWindow);
	}

	// Driver Method
	public static void main(String[] args) {
		String str = "this is a test string";
		String pattern = "tist";

		System.out.print("Smallest window is :\n " + findSubString(str, pattern));
	}
}
