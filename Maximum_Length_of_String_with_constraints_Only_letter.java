class Solution {

	/**
	 * Entry point for the algorithm to find maximum length of substring(s)
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maxLengthWithRestrictions("Pass1wowrdD23223a"));
	}

	/**
	 * Return the length of maximum substring
	 *  - Contains only Upper or Lower Case letters
	 *  - Must contain at least one Upper case letter
	 *  - Should not contain any other letter, not even integer
	 *  - -1 in case of no such substring 
	 * @param string
	 * @return maximum length of substring
	 */
	private static int maxLengthWithRestrictions(String string) {
		int length = 0;
		int currentMax = 0;
		boolean hasCaps = false;

		char process = '\u0000';
		for (int index = 0; index < string.length(); index++) {
			process = string.charAt(index);
			if (Character.isLetter(process)) {
				currentMax++;
				hasCaps = hasCaps || Character.isUpperCase(process);
			} else {
				length = hasCaps ? Math.max(length, currentMax) : length;
				currentMax = 0;
				hasCaps = false;
			}
		}

		return length == 0 ? -1 : length;
	}	
}
