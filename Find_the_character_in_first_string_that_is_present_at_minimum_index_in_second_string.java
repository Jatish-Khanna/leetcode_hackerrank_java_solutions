import java.util.HashMap;

class Solution {

	private static void printMinIndexChar(String firstString, String secondString) {

		HashMap<Character, Integer> dictionary = new HashMap<>();

		for (int index = 0; index < firstString.length(); index++) {
			if (dictionary.get(firstString.charAt(index)) == null) {
				dictionary.put(firstString.charAt(index), index);
			}
		}

		int minimumIndex = Integer.MAX_VALUE;

		for (int index = 0; index < secondString.length(); index++) {
			if (dictionary.get(secondString.charAt(index)) != null) {
				minimumIndex = Math.min(minimumIndex, dictionary.get(secondString.charAt(index)));
			}
		}
		if (minimumIndex == Integer.MAX_VALUE)
			System.out.println("Not found");
		else
			System.out.println("Character found at:" + firstString.charAt(minimumIndex));
	}

	// Driver Method
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String patt = "set";
		printMinIndexChar(str, patt);
	}

}
