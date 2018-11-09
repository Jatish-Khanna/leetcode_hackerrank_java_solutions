import java.util.Arrays;

class Solution {

	public static void main(String args[]) {
		String str1 = "Test";
		String str2 = "esTa";
		
		
		if (areStringsAnagram(str1, str2))
			System.out.println("The two strings " + str1 + " and  " + str2 + " are anagram");
		else
			System.out.println("The two strings " + str1 + " and  " + str2 + " are not anagram");
	}

	private static boolean areStringsAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		int[] hashFrequency = new int[256];
    // Hash character frequency from first string
		str1.chars().forEach(element -> hashFrequency[element]++);
    // Rehash and decrement already found character frequency
		str2.chars().forEach(element -> hashFrequency[element]--);

    // Find any character with frequency not equal zero (return false if found)
		return Arrays.stream(hashFrequency).noneMatch(element -> element != 0);
	}

}
