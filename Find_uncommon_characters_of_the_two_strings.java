import java.util.TreeSet;

class Solution {

	private static void findAndPrintUncommonChars(String firstString, String secondString) {
		boolean[] dictionaryFirst = new boolean[26];
		boolean[] dictionarySecond = new boolean[26];

		for (int index = 0; index < firstString.length(); index++) {
			dictionaryFirst[firstString.charAt(index) - 'a'] = true;
		}

		for (int index = 0; index < secondString.length(); index++) {
			dictionarySecond[secondString.charAt(index) - 'a'] = true;
		}

		TreeSet<Character> resultDictionary = new TreeSet<>();

		for (int index = 0; index < 26; index++) {
			if (((dictionaryFirst[index] && !dictionarySecond[index])
					|| (!dictionaryFirst[index] && dictionarySecond[index])))
				resultDictionary.add((char) (index + 'a'));
		}

		for (Character ch : resultDictionary) {
			System.out.print(ch + " ");
		}

	}

	// Driver program to test above
	public static void main(String[] args) {
		String str1 = "characters";
		String str2 = "alphabets";
		findAndPrintUncommonChars(str1, str2);
	}
}
