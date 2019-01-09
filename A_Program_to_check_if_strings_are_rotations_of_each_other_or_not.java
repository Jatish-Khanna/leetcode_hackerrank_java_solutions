class Solution {

	private static boolean areRotations(String stringOne, String stringTwo) {

		if (stringOne == null && stringTwo == null)
			return true;

		StringBuilder appendString = new StringBuilder(stringOne);
		appendString.append(stringOne);

		return appendString.indexOf(stringTwo) != -1;
	}

	// Driver method
	public static void main(String[] args) {
		String str1 = "AACD";
		String str2 = "ACDA";

		if (areRotations(str1, str2))
			System.out.println("Strings are rotations of each other");
		else
			System.out.printf("Strings are not rotations of each other");
	}
}
