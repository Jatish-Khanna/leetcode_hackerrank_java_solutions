import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		String str = "ABDEFGABEF";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubstring(str);
		System.out.println("The length of " + "the longest non repeating character is " + len);
	}

	private static int longestUniqueSubstring(String str) {
		int legnth = 0;
		int maxLength = 0;
		int lastSeen;
		char current;
		Map<Character, Integer> dictionary = new HashMap<>();

		for (int index = 0; index < str.length(); index++) {
			current = str.charAt(index);
			if (dictionary.containsKey(current)) {
				lastSeen = dictionary.get(current);
				maxLength = Math.max(legnth, maxLength);
				legnth = index - lastSeen;
			} else {
				legnth++;
			}
			dictionary.put(current, index);
		}

		maxLength = Math.max(legnth, maxLength);
		return maxLength;
	}
}
