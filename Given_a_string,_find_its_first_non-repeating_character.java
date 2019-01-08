import java.util.HashMap;
import java.util.Map;

class Solution {

	static class CountIndexer {
		int count;
		int index;

		CountIndexer(int index) {
			this.count = 1;
			this.index = index;
		}
	}

	private static int firstNonRepeating(String string) {
		if (string == null || "".equals(string))
			return Integer.MAX_VALUE;

		HashMap<Character, CountIndexer> firstOccurrence = new HashMap<>();
		char current = '\u0000';
		CountIndexer presentIndexer;
		int firstIndex = Integer.MAX_VALUE;

		for (int index = 0; index < string.length(); index++) {
			current = string.charAt(index);

			presentIndexer = firstOccurrence.get(current);
			if (presentIndexer != null) {
				presentIndexer.count++;
				firstOccurrence.put(current, presentIndexer);
			} else {
				firstOccurrence.put(current, new CountIndexer(index));
			}
		}

		for (Map.Entry<Character, CountIndexer> keyset : firstOccurrence.entrySet()) {
			if (keyset.getValue().count == 1) {
				firstIndex = Math.min(firstIndex, keyset.getValue().index);
			}
		}
		return firstIndex;
	}

	// Driver method
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int index = firstNonRepeating(str);

		System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating " + " or string is empty"
				: "First non-repeating character is " + str.charAt(index));
	}
}
